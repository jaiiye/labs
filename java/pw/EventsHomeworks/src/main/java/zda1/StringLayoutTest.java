package zda1;

import java.awt.*;
import javax.swing.*;


public class StringLayoutTest {

 
    public static void addComponentsToPane(Container pane) {
        
    	JButton b1 = new JButton("Przycisk 1");
    	JButton b2 = new JButton("Trochę większy przycisk 2");
    	
    	SpringLayout springLayout = new SpringLayout();
    	
    	pane.setLayout(springLayout);
    	
    	SpringLayout.Constraints b1c = new SpringLayout.Constraints();
    	SpringLayout.Constraints b2c = new SpringLayout.Constraints();
    	
    	Spring yPadding = Spring.constant(20);  // odległość od góry
    	b1c.setX(Spring.constant(10));
    	b1c.setY(yPadding);
    	
    	pane.add(b1, b1c);
    	
    	Spring b1Right = springLayout.getConstraint(SpringLayout.EAST, b1);
    	Spring b2Left = Spring.sum(b1Right, Spring.constant(5));
    	b2c.setX(b2Left);
    	b2c.setY(yPadding);
    	
    	pane.add(b2, b2c);
    	
        
        }
 
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("SpringBagLayoutDemo");
       
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Set up the content pane.
        addComponentsToPane(frame.getContentPane());
        frame.setSize(400, 300);
        
        //Display the window.
        
        //frame.pack();
        frame.setVisible(true);
    }
 
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
