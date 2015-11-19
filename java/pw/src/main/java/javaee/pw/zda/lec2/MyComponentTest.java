package javaee.pw.zda.lec2;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;


public class MyComponentTest {
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("test");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = frame.getContentPane();
		Component c = new MyComponent();
		contentPane.add(c);
		
		frame.pack();		
		frame.setVisible(true);
		
	}
}
