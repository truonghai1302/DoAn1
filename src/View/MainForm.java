/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.DataPerStepForDijkstra;
import Algorithm.Dijkstra;
import Draw.CallBackToMainForm;
import Draw.DrawDoThi;
import Draw.ShapeLine;
import Draw.ShapePoint;
import Utils.CellRendererOfTable;
import Model.DataPerStepForRunAutomatically;
import Model.Line;
import Model.Matrix;
import Model.Matrix.Mode;
import Model.MPoint;
import Utils.Const;
import Utils.FunctionUtils;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.CompareGenerator;
import com.sun.xml.internal.ws.wsdl.parser.InaccessibleWSDLException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import javafx.util.Pair;
import javax.swing.ButtonModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.text.JTextComponent;
import javax.swing.text.View;

/**
 *
 * @author DELL
 */
public class MainForm extends javax.swing.JFrame
        implements IMainForm,
        ActionListener,
        CallBackToMainForm,
        TableModelListener {

    private Matrix mMaTran;
    private DefaultTableModel mTableModelMaTran;
    private DefaultTableModel mTableModelThuatToan;
    private ArrayList<Object[][]> mListDoThiCoSan;
    private ArrayList<Point[]> mListDoThiCoSanCoordinate;
    private ArrayList<DataPerStepForDijkstra> mListDataOfTwoPointForOneStep;
    private DrawDoThi mDrawDoThi;
    private int stepIndicator = 0;
    private boolean isShowFullScreen = false;

    /**
     * Creates new form MainForm
     */
    public MainForm() {
        initComponents();
        initData();
        addPanelDrawDoThi();
        prepareUI();
        setEventListener();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroup = new javax.swing.ButtonGroup();
        btnGroupPhuongThucNhapDoThi = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        rdbCoHuong = new javax.swing.JRadioButton();
        rdbVoHuong = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        rdbTuVe = new javax.swing.JRadioButton();
        rdbDoThiCoSan = new javax.swing.JRadioButton();
        cmbDoThiCoSan = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        cmbDiemXuatPhat = new javax.swing.JComboBox<>();
        cmbDiemCuoi = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        btnChayMotLan = new javax.swing.JButton();
        btnChayTungBuoc = new javax.swing.JButton();
        btnChayTuDong = new javax.swing.JButton();
        cmbDelayTime = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblThuatToan = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        lblBieuDienThuatToan = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblMaTran = new javax.swing.JTable();
        panelContainDrawDoThi = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DIJKSTRA - Tìm đường đi ngắn nhất");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Kiểu đồ thị", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanel2.setToolTipText("Đồ thị");

        btnGroup.add(rdbCoHuong);
        rdbCoHuong.setText("Có hướng ");
        rdbCoHuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbCoHuongActionPerformed(evt);
            }
        });

        btnGroup.add(rdbVoHuong);
        rdbVoHuong.setText("Vô hướng");
        rdbVoHuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbVoHuongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(rdbCoHuong)
                .addGap(49, 49, 49)
                .addComponent(rdbVoHuong)
                .addContainerGap(77, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbCoHuong)
                    .addComponent(rdbVoHuong))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chọn đồ thị\n", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        btnGroupPhuongThucNhapDoThi.add(rdbTuVe);
        rdbTuVe.setText("Tự Vẽ");
        rdbTuVe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbTuVeActionPerformed(evt);
            }
        });

        btnGroupPhuongThucNhapDoThi.add(rdbDoThiCoSan);
        rdbDoThiCoSan.setText("Đồ thị có sẵn");

        cmbDoThiCoSan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(rdbTuVe)
                .addGap(18, 18, 18)
                .addComponent(rdbDoThiCoSan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbDoThiCoSan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbTuVe)
                    .addComponent(rdbDoThiCoSan)
                    .addComponent(cmbDoThiCoSan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Đường Đi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        cmbDiemXuatPhat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbDiemXuatPhat.setToolTipText("Điểm xuất phát");

        cmbDiemCuoi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(cmbDiemXuatPhat, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(cmbDiemCuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbDiemXuatPhat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbDiemCuoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cách chạy", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        btnChayMotLan.setText("Chạy 1 lần");

        btnChayTungBuoc.setText("Chạy từng bước");

        btnChayTuDong.setText("Chạy tự động");
        btnChayTuDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChayTuDongActionPerformed(evt);
            }
        });

        cmbDelayTime.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Delay (ms)");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnChayTuDong)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbDelayTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnChayMotLan, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnChayTungBuoc)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnChayTungBuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnChayMotLan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(4, 4, 4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbDelayTime, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addComponent(btnChayTuDong, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tblThuatToan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblThuatToan.setDragEnabled(true);
        jScrollPane1.setViewportView(tblThuatToan);

        lblBieuDienThuatToan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblBieuDienThuatToan.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hiển thị đường đi và tổng độ dài", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jScrollPane2.setViewportView(lblBieuDienThuatToan);

        tblMaTran.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblMaTran.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                tblMaTranComponentResized(evt);
            }
        });
        jScrollPane3.setViewportView(tblMaTran);

        javax.swing.GroupLayout panelContainDrawDoThiLayout = new javax.swing.GroupLayout(panelContainDrawDoThi);
        panelContainDrawDoThi.setLayout(panelContainDrawDoThiLayout);
        panelContainDrawDoThiLayout.setHorizontalGroup(
            panelContainDrawDoThiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelContainDrawDoThiLayout.setVerticalGroup(
            panelContainDrawDoThiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelContainDrawDoThi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1030, Short.MAX_VALUE))
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(37, 37, 37)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(40, 40, 40)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, Short.MAX_VALUE)
                        .addGap(49, 49, 49)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelContainDrawDoThi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE))
                .addGap(41, 41, 41))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rdbCoHuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbCoHuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdbCoHuongActionPerformed

    private void rdbVoHuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbVoHuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdbVoHuongActionPerformed

    private void rdbTuVeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbTuVeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdbTuVeActionPerformed

    private void btnChayTuDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChayTuDongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnChayTuDongActionPerformed

    private void tblMaTranComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tblMaTranComponentResized
        // TODO add your handling code here:
    }//GEN-LAST:event_tblMaTranComponentResized

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChayMotLan;
    private javax.swing.JButton btnChayTuDong;
    private javax.swing.JButton btnChayTungBuoc;
    private javax.swing.ButtonGroup btnGroup;
    private javax.swing.ButtonGroup btnGroupPhuongThucNhapDoThi;
    private javax.swing.JComboBox<String> cmbDelayTime;
    private javax.swing.JComboBox<String> cmbDiemCuoi;
    private javax.swing.JComboBox<String> cmbDiemXuatPhat;
    private javax.swing.JComboBox<String> cmbDoThiCoSan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblBieuDienThuatToan;
    private javax.swing.JPanel panelContainDrawDoThi;
    private javax.swing.JRadioButton rdbCoHuong;
    private javax.swing.JRadioButton rdbDoThiCoSan;
    private javax.swing.JRadioButton rdbTuVe;
    private javax.swing.JRadioButton rdbVoHuong;
    private javax.swing.JTable tblMaTran;
    private javax.swing.JTable tblThuatToan;
    // End of variables declaration//GEN-END:variables

    @Override
    public void prepareUI() {
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e); //To change body of generated methods, choose Tools | Templates.
                mDrawDoThi.setBounds(0, 0, panelContainDrawDoThi.getWidth(), panelContainDrawDoThi.getHeight());
                if (isShowFullScreen) {
                    Const.HEIGHT_OF_TABLE_MATRAN = Const.MIN_HEIGHT_OF_TABLE_MATRAN;
                    isShowFullScreen = false;
                } else {
                    Const.HEIGHT_OF_TABLE_MATRAN = Const.MAX_HEIGHT_OF_TABLE_MATRAN;
                    isShowFullScreen = true;
                }
                FunctionUtils.updateHeightOfRowInTable(tblMaTran);
            }
        });

        // combobox Do thi co san 
        cmbDoThiCoSan.removeAllItems();
        cmbDoThiCoSan.addItem("Đồ thị 1");
        cmbDoThiCoSan.addItem("Đồ thị 2");

        // combobox MPoint ( Start - End ) 
        cmbDiemXuatPhat.removeAllItems();
        cmbDiemCuoi.removeAllItems();
        for (int i = 0; i < mMaTran.getListPoints().size(); i++) {
            int point = mMaTran.getListPoints().get(i).getIndicator();
            cmbDiemXuatPhat.addItem("" + point);
            cmbDiemCuoi.addItem("" + point);
        }

        // combobox Delay Time
        cmbDelayTime.removeAllItems();
        for (int i = 0; i < Const.DELAY_TIME.length; i++) {
            cmbDelayTime.addItem("" + Const.DELAY_TIME[i]);
        }

        // Co Huong && Chon Do thi co san 1 
        rdbCoHuong.setSelected(true);
        rdbDoThiCoSan.setSelected(true);

        // load Matrix vao table
        mTableModelMaTran = new DefaultTableModel(mMaTran.getListVariable(), mMaTran.getColumnsName());
        mTableModelMaTran.addTableModelListener(this);
        tblMaTran.setModel(mTableModelMaTran);
        FunctionUtils.updateHeightOfRowInTable(tblMaTran);

        // Table Thuat Toan
        mTableModelThuatToan = new DefaultTableModel(new Object[][]{}, mMaTran.getColumnsName());
        tblThuatToan.setModel(mTableModelThuatToan);
        tblThuatToan.setRowHeight(40);

        // lable giá trị thuật toán 
        jScrollPane2.setBorder(null);
        lblBieuDienThuatToan.setFont(new Font("Arial", Font.BOLD, 16));
        lblBieuDienThuatToan.setForeground(Color.BLUE);
    }

    @Override
    public void addPanelDrawDoThi() {
        mDrawDoThi = new DrawDoThi(this, mMaTran.getListPoints(), mMaTran.isMode().equals(Mode.CoHuong));
        mDrawDoThi.setBounds(0, 0, panelContainDrawDoThi.getWidth(), panelContainDrawDoThi.getHeight());
        panelContainDrawDoThi.add(mDrawDoThi);
    }

    @Override
    public void initData() {
        // list Do Thi Co San
        mListDoThiCoSan = new ArrayList<Object[][]>();
        mListDoThiCoSan.add(Const.DO_THI_1);
        mListDoThiCoSan.add(Const.DO_THI_2);

        // list toạ độ Point của Đồ thị có sẵn 
        mListDoThiCoSanCoordinate = new ArrayList<Point[]>();
        mListDoThiCoSanCoordinate.add(Const.DO_THI_1_COORDINATE);
        mListDoThiCoSanCoordinate.add(Const.DO_THI_2_COORDINATE);

        // Matrix 
        mMaTran = new Matrix(
                Mode.CoHuong,
                mListDoThiCoSan.get(0),
                mListDoThiCoSanCoordinate.get(0));

    }

    @Override
    public void setEventListener() {
        // Table 
        mTableModelMaTran.addTableModelListener(this);

        // Radion button 
        rdbCoHuong.setActionCommand("CoHuong");
        rdbCoHuong.addActionListener(this);

        rdbVoHuong.setActionCommand("VoHuong");
        rdbVoHuong.addActionListener(this);

        rdbTuVe.setActionCommand("TuVe");
        rdbTuVe.addActionListener(this);

        rdbDoThiCoSan.setActionCommand("DoThiCoSan");
        rdbDoThiCoSan.addActionListener(this);

        // Combobox 
        cmbDoThiCoSan.setActionCommand("SelectDoThi");
        cmbDoThiCoSan.addActionListener(this);

        cmbDiemXuatPhat.setActionCommand("SelectDuongDiMoi");
        cmbDiemXuatPhat.addActionListener(this);

        cmbDiemCuoi.setActionCommand("SelectDuongDiMoi");
        cmbDiemCuoi.addActionListener(this);

        // Button 
        btnChayMotLan.setActionCommand("ChayMotLan");
        btnChayMotLan.addActionListener(this);

        btnChayTungBuoc.setActionCommand("ChayTungBuoc");
        btnChayTungBuoc.addActionListener(this);

        btnChayTuDong.setActionCommand("ChayTuDong");
        btnChayTuDong.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "CoHuong":
                handleWithSelectedDoThiCoHuong();
                break;
            case "VoHuong":
                handleWithSelectedDoThiVoHuong();
                break;
            case "TuVe":
                handleWithSelectedDoThiTuVe();
                break;
            case "DoThiCoSan":
                handleWithSelectedDoThiCoSan();
                break;
            case "SelectDuongDiMoi":
                handleWithSelectedDuongDiMoi();
                break;
            case "SelectDoThi":
                handleWithSelectedDoThiCoSanPosition(cmbDoThiCoSan.getSelectedIndex());
                break;
            case "ChayMotLan":
                handleWithActionChay1Lan();
                break;
            case "ChayTungBuoc":
                handleWithActionChayTungBuoc();
                break;
            case "ChayTuDong":
                handleWithActionChayTuDong();
                break;
            default:
                break;
        }
    }

    @Override
    public void clearViewOfOldRoad() {
        // xoá hiển thị giá trị của đường đi trước 
        mDrawDoThi.drawDoThiUnselected();
        lblBieuDienThuatToan.setText("");
        mTableModelThuatToan = new DefaultTableModel(null, new Object[]{});
        tblThuatToan.setModel(mTableModelThuatToan);
    }

    @Override
    public boolean checkValidBeforeExecute() {
        if (mMaTran.getListPoints() == null
                || mMaTran.getListPoints().size() == 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn đồ thị hợp lệ !!!");
            return false;
        }

        if (cmbDiemXuatPhat.getSelectedIndex() == cmbDiemCuoi.getSelectedIndex()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn điểm xuất phát và điểm kết thúc khác nhau !!!");
            return false;
        }
        return true;
    }

    @Override
    public void showDataWithStepIndicator(int sPoint, int fPoint,
            int stepIndicator, int maxStep, int soDinh) {
        if (stepIndicator > maxStep || stepIndicator < 1) {
            return;
        }

        // Tạo Data cho vào table Thuật Toán 
        Object[][] listDataForTable = new Object[stepIndicator][soDinh];

        // lưu vết Điểm cuối && giá trị để đi đến điểm cuối
        int currentLength = 0;
        int currentFinishPoint = -1;
        boolean flagSuccess = false;
        ArrayList<Line> listLinePassed = new ArrayList<Line>();

        for (int step = 0; step < stepIndicator; step++) {
            DataPerStepForDijkstra item = mListDataOfTwoPointForOneStep.get(step);
            int finishPoint = item.getFinishPoint();
            int startPoint = item.getStartPoint();
            ArrayList<Integer> listPointMarked = item.getListPointMarked();

            currentLength = item.getCurrentValue();
            currentFinishPoint = item.getFinishPoint();

            // đánh dấu những điểm đã đi qua 
            for (int i = 0; i < listPointMarked.size(); i++) {
                listDataForTable[step][listPointMarked.get(i)] = "---";
            }
//
            for (Entry<Integer, Integer> item2 : item.getListValue().entrySet()) {
                int pointConnected = item2.getKey();
                int valueOfPointConnected = item2.getValue();
                // step > 0 => bước > 1 
                if (step != 0) {
                    Object[][] listVariables = mMaTran.getListVariable();
                    // những điểm không thể kết nối được 
                    if ((listVariables[startPoint][pointConnected]).toString().equals("0")) {
                        listDataForTable[step][pointConnected] = "[ @ ," + getPointIndicatorFromPosition(startPoint) + " ]";
                    } else {
                        // những điểm có thể kết nối nhưng không phải là điểm được chọn 
                        if (pointConnected != finishPoint) {
                            listDataForTable[step][pointConnected] = "[ " + valueOfPointConnected
                                    + " , " + getPointIndicatorFromPosition(startPoint) + " ]";
                        } // Điểm được chọn 
                        else {
                            listDataForTable[step][pointConnected] = "[ " + valueOfPointConnected
                                    + " , " + getPointIndicatorFromPosition(startPoint) + " ]";

                            listLinePassed.add(
                                    new Line(getPointIndicatorFromPosition(startPoint),
                                            getPointIndicatorFromPosition(pointConnected),
                                            valueOfPointConnected));
                        }
                    }
                } // step == 0 => bước 1 => kết nối với chính điểm đầu tiên  
                else {
                    if (pointConnected != startPoint) {
//                        System.out.println("MPoint Connected : " + (pointConnected - 1));
                        listDataForTable[step][pointConnected] = "[ @ ," + getPointIndicatorFromPosition(startPoint) + " ]";
                    } // Điểm được chọn
                    else {
                        listDataForTable[step][pointConnected] = "[ " + valueOfPointConnected
                                + " , " + getPointIndicatorFromPosition(startPoint) + " ]";

                        listLinePassed.add(
                                new Line(getPointIndicatorFromPosition(startPoint),
                                        getPointIndicatorFromPosition(pointConnected),
                                        valueOfPointConnected));

                    }
                }
            }

            // kiểm tra xem bước cuối có đường đi hay không 
            if (step == maxStep - 1) {
                int valueOfFinalStep = Integer.parseInt(mMaTran.getListVariable()[startPoint][finishPoint].toString());
                if (valueOfFinalStep != 0) {
                    flagSuccess = true;
                }
            }
        }

        // kiểm tra có phải là chạy 1 lần || đi đến bước cuối cùng hay ko 
        if (stepIndicator == maxStep) {
            // không có đường 
            if (currentFinishPoint != fPoint
                    || flagSuccess == false) {
                lblBieuDienThuatToan.setText("    Không có đường đi từ điểm "
                        + getPointIndicatorFromPosition(sPoint) + "  ->  "
                        + getPointIndicatorFromPosition(fPoint));
                mDrawDoThi.drawDoThiUnselected();
                // table thuật toán
                mTableModelThuatToan = new DefaultTableModel(listDataForTable, mMaTran.getColumnsName());
                tblThuatToan.setModel(mTableModelThuatToan);
                FunctionUtils.updateTableWithSelectedCells(tblThuatToan, new ArrayList<Pair<Integer, Integer>>());
                return;
            }
        }

        // hiển thị đường đi 
        // K <=> StartPoint ---- V <=> FinishPoint
        ArrayList<Pair<Integer, Integer>> listRoadsTemp = new ArrayList<Pair<Integer, Integer>>();

        boolean flagDiemCuoi = true;
        Pair<Integer, Integer> diemCuoiCurrent = new Pair(-1, -1);

        for (int j = stepIndicator - 1; j >= 0; j--) {
            DataPerStepForDijkstra item = mListDataOfTwoPointForOneStep.get(j);
            int start = item.getStartPoint();
            int finish = item.getFinishPoint();
            int curValue = item.getCurrentValue();
            if (flagDiemCuoi != true) {
                if (finish == diemCuoiCurrent.getKey()) {
                    diemCuoiCurrent = new Pair(start, finish);
                    listRoadsTemp.add(new Pair(start, finish));
                }
            } else {
                diemCuoiCurrent = new Pair(start, finish);
                listRoadsTemp.add(new Pair(start, finish));
                flagDiemCuoi = false;
            }
        }
        ArrayList<Integer> listPointOfTrueRoad = new ArrayList<Integer>();

        StringBuilder result = new StringBuilder();
        result.append("    Đường đi từ " + getPointIndicatorFromPosition(sPoint) + " -> "
                + getPointIndicatorFromPosition(currentFinishPoint) + " :      "
                + getPointIndicatorFromPosition(sPoint) + "   ->   ");

        for (int i = listRoadsTemp.size() - 1; i >= 0; i--) {
            listPointOfTrueRoad.add(getPointIndicatorFromPosition(listRoadsTemp.get(i).getValue()));
            System.out.println(getPointIndicatorFromPosition(listRoadsTemp.get(i).getValue()) + " -> ");
        }

        for (int i = 1; i < listPointOfTrueRoad.size(); i++) {
            result.append(listPointOfTrueRoad.get(i) + "   ->   ");
        }
        result.replace(result.length() - 5, result.length(), "");

        // xuất đường đi  
        result.append("        ---       Tổng độ dài :  " + currentLength);
        lblBieuDienThuatToan.setText(result.toString());

        // table thuật toán
        listPointOfTrueRoad.add(0, getPointIndicatorFromPosition(sPoint));
        ArrayList<Pair<Integer, Integer>> listCellSelectedPointPosition = getListCellSelectedPosition(listPointOfTrueRoad, listLinePassed);
        mTableModelThuatToan = new DefaultTableModel(listDataForTable, mMaTran.getColumnsName());
        tblThuatToan.setModel(mTableModelThuatToan);
        FunctionUtils.updateTableWithSelectedCells(tblThuatToan, listCellSelectedPointPosition);

        // vẽ đường đi lên đồ thị 
        mDrawDoThi.drawRoad(listPointOfTrueRoad);
    }

    int getPointIndicatorFromPosition(int pointPosition) {
        return mMaTran.getListPoints().get(pointPosition).getIndicator();
    }

    int getPointPositionFromIndicator(int pointIndicator) {
        Object[] listIndicator = mMaTran.getColumnsName();
        for (int i = 0; i < listIndicator.length; i++) {
            int indicator = Integer.parseInt(listIndicator[i].toString());
            if (indicator == pointIndicator) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void callBackUpdatedFromDrawDoThi(DrawDoThi.Flag flagUpdate, ArrayList<ShapePoint> listShapePoints,
            ArrayList<ShapeLine> listShapeLines
    ) {
        ArrayList<MPoint> listPoints = FunctionUtils.convertListShapeToListPoint(listShapePoints, listShapeLines);
        /**
         * sort lại các point
         */
        listPoints.sort(new Comparator<MPoint>() {
            @Override
            public int compare(MPoint o1, MPoint o2) {
                return o1.getIndicator() - o2.getIndicator();
            }
        });

        /**
         * sort lại các line của point đó
         */
        for (MPoint point : listPoints) {
            ArrayList<Line> listLines = point.getListLine();
            for (int j = 0; j < listLines.size(); j++) {
                listLines.sort(new Comparator<Line>() {
                    @Override
                    public int compare(Line o1, Line o2) {
                        return o1.getEndIndicator() - o2.getEndIndicator();
                    }
                });
            }
        }

        // cập nhật lại ma trận  
        mMaTran.updateMaTranWithListPoints(listPoints);
        // cập nhật dữ liệu trên table Ma trận 
        mTableModelMaTran = new DefaultTableModel(mMaTran.getListVariable(), mMaTran.getColumnsName());
        mTableModelMaTran.addTableModelListener(this);
        tblMaTran.setModel(mTableModelMaTran);
        FunctionUtils.updateHeightOfRowInTable(tblMaTran);

        // xoá hiển thị kết quả đường đi trước đó
        lblBieuDienThuatToan.setText("Hiển thị đường đi và kết quả thuật toán");

        mTableModelThuatToan = new DefaultTableModel(null, new Object[]{});
        tblThuatToan.setModel(mTableModelThuatToan);

        // cập nhật combobox đường đi 
        cmbDiemXuatPhat.removeAllItems();
        cmbDiemCuoi.removeAllItems();
        for (int i = 0; i < mMaTran.getListPoints().size(); i++) {
            int point = mMaTran.getListPoints().get(i).getIndicator();
            cmbDiemXuatPhat.addItem("" + point);
            cmbDiemCuoi.addItem("" + point);
        }
    }

    @Override
    public void handleWithActionChayTuDong() {
        stepIndicator = 0;
        boolean isValid = checkValidBeforeExecute();
        if (isValid) {

            // lấy dữ liệu từ giải thuật dijkstra
            int soDinh = mMaTran.getListPoints().size();
            int sPoint = Integer.parseInt(cmbDiemXuatPhat.getSelectedItem().toString());
            int fPoint = Integer.parseInt(cmbDiemCuoi.getSelectedItem().toString());

            int startPosition = getPointPositionFromIndicator(sPoint);
            int finishPosition = getPointPositionFromIndicator(fPoint);
            mListDataOfTwoPointForOneStep = Dijkstra.dijkstra(FunctionUtils.convertListObjectToListInt(mMaTran.getListVariable()),
                    soDinh,
                    startPosition,
                    finishPosition);

            // Tạo Data cho vào table Thuật Toán 
            Object[][] listVariableForTable = new Object[mListDataOfTwoPointForOneStep.size()][soDinh];

            ArrayList<DataPerStepForRunAutomatically> listDPS = new ArrayList<DataPerStepForRunAutomatically>();
            ArrayList<Line> listLinePassed = new ArrayList<Line>();

            for (int step = 0; step < mListDataOfTwoPointForOneStep.size(); step++) {
                DataPerStepForDijkstra item = mListDataOfTwoPointForOneStep.get(step);
                int finishPoint = item.getFinishPoint();
                int startPoint = item.getStartPoint();
                listLinePassed.add(
                        new Line(getPointIndicatorFromPosition(startPoint),
                                getPointIndicatorFromPosition(finishPoint),
                                item.getCurrentValue()));

                // tạo dữ liệu cho mỗi bước 
                ArrayList<Line> listLinePassedOfCurrentStep = new ArrayList<Line>();
                listLinePassedOfCurrentStep.addAll(listLinePassed);
                ArrayList<Line> listLineTesting = new ArrayList<Line>();

                // đánh dấu những điểm đã đi qua 
                ArrayList<Integer> listPointMarked = item.getListPointMarked();
                for (int i = 0; i < listPointMarked.size(); i++) {
                    listVariableForTable[step][listPointMarked.get(i)] = "---";
                }

                for (Entry<Integer, Integer> item2 : item.getListValue().entrySet()) {
                    int pointConnected = item2.getKey();
                    int valueOfPointConnected = item2.getValue();
                    // step > 0 => bước > 1 
                    if (step != 0) {
                        Object[][] listVariables = mMaTran.getListVariable();
                        // những điểm không thể kết nối được 
                        if ((listVariables[startPoint][pointConnected]).toString().equals("0")) {
                            listVariableForTable[step][pointConnected] = "[ @ ," + getPointIndicatorFromPosition(startPoint) + " ]";
                        } else {
                            // những điểm có thể kết nối nhưng không phải là điểm được chọn 
                            if (pointConnected != finishPoint) {
                                listVariableForTable[step][pointConnected] = "[ " + valueOfPointConnected
                                        + " , " + getPointIndicatorFromPosition(startPoint) + " ]";

                                Line line = new Line(
                                        getPointIndicatorFromPosition(startPoint),
                                        getPointIndicatorFromPosition(pointConnected),
                                        valueOfPointConnected);
                                listLineTesting.add(line);
                            } // Điểm được chọn 
                            else {
                                listVariableForTable[step][pointConnected] = "[ " + valueOfPointConnected
                                        + " , " + getPointIndicatorFromPosition(startPoint) + " ]";

                                Line line = new Line(
                                        getPointIndicatorFromPosition(startPoint),
                                        getPointIndicatorFromPosition(pointConnected),
                                        valueOfPointConnected);
                                listLineTesting.add(line);
                            }
                        }
                    } // step == 0 => bước 1 => kết nối với chính điểm đầu tiên  
                    else {

                        // những điểm không kết nối được 
                        if (pointConnected != startPoint) {
                            listVariableForTable[step][pointConnected] = "[ @ ," + getPointIndicatorFromPosition(startPoint) + " ]";
                        } // kết nối được ( điểm đầu tiên - startPoint )
                        else {
                            listVariableForTable[step][pointConnected] = "[ " + valueOfPointConnected
                                    + " , " + getPointIndicatorFromPosition(startPoint) + " ]";

                            Line line = new Line(
                                    getPointIndicatorFromPosition(startPoint),
                                    getPointIndicatorFromPosition(pointConnected),
                                    valueOfPointConnected);
                            listLineTesting.add(line);
                        }
                    }
                }

                Object[][] listVariable = new Object[step + 1][soDinh];
                for (int i = 0; i <= step; i++) {
                    for (int j = 0; j < soDinh; j++) {
                        listVariable[i][j] = listVariableForTable[i][j];
                    }
                }

                DataPerStepForRunAutomatically dps = new DataPerStepForRunAutomatically(
                        listLineTesting,
                        getPointIndicatorFromPosition(startPoint),
                        getPointIndicatorFromPosition(finishPoint),
                        listLinePassedOfCurrentStep,
                        listVariable,
                        false);
                if (step == mListDataOfTwoPointForOneStep.size() - 1) {
                    dps.setIsFinalStep(true);
                }
                listDPS.add(dps);
            }

            // vẽ lên đồ thị 
            long delayTime = Long.parseLong(cmbDelayTime.getSelectedItem().toString());
            mDrawDoThi.drawDoThiWithActionChayTuDong(listDPS, delayTime);
        }
    }

    @Override
    public void tableChanged(TableModelEvent e
    ) {
        if (e.getType() == TableModelEvent.UPDATE) {
            try {
                int rowUpdate = tblMaTran.getSelectedRow();
                int columnUpdate = tblMaTran.getSelectedColumn();
                String newValue = (tblMaTran.getValueAt(rowUpdate, columnUpdate)).toString();
                System.out.println("Row : " + rowUpdate + " --- Column : " + columnUpdate);
                handleWithUpdateValueOfLineOnTableMaTran(newValue, rowUpdate, columnUpdate);
            } catch (Exception e1) {

            }
        }
    }

    @Override
    public void handleWithUpdateValueOfLineOnTableMaTran(String value, int pointStartPosition, int pointEndPosition) {
        // Exception : không có đường đi point -> chính point đó 
        if (pointStartPosition == pointEndPosition) {
            JOptionPane.showMessageDialog(this, "Không có đường đi từ điểm -> chính điểm đó");
            mTableModelMaTran = new DefaultTableModel(mMaTran.getListVariable(), mMaTran.getColumnsName());
            mTableModelMaTran.addTableModelListener(this);
            tblMaTran.setModel(mTableModelMaTran);
            FunctionUtils.updateHeightOfRowInTable(tblMaTran);
            return;
        }

        // Exception : không thể tạo line 2 chiều trong Ma trận 
        if (mMaTran.isMode() == Mode.CoHuong) {
            int vl = Integer.parseInt(mMaTran.getListVariable()[pointEndPosition][pointStartPosition].toString());
            if (vl != 0) {
                JOptionPane.showMessageDialog(this, "Không thể tạo Line 2 chiều");
                mTableModelMaTran = new DefaultTableModel(mMaTran.getListVariable(), mMaTran.getColumnsName());
                mTableModelMaTran.addTableModelListener(this);
                tblMaTran.setModel(mTableModelMaTran);
                FunctionUtils.updateHeightOfRowInTable(tblMaTran);
                return;
            }
        }

        // update || add
        try {
            MPoint startPoint = mMaTran.getListPoints().get(pointStartPosition);
            MPoint endPoint = mMaTran.getListPoints().get(pointEndPosition);

            int newValue = Integer.parseInt(value);

            // Exception : không thể tạo Line có value < 0 
            if (newValue < 0) {
                JOptionPane.showMessageDialog(this, "Không thể tạo Line có giá trị < 0");
                mTableModelMaTran = new DefaultTableModel(mMaTran.getListVariable(), mMaTran.getColumnsName());
                mTableModelMaTran.addTableModelListener(this);
                tblMaTran.setModel(mTableModelMaTran);
                FunctionUtils.updateHeightOfRowInTable(tblMaTran);
                return;
            }

            boolean isUpdate = false; // flag kiểm tra xem là cập nhật hay là thêm mới đường thẳng 
            boolean isUpdateOnVirtualLine = false; // flag kiểm tra xem là cập nhật trên Line ảo ( Line được sinh ra bởi ma trận vô hướng)

            // kiểm tra update trong trường hợp Ma trận có hướng 
            if (mMaTran.isMode() == Mode.CoHuong) {
                int v1 = Integer.parseInt(mMaTran.getListVariable()[pointStartPosition][pointEndPosition].toString());
                if (v1 > 0) {
                    for (Line line : startPoint.getListLine()) {
                        if (line.getEndIndicator() == endPoint.getIndicator()) {
                            line.setValue(newValue);
                            isUpdate = true;
                            System.out.println("Update");
                            break;
                        }
                    }
                }
            }

            // kiểm tra update trong trường hợp Ma trận vô hướng
            if (mMaTran.isMode() == Mode.VoHuong) {
                int v1 = Integer.parseInt(mMaTran.getListVariable()[pointStartPosition][pointEndPosition].toString());
                if (v1 > 0) {
                    // kiểm tra xem đường thẳng mới được cập nhật là Line thật ( có hướng ) hay Line ảo ( được sinh ra bởi ma trận vô hướng ) 
                    // kiểm tra xem có phải là cập nhật trên Line thật ( có hướng ) 
                    int v2 = Integer.parseInt(mMaTran.getlistVariableCoHuong()[pointStartPosition][pointEndPosition].toString());
                    // line thật
                    if (v2 > 0) {
                        for (Line line : startPoint.getListLine()) {
                            if (line.getEndIndicator() == endPoint.getIndicator()) {
                                System.out.println("cập nhật trên line thật");
                                line.setValue(newValue);
                                isUpdate = true;
                                break;
                            }
                        }
                    } // line ảo
                    else {
                        for (Line line : endPoint.getListLine()) {
                            System.out.println("cập nhật trên line ảo");
                            if (line.getEndIndicator() == startPoint.getIndicator()) {
                                line.setValue(newValue);
                                isUpdate = true;
                                isUpdateOnVirtualLine = true;
                                break;
                            }

                        }
                    }
                }
            }

            // thêm mới đường thẳng 
            if (isUpdate == false) {
                for (Line line : startPoint.getListLine()) {
                    if (line.getEndIndicator() == endPoint.getIndicator()) {
                        line.setValue(newValue);
                    }
                }
            }

            // vẽ lại trên đổ thị 
            ShapeLine newShapeLine = new ShapeLine(
                    startPoint.getOriginPoint(),
                    endPoint.getOriginPoint(),
                    newValue,
                    (mMaTran.isMode() == Mode.CoHuong),
                    false,
                    startPoint.getIndicator(),
                    endPoint.getIndicator());

            // update new value 
            if (isUpdate) {
                if (isUpdateOnVirtualLine == false) {
                    mDrawDoThi.callBackChangeValueOfLine(newShapeLine);
                } else {
                    newShapeLine.setStartIndicator(endPoint.getIndicator());
                    newShapeLine.setFinishIndicator(startPoint.getIndicator());

                    mDrawDoThi.callBackChangeValueOfLine(newShapeLine);
                }
            } // add new line
            else {
                System.out.println("Add new Line ");
                mDrawDoThi.addNewShapeLine(newShapeLine);
            }
            mDrawDoThi.drawDoThiUnselected();

            // cập nhật toàn ma trận
            ArrayList<MPoint> listPoints = new ArrayList<MPoint>();
            listPoints.addAll(mMaTran.getListPoints());
            mMaTran.updateMaTranWithListPoints(listPoints);

            // clear table thuật toán
            mTableModelThuatToan = new DefaultTableModel(new Object[][]{}, new Object[]{});
            tblThuatToan.setModel(mTableModelThuatToan);

            // clear label đường đi 
            lblBieuDienThuatToan.setText("");

            // cập nhật trên table Ma Tran
            mTableModelMaTran = new DefaultTableModel(mMaTran.getListVariable(), mMaTran.getColumnsName());
            mTableModelMaTran.addTableModelListener(this);
            tblMaTran.setModel(mTableModelMaTran);
            FunctionUtils.updateHeightOfRowInTable(tblMaTran);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Nhập giá trị không hợp lệ ! mời nhập số nguyên dương");
            mTableModelMaTran = new DefaultTableModel(mMaTran.getListVariable(), mMaTran.getColumnsName());
            mTableModelMaTran.addTableModelListener(this);
            tblMaTran.setModel(mTableModelMaTran);
            FunctionUtils.updateHeightOfRowInTable(tblMaTran);
            return;
        }
    }

    @Override
    public void callBackUpdateViewPerStepWithActionChayTuDongFromDrawDoThi(DataPerStepForRunAutomatically dps
    ) {
        // show Đường đi  
        int startPointIndicator = Integer.parseInt(cmbDiemXuatPhat.getSelectedItem().toString());
        int finishPointIndicator = Integer.parseInt(cmbDiemCuoi.getSelectedItem().toString());
        StringBuilder resultPerStep = new StringBuilder();

        // kiểm tra có đường đi ở bước cuối hay không 
        if (dps.isIsFinalStep() == true) {
            if (dps.getFinishIndicator() != finishPointIndicator
                    || dps.getListLinesTesting().size() == 0) {
                resultPerStep.append("    Không có đường đi từ " + startPointIndicator + " -> " + finishPointIndicator);
                mTableModelThuatToan = new DefaultTableModel(dps.getTableVariable(), mMaTran.getColumnsName());
                tblThuatToan.setModel(mTableModelThuatToan);
                FunctionUtils.updateTableWithSelectedCells(tblThuatToan, new ArrayList<Pair<Integer, Integer>>());
                lblBieuDienThuatToan.setText(resultPerStep.toString());
                return;
            }
        }

        // lable đường đi của thuật toán 
        ArrayList<Integer> listPointOfTrueRoad = dps.getListPointOfTrueRoad();
        int t = 0;
        resultPerStep.append("    Đường đi từ " + startPointIndicator + "  ->  " + finishPointIndicator + " :      ");
        for (Integer point : dps.getListPointOfTrueRoad()) {
            if (t != 0) {
                resultPerStep.append(point + "   ->   ");
            }
            t++;
        }

        resultPerStep.replace(resultPerStep.length() - 5, resultPerStep.length(), "");
        int totalLength = 0;
        int pointBefore = listPointOfTrueRoad.get(0);
        for (int i = 0; i < listPointOfTrueRoad.size(); i++) {
            totalLength += (Integer.parseInt(
                    mMaTran.getListVariable()[getPointPositionFromIndicator(pointBefore)][getPointPositionFromIndicator(listPointOfTrueRoad.get(i))].toString()));
            pointBefore = listPointOfTrueRoad.get(i);
        }

        resultPerStep.append("        ---       Tổng độ dài :  " + totalLength);
        lblBieuDienThuatToan.setText(resultPerStep.toString());

        // table thuật toán
        ArrayList<Pair<Integer, Integer>> listCellSelectedPointPosition = getListCellSelectedPosition(listPointOfTrueRoad, dps.getListLinePassed());

        mTableModelThuatToan = new DefaultTableModel(dps.getTableVariable(), mMaTran.getColumnsName());
        tblThuatToan.setModel(mTableModelThuatToan);
        FunctionUtils.updateTableWithSelectedCells(tblThuatToan, listCellSelectedPointPosition);
    }

    public ArrayList<Pair<Integer, Integer>> getListCellSelectedPosition(ArrayList<Integer> listPointOfTrueRoad, ArrayList<Line> listLinePassed) {
        ArrayList<Pair<Integer, Integer>> listCellSelectedPointPosition = new ArrayList<Pair<Integer, Integer>>();
        int sizeOfTrueRoadPoint = listPointOfTrueRoad.size();

        for (Integer i : listPointOfTrueRoad) {
            System.err.println("True Road : " + i);
        }
        for (Line line : listLinePassed) {
            System.out.println("Start : " + line.getStartIndicator() + " - End : " + line.getEndIndicator() + " : " + line.getValue());
        }

//        // step 1 
//        if (sizeOfTrueRoadPoint < 2) {
//            int connectedPoint = listLinePassed.get(0).getEndIndicator();
//            listCellSelectedPointPosition.add(
//                    new Pair(0, getPointPositionFromIndicator(connectedPoint)));
//        } // step > 1
//        else {
//            int step = 1;
//            for (int i = 0; i < listLinePassed.size(); i++) {
//                Line line = listLinePassed.get(i);
//                int connectedPoint = listPointOfTrueRoad.get(step);
//                if (line.getEndIndicator() == connectedPoint) {
//                    listCellSelectedPointPosition.add(
//                            new Pair(i,
//                                    getPointPositionFromIndicator(line.getEndIndicator())));
//                    step++;
//                }
//            }
//        }
        for (int i = 0; i < listLinePassed.size(); i++) {
            Line line = listLinePassed.get(i);
            listCellSelectedPointPosition.add(new Pair(i, getPointPositionFromIndicator(line.getEndIndicator())));
        }
        return listCellSelectedPointPosition;
    }

    @Override
    public void handleWithSelectedDoThiCoHuong() {
        stepIndicator = 0;

        // cập nhật ma trận  ( mode ) 
        mMaTran.setMode(Mode.CoHuong);
        // cập nhật hiển thị bảng giá trị Ma trận 
        mTableModelMaTran = new DefaultTableModel(mMaTran.getListVariable(), mMaTran.getColumnsName());
        mTableModelMaTran.addTableModelListener(this);
        tblMaTran.setModel(mTableModelMaTran);
        FunctionUtils.updateHeightOfRowInTable(tblMaTran);
        // xoá hiển thị đường đi trước đó 
        lblBieuDienThuatToan.setText("");
        mTableModelThuatToan = new DefaultTableModel(null, new Object[]{});
        tblThuatToan.setModel(mTableModelThuatToan);
        // vẽ lại đồ thị 
        mDrawDoThi.drawWithMode(mMaTran.getListPoints(), true);
    }

    @Override
    public void handleWithSelectedDoThiVoHuong() {
        stepIndicator = 0;

        // cập nhật ma trận  ( mode ) 
        mMaTran.setMode(Mode.VoHuong);
        // cập nhật hiển thị bảng giá trị Ma trận 
        mTableModelMaTran = new DefaultTableModel(mMaTran.getListVariable(), mMaTran.getColumnsName());
        mTableModelMaTran.addTableModelListener(this);
        tblMaTran.setModel(mTableModelMaTran);
        FunctionUtils.updateHeightOfRowInTable(tblMaTran);
        // xoá hiển thị đường đi trước đó 
        lblBieuDienThuatToan.setText("");
        mTableModelThuatToan = new DefaultTableModel(null, new Object[]{});
        tblThuatToan.setModel(mTableModelThuatToan);
        // vẽ lại đồ thị 
        mDrawDoThi.drawWithMode(mMaTran.getListPoints(), false);
    }

    @Override
    public void handleWithSelectedDoThiTuVe() {
        stepIndicator = 0;

        // disable combobox DoThiCoSan
        cmbDoThiCoSan.setSelectedIndex(0);
        cmbDoThiCoSan.setEnabled(false);

        // clear Matrix 
        mMaTran.clearMaTran();

        // clear table MaTrans
        mTableModelMaTran = new DefaultTableModel(new Object[][]{}, new Object[]{});
        mTableModelMaTran.addTableModelListener(this);
        tblMaTran.setModel(mTableModelMaTran);

        // clear table thuật toán 
        mTableModelThuatToan = new DefaultTableModel(new Object[][]{}, new Object[]{});
        tblThuatToan.setModel(mTableModelThuatToan);

        // clear hiển thị đường đi của thuật toán 
        lblBieuDienThuatToan.setText("Hiển thị giá trị và đường đi của thuật toán");

        // xoá hiển thị đồ thị trước đó 
        mDrawDoThi.drawWithMode(mMaTran.getListPoints(), (mMaTran.isMode() == Mode.CoHuong));

        // clear trong combobox đường đi 
        cmbDiemCuoi.removeAllItems();
        cmbDiemCuoi.addItem("");
        cmbDiemXuatPhat.removeAllItems();
        cmbDiemXuatPhat.addItem("");
    }

    @Override
    public void handleWithSelectedDoThiCoSan() {
        stepIndicator = 0;

        // enable combobox DoThiCoSan
        cmbDoThiCoSan.setEnabled(true);

        mMaTran.clearMaTran();

        // Matrix == null 
        mMaTran = new Matrix(mMaTran.isMode(), mListDoThiCoSan.get(0), mListDoThiCoSanCoordinate.get(0));

        // vẽ lại đồ thị 
        mDrawDoThi.initShapeData(mMaTran.getListPoints(), mMaTran.isMode().equals(Mode.CoHuong));
        mDrawDoThi.repaint();

        // Table Ma Tran
        mTableModelMaTran = new DefaultTableModel(mMaTran.getListVariable(), mMaTran.getColumnsName());
        mTableModelMaTran.addTableModelListener(this);
        tblMaTran.setModel(mTableModelMaTran);
        FunctionUtils.updateHeightOfRowInTable(tblMaTran);

        // Table Thuat Toan
        mTableModelThuatToan = new DefaultTableModel(new Object[][]{}, mMaTran.getColumnsName());
        tblThuatToan.setModel(mTableModelThuatToan);

        // udpate MPoint of combobox ( Start - End ) 
        cmbDiemXuatPhat.removeAllItems();
        cmbDiemCuoi.removeAllItems();
        for (int i = 0; i < mMaTran.getListPoints().size(); i++) {
            int point = mMaTran.getListPoints().get(i).getIndicator();
            cmbDiemXuatPhat.addItem("" + point);
            cmbDiemCuoi.addItem("" + point);
        }
    }

    @Override
    public void handleWithSelectedDuongDiMoi() {
        stepIndicator = 0;
        clearViewOfOldRoad();
    }

    @Override
    public void handleWithSelectedDoThiCoSanPosition(int position) {
        stepIndicator = 0;
        if (position >= 0) {
            // Matrix == null 
            mMaTran = new Matrix(mMaTran.isMode(), mListDoThiCoSan.get(position), mListDoThiCoSanCoordinate.get(position));

            // vẽ lại đồ thị 
            mDrawDoThi.initShapeData(mMaTran.getListPoints(), mMaTran.isMode().equals(Mode.CoHuong));
            mDrawDoThi.repaint();

            // Table Ma Tran
            mTableModelMaTran = new DefaultTableModel(mMaTran.getListVariable(), mMaTran.getColumnsName());
            mTableModelMaTran.addTableModelListener(this);
            tblMaTran.setModel(mTableModelMaTran);
            FunctionUtils.updateHeightOfRowInTable(tblMaTran);

            // Table Thuat Toan
            mTableModelThuatToan = new DefaultTableModel(new Object[][]{}, mMaTran.getColumnsName());
            tblThuatToan.setModel(mTableModelThuatToan);

            // udpate MPoint of combobox ( Start - End ) 
            cmbDiemXuatPhat.removeAllItems();
            cmbDiemCuoi.removeAllItems();
            for (int i = 0; i < mMaTran.getListPoints().size(); i++) {
                int point = mMaTran.getListPoints().get(i).getIndicator();
                cmbDiemXuatPhat.addItem("" + point);
                cmbDiemCuoi.addItem("" + point);
            }
        }
    }

    @Override
    public void handleWithActionChay1Lan() {
        stepIndicator = 0;
        boolean isValid = checkValidBeforeExecute();
        if (isValid) {
            int soDinh = mMaTran.getListPoints().size();
            int sPoint = Integer.parseInt(cmbDiemXuatPhat.getSelectedItem().toString());
            int fPoint = Integer.parseInt(cmbDiemCuoi.getSelectedItem().toString());

            int startPosition = getPointPositionFromIndicator(sPoint);
            int finishPosition = getPointPositionFromIndicator(fPoint);
            mListDataOfTwoPointForOneStep = Dijkstra.dijkstra(FunctionUtils.convertListObjectToListInt(mMaTran.getListVariable()),
                    soDinh,
                    startPosition,
                    finishPosition);

            showDataWithStepIndicator(startPosition, finishPosition,
                    mListDataOfTwoPointForOneStep.size(), mListDataOfTwoPointForOneStep.size(), soDinh);
        }
    }

    @Override
    public void handleWithActionChayTungBuoc() {
        boolean isValid = checkValidBeforeExecute();
        if (isValid) {
            stepIndicator++;

            int soDinh = mMaTran.getListPoints().size();
            int sPoint = Integer.parseInt(cmbDiemXuatPhat.getSelectedItem().toString());
            int fPoint = Integer.parseInt(cmbDiemCuoi.getSelectedItem().toString());
            // lấy list DataPerStepForDijkstra 

            int startPosition = getPointPositionFromIndicator(sPoint);
            int finishPosition = getPointPositionFromIndicator(fPoint);

            if (stepIndicator == 1) {
                mListDataOfTwoPointForOneStep = Dijkstra.dijkstra(FunctionUtils.convertListObjectToListInt(mMaTran.getListVariable()),
                        soDinh,
                        startPosition,
                        finishPosition);
                mDrawDoThi.drawDoThiUnselected();
            }
            showDataWithStepIndicator(startPosition, finishPosition, stepIndicator, mListDataOfTwoPointForOneStep.size(), soDinh);
        }
    }
}
