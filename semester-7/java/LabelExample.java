import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


// HelloWorld class extends Applet
public class LabelExample {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Label Example");
        JPanel panel = new JPanel();
        JButton button = new JButton("Click Me");
        panel.add(button);
        frame.add(panel);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}