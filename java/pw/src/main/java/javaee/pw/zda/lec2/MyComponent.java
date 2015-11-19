package javaee.pw.zda.lec2;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JComponent;

public class MyComponent extends JComponent {
    public static final int MESSAGE_X = 75;
    public static final int MESSAGE_Y = 100;
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;
    public void paintComponent(Graphics g)  {
        g.drawString("Witamy na okienku", MESSAGE_X, MESSAGE_Y);
    }
    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH,    DEFAULT_HEIGHT);
    }
}