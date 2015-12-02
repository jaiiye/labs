package zda1;

import java.awt.Container;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Created by blepa on 2015-12-02.
 */

/**
 * Proszę napisać program testujący BoxLayout
 */
public class zad9 {
    public static void main(String[] args) {
        JFrame f = new JFrame("Vertical BoxLayout-managed container");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container pane = f.getContentPane();
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
        for (float align = 0.0f; align <= 1.0f; align += 0.2f) {
            JButton button = new JButton("X Alignment = " + align);
            button.setAlignmentX(align);
            pane.add(button);
        }
        f.setSize(600, 500);
        f.setVisible(true);
    }
}
