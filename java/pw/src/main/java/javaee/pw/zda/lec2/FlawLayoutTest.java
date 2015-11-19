package javaee.pw.zda.lec2;

import java.awt.Container;
import java.awt.Insets;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;

public class FlawLayoutTest {

	JFrame frame = new JFrame("Dwa przyciski");
	
	frame.setBounds(100, 100, 450, 300);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	Container pane = frame.getContentPane();
	
	pane.setLayout(new FlowLayout(FlowLayout.LEFT));
	
	for(int i=0; i< 10; i++) {
	    JButton btn = new JButton(String.valueOf(i));
	    btn.setSize(new Dimension(100,20));
	    pane.add(btn);
	}
	
	pane.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
	frame.setVisible(true);

}
