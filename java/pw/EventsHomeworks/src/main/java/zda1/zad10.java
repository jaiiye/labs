package zda1;

import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Spring;
import javax.swing.SpringLayout;
import javax.swing.SwingUtilities;

/**
 * Created by blepa on 2015-12-02.
 */
public class zad10 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(	() -> {
                    JFrame frame = new JFrame("SpringLayout2");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setSize(300,200);
                    Container contentPane = frame.getContentPane();
                    SpringLayout springLayout = new SpringLayout();
                    contentPane.setLayout(springLayout);
                    JButton b1 = new JButton("Przycisk 1");
                    JButton b2 = new JButton("Trochę większy przycisk 2");
                    SpringLayout.Constraints b1c = new SpringLayout.Constraints();
                    SpringLayout.Constraints b2c = new SpringLayout.Constraints();
                    Spring yPadding = Spring.constant(20);  // odległość od góry
                    b1c.setX(Spring.constant(10));
                    b1c.setY(yPadding);
                    contentPane.add(b1, b1c);
                    Spring b1Right = springLayout.getConstraint(SpringLayout.EAST, b1);
                    Spring b2Left = Spring.sum(b1Right, Spring.constant(5));
                    b2c.setX(b2Left);
                    b2c.setY(yPadding);
                    contentPane.add(b2, b2c);
                    frame.setVisible(true);
                }
        );
    }
}
