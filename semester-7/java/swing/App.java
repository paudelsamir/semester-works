import javax.swing.*;
import java.awt.*;

public class App {
    public static void main(String[] args) {
        JFrame frame = new JFrame("My First Swing App");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Enter your name:");
        JTextField textField = new JTextField(15);
        JButton button = new JButton("Say Hello");
        JLabel output = new JLabel();

        button.addActionListener(e ->
            output.setText("Hello, " + (textField.getText().isEmpty() ? "World" : textField.getText()) + "!")
        );

        frame.setLayout(new FlowLayout());
        frame.add(label);
        frame.add(textField);
        frame.add(button);
        frame.add(output);

        frame.setVisible(true);
    }
}
