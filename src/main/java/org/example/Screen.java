package org.example;

import javax.swing.*;
import java.awt.*;

public class Screen extends JPanel {
    public Screen(){
        this.setVisible(true);
        this.setLayout(new BorderLayout());

        JTextField jTextField = new JTextField("escribe aqui");
        jTextField.setSize(100, 100);
        add(jTextField, BorderLayout.CENTER);
    }

}
