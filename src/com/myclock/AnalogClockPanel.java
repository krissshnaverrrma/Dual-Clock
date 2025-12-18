package com.myclock;

import java.awt.*;
import java.io.File;
import java.time.LocalTime;
import javax.sound.sampled.*;
import javax.swing.*;

public class AnalogClockPanel extends JPanel {
    private Clip tickClip;

    public AnalogClockPanel() {
        setBackground(Color.BLACK);
        loadSound();
        Timer timer = new Timer(1000, e -> {
            repaint();
            playSound();
        });
        timer.start();
    }

    private void loadSound() {
        try {
            File soundFile = new File("src/tick.wav");
            if (soundFile.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(soundFile);
                tickClip = AudioSystem.getClip();
                tickClip.open(audioInput);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void playSound() {
        if (tickClip != null) {
            if (tickClip.isRunning()) {
                tickClip.stop();
            }
            tickClip.setFramePosition(0);
            tickClip.start();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int w = getWidth();
        int h = getHeight();
        int centerX = w / 2;
        int centerY = h / 2;
        int radius = (int) (Math.min(w, h) * 0.38);
        LocalTime time = LocalTime.now();
        g2d.setColor(Color.WHITE);
        g2d.setStroke(new BasicStroke(3));
        g2d.drawOval(centerX - radius, centerY - radius, 2 * radius, 2 * radius);
        g2d.setFont(new Font("Arial", Font.BOLD, 22));
        g2d.drawString("12", centerX - 12, centerY - radius + 35);
        g2d.drawString("6", centerX - 6, centerY + radius - 20);
        g2d.drawString("3", centerX + radius - 30, centerY + 8);
        g2d.drawString("9", centerX - radius + 15, centerY + 8);
        double secondAngle = time.getSecond() * (2 * Math.PI / 60) - Math.PI / 2;
        double minuteAngle = (time.getMinute() + time.getSecond() / 60.0) * (2 * Math.PI / 60) - Math.PI / 2;
        double hourAngle = (time.getHour() % 12 + time.getMinute() / 60.0) * (2 * Math.PI / 12) - Math.PI / 2;
        drawHand(g2d, centerX, centerY, hourAngle, radius * 0.5, 8, Color.WHITE);
        drawHand(g2d, centerX, centerY, minuteAngle, radius * 0.75, 5, Color.WHITE);
        drawHand(g2d, centerX, centerY, secondAngle, radius * 0.9, 2, Color.RED);
        g2d.setColor(Color.WHITE);
        g2d.fillOval(centerX - 6, centerY - 6, 12, 12);
    }

    private void drawHand(Graphics2D g2d, int x, int y, double angle, double len, float width, Color color) {
        g2d.setColor(color);
        g2d.setStroke(new BasicStroke(width, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g2d.drawLine(x, y, (int) (x + len * Math.cos(angle)), (int) (y + len * Math.sin(angle)));
    }
}