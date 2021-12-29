package vue;

import javax.swing.*;
import java.awt.*;

public class Vue {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Fractal View");

        JLabel label = new JLabel("Je suis un JLabel", JLabel.CENTER);
        frame.add(label);

        JPanel panel = new JPanel();
        JLabel c = new JLabel("C = ", JLabel.CENTER);
        JLabel pas = new JLabel("C = ", JLabel.CENTER);
        JLabel xmin = new JLabel("C = ", JLabel.CENTER);
        JLabel ymin = new JLabel("C = ", JLabel.CENTER);
        JLabel repetition = new JLabel("C = ", JLabel.CENTER);
        JButton xmax = new JButton("C = ");
        JButton ymax = new JButton("Bouton 2");

        frame.setLayout(new GridLayout(2, 1));
        frame.add(label);
        frame.add(panel);

        frame.pack();
        frame.setSize(250, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
