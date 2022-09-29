package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        //button to clear the screen
        JButton clear = new JButton("CE");
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                screen.setText("");
            }
        });

        this.add(clear);

        // button to delete arguments

        JButton del = new JButton("DEL");
        del.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String screenText = screen.getText();
                int len = screenText.length();
                try{
                    String subScreen = screenText.substring(0, len - 1);
                    screen.setText(subScreen);
                }catch(StringIndexOutOfBoundsException exception){
                    System.out.println("The screen is empty");
                }

            }
        });

        this.add(del);

        // PI

        JButton pi = new JButton("PI");
        pi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                screen.setText(3.141516+"");
            }
        });

        this.add(pi);

         // crete each button number and add in the frame
        for(int i =1; i <= amount; i++){
            JButton b = new JButton(new Actions(i+"", this.screen));
            this.add(b);
        }

        // buttons for operation created with their own action class

        JButton sum = new JButton(new ActionsOperators("+", this.screen));
        JButton cero = new JButton(new Actions("0", this.screen));
        JButton multiply = new JButton(new ActionsOperators("*", this.screen));
        JButton divide = new JButton(new ActionsOperators("/", this.screen));
        JButton rest = new JButton(new ActionsOperators("-", this.screen));
        JButton equal = new JButton(new ActionsOperators("=", this.screen));
        this.add(sum);
        this.add(cero);
        this.add(multiply);
        this.add(divide);
        this.add(rest);
        this.add(equal);

    }
}

class Actions extends  AbstractAction {
    JTextField field;


    public Actions(String name, JTextField field) {
        putValue(Action.NAME, name);
        this.field = field;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String a = this.field.getText();
        this.field.setText(a += this.getValue(Action.NAME));
    }
}

class ActionsOperators extends AbstractAction{
    JTextField field;
    static double previous;
    static double actual;
    static String actualOperation;
    public ActionsOperators(String name,JTextField field){
        putValue(Action.NAME, name);
        this.field = field;

    }
    @Override
    public void actionPerformed(ActionEvent e) {

        String operation = (String)this.getValue(Action.NAME);
        System.out.println(operation);
        if(operation.equals("+")){
            previous = Double.parseDouble(field.getText());
            field.setText("");
            actualOperation = "sum";
        } else if(operation.equals("-")){
            previous = Double.parseDouble(field.getText());
            field.setText("");
            actualOperation = "res";
        } else if(operation.equals("/")){
            previous = Double.parseDouble(field.getText());
            field.setText("");
            actualOperation = "div";
        } else if(operation.equals("*")){
            previous = Double.parseDouble(field.getText());
            field.setText("");
            actualOperation = "mul";

        } else if(operation.equals("=")){
                actual =  Double.parseDouble(field.getText());
                double result = 0;
                switch (actualOperation){
                    case "sum": result = actual + previous;
                    break;
                    case "res" : result = previous - actual;
                    break;
                    case "mul": result = actual * previous;
                    break;
                    case "div": result = previous / actual;
                    break;
                }
                field.setText(result+"");
        }

    }
}