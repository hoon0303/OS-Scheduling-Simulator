package OMproject;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Setting extends JPanel {
    private OS mainpanel;
    private JButton cntbtn, jButton1, backbtn, Testbtn;
    private JTextField cntText, Timetext;
    private JLabel text, TimeLabel;
    private DefaultTableModel model;
    private JTable table;
    private JDialog dialog;

    public Setting(OS mainpanel) {
        this.mainpanel = mainpanel;
        setLayout(null);
        TimeLabel = new JLabel("시간할당량을 입력하시오");
        TimeLabel.setSize(400, 40);
        TimeLabel.setFont(new Font(null, Font.PLAIN, 20));
        TimeLabel.setLocation(20, 150);
        add(TimeLabel);

        Timetext = new JTextField(20);
        Timetext.setSize(140, 40);
        Timetext.setFont(new Font(null, Font.PLAIN, 40));
        Timetext.setLocation(30, 200);
        Timetext.setBackground(Color.white);
        add(Timetext);

        text = new JLabel("프로세스 수를 입력하시오");
        text.setSize(400, 40);
        text.setFont(new Font(null, Font.PLAIN, 20));
        text.setLocation(20, 40);
        add(text);

        cntbtn = new JButton("입력");
        cntbtn.setSize(80, 40);
        cntbtn.setLocation(160, 90);
        cntbtn.setBackground(Color.WHITE);
        add(cntbtn);

        cntText = new JTextField(20);
        cntText.setSize(120, 40);
        cntText.setFont(new Font(null, Font.PLAIN, 40));
        cntText.setLocation(30, 90);
        cntText.setBackground(Color.white);
        add(cntText);

        jButton1 = new JButton("다음");
        jButton1.setSize(120, 80);
        jButton1.setLocation(1150, 600);
        jButton1.setBackground(Color.WHITE);
        add(jButton1);

        backbtn = new JButton("뒤로");
        backbtn.setSize(120, 80);
        backbtn.setLocation(1000, 600);
        backbtn.setBackground(Color.WHITE);
        add(backbtn);

        Testbtn = new JButton("테스트데이터");
        Testbtn.setSize(120, 80);
        Testbtn.setLocation(1000, 200);
        Testbtn.setBackground(Color.WHITE);
        add(Testbtn);

        String head[] = {"프로세스 ID", "도착시간", "서비스시간", "우선순위"};
        model = new DefaultTableModel(null, head);
        table = new JTable(model);
        table.setFont(new Font(null, Font.PLAIN, 25));
        table.setRowHeight(30);

        JScrollPane scroll = new JScrollPane(table);
        scroll.setSize(600, 400);
        scroll.setLocation(290, 140);
        add(scroll);

        Testbtn.addActionListener(new MyActionListener());
        backbtn.addActionListener(new MyActionListener());
        cntbtn.addActionListener(new MyActionListener());
        jButton1.addActionListener(new MyActionListener());
    }

    static boolean isNumber(String s) {
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
            if (c < 48 || c > 57) {
                return false;
            }
        }
        return true;
    }

    public void SqliteData() {
        int cnt = table.getRowCount();
        for (int i = 0; i < cnt; i++) {
            model.removeRow(0);
        }
        Connection connection = null;
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            System.out.println("org.sqlite.JDBC를 찾지 못했습니다.");
        }
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:TestData.db");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from test_db");
            while (rs.next()) {
                String new_data[] = {rs.getString("ID"), rs.getString("ArriveTime"), rs.getString("ServiceTime"), rs.getString("Priority")};
                model.addRow(new_data);
                Timetext.setText(rs.getString("TimeQuantum"));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == jButton1) {
                for (int i = 0; i < table.getRowCount(); i++) {
                    for (int j = 1; j < 4; j++) {
                        if (!isNumber((String) table.getValueAt(i, j)) || ((String) table.getValueAt(i, j)).length() == 0) {
                            MyDialog1 dialog1 = new MyDialog1(mainpanel, "데이터를 정확히 입력하세요");
                            dialog1.setVisible(true);
                            return;
                        }
                    }
                }
                if (!isNumber(Timetext.getText()) || Timetext.getText().length() == 0) {
                    MyDialog1 dialog1 = new MyDialog1(mainpanel, "시간 할당량을 확인해주세요");
                    dialog1.setVisible(true);
                    return;
                }

                mainpanel.dataArray = new ProcessData[table.getRowCount()];
                for (int i = 0; i < table.getRowCount(); i++) {
                    mainpanel.dataArray[i] = new ProcessData();
                    String temp = (String) table.getValueAt(i, 0);
                    mainpanel.dataArray[i].ID = temp;
                    temp = (String) table.getValueAt(i, 1);
                    mainpanel.dataArray[i].ArriveTime = Integer.parseInt(temp);
                    temp = (String) table.getValueAt(i, 2);
                    mainpanel.dataArray[i].ServiceTime = Integer.parseInt(temp);
                    temp = (String) table.getValueAt(i, 3);
                    mainpanel.dataArray[i].Priority = Integer.parseInt(temp);
                    temp = Timetext.getText();
                    mainpanel.dataArray[i].TimeQuantum = Integer.parseInt(temp);
                }
                mainpanel.panel_change("result");
            } else if (e.getSource() == backbtn) {
                mainpanel.panel_change("start");
            } else if (e.getSource() == Testbtn) {
                SqliteData();
            } else {
                int cnt = table.getRowCount();
                for (int i = 0; i < cnt; i++) {
                    model.removeRow(0);
                }
                String temp = cntText.getText();
                int cnt1;

                if (!isNumber(temp) || temp.length() == 0) {
                    dialog = new MyDialog(mainpanel, "오류");
                    dialog.setVisible(true);
                    cntText.setText("");
                    cnt1 = 0;
                } else
                    cnt1 = Integer.parseInt(temp);
                String new_data[] = {"", "", "", ""};
                for (int i = 0; i < cnt1; i++) {
                    new_data[0] = "p" + (i + 1);
                    model.addRow(new_data);
                }
            }
        }
    }
}
