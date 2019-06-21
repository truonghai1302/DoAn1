/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Draw;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author DELL
 */
public class DialogRemoveLine extends JDialog {

    Container cp;
    JLabel lblText;
    JButton btnYes;
    JButton btnCancel;
    CallBackToDrawDoThi mCallBackToDrawDoThi;
    ShapeLine mDeleteLine ;

    public DialogRemoveLine(JFrame frame, DrawDoThi ddt , ShapeLine line) {
        super(frame, "Xoá 1 đường thẳng", true);
        mCallBackToDrawDoThi = ddt;
        this.mDeleteLine = line;
        initAndAddView();
        setEvent();
        configForDialog();
    }

    public void setEvent() {
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e); //To change body of generated methods, choose Tools | Templates.
                if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                    mCallBackToDrawDoThi.callBackRemoveLine(mDeleteLine);
                    setVisible(false);
                }
            }
        }
        );
        // yes 
        btnYes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mCallBackToDrawDoThi.callBackRemoveLine(mDeleteLine);
                setVisible(false);
            }
        });
        // cancel  
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                setVisible(false);

            }
        });
        // close <=> cancel
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e); //To change body of generated methods, choose Tools | Templates.
                setVisible(false);
            }
        });
    }

    void initAndAddView() {
        cp = getContentPane();
        cp.setLayout(new FlowLayout());
        lblText = new JLabel("Bạn có muốn xoá đường thẳng này không ?");
        btnYes = new JButton("Đồng ý");
        btnCancel = new JButton("Huỷ bỏ");
        cp.add(lblText);
        cp.add(btnYes);
        cp.add(btnCancel);
    }

    void configForDialog() {
        setSize(280, 120);
        setLocationRelativeTo(null);
        getRootPane().setWindowDecorationStyle(JRootPane.INFORMATION_DIALOG);
    }
}
