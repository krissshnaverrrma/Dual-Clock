package com.myclock;

import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.*;

public class DigitalClockPanel extends JPanel {
    private final JLabel timeLabel;
    private final JLabel dateLabel;
    private final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("EEEE, MMM dd, yyyy");

    public DigitalClockPanel() {
        setLayout(new GridBagLayout());
        setBackground(Color.BLACK);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);
        timeLabel = new JLabel("Loading...");
        timeLabel.setFont(new Font("Verdana", Font.BOLD, 50));
        timeLabel.setForeground(Color.WHITE);
        add(timeLabel, gbc);
        gbc.gridy = 1;
        dateLabel = new JLabel("Loading Date...");
        dateLabel.setFont(new Font("Verdana", Font.PLAIN, 20));
        dateLabel.setForeground(Color.WHITE);
        add(dateLabel, gbc);
        Timer timer = new Timer(1000, e -> updateTime());
        timer.start();
        updateTime();
    }

    private void updateTime() {
        timeLabel.setText(LocalTime.now().format(timeFormatter));
        dateLabel.setText(LocalDate.now().format(dateFormatter));
    }
}