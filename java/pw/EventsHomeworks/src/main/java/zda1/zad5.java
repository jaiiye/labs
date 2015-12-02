package zda1;

import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * Proszę o wyświetlenie okienka z przyciskiem ZAMKIJ. Po naciśnięciu przycisku aplikacja powinna się zamknąć
 */

/**
 * Created by blepa on 2015-12-02.
 */
public class zad5 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
                    JFrame frame = new JFrame("Dwa przyciski");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    JButton closeButton = new JButton("Close");
                    Container contentPane = frame.getContentPane();
                    closeButton.addActionListener(e -> {
                        System.exit(0);
                    });
                    contentPane.add(closeButton);
                    frame.pack();
                    frame.setVisible(true);
                }
        );
    }
}
