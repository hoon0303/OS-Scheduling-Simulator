package OMproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Start extends JPanel {
    private OS mainpanel;
    private JButton jButton1, jButton2, jButton3;

    public Start(OS mainpanel) {
        this.mainpanel = mainpanel;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 40));

        JLabel label = new JLabel("OM 프로젝트");
        label.setFont(new Font(null, Font.PLAIN, 80));
        panel.add(label);
        add(panel);

        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 100));
        jButton1 = new JButton("시작");
        jButton1.setPreferredSize(new Dimension(250, 200));
        jButton1.setFont(new Font(null, Font.PLAIN, 50));
        jButton1.setBackground(Color.WHITE);
        panel1.add(jButton1);
        jButton2 = new JButton("가이드");
        jButton2.setPreferredSize(new Dimension(250, 200));
        jButton2.setFont(new Font(null, Font.PLAIN, 50));
        jButton2.setBackground(Color.WHITE);
        panel1.add(jButton2);
        jButton3 = new JButton("제작자");
        jButton3.setPreferredSize(new Dimension(250, 200));
        jButton3.setFont(new Font(null, Font.PLAIN, 50));
        jButton3.setBackground(Color.WHITE);
        panel1.add(jButton3);

        add(panel1);

        jButton1.addActionListener(new MyActionListener());
        jButton2.addActionListener(new MyActionListener());
        jButton3.addActionListener(new MyActionListener());
    }

    class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == jButton1)
                mainpanel.panel_change("setting");
            else if (e.getSource() == jButton2)
                mainpanel.panel_change("guide");
            else
                mainpanel.panel_change("developer");
        }
    }
}
