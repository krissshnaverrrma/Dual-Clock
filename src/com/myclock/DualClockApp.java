package com.myclock;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

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
        JLabel footerLabel = new JLabel("Developer by Krishna Verma", SwingConstants.CENTER);
        footerLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
        footerLabel.setOpaque(true);
        footerLabel.setBackground(Color.BLACK);
        footerLabel.setForeground(Color.WHITE);
        footerLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        frame.add(footerLabel, BorderLayout.SOUTH);
        frame.setSize(900, 480);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}