package org.example;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        CalculatorFrame frame = new CalculatorFrame();
        frame.createWindow();
        JTextField jTextField = new JTextField();
        frame.add(jTextField);
        frame.add(new Buttons(jTextField));


        frame.setBounds(100, 100, 500, 500);
    }
}