package javaee.pw.zda.lec2;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Point;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
class tictac {
  int count;
  public int getTic() {
    return count;
  } 
  public void inc() {
    count++;
  }
}

public class Cross {
	public static void main(String[] args) {
	    SwingUtilities.invokeLater(  () -> {
	      final tictac tic = new tictac();
	      JFrame frame = new JFrame("Test");
	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      frame.setBounds(50, 50, 400, 200);
	      Container pane  = frame.getContentPane();
	      pane.setLayout(null);
	      for(int i =0; i<9;i++) {
	        JButton btn = new JButton(" ");
	        btn.setSize(new Dimension(100,20));
	        btn.setLocation(new Point(10+(i%3)*110,10+(i/3)*30));
	        btn.addActionListener(e->{
	          //if(btn.getText() == " ") {
	            btn.setText(tic.getTic() % 2 == 0? "X":"O");
	            tic.inc();
	          //}
	        });
	        pane.add(btn);
	      }
	      frame.setVisible(true);
	    }
	  );
	  }
}
