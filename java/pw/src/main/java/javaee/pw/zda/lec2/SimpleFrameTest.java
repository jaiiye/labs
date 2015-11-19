package javaee.pw.zda.lec2;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class SimpleFrameTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable(){
            public void run(){
            	JFrame frame = new JFrame("test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}