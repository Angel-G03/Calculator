import javax.swing.*;
import java.awt.*;

public class Calculator {

    private String currentString = ""; // The number being displayed on the calculator screen
    private String first;
    private String second;
    private String operation;
    private int operatorCount = 0;
    private double result;
    private final Font buttonFont = new Font(Font.SANS_SERIF, Font.BOLD, 20);
    private final Dimension buttonSize = new Dimension(115, 115);
    private final JTextField display = new JTextField();

    public void initButton(JButton button) {
        button.setPreferredSize(buttonSize);
        button.setFont(buttonFont);
        button.addActionListener(e -> {
            currentString += button.getText();
            display.setText(currentString);
        });
    }

    public void initOperator(JButton button) {
        button.setPreferredSize(buttonSize);
        button.addActionListener(e -> {
            operation = "+";
            first = currentString; // Save first number
            currentString = ""; // Clear current string to use for next number
            operatorCount++;
        });
    }

    public Calculator() {

        // Create frame and set attributes
        JFrame frame = new JFrame("Calculator");
        frame.setLayout(new FlowLayout());
        short WIDTH = 500;
        short HEIGHT = 777;
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        // Create Text Display
        display.setPreferredSize(new Dimension(450, 125));
        display.setFocusable(false);
        display.setHorizontalAlignment(SwingConstants.RIGHT); // Right-centers the text
        Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 52);
        display.setFont(font);
        frame.add(display);

        // Create Buttons
        JButton zero = new JButton("0");
        initButton(zero);
        frame.add(zero);

        JButton one = new JButton("1");
        initButton(one);
        frame.add(one);

        JButton two = new JButton("2");
        initButton(two);
        frame.add(two);

        JButton three = new JButton("3");
        initButton(three);
        frame.add(three);

        JButton four = new JButton("4");
        initButton(four);
        frame.add(four);

        JButton five = new JButton("5");
        initButton(five);
        frame.add(five);

        JButton six = new JButton("6");
        initButton(six);
        frame.add(six);

        JButton seven = new JButton("7");
        initButton(seven);
        frame.add(seven);

        JButton eight = new JButton("8");
        initButton(eight);
        frame.add(eight);

        JButton nine = new JButton("9");
        initButton(nine);
        frame.add(nine);

        JButton decimal = new JButton(".");
        initButton(decimal);
        frame.add(decimal);

        JButton add = new JButton("+");
        initOperator(add);
        frame.add(add);

        JButton subtract = new JButton("-");
        initOperator(subtract);
        frame.add(subtract);

        JButton multiply = new JButton("*");
        initOperator(multiply);
        frame.add(multiply);

        JButton divide = new JButton("/");
        initOperator(divide);
        frame.add(divide);

        JButton delete = new JButton("DEL");
        delete.setPreferredSize(buttonSize);
        delete.setFont(buttonFont);
        delete.addActionListener(e -> {
            currentString = currentString.substring(0, currentString.length()-1);
            display.setText(currentString);
        });
        frame.add(delete);

        JButton clear = new JButton("CLR");
        clear.setPreferredSize(buttonSize);
        clear.setFont(buttonFont);
        clear.addActionListener(e -> {
            currentString = "";
            operation = "";
            first = "";
            second = "";
            operatorCount = 0;
            display.setText(currentString);
        });
        frame.add(clear);

        JButton enter = new JButton("ENTER");
        enter.setPreferredSize(buttonSize);
        enter.setFont(buttonFont);
        enter.addActionListener(e -> {
            if (operatorCount > 0) { // Meaning we have a first number to operate on
                second = currentString; // Save a copy of the second number to use in calculation
                switch (operation) {
                    case "+" -> {
                        result = Double.parseDouble(first) + Double.parseDouble(second);
                        display.setText(String.valueOf(result));
                        currentString = String.valueOf(result);
                    }
                    case "-" -> {
                        result = Double.parseDouble(first) - Double.parseDouble(second);
                        display.setText(String.valueOf(result));
                        currentString = String.valueOf(result);
                    }
                    case "*" -> {
                        result = Double.parseDouble(first) * Double.parseDouble(second);
                        display.setText(String.valueOf(result));
                        currentString = String.valueOf(result);
                    }
                    case "/" -> {
                        result = Double.parseDouble(first) / Double.parseDouble(second);
                        display.setText(String.valueOf(result));
                        currentString = String.valueOf(result);
                    }
                }
                operatorCount = 0;
            }
        });
        frame.add(enter);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
