package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Buttons extends JPanel {

    JTextField screen;
    public Buttons(JTextField screen){
        this.screen = screen;
        createButtons(9);
        createWindow();
    }
    public void createWindow(){
        this.setVisible(true);
        this.setLayout(new GridLayout(0, 3, 10, 10));
    }

    public void createButtons(int amount){

         // we create a group of actions for each Button
        for(int i =1; i <= amount; i++){
            JButton b = new JButton(new Actions(i+"", this.screen));
            this.add(b);
        }
    }
}

class Actions extends  AbstractAction{
    JTextField field;
    public Actions(String name, JTextField field){
        putValue(Action.NAME, name);
        this.field = field;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String valueToCompare = (String) getValue(Action.NAME);
        String message = "ese boton no existe";

        if(valueToCompare.equals("1")){
            String a = field.getText();
            field.setText(a += "1");
        } else if(valueToCompare.equals("2")){

        }else if(valueToCompare.equals("3")){
            message = "3";
        }else if(valueToCompare.equals("4")){
            message = "4";
        }else if(valueToCompare.equals("5")){
            message = "5";
        }else if(valueToCompare.equals("6")){
            message = "6";
        }
        System.out.println(message);
    }
}