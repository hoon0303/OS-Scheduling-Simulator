package OMproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyDialog1 extends JDialog {
    JLabel tf = new JLabel("�����͸� ��Ȯ�� �Է��ϼ���");
    JButton okButton = new JButton("OK");

    public MyDialog1(JFrame frame, String title) {
        super(frame, title);
        setLayout(new FlowLayout());
        add(tf);
        add(okButton);
        setSize(400, 100);

        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }
}
