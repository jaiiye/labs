package zda1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JDialogTest {
	final static int defaultFrameX = 400;
	final static int defaultFraneY = 300;
	
	private static JTextArea textArea;
	private static JScrollPane scrollPane;
	private static JFrame frame; 
	
	public static void addComponentsToPane(Container pane) {
		
		JButton b1 = new JButton("OK");
    	JButton b2 = new JButton("Cancel");
    	JButton b3 = new JButton("Ok2");
    	
    	textArea = new JTextArea(8, 40);
    	scrollPane = new JScrollPane(textArea);    	
    	
    	SpringLayout springLayout = new SpringLayout();
    	
    	pane.add(scrollPane);
    	pane.add(b1);
    	pane.add(b2);
    	pane.add(b3);
    	
    	pane.setLayout(springLayout);
    	
    	springLayout.putConstraint(SpringLayout.WEST, scrollPane, 10, SpringLayout.WEST, pane);
    	springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 10, SpringLayout.NORTH, pane);
    	springLayout.putConstraint(SpringLayout.WEST, b1, 10, SpringLayout.EAST, scrollPane);
    	springLayout.putConstraint(SpringLayout.NORTH, b1, 0, SpringLayout.NORTH, scrollPane);
    	springLayout.putConstraint(SpringLayout.NORTH, b2, 10, SpringLayout.SOUTH, b1);
    	springLayout.putConstraint(SpringLayout.WEST, b2, 0, SpringLayout.WEST, b1); 
    	springLayout.putConstraint(SpringLayout.NORTH, b3, 10, SpringLayout.SOUTH, b2);
    	springLayout.putConstraint(SpringLayout.WEST, b3, 0, SpringLayout.WEST, b2); 
    	springLayout.putConstraint(SpringLayout.EAST, pane, 10, SpringLayout.EAST, b1);
    	springLayout.putConstraint(SpringLayout.SOUTH, pane, 20, SpringLayout.SOUTH, scrollPane);   	
    	
    	
    	SpringLayout.Constraints b1c = springLayout.getConstraints(b1);
    	SpringLayout.Constraints b2c = springLayout.getConstraints(b2);
    	SpringLayout.Constraints b3c = springLayout.getConstraints(b3);
    	
    	
    	Spring maxWidth = Spring.max(b1c.getWidth(), b2c.getWidth());
    	b1c.setWidth(maxWidth);
    	b2c.setWidth(maxWidth);
    	b3c.setWidth(maxWidth);
    	
    	b1.addActionListener(new showTextAreaContents());
    	b2.addActionListener(new deleteTextAreaContents());
    	b3.addActionListener(new showTextAreaContents2());
		
		
	}
	
	
	public static class showTextAreaContents implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JFrame messageFrame = new JFrame("MessageFrame");
			
			JOptionPane.showMessageDialog(messageFrame, textArea.getText());
			
		//	messageFrame.pack();
		//	messageFrame.setVisible(true);
			
		}
		
	}
	
	public static class deleteTextAreaContents implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			JFrame messageFrame = new JFrame("MessageFrame");
			//Custom button text
			Object[] options = {"Yes, please","No, thanks"};
			int n = JOptionPane.showOptionDialog(messageFrame,
			    "Would you like delete text area?",
			    "Delete text area?",
			    JOptionPane.YES_NO_CANCEL_OPTION,
			    JOptionPane.QUESTION_MESSAGE,
			    null,
			    options,
			    options[1]);               
			
			if ( n == 0 ) {
				textArea.setText("");
			}
		
		}
		
		
	}
	
	public static class showTextAreaContents2  implements ActionListener {
		public void actionPerformed(ActionEvent e) {		
			JFrame messageFrame = new JFrame();
			
			JDialog dialog = new AboutDialog(messageFrame);
			dialog.setVisible(true);			
		}
	}
	
	static class AboutDialog extends JDialog {
		public AboutDialog(JFrame owner) {
	        super(owner,"About dialog" , true);
	        add(new JLabel(textArea.getText()),BorderLayout.CENTER);
	        JPanel panel = new JPanel();
	        JButton ok = new JButton("OK");
	        ok.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent event) {
	                setVisible(false);
	            }
	        });
	        panel.add(ok);
	        add(panel, BorderLayout.SOUTH);
	        setSize(250, 150);
	        
	    }
	}


	private static void createAndShowGUI() {
	        //Create and set up the window.
	        frame = new JFrame("SpringBagLayoutTextWindowDemo");
	       
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
