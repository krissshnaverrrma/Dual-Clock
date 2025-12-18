package com.myclock;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DualClockApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Clock Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icon = new ImageIcon("src/icon.png");
        frame.setIconImage(icon.getImage());
        frame.setLayout(new BorderLayout());
        JPanel clockContainer = new JPanel(new GridLayout(1, 2));
        clockContainer.setBackground(Color.BLACK);
        DigitalClockPanel digitalClock = new DigitalClockPanel();
        AnalogClockPanel analogClock = new AnalogClockPanel();
        clockContainer.add(digitalClock);
        clockContainer.add(analogClock);
        frame.add(clockContainer, BorderLayout.CENTER);
        frame.setSize(900, 480);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}