package javaee.pw.zda.lec2;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class BoxLayoutTest {
	JPanel hPanel = new JPanel();
	BoxLayout boxLayout = new BoxLayout(hPanel, BoxLayout.X_AXIS);
	
	hPanel.setLayout(boxLayout);
	hPanel.add(new JButton("Button 1"));
	hPanel.add(new JButton("Button 2"));

}
