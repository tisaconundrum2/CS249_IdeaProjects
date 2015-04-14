package com.company;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class StatusTimer {
    public static int count;{
    //public static void main(String args[]) {
    // new JFrame().setVisible(false);
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent event) {
            count += 1;
        }
    };
    Timer timer = new Timer(500, actionListener);
    timer.start();
    }
}

