import javax.swing.*;

public class SwingSkeleton {

    public static void main(String[] args) {
        // Window
        JFrame frame = new JFrame("My Swing App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        // Container
        JPanel panel = new JPanel();
        frame.add(panel);

        // Add components here:
        // panel.add(new JLabel("Hello"));

        // Show
        frame.setVisible(true);
    }
}
