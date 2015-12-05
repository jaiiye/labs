package zda1;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;

public class GirdLayoutTest {
	 	final static boolean shouldFill = true;
	    final static boolean shouldWeightX = true;
	    final static boolean shouldWeightY = true;
	    final static boolean RIGHT_TO_LEFT = false;
	    
	    final static int defaultWeightX = 1;
	    final static int defaultWeightY = 1;
	    
	    final static int gridRowNumber = 5;
	    final static int girColumnNumber = 5;
	 
	    public static void addComponentsToPane(Container pane) {
	        if (RIGHT_TO_LEFT) {
	            pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
	        }
	        
	        JButton button;
	        
	        pane.setLayout(new GridBagLayout());
	        GridBagConstraints c = new GridBagConstraints();
	        if (shouldFill) {
	        	//natural height, maximum width
	        	c.fill = GridBagConstraints.BOTH;
	        }
	        
	        
	        for (int i=0; i<girColumnNumber; i++) {
	        	for (int j=0; j<gridRowNumber; j++) {
	        		button = new JButton(i+";"+j);
	        		
	        		c.fill = GridBagConstraints.BOTH;
	        		
	        		c.weightx = defaultWeightX;
	        		c.weighty = defaultWeightY;
	        		
	        		c.gridx = i;
	        		c.gridy = j;

	        		
	        		if (shouldWeightX){
	        			c.weightx = i * c.weightx;
	        		}
	        			
	        		if (shouldWeightY){
	        			c.weighty = j * c.weighty;
	        		}
	        				
	        		
	        		pane.add(button, c);
	        				
	        	}
	        }
	    }
	 
	    /**
	     * Create the GUI and show it.  For thread safety,
	     * this method should be invoked from the
	     * event-dispatching thread.
	     */
	    private static void createAndShowGUI() {
	        //Create and set up the window.
	        JFrame frame = new JFrame("GridBagLayoutDemo");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 
	        //Set up the content pane.
	        addComponentsToPane(frame.getContentPane());
	 
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
