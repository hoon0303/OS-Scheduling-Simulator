package OMproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyDialog extends JDialog {
    JLabel tf = new JLabel("���ڸ� �Է��Ͻÿ�");
    JButton okButton = new JButton("OK");

    public MyDialog(JFrame frame, String title) {
        super(frame, title);
        setLayout(new FlowLayout());
        add(tf);
        add(okButton);
        setSize(200, 100);

        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }
}
