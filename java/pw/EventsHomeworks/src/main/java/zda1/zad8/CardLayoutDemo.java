package zda1.zad8;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CardLayoutDemo extends JFrame {

    class MyPanel extends JPanel {

        private static final long serialVersionUID = 1L;

        public MyPanel(String title) {
            super();
            JLabel jLabel = new JLabel(title);
            add(jLabel);
        }
    }

    public static void main(String[] args) {
        CardLayoutDemo app = new CardLayoutDemo();
        app.init();
        app.show();
    }

    private JFrame mainFrame;
    private JButton prev;
    private JButton next;
    private JPanel buttonPanel;

    private JPanel contentPanel;

    private CardLayout cardLayout;

    public CardLayoutDemo() {
        mainFrame = new JFrame("CardLayoutTest");
        mainFrame.setPreferredSize(new Dimension(200,100));
        prev = new JButton("<<");
        next = new JButton(">>");
        buttonPanel = new JPanel();
        contentPanel = new JPanel();

        mainFrame.setSize(new Dimension(300, 300));
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buttonPanel.setLayout(new GridLayout(1, 2));
        buttonPanel.add(prev, 0);
        buttonPanel.add(next, 1);

        mainFrame.add(buttonPanel, BorderLayout.NORTH);
        mainFrame.add(contentPanel, BorderLayout.CENTER);

    }

    private void init() {
        cardLayout = new CardLayout();
        contentPanel.setLayout(cardLayout);
        for (int i = 0; i < 5; i++) {
            contentPanel.add(new MyPanel("Karta numer: " + i), "" + i);
        }

        prev.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                cardLayout.previous(contentPanel);
            }

        });

        next.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                cardLayout.next(contentPanel);
            }

        });
    }

    public void show() {
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
}