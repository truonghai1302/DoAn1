/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Draw;

import Model.DataPerStepForRunAutomatically;
import Model.Line;
import Model.MPoint;
import Utils.Const;
import Utils.FunctionUtils;
import View.MainForm;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseWheelEvent;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;

/**
 *
 * @author DELL
 */
public class DrawDoThi extends JPanel
        implements CallBackToDrawDoThi,
        ActionListener {

    // mode của đồ thị
    private boolean isCoHuong;

    private JPopupMenu mMenuOfPoint;
    private JPopupMenu mMenuOfLine;

    private JFrame mFrame;
    private CallBackToMainForm mCallBackToMainForm;
    private ArrayList<ShapeLine> mListShapeLines;
    private ArrayList<ShapePoint> mListShapePoints;
    private Flag flag;
    // Di chuyển 1 điểm
    private boolean mFlagOfMovingPoint = false;
    private int mIndicatorOfMovingPoint = -1;
    // Nối 2 điểm 
    private boolean mFlagOfConnectingPoint = false;
    private Point mOriginPoint;
    private ShapeLine mShapeLineConnectingPoint;

    private boolean isLeftClick = true;
    // Point 
    private int mPointPositionSelected = -1;
    private Point mSelectedPointLocation = null;
    private ShapePoint mStartPointConnected = null;

    // Line 
    private ShapeLine mSelectedLine = null;

    public DrawDoThi(MainForm mainForm, ArrayList<MPoint> listDatas, boolean CoHuong) {
        mFrame = mainForm;
        mCallBackToMainForm = mainForm;
        initShapeData(listDatas, CoHuong);
        initPopupMenu();
        flag = Flag.NONE;

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e); //To change body of generated methods, choose Tools | Templates.
                Point clickedPoint = e.getPoint();
                mSelectedPointLocation = clickedPoint;

                // click vào Point 
                int i = 0;
                for (ShapePoint point : mListShapePoints) {
                    if (point.getShape().contains(clickedPoint)) {
                        // Click chuột phải -> tạo menu 
                        if (SwingUtilities.isRightMouseButton(e)) {
                            System.err.println("RIght click");
                            isLeftClick = false;
                            mPointPositionSelected = i;
                            mStartPointConnected = mListShapePoints.get(i);
//                            mMenuOfPoint.show(e.getComponent(), clickedPoint.x, clickedPoint.y);
                            return;
                        } // click chuột trái -> di chuyển 1 điểm 
                        else {
                            isLeftClick = true;
                            flag = Flag.DI_CHUYEN_1_DIEM;
                            mPointPositionSelected = i;

                            return;
                        }
                    }
                    i++;
                }

                // click vào đường thẳng 
                for (ShapeLine line : mListShapeLines) {
                    if (line.getShape().contains(clickedPoint)) {
                        // Click chuột phải -> tạo menu 
                        if (SwingUtilities.isRightMouseButton(e)) {
                            isLeftClick = false;
                            mSelectedLine = new ShapeLine(
                                    line.getOriginPoint(),
                                    line.getFinishPoint(),
                                    line.getValue(),
                                    line.isIsCoHuong(),
                                    line.isIsSelected(),
                                    line.getStartIndicator(),
                                    line.getFinishIndicator());
                            mMenuOfLine.show(e.getComponent(), clickedPoint.x, clickedPoint.y);
                            return;
                        }
                    }
                }

                // click vào khoảng trống 
                if (SwingUtilities.isRightMouseButton(e)) {
                    new DialogAddNewPoint(mainForm, DrawDoThi.this, mListShapePoints, clickedPoint)
                            .setVisible(true);
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e); //To change body of generated methods, choose Tools | Templates.
                Point releasedPoint = e.getPoint();
                // Di chuyển 1 điểm -> callback update
                if (flag == Flag.DI_CHUYEN_1_DIEM) {
                    mCallBackToMainForm.callBackUpdatedFromDrawDoThi(
                            flag,
                            mListShapePoints,
                            mListShapeLines);
                    flag = Flag.NONE;
                    mPointPositionSelected = -1;
                    return;
                }

                // click chuột phải vào điểm 
                if (isLeftClick == false) {

                    for (ShapePoint point : mListShapePoints) {
                        if (point.getShape().contains(releasedPoint)) {
                            // Nối 2 điểm 
                            if (releasedPoint.x != mSelectedPointLocation.x
                                    || releasedPoint.y != mSelectedPointLocation.y) {
                                boolean isValid = checkConnectedOfTwoPointIsValid(mShapeLineConnectingPoint.getStartIndicator(), point.getIndicator());
                                if (isValid) {
                                    new DialogConnect2Point(
                                            new Point(mSelectedPointLocation.x + mFrame.getLocation().x,
                                                    mSelectedPointLocation.y + mFrame.getLocation().y),
                                            mFrame,
                                            DrawDoThi.this,
                                            mStartPointConnected,
                                            point)
                                            .setVisible(true);
                                } else {
                                    JOptionPane.showMessageDialog(null, "Không thể tạo line giữa 2 điểm này !!!");
                                }
                            }
                            // mở menu 
                            else {
                                mMenuOfPoint.show(e.getComponent(), releasedPoint.x, releasedPoint.y);
                            }
                        }

                        repaint();
                    }
                    flag = Flag.NONE;
                    isLeftClick = true;
                }
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e); //To change body of generated methods, choose Tools | Templates.
                Point draggingPoint = e.getPoint();
                // di chuyển 1 điểm 
                if (isLeftClick && flag == Flag.DI_CHUYEN_1_DIEM) {
                    // Di chuyển 1 điểm 
                    ShapePoint sp = mListShapePoints.get(mPointPositionSelected);
                    int draggingIndicator = sp.getIndicator();
                    // thay đổi position của point đang dragged 
                    sp.setOriginPoint(draggingPoint);
                    // thay đổi position của point trong list line  
                    for (ShapeLine line : mListShapeLines) {
                        if (line.getStartIndicator() == draggingIndicator) {
                            line.setOriginPoint(draggingPoint);
                        }
                        if (line.getFinishIndicator() == draggingIndicator) {
                            line.setFinishPoint(draggingPoint);
                        }
                    }
                    repaint();
                }

                // Nối 2 điểm 
                if (isLeftClick == false) {
                    flag = Flag.NOI_2_DIEM;
                    mShapeLineConnectingPoint = new ShapeLine(
                            mStartPointConnected.getOriginPoint(),
                            draggingPoint,
                            1,
                            isCoHuong,
                            false,
                            mStartPointConnected.getIndicator(),
                            10);
                    repaint();
                }
            }
        });
    }

    public void initPopupMenu() {
        // menu of Point 
        mMenuOfPoint = new JPopupMenu();

        JMenuItem menuSuaDiem = new JMenuItem("Sửa Điểm");
        menuSuaDiem.setActionCommand("SuaDiem");
        menuSuaDiem.addActionListener(this);

        JMenuItem menuXoaDiem = new JMenuItem("Xoá Điểm");
        menuXoaDiem.setActionCommand("XoaDiem");
        menuXoaDiem.addActionListener(this);

        mMenuOfPoint.add(menuSuaDiem);
        mMenuOfPoint.add(menuXoaDiem);

        // menu of Point 
        mMenuOfLine = new JPopupMenu();

        JMenuItem menuSuaDuongThang = new JMenuItem("Sửa đường thẳng");
        menuSuaDuongThang.setActionCommand("SuaDuongThang");
        menuSuaDuongThang.addActionListener(this);

        JMenuItem menuXoaDuongThang = new JMenuItem("Xoá đường thẳng");
        menuXoaDuongThang.setActionCommand("XoaDuongThang");
        menuXoaDuongThang.addActionListener(this);

        mMenuOfLine.add(menuSuaDuongThang);
        mMenuOfLine.add(menuXoaDuongThang);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "SuaDiem":
                new DialogChangeValue(mFrame,
                        DrawDoThi.this,
                        mListShapePoints.get(mPointPositionSelected),
                        mListShapePoints,
                        mListShapePoints.get(mPointPositionSelected))
                        .setVisible(true);
                break;
            case "XoaDiem":
                new DialogRemovePoint(mFrame,
                        DrawDoThi.this,
                        mListShapePoints.get(mPointPositionSelected).getIndicator())
                        .setVisible(true);
                break;
            case "SuaDuongThang":
                new DialogChangeValue(
                        mFrame,
                        DrawDoThi.this,
                        mSelectedLine,
                        null,
                        null)
                        .setVisible(true);
                break;
            case "XoaDuongThang":
                new DialogRemoveLine(mFrame,
                        DrawDoThi.this,
                        mSelectedLine)
                        .setVisible(true);
                break;
            default:
                break;
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g); //To change body of generated methods, choose Tools | Templates.
        draw(g);
    }

    public void draw(Graphics g) {
        g.clearRect(0, 0, getWidth(), getHeight());
        Graphics2D g2d = (Graphics2D) g;

        // draw line
        for (ShapeLine shape : mListShapeLines) {
            if (shape.getValue() > 0) {
                shape.paint(g2d);
            }
        }

        // draw line connecting 
//        if (mFlagOfConnectingPoint
//                && flag == Flag.NOI_2_DIEM) {
        if (flag == Flag.NOI_2_DIEM) {
            mShapeLineConnectingPoint.paint(g2d);
        }
//        }

        // draw point 
        for (ShapePoint shape : mListShapePoints) {
            shape.paint(g2d);
        }
    }

    public void drawWithMode(ArrayList<MPoint> listDatas, boolean isCoHuong) {
        initShapeData(listDatas, isCoHuong);
        drawDoThiUnselected();
    }

    public void initShapeData(ArrayList<MPoint> listDatas, boolean isCoHuong) {
        this.isCoHuong = isCoHuong;
        mListShapeLines = new ArrayList<ShapeLine>();
        mListShapePoints = new ArrayList<ShapePoint>();
        ArrayList<MShape> listShapes = FunctionUtils.convertListDatasToListShape(listDatas, isCoHuong);
        for (MShape shape : listShapes) {
            if (shape instanceof ShapeLine) {
                mListShapeLines.add((ShapeLine) shape);
            }
            if (shape instanceof ShapePoint) {
                mListShapePoints.add((ShapePoint) shape);
            }
        }
    }

    public void drawRoad(ArrayList<Integer> road) {
        // xoá vết các đường đi trước 
        drawDoThiUnselected();

        // vẽ lại 
        int flag = -1;
        int pointBefore = -1;
        for (Integer step : road) {
            // line selected 
            if (flag > - 1) {
                for (ShapeLine l : mListShapeLines) {
                    // kiểm tra line có hướng 
                    if (isCoHuong) {
                        if (l.getStartIndicator() == pointBefore
                                && l.getFinishIndicator() == step) {
                            l.setIsSelected(true);
                        }
                    } // kiểm tra line vô hướng 
                    else {
                        if ((l.getStartIndicator() == pointBefore
                                && l.getFinishIndicator() == step)
                                || (l.getStartIndicator() == step
                                && l.getFinishIndicator() == pointBefore)) {
                            l.setIsSelected(true);
                        }
                    }
                }
            }

            // point selected 
            for (ShapePoint p : mListShapePoints) {
                if (p.getIndicator() == step) {
                    p.setIsSelected(true);
                    pointBefore = step;
                }
            }

            flag++;
        }

        repaint();
    }

    public void drawDoThiUnselected() {
        for (ShapeLine shape : mListShapeLines) {
            shape.setIsSelected(false);
        }
        for (ShapePoint shape : mListShapePoints) {
            shape.setIsSelected(false);
        }
        repaint();
    }

    public void setFlagDiChuyen1Diem() {
        flag = Flag.DI_CHUYEN_1_DIEM;
    }

    public void setFlagNoi2Diem() {
        flag = Flag.NOI_2_DIEM;
    }

    public void setFlagXoaDiem() {
        flag = Flag.XOA_DIEM;
    }

    public void setFlagThemDiem() {
        flag = Flag.THEM_DIEM;
    }

    public void setFlagXoaDuongThang() {
        this.flag = Flag.XOA_DUONG_THANG;
    }

    public void setFlagThayDoiGiaTri() {
        this.flag = Flag.THAY_DOI_GIA_TRI;
    }

    // true -> có thể tạo kết nối mới giữa 2 điểm 
    // false -> đã tồn tại kết nối trước đó 
    public boolean checkConnectedOfTwoPointIsValid(int startIndicator, int finishIndicator) {
        if (startIndicator == finishIndicator) {
            return false;
        }
        for (ShapeLine line : mListShapeLines) {
            if ((line.getStartIndicator() == startIndicator
                    && line.getFinishIndicator() == finishIndicator)
                    || (line.getStartIndicator() == finishIndicator
                    && line.getFinishIndicator() == startIndicator)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void callBackSetValueForLine(boolean yes, int value) {
        // set value 
        if (yes) {
            ShapeLine newLine = new ShapeLine(
                    mShapeLineConnectingPoint.getOriginPoint(),
                    mShapeLineConnectingPoint.getFinishPoint(),
                    value,
                    isCoHuong,
                    false,
                    mShapeLineConnectingPoint.getStartIndicator(),
                    mShapeLineConnectingPoint.getFinishIndicator());
            System.out.println("From : " + newLine.getStartIndicator()
                    + "  -> " + newLine.getFinishIndicator() + " : " + newLine.getValue());
            mListShapeLines.add(newLine);
            mCallBackToMainForm.callBackUpdatedFromDrawDoThi(flag, mListShapePoints, mListShapeLines);
        }
        repaint();
    }

    @Override
    public void callBackAddNewLine(int value, ShapePoint startPoint, ShapePoint finishPoint) {
        ShapeLine newLine = new ShapeLine(
                startPoint.getOriginPoint(),
                finishPoint.getOriginPoint(),
                value,
                isCoHuong,
                false,
                startPoint.getIndicator(),
                finishPoint.getIndicator());
        mListShapeLines.add(newLine);
        mCallBackToMainForm.callBackUpdatedFromDrawDoThi(flag, mListShapePoints, mListShapeLines);
        repaint();
    }

    @Override
    public void callBackRemovePoint(int pointIndicator, boolean yes) {
        if (yes) {
            // xoá point 
            for (ShapePoint point : mListShapePoints) {
                if (point.getIndicator() == pointIndicator) {
                    mListShapePoints.remove(point);
                    break;
                }
            }

            // xoá line có liên quan tới point 
            ArrayList<ShapeLine> listTemp = new ArrayList<ShapeLine>();
            for (int i = mListShapeLines.size() - 1; i >= 0; i--) {
                ShapeLine line = mListShapeLines.get(i);
                if (line.getFinishIndicator() != pointIndicator
                        && line.getStartIndicator() != pointIndicator) {
                    listTemp.add(line);
                }
            }

            mListShapeLines.clear();
            mListShapeLines.addAll(listTemp);

            repaint();
            mCallBackToMainForm.callBackUpdatedFromDrawDoThi(flag, mListShapePoints, mListShapeLines);
        }
    }

    @Override
    public void callBackAddNewPoint(ShapePoint newPoint) {
        // thêm điểm mới 
        mListShapePoints.add(newPoint);

        // call back
        mCallBackToMainForm.callBackUpdatedFromDrawDoThi(flag, mListShapePoints, mListShapeLines);
        repaint();
    }

    public void addNewShapeLine(ShapeLine line) {
        mListShapeLines.add(line);
        repaint();
    }

    @Override
    public void callBackRemoveLine(ShapeLine lineDelete) {
        // remove line 
        for (int i = 0; i < mListShapeLines.size(); i++) {
            ShapeLine line = mListShapeLines.get(i);
            if (line.getStartIndicator() == lineDelete.getStartIndicator()
                    && line.getFinishIndicator() == lineDelete.getFinishIndicator()) {
                mListShapeLines.remove(i);
                break;
            }
        }
        // call back 
        mCallBackToMainForm.callBackUpdatedFromDrawDoThi(flag, mListShapePoints, mListShapeLines);
        repaint();
    }

    @Override
    public void callBackChangeIndicatorOfPoint(ShapePoint pointChange) {
        System.out.println("Change point");
        // change indicator 
        // lấy ra indicator trước đó của Point bị thay đổi 
        int beforeIndicator = 0;
        int newIndicator = pointChange.getIndicator();
        for (int i = 0; i < mListShapePoints.size(); i++) {
            ShapePoint point = mListShapePoints.get(i);
            if (point.getOriginPoint() == pointChange.getOriginPoint()) {
                beforeIndicator = point.getIndicator();
                point.setIndicator(newIndicator);
                break;
            }
        }

        // cập nhật lại point trong list lines 
        for (ShapeLine line : mListShapeLines) {
            if (line.getStartIndicator() == beforeIndicator) {
                line.setStartIndicator(newIndicator);
                System.out.println("Start : " + line.getStartIndicator() + " --- End : " + line.getFinishIndicator());
            }

            if (line.getFinishIndicator() == beforeIndicator) {
                line.setFinishIndicator(newIndicator);
                System.out.println("Start : " + line.getStartIndicator() + " --- End : " + line.getFinishIndicator());

            }
        }

        // call back 
        mCallBackToMainForm.callBackUpdatedFromDrawDoThi(flag, mListShapePoints, mListShapeLines);
        repaint();
    }

    @Override
    public void callBackChangeValueOfLine(ShapeLine lineChange) {
        // change line 
        for (int i = 0; i < mListShapeLines.size(); i++) {
            ShapeLine line = mListShapeLines.get(i);
            if (line.getStartIndicator() == lineChange.getStartIndicator()
                    && line.getFinishIndicator() == lineChange.getFinishIndicator()) {
                mListShapeLines.get(i).setValue(lineChange.getValue());
                break;
            }
        }
        // call back 
        mCallBackToMainForm.callBackUpdatedFromDrawDoThi(flag, mListShapePoints, mListShapeLines);
        repaint();
    }

    public ShapeLine getShapeLineWithIndicator(int startIndicator, int finishIndicator) {
        for (ShapeLine line : mListShapeLines) {
            if (line.getStartIndicator() == startIndicator
                    && line.getFinishIndicator() == finishIndicator) {
                return line;
            }
        }
        return null;
    }

    public ShapePoint getShapePointWithIndicator(int indicator) {
        for (ShapePoint point : mListShapePoints) {
            if (point.getIndicator() == indicator) {
                return point;
            }
        }
        return null;
    }

    public void drawDoThiWithActionChayTuDong(ArrayList<DataPerStepForRunAutomatically> listDPS, long delayTime) {
        long increase = delayTime;
        Timer t = new Timer();

        for (int step = 0; step < listDPS.size(); step++) {
            DataPerStepForRunAutomatically dps = listDPS.get(step);
            int startIndicator = dps.getStartIndicator();
            int finishIndicator = dps.getFinishIndicator();

            // show từng Line được thử 
            boolean isNewStep = true;
            for (Line line : dps.getListLinesTesting()) {
                if (isNewStep) {
                    // xoá đi nhánh sai <=> đi tới nhánh mới
                    t.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            // xoá nhánh sai 
                            int sizePoint = dps.getListPointOfTrueRoad().size();
                            if (sizePoint > 1) {
                                drawFinalLineInOneStep(dps);
                                int DiemCuoi = dps.getListPointOfTrueRoad().get(sizePoint - 1);
                                int DiemKeCuoi = dps.getListPointOfTrueRoad().get(sizePoint - 2);
                                ShapePoint sp = getShapePointWithIndicator(DiemCuoi);
                                if (sp != null) {
                                    sp.setIsSelected(false);
                                }
                                ShapeLine sl = getShapeLineWithIndicator(DiemCuoi, DiemKeCuoi);
                                if (sl != null) {
                                    sl.setIsSelected(false);
                                } else {
                                    if (isCoHuong == false) {
                                        sl = getShapeLineWithIndicator(DiemKeCuoi, DiemCuoi);
                                        if (sl != null) {
                                            sl.setIsSelected(false);
                                        }
                                    }
                                }
                            }

                            drawWhenTestingLineInOneStep(dps, line);
                        }
                    }, delayTime);
                    delayTime += increase;
                } else {
                    t.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            drawWhenTestingLineInOneStep(dps, line);
                        }
                    }, delayTime);
                    delayTime += increase;
                }
            }

            // không có đường đi 
            if (step == listDPS.size() - 1 && dps.getListLinesTesting().size() == 0) {
                t.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        mCallBackToMainForm.callBackUpdateViewPerStepWithActionChayTuDongFromDrawDoThi(dps);
                        drawDoThiUnselected();
                    }
                }, delayTime);
            } // có đường đi
            else {
                // hiển thị Line cuối cùng ( được chọn ) 
                t.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        mCallBackToMainForm.callBackUpdateViewPerStepWithActionChayTuDongFromDrawDoThi(dps);
                        drawFinalLineInOneStep(dps);
                    }
                }, delayTime);
            }
            delayTime += increase;
        }

    }

    public void drawWhenTestingLineInOneStep(DataPerStepForRunAutomatically dps, Line TestingLine) {
        // bỏ chọn line && point trước đó đã test  
        for (Line line : dps.getListLinesTesting()) {
            ShapeLine sl = getShapeLineWithIndicator(line.getStartIndicator(), line.getEndIndicator());
            ShapePoint sp = getShapePointWithIndicator(line.getEndIndicator());

            if (sl != null) {
                sl.setIsSelected(false);
            } else {
                // Vô hướng
                if (isCoHuong == false) {
                    sl = getShapeLineWithIndicator(line.getEndIndicator(), line.getStartIndicator());
                    if (sl != null) {
                        sl.setIsSelected(false);
                    }
                }
            }
            if (sp != null) {
                sp.setIsSelected(false);
            }
        }

        // line và point được chọn 
        ShapeLine sl = getShapeLineWithIndicator(TestingLine.getStartIndicator(), TestingLine.getEndIndicator());
        ShapePoint sp = getShapePointWithIndicator(TestingLine.getEndIndicator());

        if (sl != null) {

            sl.setColor(Const.COLOR_TESTING);
        } else {
            // Vô hướng
            if (isCoHuong == false) {
                sl = getShapeLineWithIndicator(TestingLine.getEndIndicator(), TestingLine.getStartIndicator());
                if (sl != null) {
                    sl.setIsSelected(false);
                }
            }
        }
        if (sp != null) {
            sp.setColor(Const.COLOR_TESTING);
        }

        repaint();
    }

    public void drawFinalLineInOneStep(DataPerStepForRunAutomatically dps) {
        // bỏ chọn tất cả line && point 
        for (ShapeLine sl : mListShapeLines) {
            sl.setIsSelected(false);
        }

        for (ShapePoint sp : mListShapePoints) {
            sp.setIsSelected(false);
        }

        // chọn những line và point đã đi qua 
        int i = 0;
        for (Integer pointIndicator : dps.getListPointOfTrueRoad()) {
            ShapePoint sp = getShapePointWithIndicator(pointIndicator);
            if (i != 0) {
                ShapeLine sl = getShapeLineWithIndicator(i, pointIndicator);
                if (sl != null) {
                    sl.setIsSelected(true);
                } else {
                    // Vô hướng
                    if (isCoHuong == false) {
                        sl = getShapeLineWithIndicator(pointIndicator, i);
                        if (sl != null) {
                            sl.setIsSelected(true);
                        }
                    }
                }
            }
            if (sp != null) {
                sp.setIsSelected(true);
            }
            i = pointIndicator;
        }
        repaint();
    }

    public enum Flag {
        NONE,
        DI_CHUYEN_1_DIEM,
        NOI_2_DIEM,
        XOA_DIEM,
        THEM_DIEM,
        XOA_DUONG_THANG,
        THAY_DOI_GIA_TRI
    }
}
