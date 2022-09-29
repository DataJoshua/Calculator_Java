package org.example;

import javax.swing.*;
import java.awt.*;

public class CalculatorFrame extends JFrame {

    public CalculatorFrame(){
        createWindow();
    }
    public void createWindow(){
        this.setVisible(true);
        this.setTitle("My calculator: Джошуа Родригес");
        this.setLayout(new GridLayout(0, 1, 10,10));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}