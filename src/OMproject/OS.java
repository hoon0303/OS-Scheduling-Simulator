package OMproject;

import javax.swing.*;
import java.awt.*;

public class OS extends JFrame {
    public Start start = null;
    public Setting setting = null;
    public Result result = null;
    public ProcessData dataArray[] = null;
    public Developer developer = null;
    public Guide guide = null;

    public void panel_change(String panelName) {
        getContentPane().removeAll();
        switch (panelName) {
            case "start":
                getContentPane().add(start);
                break;
            case "setting":
                getContentPane().add(setting);
                break;
            case "result":
                getContentPane().add(result);
                break;
            case "developer":
                getContentPane().add(developer);
                break;
            case "guide":
                getContentPane().add(guide);
                break;
        }
        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        OS mainpanel = new OS();

        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screen = tk.getScreenSize();
        int f_xpos = (int) (screen.getWidth() / 2 - 1300 / 2);
        int f_ypos = (int) (screen.getHeight() / 2 - 800 / 2);
        mainpanel.setLocation(f_xpos, f_ypos);

        mainpanel.setTitle("OM 프로젝트");
        mainpanel.start = new Start(mainpanel);
        mainpanel.setting = new Setting(mainpanel);
        mainpanel.result = new Result(mainpanel);
        mainpanel.developer = new Developer(mainpanel);
        mainpanel.guide = new Guide(mainpanel);

        mainpanel.add(mainpanel.start);
        mainpanel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainpanel.setSize(1300, 800);
        mainpanel.setResizable(false);
        mainpanel.setVisible(true);
    }
}
