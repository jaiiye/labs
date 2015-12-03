package zda1.zad7;

/**
 * Created by blepa on 2015-12-03.
 * <p>
 * Proszę napisać program zawierający grupę przycisków zmieniających kierunki wypełnienia układu FlowLayout
 * <p>
 * Proszę napisać program zawierający grupę przycisków zmieniających kierunki wypełnienia układu FlowLayout
 */

/**
 * Proszę napisać program zawierający grupę przycisków zmieniających kierunki wypełnienia układu FlowLayout
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SwingLayoutDemo {
    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JLabel testLabel;
    private JPanel controlPanel;
    private JPanel testFlowLayoutPanel;
    private JLabel msglabel;

    public SwingLayoutDemo() {
        prepareGUI();
    }

    public static void main(String[] args) {
        SwingLayoutDemo swingLayoutDemo = new SwingLayoutDemo();
        swingLayoutDemo.showControlLayoutDemo();
        swingLayoutDemo.showFlowLayoutDemo();
    }

    private void prepareGUI() {
        mainFrame = new JFrame("Java SWING FlowLayout");
        mainFrame.setSize(600, 800);
        mainFrame.setLayout(new GridLayout(4, 1));

        headerLabel = new JLabel("", JLabel.CENTER);
        statusLabel = new JLabel("", JLabel.CENTER);
        testLabel = new JLabel("", JLabel.CENTER);

        statusLabel.setSize(100, 100);
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        testFlowLayoutPanel = new JPanel();
        testFlowLayoutPanel.setLayout(new FlowLayout());
        testFlowLayoutPanel.setSize(0, 0);
        testFlowLayoutPanel.setBackground(Color.darkGray);


        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.add(testFlowLayoutPanel);
        mainFrame.setVisible(true);
    }

    private void showControlLayoutDemo() {
        headerLabel.setText("Wybierz kierunek");

        JPanel panel = new JPanel();
        panel.setSize(0, 0);
        FlowLayout layout = new FlowLayout();
        layout.setHgap(10);
        layout.setVgap(10);
        panel.setLayout(layout);

        JButton button1 = new JButton("LEFT");
        panel.add(button1);
        button1.addActionListener(new ChangeAligmentLeft());

        JButton button2 = new JButton("RIGHT");
        panel.add(button2);
        button2.addActionListener(new ChangeAligmentRight());

        JButton button3 = new JButton("CENTER");
        panel.add(button3);
        button3.addActionListener(new ChangeAligmentCenter());

        JButton button4 = new JButton("LEADING");
        panel.add(button4);
        button4.addActionListener(new ChangeAligmentLeading());

        JButton button5 = new JButton("TRAILING");
        panel.add(button5);
        button5.addActionListener(new ChangeAligmentTrailing());


        controlPanel.add(panel);

        mainFrame.setVisible(true);
    }

    private void showFlowLayoutDemo() {

        testFlowLayoutPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        testFlowLayoutPanel.add(new JButton("TEST"));
        testFlowLayoutPanel.add(new JButton("TEST2"));
        testFlowLayoutPanel.add(new JButton("TEST3"));
        testFlowLayoutPanel.add(new JButton("TEST4"));
        testFlowLayoutPanel.add(new JButton("TEST5"));
        testFlowLayoutPanel.add(new JButton("TEST6"));
        testFlowLayoutPanel.add(new JButton("TEST7"));
        testFlowLayoutPanel.add(new JButton("TEST8"));
        testFlowLayoutPanel.add(new JButton("TEST9"));
        testFlowLayoutPanel.add(new JButton("TEST10"));
    }


    private class ChangeAligmentLeft implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            testFlowLayoutPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
            testFlowLayoutPanel.revalidate();
            testFlowLayoutPanel.repaint();
        }
    }

    private class ChangeAligmentRight implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            testFlowLayoutPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
            testFlowLayoutPanel.revalidate();
            testFlowLayoutPanel.repaint();
        }
    }

    private class ChangeAligmentCenter implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            testFlowLayoutPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
            testFlowLayoutPanel.revalidate();
            testFlowLayoutPanel.repaint();
        }
    }

    private class ChangeAligmentLeading implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            testFlowLayoutPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
            testFlowLayoutPanel.revalidate();
            testFlowLayoutPanel.repaint();
        }
    }

    private class ChangeAligmentTrailing implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            testFlowLayoutPanel.setLayout(new FlowLayout(FlowLayout.TRAILING));
            testFlowLayoutPanel.revalidate();
            testFlowLayoutPanel.repaint();
        }
    }

}


