package com.raparison.desktop.model;

import com.raparison.desktop.controller.ActivityController;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class Activity {
    public Activity(String name, int duration, Date activityDate, int RPE, double charge) {
        this.name = name;
        this.duration = duration;
        this.activityDate = activityDate;
        this.RPE = RPE;
        this.charge = charge;
    }

    public Activity(String name, int duration, Date activityDate, int RPE) {
        this.name = name;
        this.duration = duration;
        this.activityDate = activityDate;
        this.RPE = RPE;
    }
    private String name;
    private int duration;
    private Date activityDate;
    private int RPE;
    private double charge;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Date getActivityDate() {
        return activityDate;
    }

    public void setActivityDate(Date activityDate) {
        this.activityDate = activityDate;
    }

    public int getRPE() {
        return RPE;
    }

    public void setRPE(int RPE) {
        this.RPE = RPE;
    }

    public double getCharge() {
        return charge;
    }

    public void setCharge(double charge) {
        this.charge = charge;
    }

    public static class DataDisplayForm extends JFrame {
        private JLabel nameLabel;
        private JLabel durationLabel;
        private JLabel rpeLabel;

        public DataDisplayForm(String name, int duration, int rpe) {
            setTitle("Données de l'activité");
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(3, 1));

            nameLabel = new JLabel("Nom : " + name);
            durationLabel = new JLabel("Durée : " + duration);
            rpeLabel = new JLabel("RPE : " + rpe);

            panel.add(nameLabel);
            panel.add(durationLabel);
            panel.add(rpeLabel);

            add(panel);

            pack();
            setLocationRelativeTo(null);
        }
    }
}
