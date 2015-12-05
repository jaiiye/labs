package zda1;

import java.awt.*;
import javax.swing.*;

public class SpringLayoutTextWindowTest extends JFrame {
	
	final static int defaultFrameX = 400;
	final static int defaultFraneY = 300;
	
	
	public static void addComponentsToPane(Container pane) {
		
		JButton b1 = new JButton("OK");
    	JButton b2 = new JButton("Cancel");
    	
    	JTextArea textArea = new JTextArea(8, 40);
    	JScrollPane scrollPane = new JScrollPane(textArea);
    	
    	SpringLayout springLayout = new SpringLayout();
    	
    	pane.add(scrollPane);
    	pane.add(b1);
    	pane.add(b2);
    	
    	pane.setLayout(springLayout);
    	
    	springLayout.putConstraint(SpringLayout.WEST, scrollPane, 10, SpringLayout.WEST, pane);
    	springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 10, SpringLayout.NORTH, pane);
    	springLayout.putConstraint(SpringLayout.WEST, b1, 10, SpringLayout.EAST, scrollPane);
    	springLayout.putConstraint(SpringLayout.NORTH, b1, 0, SpringLayout.NORTH, scrollPane);
    	springLayout.putConstraint(SpringLayout.NORTH, b2, 10, SpringLayout.SOUTH, b1);
    	springLayout.putConstraint(SpringLayout.WEST, b2, 0, SpringLayout.WEST, b1);   
    	springLayout.putConstraint(SpringLayout.EAST, pane, 10, SpringLayout.EAST, b1);
    	springLayout.putConstraint(SpringLayout.SOUTH, pane, 20, SpringLayout.SOUTH, scrollPane);
    	
    	
    	
    	SpringLayout.Constraints b1c = springLayout.getConstraints(b1);
    	SpringLayout.Constraints b2c = springLayout.getConstraints(b2);
    	Spring maxWidth = Spring.max(b1c.getWidth(), b2c.getWidth());
    	b1c.setWidth(maxWidth);
    	b2c.setWidth(maxWidth);
		
		
	}

	 private static void createAndShowGUI() {
	        //Create and set up the window.
	        JFrame frame = new JFrame("SpringBagLayoutTextWindowDemo");
	       
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 
	        //Set up the content pane.
	        addComponentsToPane(frame.getContentPane());
	        //frame.setSize();
	        
	        //Display the window.
	        
	        frame.pack();
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
