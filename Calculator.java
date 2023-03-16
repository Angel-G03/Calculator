import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator {
    
    private final short WIDTH = 500;
    private final short HIEGHT = 700;
    private final Dimension buttonSize = new Dimension(100, 100);
    private String currentString = "";
    private String first;
    private String second;
    private String operation;
    private int operatorCount = 0;
    private int result;
    private double resultf;

    public Calculator() {

        // Create frame and set attributes
        JFrame frame = new JFrame("Calculator");
        frame.setLayout(new FlowLayout());
        frame.setSize(WIDTH, HIEGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create Text Display
        JTextField display = new JTextField();
        display.setPreferredSize(new Dimension(420, 100));
        display.setFocusable(false);
        display.setHorizontalAlignment(SwingConstants.RIGHT); // Right-centers the text
        Font font = new Font(display.getFont().getName(), display.getFont().getStyle(), 48); 
        display.setFont(font); 
        frame.add(display);

        // Create Buttons and Handle Events
        JButton zero = new JButton("0");
        zero.setPreferredSize(buttonSize);
        zero.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("User pressed 0");
                currentString += "0"; 
                display.setText(currentString);

            }
        });

        JButton one = new JButton("1");
        one.setPreferredSize(buttonSize);
        one.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("User pressed 1");
                currentString += "1";
                display.setText(currentString);
            }
        });

        JButton two = new JButton("2");
        two.setPreferredSize(buttonSize);
        two.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("User pressed 2");
                currentString += "2";
                display.setText(currentString);
            }
        });

        JButton three = new JButton("3");
        three.setPreferredSize(buttonSize);
        three.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("User pressed 3");
                currentString += "3";
                display.setText(currentString);
            }
        });

        JButton four = new JButton("4");
        four.setPreferredSize(buttonSize);
        four.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("User pressed 4");
                currentString += "4";
                display.setText(currentString);
            }
        });

        JButton five = new JButton("5");
        five.setPreferredSize(buttonSize);
        five.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("User pressed 5");
                currentString += "5";
                display.setText(currentString);
            }
        });

        JButton six = new JButton("6");
        six.setPreferredSize(buttonSize);
        six.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("User pressed 6");
                currentString += "6";
                display.setText(currentString);
            }
        });

        JButton seven = new JButton("7");
        seven.setPreferredSize(buttonSize);
        seven.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("User pressed 7");
                currentString += "7";
                display.setText(currentString);
            }
        });

        JButton eight = new JButton("8");
        eight.setPreferredSize(buttonSize);
        eight.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("User pressed 8");
                currentString += "8";
                display.setText(currentString);
            }
        });

        JButton nine = new JButton("9");
        nine.setPreferredSize(buttonSize);
        nine.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("User pressed 9");
                currentString += "9";
                display.setText(currentString);
            }
        });

        JButton decimal = new JButton(".");
        decimal.setPreferredSize(buttonSize);
        decimal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("User pressed .");
                currentString += ".";
                display.setText(currentString);
            }
        });

        JButton add = new JButton("+");
        add.setPreferredSize(buttonSize);
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    System.out.println("User pressed +");
                    operation = "+";
                    first = currentString; // Save first number
                    System.out.println("First number is: " + first);
                    currentString = ""; // Clear current string to use for next number
                    operatorCount++; 
            }
        });

        JButton subtract = new JButton("-");
        subtract.setPreferredSize(buttonSize);
        subtract.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("User pressed -");
                operation = "-";
                first = currentString;
                System.out.println("First number is: " + first);
                currentString = "";
                operatorCount++;
            }
        });

        JButton multiply = new JButton("*");
        multiply.setPreferredSize(buttonSize);
        multiply.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("User pressed *");
                operation = "*";
                first = currentString;
                System.out.println("First number is: " + first);
                currentString = "";
                operatorCount++;
            }
        });

        JButton divide = new JButton("/");
        divide.setPreferredSize(buttonSize);
        divide.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("User pressed /");
                operation = "/";
                first = currentString;
                System.out.println("First number is: " + first);
                currentString = "";
                operatorCount++;
            }
        });

        JButton delete = new JButton("DEL");
        delete.setPreferredSize(buttonSize);
        delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("User pressed DEL");
                currentString = currentString.substring(0, currentString.length()-1); 
                display.setText(currentString);
            }
        });

        JButton clear = new JButton("CLR");
        clear.setPreferredSize(buttonSize);
        clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("User pressed CLR");
                currentString = "";
                operation = "";
                first = "";
                second = "";
                operatorCount = 0;
                display.setText(currentString);
            }
        });


        JButton enter = new JButton("ENTER");
        enter.setPreferredSize(buttonSize);
        enter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("User pressed ENTER");
                if (operatorCount > 0) { // Meaning we have a first number to operate on
                    second = currentString; // Save a copy of the second number to use in calculation
                    System.out.println("Second number is: " + second);
                    if (operation.equals("+")) {
                        result = Integer.parseInt(first) + Integer.parseInt(second);
                        display.setText(String.valueOf(result));
                        System.out.println("Result is: " + result);
                        currentString = String.valueOf(result);
                    }
                    else if (operation.equals("-")) {
                        result = Integer.parseInt(first) - Integer.parseInt(second);
                        display.setText(String.valueOf(result));
                        System.out.println("Result is: " + result);
                        currentString = String.valueOf(result);
                    }
                    else if (operation.equals("*")) {
                        result = Integer.parseInt(first) * Integer.parseInt(second);
                        display.setText(String.valueOf(result));
                        System.out.println("Result is: " + result);
                        currentString = String.valueOf(result);
                    }
                    else if (operation.equals("/")) {
                        resultf = Double.parseDouble(first) / Double.parseDouble(second);
                        display.setText(String.valueOf(resultf));
                        System.out.println("Result is: " + resultf);
                        currentString = String.valueOf(resultf);
                    }
                    operatorCount = 0;
                }
            }
        });

        // Add buttons to the frame
        frame.add(zero);
        frame.add(one);
        frame.add(two);
        frame.add(three);
        frame.add(four);
        frame.add(five);
        frame.add(six);
        frame.add(seven);
        frame.add(eight);
        frame.add(nine);
        frame.add(decimal);
        frame.add(add);
        frame.add(subtract);
        frame.add(multiply);
        frame.add(divide);
        frame.add(delete);
        frame.add(clear);
        frame.add(enter);

        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new Calculator();
    }
}