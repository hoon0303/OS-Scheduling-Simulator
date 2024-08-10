package OMproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Guide extends JPanel {
    private OS mainpanel;
    private JButton backbtn;
    private JLabel label, label1, label2, label3, label4, label5, label6, label7;

    public Guide(OS mainpanel) {
        this.mainpanel = mainpanel;
        setLayout(null);

        backbtn = new JButton("뒤로");
        backbtn.setSize(120, 80);
        backbtn.setLocation(1150, 600);
        backbtn.setBackground(Color.WHITE);
        add(backbtn);

        label = new JLabel("가이드");
        label.setFont(new Font(null, Font.PLAIN, 50));
        label.setLocation(100, 80);
        label.setSize(800, 50);
        add(label);
        label.setVisible(true);

        label1 = new JLabel("1. 시작 버튼 클릭:");
        label1.setFont(new Font(null, Font.PLAIN, 30));
        label1.setLocation(120, 150);
        label1.setSize(800, 40);
        add(label1);
        label1.setVisible(true);

        label2 = new JLabel("- 프로그램을 시작하려면 '시작' 버튼을 클릭하세요.");
        label2.setFont(new Font(null, Font.PLAIN, 25));
        label2.setLocation(140, 190);
        label2.setSize(1000, 30);
        add(label2);
        label2.setVisible(true);

        label3 = new JLabel("2. 프로세스 데이터 입력:");
        label3.setFont(new Font(null, Font.PLAIN, 30));
        label3.setLocation(120, 240);
        label3.setSize(800, 40);
        add(label3);
        label3.setVisible(true);

        label4 = new JLabel("- 프로세스 수, 도착 시간, 서비스 시간, 우선순위를 입력하세요.");
        label4.setFont(new Font(null, Font.PLAIN, 25));
        label4.setLocation(140, 280);
        label4.setSize(1000, 30);
        add(label4);
        label4.setVisible(true);

        label5 = new JLabel("3. 시간 할당량 설정 (선택 사항):");
        label5.setFont(new Font(null, Font.PLAIN, 30));
        label5.setLocation(120, 330);
        label5.setSize(1000, 40);
        add(label5);
        label5.setVisible(true);

        label6 = new JLabel("- 라운드 로빈 알고리즘을 사용하려면 시간 할당량을 입력하세요.");
        label6.setFont(new Font(null, Font.PLAIN, 25));
        label6.setLocation(140, 370);
        label6.setSize(1000, 30);
        add(label6);
        label6.setVisible(true);

        label7 = new JLabel("4. 스케줄링 알고리즘 선택 및 결과 확인:");
        label7.setFont(new Font(null, Font.PLAIN, 30));
        label7.setLocation(120, 420);
        label7.setSize(1000, 40);
        add(label7);
        label7.setVisible(true);

        JLabel label8 = new JLabel("- 알고리즘을 선택하여 프로세스의 처리 결과를 확인하세요.");
        label8.setFont(new Font(null, Font.PLAIN, 25));
        label8.setLocation(140, 460);
        label8.setSize(1000, 30);
        add(label8);
        label8.setVisible(true);

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
