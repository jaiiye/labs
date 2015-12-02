package zda1;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * Proszę o wyświetlenie pustego okienka
 */

/**
 * Created by blepa on 2015-12-02.
 */

public class zad4 {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
                    JFrame frame = new JFrame("Test");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setBounds(50, 50, 200, 200);
                    frame.setVisible(true);
                }
        );
    }
}

