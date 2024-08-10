package OMproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import java.util.Vector;

public class Result extends JPanel {
    private OS mainpanel;
    private JButton backbtn, FCFSbtn, SJFbtn, SRTSbtn, Priority1Sbtn, Priority2Sbtn, RRbtn, HRNbtn;
    private JLabel label, TurnAroundTime, WaitingTime;
    private int x, y, w, h, sum = 0, location = 320, Maxlen = 950;
    private Vector<JButton> v = new Vector<>(10, 5);
    private Vector<Integer> vsize = new Vector<>(10, 5);
    private Vector<JLabel> vlabel = new Vector<>(10, 5);
    private Hashtable<String, Integer> ArriveTime = new Hashtable<>();
    private Hashtable<String, Integer> sameTime = new Hashtable<>();

    public Result(OS mainpanel) {
        this.mainpanel = mainpanel;
        setLayout(null);
        w = 250;
        h = 50;
        x = 30;
        y = 300;

        TurnAroundTime = new JLabel("평균 반환시간 : 0");
        TurnAroundTime.setSize(500, 50);
        TurnAroundTime.setFont(new Font(null, Font.PLAIN, 40));
        TurnAroundTime.setLocation(900, 300);
        add(TurnAroundTime);

        WaitingTime = new JLabel("평균 대기시간 : 0");
        WaitingTime.setSize(500, 50);
        WaitingTime.setFont(new Font(null, Font.PLAIN, 40));
        WaitingTime.setLocation(900, 370);
        add(WaitingTime);

        backbtn = new JButton("뒤로");
        backbtn.setSize(120, 80);
        backbtn.setLocation(1150, 600);
        backbtn.setBackground(Color.WHITE);
        add(backbtn);

        label = new JLabel("FCFS");
        label.setFont(new Font(null, Font.PLAIN, 40));
        label.setLocation(20, 60);
        label.setSize(300, 40);
        add(label);
        label.setVisible(true);
        setVisible(true);

        FCFSbtn = new JButton("FCFS");
        FCFSbtn.setPreferredSize(new Dimension(500, 50));
        FCFSbtn.setFont(new Font(null, Font.PLAIN, 30));
        FCFSbtn.setBackground(Color.gray);
        FCFSbtn.setSize(w, h);
        FCFSbtn.setLocation(x, y);
        add(FCFSbtn);

        SJFbtn = new JButton("SJF");
        SJFbtn.setPreferredSize(new Dimension(1000, 50));
        SJFbtn.setFont(new Font(null, Font.PLAIN, 30));
        SJFbtn.setBackground(Color.gray);
        SJFbtn.setSize(w, h);
        SJFbtn.setLocation(x, y = y + h);
        add(SJFbtn);

        SRTSbtn = new JButton("SRT");
        SRTSbtn.setPreferredSize(new Dimension(1000, 50));
        SRTSbtn.setFont(new Font(null, Font.PLAIN, 30));
        SRTSbtn.setBackground(Color.gray);
        SRTSbtn.setSize(w, h);
        SRTSbtn.setLocation(x, y = y + h);
        add(SRTSbtn);

        Priority1Sbtn = new JButton("비선점 Priority");
        Priority1Sbtn.setPreferredSize(new Dimension(1000, 50));
        Priority1Sbtn.setFont(new Font(null, Font.PLAIN, 30));
        Priority1Sbtn.setBackground(Color.gray);
        Priority1Sbtn.setSize(w, h);
        Priority1Sbtn.setLocation(x, y = y + h);
        add(Priority1Sbtn);

        Priority2Sbtn = new JButton("선점 Priority");
        Priority2Sbtn.setPreferredSize(new Dimension(1000, 50));
        Priority2Sbtn.setFont(new Font(null, Font.PLAIN, 30));
        Priority2Sbtn.setBackground(Color.gray);
        Priority2Sbtn.setSize(w, h);
        Priority2Sbtn.setLocation(x, y = y + h);
        add(Priority2Sbtn);

        RRbtn = new JButton("RR");
        RRbtn.setPreferredSize(new Dimension(1000, 50));
        RRbtn.setFont(new Font(null, Font.PLAIN, 30));
        RRbtn.setBackground(Color.gray);
        RRbtn.setSize(w, h);
        RRbtn.setLocation(x, y = y + h);
        add(RRbtn);

        HRNbtn = new JButton("HRN");
        HRNbtn.setPreferredSize(new Dimension(1000, 50));
        HRNbtn.setFont(new Font(null, Font.PLAIN, 30));
        HRNbtn.setBackground(Color.gray);
        HRNbtn.setSize(w, h);
        HRNbtn.setLocation(x, y = y + h);
        add(HRNbtn);

        backbtn.addActionListener(new MyActionListener());
        FCFSbtn.addActionListener(new MyActionListener());
        SJFbtn.addActionListener(new MyActionListener());
        SRTSbtn.addActionListener(new MyActionListener());
        Priority1Sbtn.addActionListener(new MyActionListener());
        Priority2Sbtn.addActionListener(new MyActionListener());
        RRbtn.addActionListener(new MyActionListener());
        HRNbtn.addActionListener(new MyActionListener());
    }

    public void Fcfs() {
        sum = 0;
        for (int i = 0; i < v.size(); i++) {
            v.get(i).setVisible(false);
            vlabel.get(i).setVisible(false);
        }
        v.removeAllElements();
        vsize.removeAllElements();
        vlabel.removeAllElements();
        ProcessData Fcfs[] = new ProcessData[mainpanel.dataArray.length];
        for (int i = 0; i < mainpanel.dataArray.length; i++) {
            Fcfs[i] = new ProcessData();
            Fcfs[i].ArriveTime = mainpanel.dataArray[i].ArriveTime;
            Fcfs[i].ID = mainpanel.dataArray[i].ID;
            Fcfs[i].Priority = mainpanel.dataArray[i].Priority;
            Fcfs[i].ServiceTime = mainpanel.dataArray[i].ServiceTime;
            Fcfs[i].TimeQuantum = mainpanel.dataArray[i].TimeQuantum;
        }
        ProcessData temp = new ProcessData();
        for (int i = 0; i < Fcfs.length; i++) {
            for (int j = i; j < Fcfs.length; j++) {
                if (Fcfs[i].ArriveTime > Fcfs[j].ArriveTime) {
                    temp = Fcfs[i];
                    Fcfs[i] = Fcfs[j];
                    Fcfs[j] = temp;
                }
            }
        }
        int time = 0;
        int response = 0;
        int waitsum;
        for (int i = 0; i < Fcfs.length; i++) {
            if (Fcfs[i].ArriveTime > time) {
                chartadd("", Fcfs[i].ArriveTime - time);
                time += Fcfs[i].ArriveTime - time;
            }
            chartadd(Fcfs[i].ID, Fcfs[i].ServiceTime);
            time += Fcfs[i].ServiceTime;
            response += time - Fcfs[i].ArriveTime;
        }
        waitsum = response;
        for (int i = 0; i < Fcfs.length; i++) {
            waitsum -= Fcfs[i].ServiceTime;
        }

        TurnAroundTime.setText("평균 반환시간 : " + (double) response / Fcfs.length);
        WaitingTime.setText("평균 대기시간 : " + (double) waitsum / Fcfs.length);
    }

    public void sjf1() {
        sum = 0;
        for (int i = 0; i < v.size(); i++) {
            v.get(i).setVisible(false);
            vlabel.get(i).setVisible(false);
        }
        v.removeAllElements();
        vsize.removeAllElements();
        vlabel.removeAllElements();
        ProcessData sjf[] = new ProcessData[mainpanel.dataArray.length];
        for (int i = 0; i < mainpanel.dataArray.length; i++) {
            sjf[i] = new ProcessData();
            sjf[i].ArriveTime = mainpanel.dataArray[i].ArriveTime;
            sjf[i].ID = mainpanel.dataArray[i].ID;
            sjf[i].Priority = mainpanel.dataArray[i].Priority;
            sjf[i].ServiceTime = mainpanel.dataArray[i].ServiceTime;
            sjf[i].TimeQuantum = mainpanel.dataArray[i].TimeQuantum;
        }
        ProcessData compare = new ProcessData();
        ProcessData temp = new ProcessData();
        int least;

        for (int i = 0; i < sjf.length; i++) {
            least = i;
            for (int j = i + 1; j < sjf.length; j++) {
                if (sjf[least].ArriveTime > sjf[j].ArriveTime) {
                    least = j;
                }
            }
            temp = sjf[i];
            sjf[i] = sjf[least];
            sjf[least] = temp;
        }
        compare.ServiceTime = 100;

        int time = 0;
        int response = 0;
        int waitsum;
        for (int i = 0; i < sjf.length; i++) {
            least = i;
            compare.ServiceTime = 100;
            for (int j = i; j < sjf.length; j++) {
                if (compare.ServiceTime == sjf[j].ServiceTime && sjf[j].ArriveTime <= time) {
                    if (sjf[j].ArriveTime < compare.ArriveTime)
                        least = j;
                }
                if (compare.ServiceTime > sjf[j].ServiceTime && sjf[j].ArriveTime <= time) {
                    least = j;
                    compare.ServiceTime = sjf[j].ServiceTime;
                }
                if (sjf[least].ArriveTime > time)
                    time += sjf[least].ArriveTime - time;
            }
            time = time + sjf[least].ServiceTime;
            temp = sjf[i];
            sjf[i] = sjf[least];
            sjf[least] = temp;
        }
        time = 0;
        for (int i = 0; i < sjf.length; i++) {
            if (sjf[i].ArriveTime > time) {
                chartadd("", sjf[i].ArriveTime - time);
                time += sjf[i].ArriveTime - time;
            }
            chartadd(sjf[i].ID, sjf[i].ServiceTime);
            time += sjf[i].ServiceTime;
            response += time - sjf[i].ArriveTime;
        }
        waitsum = response;
        for (int i = 0; i < sjf.length; i++) {
            waitsum -= sjf[i].ServiceTime;
        }

        TurnAroundTime.setText("평균 반환시간 : " + (double) response / sjf.length);
        WaitingTime.setText("평균 대기시간 : " + (double) waitsum / sjf.length);
    }

    public void srt() {
        sum = 0;
        for (int i = 0; i < v.size(); i++) {
            v.get(i).setVisible(false);
            vlabel.get(i).setVisible(false);
        }
        v.removeAllElements();
        vsize.removeAllElements();
        vlabel.removeAllElements();
        int least;
        ProcessData srt[] = new ProcessData[mainpanel.dataArray.length];
        for (int i = 0; i < mainpanel.dataArray.length; i++) {
            srt[i] = new ProcessData();
            srt[i].ArriveTime = mainpanel.dataArray[i].ArriveTime;
            srt[i].ID = mainpanel.dataArray[i].ID;
            srt[i].Priority = mainpanel.dataArray[i].Priority;
            srt[i].ServiceTime = mainpanel.dataArray[i].ServiceTime;
            srt[i].TimeQuantum = mainpanel.dataArray[i].TimeQuantum;
        }
        ProcessData temp = new ProcessData();

        for (int i = 0; i < srt.length; i++) {
            least = i;
            for (int j = i + 1; j < srt.length; j++) {
                if (srt[least].ArriveTime > srt[j].ArriveTime) {
                    least = j;
                }
            }
            temp = srt[i];
            srt[i] = srt[least];
            srt[least] = temp;
        }
        int present = 0;
        int size2 = 0;
        int time = srt[0].ArriveTime;
        int tmp;
        int count = 0;
        int waitsum = 0;
        int response = 0;
        int first = 0;
        if (time > 0) {
            chartadd("", time);
        }
        while (true) {
            if (count == srt.length)
                break;
            size2 = size2 + 1;

            srt[present].ServiceTime -= 1;
            time = time + 1;

            least = 0;
            if (srt[present].ServiceTime <= 0) {
                if (srt[present].ServiceTime == 0) {
                    response += time;
                    response -= srt[present].ArriveTime;
                    count++;
                    chartadd(srt[present].ID, size2);
                } else {
                    chartadd("", size2);
                }
                size2 = 0;

                for (int j = 0; j < srt.length; j++) {
                    if (srt[j].ServiceTime > 0 && srt[j].ArriveTime <= time) {
                        present = j;
                        break;
                    }
                }
                for (int j = 0; j < srt.length; j++) {
                    if (srt[j].ServiceTime < srt[present].ServiceTime && (srt[j].ServiceTime > 0) && srt[j].ArriveTime <= time)
                        present = j;
                }

            } else {
                tmp = present;
                for (int i = 0; i < srt.length; i++) {

                    if (srt[i].ServiceTime < srt[present].ServiceTime && (srt[i].ServiceTime > 0) && srt[i].ArriveTime <= time)
                        present = i;

                }
                if (tmp != present) {
                    first = time;
                    chartadd(srt[tmp].ID, size2);
                    size2 = 0;
                }

            }
        }
        waitsum = response;
        for (int i = 0; i < mainpanel.dataArray.length; i++) {
            waitsum -= mainpanel.dataArray[i].ServiceTime;
        }

        TurnAroundTime.setText("평균 반환시간 : " + (double) response / srt.length);

        WaitingTime.setText("평균대기시간 : " + (double) waitsum / srt.length);
    }

    public void Priority1() {
        sum = 0;
        for (int i = 0; i < v.size(); i++) {
            v.get(i).setVisible(false);
            vlabel.get(i).setVisible(false);
        }
        v.removeAllElements();
        vsize.removeAllElements();
        vlabel.removeAllElements();
        ProcessData compare = new ProcessData();
        ProcessData Priority1[] = new ProcessData[mainpanel.dataArray.length];
        for (int i = 0; i < mainpanel.dataArray.length; i++) {
            Priority1[i] = new ProcessData();
            Priority1[i].ArriveTime = mainpanel.dataArray[i].ArriveTime;
            Priority1[i].ID = mainpanel.dataArray[i].ID;
            Priority1[i].Priority = mainpanel.dataArray[i].Priority;
            Priority1[i].ServiceTime = mainpanel.dataArray[i].ServiceTime;
            Priority1[i].TimeQuantum = mainpanel.dataArray[i].TimeQuantum;
        }
        compare.Priority = 0;
        int least;
        int time = 0;
        ProcessData temp = new ProcessData();
        for (int i = 0; i < Priority1.length; i++) {
            least = i;
            compare.Priority = 0;
            for (int j = i; j < Priority1.length; j++) {
                if (compare.Priority == Priority1[j].Priority && Priority1[j].ArriveTime <= time) {
                    if (Priority1[j].ArriveTime < compare.ArriveTime)
                        least = j;
                }
                if (compare.Priority < Priority1[j].Priority && Priority1[j].ArriveTime <= time) {
                    least = j;
                    compare = Priority1[j];
                }
            }

            time = time + Priority1[least].ServiceTime;
            temp = Priority1[i];
            Priority1[i] = Priority1[least];
            Priority1[least] = temp;
        }
        int response = 0;
        int waitsum = 0;
        time = 0;
        for (int i = 0; i < Priority1.length; i++) {
            if (Priority1[i].ArriveTime > time) {
                chartadd("", Priority1[i].ArriveTime - time);
                time += Priority1[i].ArriveTime - time;
            }
            chartadd(Priority1[i].ID, Priority1[i].ServiceTime);
            time += Priority1[i].ServiceTime;
            response += time - Priority1[i].ArriveTime;
        }
        waitsum = response;
        for (int i = 0; i < Priority1.length; i++) {
            waitsum -= Priority1[i].ServiceTime;
        }

        TurnAroundTime.setText("평균 반환시간 : " + (double) response / Priority1.length);
        WaitingTime.setText("평균 대기시간 : " + (double) waitsum / Priority1.length);
    }

    public void Priority2() {

        sum = 0;
        for (int i = 0; i < v.size(); i++) {
            v.get(i).setVisible(false);
            vlabel.get(i).setVisible(false);
        }
        v.removeAllElements();
        vsize.removeAllElements();
        vlabel.removeAllElements();
        int least;
        ProcessData Priority2[] = new ProcessData[mainpanel.dataArray.length];
        for (int i = 0; i < mainpanel.dataArray.length; i++) {
            Priority2[i] = new ProcessData();
            Priority2[i].ArriveTime = mainpanel.dataArray[i].ArriveTime;

            Priority2[i].ID = mainpanel.dataArray[i].ID;
            Priority2[i].Priority = mainpanel.dataArray[i].Priority;
            Priority2[i].ServiceTime = mainpanel.dataArray[i].ServiceTime;
            Priority2[i].TimeQuantum = mainpanel.dataArray[i].TimeQuantum;
        }
        ProcessData temp = new ProcessData();

        for (int i = 0; i < Priority2.length; i++) {
            least = i;
            for (int j = i + 1; j < Priority2.length; j++) {
                if (Priority2[least].ArriveTime > Priority2[j].ArriveTime) {
                    least = j;
                }
            }
            temp = Priority2[i];
            Priority2[i] = Priority2[least];
            Priority2[least] = temp;
        }
        int present = 0;
        int size2 = 0;
        int time = Priority2[0].ArriveTime;
        int tmp;
        int count = 0;
        int start = 0;
        int waitsum = 0;
        int response = 0;
        int first = 0;
        if (time > 0) {
            chartadd("", time);
        }
        while (true) {

            if (count == Priority2.length)
                break;
            size2 = size2 + 1;
            start += 1;
            Priority2[present].ServiceTime -= 1;
            time = time + 1;
            least = 0;
            if (Priority2[present].ServiceTime <= 0) {

                if (Priority2[present].ServiceTime == 0) {
                    response += time;
                    response -= Priority2[present].ArriveTime;
                    count++;
                    chartadd(Priority2[present].ID, size2);
                } else {
                    chartadd("", size2);

                }
                size2 = 0;
                tmp = present;

                for (int j = 0; j < Priority2.length; j++) {
                    if (Priority2[j].ServiceTime > 0 && Priority2[j].ArriveTime <= time) {
                        present = j;
                        break;
                    }
                }
                for (int j = 0; j < Priority2.length; j++) {
                    if (Priority2[j].Priority > Priority2[present].Priority && (Priority2[j].ServiceTime > 0) && Priority2[j].ArriveTime <= time)
                        present = j;
                }

            } else {
                tmp = present;
                for (int i = 0; i < Priority2.length; i++) {
                    if (Priority2[i].Priority > Priority2[present].Priority && (Priority2[i].ServiceTime > 0) && Priority2[i].ArriveTime <= time)
                        present = i;
                }
                if (tmp != present) {
                    first = time;
                    chartadd(Priority2[tmp].ID, size2);
                    size2 = 0;
                    start = 0;
                }

            }
        }
        waitsum = response;
        for (int i = 0; i < mainpanel.dataArray.length; i++) {
            waitsum -= mainpanel.dataArray[i].ServiceTime;
        }
        TurnAroundTime.setText("평균 반환시간 : " + (double) response / Priority2.length);
        WaitingTime.setText("평균대기시간 : " + (double) waitsum / Priority2.length);

    }

    public void RR() {
        sum = 0;
        for (int i = 0; i < v.size(); i++) {
            v.get(i).setVisible(false);
            vlabel.get(i).setVisible(false);
        }
        v.removeAllElements();
        vsize.removeAllElements();
        vlabel.removeAllElements();
        int least;
        ProcessData temp = new ProcessData();

        ProcessData RR[] = new ProcessData[mainpanel.dataArray.length];
        for (int i = 0; i < mainpanel.dataArray.length; i++) {
            RR[i] = new ProcessData();
            RR[i].ArriveTime = mainpanel.dataArray[i].ArriveTime;
            RR[i].ID = mainpanel.dataArray[i].ID;
            RR[i].Priority = mainpanel.dataArray[i].Priority;
            RR[i].ServiceTime = mainpanel.dataArray[i].ServiceTime;
            RR[i].TimeQuantum = mainpanel.dataArray[i].TimeQuantum;
        }
        for (int i = 0; i < RR.length; i++) {
            least = i;
            for (int j = i + 1; j < RR.length; j++) {
                if (RR[least].ArriveTime > RR[j].ArriveTime) {
                    least = j;
                }
            }
            temp = RR[i];
            RR[i] = RR[least];
            RR[least] = temp;
        }
        int time = RR[0].ArriveTime;
        int response = 0;
        int count = 0, size2 = 0, present = 0;
        if (time > 0) {
            chartadd("", time);
        }
        while (true) {

            size2 = size2 + 1;
            RR[present].ServiceTime -= 1;
            time = time + 1;
            least = 0;

            if (RR[present].ServiceTime <= 0) {
                if (RR[present].ServiceTime == 0) {
                    response += time;
                    response -= RR[present].ArriveTime;
                    count++;
                    chartadd(RR[present].ID, size2);
                } else {
                    chartadd("", size2);
                }
                size2 = 0;
                if (count == RR.length)
                    break;

                for (int j = 0; j < RR.length; j++) {
                    present = present + 1;
                    if (present >= RR.length)
                        present = 0;
                    if (RR[present].ServiceTime > 0 && RR[present].ArriveTime <= time)
                        break;
                }
            } else if (size2 == RR[0].TimeQuantum) {

                chartadd(RR[present].ID, size2);
                size2 = 0;
                for (int j = 0; j < RR.length; j++) {
                    present = present + 1;

                    if (present >= RR.length)
                        present = 0;
                    if (RR[present].ServiceTime > 0 && RR[present].ArriveTime <= time)
                        break;

                }
            }
        }
        int waitsum = response;
        for (int i = 0; i < mainpanel.dataArray.length; i++) {
            waitsum -= mainpanel.dataArray[i].ServiceTime;
        }

        TurnAroundTime.setText("평균 반환시간 : " + (double) response / RR.length);

        WaitingTime.setText("평균대기시간 : " + (double) waitsum / RR.length);

    }

    public void HRN() {
        sum = 0;
        for (int i = 0; i < v.size(); i++) {
            v.get(i).setVisible(false);
            vlabel.get(i).setVisible(false);
        }
        v.removeAllElements();
        vsize.removeAllElements();
        vlabel.removeAllElements();
        int least;
        ProcessData HRN[] = new ProcessData[mainpanel.dataArray.length];
        for (int i = 0; i < mainpanel.dataArray.length; i++) {
            HRN[i] = new ProcessData();
            HRN[i].ArriveTime = mainpanel.dataArray[i].ArriveTime;
            HRN[i].ID = mainpanel.dataArray[i].ID;
            HRN[i].Priority = mainpanel.dataArray[i].Priority;
            HRN[i].ServiceTime = mainpanel.dataArray[i].ServiceTime;
            HRN[i].TimeQuantum = mainpanel.dataArray[i].TimeQuantum;
        }
        ProcessData temp = new ProcessData();
        for (int i = 0; i < HRN.length; i++) {
            for (int j = i; j < HRN.length; j++) {
                if (HRN[i].ArriveTime > HRN[j].ArriveTime) {
                    temp = HRN[i];
                    HRN[i] = HRN[j];
                    HRN[j] = temp;
                }
            }
        }
        ProcessData compare = new ProcessData();
        compare.Priority = 0;
        int time = 0;
        for (int i = 0; i < HRN.length; i++) {
            for (int j = 0; j < HRN.length; j++) {
                HRN[j].Priority = (HRN[j].ServiceTime + time - HRN[j].ArriveTime) / HRN[j].ServiceTime;
            }
            time = time + HRN[i].ServiceTime;
            least = i;
            compare.Priority = 0;
            for (int j = i; j < HRN.length; j++) {
                if (compare.Priority == HRN[j].Priority && HRN[j].ArriveTime <= time) {
                    if (HRN[j].ArriveTime < compare.ArriveTime)
                        least = j;
                }
                if (compare.Priority < HRN[j].Priority && HRN[j].ArriveTime <= time) {
                    least = j;
                    compare = HRN[j];
                }

            }
            time = time + HRN[least].ServiceTime;
            temp = HRN[i];
            HRN[i] = HRN[least];
            HRN[least] = temp;
        }
        int response = 0;
        int waitsum = 0;
        time = 0;
        for (int i = 0; i < HRN.length; i++) {
            if (HRN[i].ArriveTime > time) {
                chartadd("", HRN[i].ArriveTime - time);
                time += HRN[i].ArriveTime - time;
            }
            chartadd(HRN[i].ID, HRN[i].ServiceTime);
            time += HRN[i].ServiceTime;
            response += time - HRN[i].ArriveTime;
        }
        waitsum = response;
        for (int i = 0; i < HRN.length; i++) {
            waitsum -= HRN[i].ServiceTime;
        }

        TurnAroundTime.setText("평균 반환시간 : " + (double) response / HRN.length);
        WaitingTime.setText("평균 대기시간 : " + (double) waitsum / HRN.length);
    }

    public void chartadd(String Id, int size) {
        sum = sum + size;
        for (int i = 0; i < v.size(); i++) {
            v.get(i).setSize(Maxlen / sum * vsize.get(i), 60);
            v.get(i).setLocation(location, 150);
            location = Maxlen / sum * vsize.get(i) + location;
            vlabel.get(i).setLocation(location - 10, 210);
        }
        int w = Maxlen / sum * size;
        int h = 60;
        JButton btn = new JButton(Id);
        JLabel label = new JLabel();
        label.setText("" + sum);
        label.setSize(50, 20);
        label.setLocation(location + w - (label.getWidth() / 2), 210);
        label.setFont(new Font(null, Font.PLAIN, 20));
        btn.setToolTipText(Id);
        btn.setSize(w, h);
        btn.setLocation(location, 150);
        btn.setEnabled(false);
        btn.setFont(new Font(null, Font.PLAIN, 20));
        btn.setBackground(Color.white);
        v.add(btn);
        vsize.add(size);
        vlabel.add(label);
        add(btn);
        add(label);
        location = 310;
    }

    class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == FCFSbtn) {
                Fcfs();
                label.setText("FCFS");
                FCFSbtn.setBackground(Color.white);
                SJFbtn.setBackground(Color.gray);
                SRTSbtn.setBackground(Color.gray);
                Priority1Sbtn.setBackground(Color.gray);
                Priority2Sbtn.setBackground(Color.gray);
                RRbtn.setBackground(Color.gray);
                HRNbtn.setBackground(Color.gray);
            } else if (e.getSource() == SJFbtn) {
                sjf1();
                label.setText("SJF");
                FCFSbtn.setBackground(Color.gray);
                SJFbtn.setBackground(Color.white);
                SRTSbtn.setBackground(Color.gray);
                Priority1Sbtn.setBackground(Color.gray);
                Priority2Sbtn.setBackground(Color.gray);
                RRbtn.setBackground(Color.gray);
                HRNbtn.setBackground(Color.gray);

            } else if (e.getSource() == SRTSbtn) {
                srt();
                label.setText("SRT");
                FCFSbtn.setBackground(Color.gray);
                SJFbtn.setBackground(Color.gray);
                SRTSbtn.setBackground(Color.white);
                Priority1Sbtn.setBackground(Color.gray);
                Priority2Sbtn.setBackground(Color.gray);
                RRbtn.setBackground(Color.gray);
                HRNbtn.setBackground(Color.gray);
            } else if (e.getSource() == Priority1Sbtn) {
                Priority1();
                label.setText("비선점 Priority");
                FCFSbtn.setBackground(Color.gray);
                SJFbtn.setBackground(Color.gray);
                SRTSbtn.setBackground(Color.gray);
                Priority1Sbtn.setBackground(Color.white);
                Priority2Sbtn.setBackground(Color.gray);
                RRbtn.setBackground(Color.gray);
                HRNbtn.setBackground(Color.gray);
            } else if (e.getSource() == Priority2Sbtn) {
                Priority2();
                label.setText("선점 Priority");
                FCFSbtn.setBackground(Color.gray);
                SJFbtn.setBackground(Color.gray);
                SRTSbtn.setBackground(Color.gray);
                Priority1Sbtn.setBackground(Color.gray);
                Priority2Sbtn.setBackground(Color.white);
                RRbtn.setBackground(Color.gray);
                HRNbtn.setBackground(Color.gray);
            } else if (e.getSource() == RRbtn) {
                RR();
                label.setText("RR");
                FCFSbtn.setBackground(Color.gray);
                SJFbtn.setBackground(Color.gray);
                SRTSbtn.setBackground(Color.gray);
                Priority1Sbtn.setBackground(Color.gray);
                Priority2Sbtn.setBackground(Color.gray);
                RRbtn.setBackground(Color.white);
                HRNbtn.setBackground(Color.gray);
            } else if (e.getSource() == HRNbtn) {
                HRN();
                label.setText("HRN");
                FCFSbtn.setBackground(Color.gray);
                SJFbtn.setBackground(Color.gray);
                SRTSbtn.setBackground(Color.gray);
                Priority1Sbtn.setBackground(Color.gray);
                Priority2Sbtn.setBackground(Color.gray);
                RRbtn.setBackground(Color.gray);
                HRNbtn.setBackground(Color.white);
            } else {
                mainpanel.panel_change("setting");
            }
        }
    }
}
