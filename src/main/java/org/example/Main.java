package org.example;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        CalculatorFrame frame = new CalculatorFrame();
        frame.createWindow();

        // Screen
        JTextField jTextField = new JTextField();
        jTextField.setEnabled(false);
        jTextField.setFont(new Font("sans serif", Font.BOLD, 50));
        frame.add(jTextField);
        frame.add(new Buttons(jTextField));



        frame.setBounds(100, 100, 500, 500);
    }
}