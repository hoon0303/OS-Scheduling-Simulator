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

        backbtn = new JButton("�ڷ�");
        backbtn.setSize(120, 80);
        backbtn.setLocation(1150, 600);
        backbtn.setBackground(Color.WHITE);
        add(backbtn);

        label = new JLabel("���̵�");
        label.setFont(new Font(null, Font.PLAIN, 50));
        label.setLocation(100, 80);
        label.setSize(800, 50);
        add(label);
        label.setVisible(true);

        label1 = new JLabel("1. ���� ��ư Ŭ��:");
        label1.setFont(new Font(null, Font.PLAIN, 30));
        label1.setLocation(120, 150);
        label1.setSize(800, 40);
        add(label1);
        label1.setVisible(true);

        label2 = new JLabel("- ���α׷��� �����Ϸ��� '����' ��ư�� Ŭ���ϼ���.");
        label2.setFont(new Font(null, Font.PLAIN, 25));
        label2.setLocation(140, 190);
        label2.setSize(1000, 30);
        add(label2);
        label2.setVisible(true);

        label3 = new JLabel("2. ���μ��� ������ �Է�:");
        label3.setFont(new Font(null, Font.PLAIN, 30));
        label3.setLocation(120, 240);
        label3.setSize(800, 40);
        add(label3);
        label3.setVisible(true);

        label4 = new JLabel("- ���μ��� ��, ���� �ð�, ���� �ð�, �켱������ �Է��ϼ���.");
        label4.setFont(new Font(null, Font.PLAIN, 25));
        label4.setLocation(140, 280);
        label4.setSize(1000, 30);
        add(label4);
        label4.setVisible(true);

        label5 = new JLabel("3. �ð� �Ҵ緮 ���� (���� ����):");
        label5.setFont(new Font(null, Font.PLAIN, 30));
        label5.setLocation(120, 330);
        label5.setSize(1000, 40);
        add(label5);
        label5.setVisible(true);

        label6 = new JLabel("- ���� �κ� �˰����� ����Ϸ��� �ð� �Ҵ緮�� �Է��ϼ���.");
        label6.setFont(new Font(null, Font.PLAIN, 25));
        label6.setLocation(140, 370);
        label6.setSize(1000, 30);
        add(label6);
        label6.setVisible(true);

        label7 = new JLabel("4. �����ٸ� �˰��� ���� �� ��� Ȯ��:");
        label7.setFont(new Font(null, Font.PLAIN, 30));
        label7.setLocation(120, 420);
        label7.setSize(1000, 40);
        add(label7);
        label7.setVisible(true);

        JLabel label8 = new JLabel("- �˰����� �����Ͽ� ���μ����� ó�� ����� Ȯ���ϼ���.");
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
