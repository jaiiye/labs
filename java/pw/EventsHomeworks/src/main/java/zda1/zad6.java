package zda1;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Point;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * Created by blepa on 2015-12-02.
 */

/**
 Proszę napisać program do gry w kółko i krzyżykProszę napisać program do gry w kółko i krzyżyk
*/

public class zad6 {
    class tictac {
        int count;

        public int getTic() {
            return count;
        }

        public void inc() {
            count++;
        }
    }

    public static void main(String[] args) {
        zad6 z6 = new zad6();

        SwingUtilities.invokeLater(() -> {
                    final tictac tic = z6.new tictac();
                    JFrame frame = new JFrame("Test");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setBounds(50, 50, 400, 200);
                    Container pane = frame.getContentPane();
                    pane.setLayout(null);
                    for (int i = 0; i < 9; i++) {
                        JButton btn = new JButton(" ");
                        btn.setSize(new Dimension(100, 20));
                        btn.setLocation(new Point(10 + (i % 3) * 110, 10 + (i / 3) * 30));
                        btn.addActionListener(e -> {
                            if (btn.getText() == " ") {
                                btn.setText(tic.getTic() % 2 == 0 ? "X" : "O");
                                tic.inc();
                            }
                        });
                        pane.add(btn);
                    }
                    frame.setVisible(true);
                }
        );
    }
}


