package cst4010.romeoandjuliet.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UI2 extends JFrame {
    public UI2() {

        final JSplitPane splitPane;
        final JPanel upperPanel;
        final JPanel lowerPanel;
        JButton button1;
        JButton button2;
        JButton button3;
        JButton button4;
        JLabel ver;
        JPanel topPanel;
        JPanel botPanel;
        JPanel panel;

        splitPane = new JSplitPane();

        upperPanel = new JPanel();
        lowerPanel = new JPanel();

        button1 = new JButton("vs Player");
        button2 = new JButton("vs AI");
        button3 = new JButton("Quit");
        button4 = new JButton("Back");
        topPanel = new JPanel();
        botPanel = new JPanel();
        panel = new JPanel();
        ver = new JLabel("v1.20200502");

        ImageIcon img = new ImageIcon("Source_Code/src/cst4010/romeoandjuliet/gui/resources/home.jpeg");
        JLabel label = new JLabel(img);


        setPreferredSize(new Dimension(400, 400));
        getContentPane().setLayout(new GridLayout());
        getContentPane().add(splitPane);

        splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
        splitPane.setDividerLocation(200);
        splitPane.setTopComponent(upperPanel);
        splitPane.setBottomComponent(lowerPanel);

        upperPanel.setLayout(new GridLayout(1, 1, 2, 2));


        lowerPanel.setLayout(new BoxLayout(lowerPanel, BoxLayout.Y_AXIS));


        button1.setMaximumSize(new Dimension(100, 100));
        button1.setAlignmentX(Component.CENTER_ALIGNMENT);
        button2.setMaximumSize(new Dimension(100, 100));
        button2.setAlignmentX(Component.CENTER_ALIGNMENT);
        button3.setMaximumSize(new Dimension(100, 100));
        ver.setAlignmentX(Component.CENTER_ALIGNMENT);

        button1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                System.out.println("CLICKED " + button1.getText());
                UI3.main(null);
                dispose();
            }
        });

        button2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                System.out.println("CLICKED " + button2.getText());
                UI4.main(null);
                dispose();
            }
        });

        button3.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                System.out.println("CLICKED " + button3.getText());
                System.exit(1);
            }
        });

        button4.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                System.out.println("CLICKED " + button4.getText());
                UI1.main(null);
                dispose();
            }
        });


        upperPanel.add(label);
        lowerPanel.add(Box.createRigidArea(new Dimension(20, 20)));
        lowerPanel.add(topPanel);
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.add(button1);
        topPanel.add(Box.createRigidArea(new Dimension(10, 10)));
        topPanel.add(button2);

        lowerPanel.add(Box.createRigidArea(new Dimension(10, 10)));
        lowerPanel.add(botPanel);
        botPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        botPanel.add(button4);
        botPanel.add(button3, BorderLayout.SOUTH);
        botPanel.add(Box.createRigidArea(new Dimension(10, 10)));

        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        lowerPanel.add(panel);
        lowerPanel.add(Box.createRigidArea(new Dimension(10, 10)));
        lowerPanel.add(ver);

        pack();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                UI2 ui = new UI2();
                ui.setVisible(true);
                ui.setResizable(false);
                ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
    }
}
