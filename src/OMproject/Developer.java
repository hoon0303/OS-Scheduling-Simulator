package OMproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Developer extends JPanel {
    private OS mainpanel;
    private JButton backbtn;
    private JLabel label, label1, label2, label3;

    public Developer(OS mainpanel) {
        this.mainpanel = mainpanel;
        setLayout(null);

        backbtn = new JButton("뒤로");
        backbtn.setSize(120, 80);
        backbtn.setLocation(1150, 600);
        backbtn.setBackground(Color.WHITE);
        add(backbtn);

        label = new JLabel("OM 개발팀 소개");
        label.setFont(new Font(null, Font.PLAIN, 50));
        label.setLocation(100, 80);
        label.setSize(500, 50);
        add(label);
        label.setVisible(true);

        label1 = new JLabel("박훈 : swing, 스케줄링 개발");
        label1.setFont(new Font(null, Font.PLAIN, 30));
        label1.setLocation(120, 170);
        label1.setSize(500, 40);
        add(label1);
        label1.setVisible(true);

        label2 = new JLabel("정승영 : 스케줄링 개발");
        label2.setFont(new Font(null, Font.PLAIN, 30));
        label2.setLocation(120, 230);
        label2.setSize(500, 40);
        add(label2);
        label2.setVisible(true);

        label2 = new JLabel("백동준 : 스케줄링 개발");
        label2.setFont(new Font(null, Font.PLAIN, 30));
        label2.setLocation(120, 290);
        label2.setSize(500, 40);
        add(label2);
        label2.setVisible(true);

        backbtn.addActionListener(new MyActionListener());
    }

    class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == backbtn)
                mainpanel.panel_change("start");

        }
    }
}
