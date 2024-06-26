import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PercentageCalculator extends JFrame implements ActionListener {
    private JTextField inputField1, inputField2, resultField;
    private JComboBox<String> operationBox;
    private JButton calculateButton;

    public PercentageCalculator() {
        setTitle("Percentage Calculator");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2));

        // Input fields and labels
        add(new JLabel("Input 1: "));
        inputField1 = new JTextField();
        add(inputField1);

        add(new JLabel("Input 2: "));
        inputField2 = new JTextField();
        add(inputField2);

        // Operation selection
        String[] operations = {"Calculate Percentage", "Percentage Increase", "Percentage Decrease", "Find Whole"};
        operationBox = new JComboBox<>(operations);
        add(new JLabel("Operation: "));
        add(operationBox);

        // Calculate button
        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(this);
        add(calculateButton);

        // Result field
        add(new JLabel("Result: "));
        resultField = new JTextField();
        resultField.setEditable(false);
        add(resultField);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double input1 = Double.parseDouble(inputField1.getText());
            double input2 = Double.parseDouble(inputField2.getText());
            double result = 0;

            String operation = (String) operationBox.getSelectedItem();
            switch (operation) {
                case "Calculate Percentage":
                    result = (input1 / input2) * 100;
                    break;
                case "Percentage Increase":
                    result = ((input2 - input1) / input1) * 100;
                    break;
                case "Percentage Decrease":
                    result = ((input1 - input2) / input1) * 100;
                    break;
                case "Find Whole":
                    result = (input1 / input2) * 100;
                    break;
            }
            resultField.setText(String.format("%.2f", result));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter valid numbers.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PercentageCalculator::new);
    }
                                              }

