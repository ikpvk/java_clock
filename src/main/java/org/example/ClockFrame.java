package org.example;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ClockFrame extends JFrame {

    Calendar calendar;
    SimpleDateFormat timeFormat;
    SimpleDateFormat dayFormat;
    JLabel timeLabel;
    String currentTimeString;
    JLabel dayLabel;
    String currentDayString;

    ClockFrame() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Krishna's Clock");
        this.setLayout(new FlowLayout());
        this.setSize(400, 200);
        this.setResizable(Boolean.FALSE);

        timeFormat = new SimpleDateFormat("hh:mm:ss a");
        dayFormat = new SimpleDateFormat("E d MMM y");

        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Verdana", Font.PLAIN, 50));
        timeLabel.setForeground(Color.BLACK);
        timeLabel.setBackground(new Color(0x6b706c));
        timeLabel.setOpaque(Boolean.TRUE);

        dayLabel = new JLabel();
        dayLabel.setFont(new Font("Verdana", Font.PLAIN, 50));
        dayLabel.setForeground(Color.BLACK);
        dayLabel.setBackground(new Color(0x6b706c));
        dayLabel.setOpaque(Boolean.TRUE);

        this.add(timeLabel);
        this.add(dayLabel);
        this.setVisible(Boolean.TRUE);

        setTime();
    }

    public void setTime() {
        while (true) {
            currentTimeString = timeFormat.format(Calendar.getInstance().getTime());
            timeLabel.setText(currentTimeString);

            currentDayString = dayFormat.format(Calendar.getInstance().getTime());
            dayLabel.setText(currentDayString);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Error occurred :");
                e.printStackTrace();
            }
        }
    }
}
