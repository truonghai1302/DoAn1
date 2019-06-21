/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Draw;

import Model.Line;
import Model.MPoint;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author DELL
 */
public class DialogAddNewPoint extends JDialog {

    JFrame mFrame;
    Container cp;
    JFormattedTextField txtValue;
    JButton btnYes;
    JButton btnCancel;
    CallBackToDrawDoThi mCallBackToDrawDoThi;
    ArrayList<ShapePoint> mListPoint;
    Point mNewPointLocation;

    public DialogAddNewPoint(JFrame frame, DrawDoThi ddt,
            ArrayList<ShapePoint> listPoints, Point newPointLocation) {
        super(frame, "Tạo điểm mới", true);
        this.mFrame = frame;
        mCallBackToDrawDoThi = ddt;
        this.mListPoint = listPoints;
        this.mNewPointLocation = newPointLocation;
        initAndAddView();
        setEvent();
        configForDialog();
    }

    public void formatTextFieldValue() {
        NumberFormat format = NumberFormat.getInstance();
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Long.class);
        formatter.setMinimum(0l);
        formatter.setAllowsInvalid(false);

        // If you want the value to be committed on each keystroke instead of focus lost
        formatter.setCommitsOnValidEdit(true);
        txtValue = new JFormattedTextField(formatter);
        txtValue.setColumns(12);

        int max = 1;
        for (ShapePoint point : mListPoint) {
            if (point.getIndicator() > max) {
                max = point.getIndicator();
            }
        }

        txtValue.setValue(max + 1);
        // bôi đen giá trị ( select ) 
        txtValue.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        txtValue.selectAll();
                    }
                });
            }
        });
    }

    public void setEvent() {
        txtValue.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e); //To change body of generated methods, choose Tools | Templates.
                if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                    boolean isSuccess = checkValidPoint(Integer.parseInt(txtValue.getValue().toString()));
                    if (isSuccess) {
                        int indicator = Integer.parseInt(txtValue.getValue().toString());
                        ShapePoint newPoint = new ShapePoint(mNewPointLocation, indicator, false);
                        mCallBackToDrawDoThi.callBackAddNewPoint(newPoint);
                        setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(mFrame, "Đã tồn tại Point . Vui lòng chọn điểm khác");
                    }
                }
            }
        }
        );
        // yes 
        btnYes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isSuccess = checkValidPoint(Integer.parseInt(txtValue.getValue().toString()));
                if (isSuccess) {
                    int indicator = Integer.parseInt(txtValue.getValue().toString());
                    ShapePoint newPoint = new ShapePoint(mNewPointLocation, indicator, false);
                    mCallBackToDrawDoThi.callBackAddNewPoint(newPoint);
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(mFrame, "Đã tồn tại Point . Vui lòng chọn điểm khác");
                }
            }
        });
        // cancel  
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mCallBackToDrawDoThi.callBackSetValueForLine(false, 0);
                setVisible(false);

            }
        });
        // close <=> cancel
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e); //To change body of generated methods, choose Tools | Templates.
                mCallBackToDrawDoThi.callBackSetValueForLine(false, 0);
                setVisible(false);
            }
        });
    }

    void initAndAddView() {
        cp = getContentPane();
        cp.setLayout(new FlowLayout());
        formatTextFieldValue();
        btnYes = new JButton("Đồng ý");
        btnCancel = new JButton("Huỷ bỏ");
        cp.add(txtValue);
        cp.add(btnYes);
        cp.add(btnCancel);
    }

    void configForDialog() {
        setSize(230, 120);
        setLocationRelativeTo(null);
        getRootPane().setWindowDecorationStyle(JRootPane.INFORMATION_DIALOG);
    }

    boolean checkValidPoint(int newPointIndicator) {
        for (ShapePoint point : mListPoint) {
            if (point.getIndicator() == newPointIndicator) {
                return false;
            }
        }
        return true;
    }
}
