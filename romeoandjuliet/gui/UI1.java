package cst4010.romeoandjuliet.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UI1 extends JFrame {
    public UI1() {

        final JSplitPane splitPane;
        final JPanel upperPanel;
        final JPanel lowerPanel;
        JButton button1;
        JButton button2;
        JButton button3;
        JLabel ver;
        JPanel topPanel;
        JPanel botPanel;
        JPanel panel;

        splitPane = new JSplitPane();

        upperPanel = new JPanel();
        lowerPanel = new JPanel();

        button1 = new JButton("Play Local");
        button2 = new JButton("Play Online");
        button3 = new JButton("Quit");
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
                cst4010.romeoandjuliet.gui.UI2.main(null);
                dispose();
            }
        });

        button2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                System.out.println("CLICKED " + button2.getText());
                cst4010.romeoandjuliet.gui.UI2.main(null);
                dispose();
            }
        });

        button3.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                System.out.println("CLICKED " + button3.getText());
                System.exit(1);
            }
        });


        upperPanel.add(label);
        lowerPanel.add(Box.createRigidArea(new Dimension(20, 20)));
        lowerPanel.add(topPanel);
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.add(button1);
        topPanel.add(Box.createRigidArea(new Dimension(10, 10)));
        topPanel.add(button2);

        lowerPanel.add(botPanel);
        botPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        botPanel.add(button3, BorderLayout.SOUTH);
        botPanel.add(Box.createRigidArea(new Dimension(10, 10)));

        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        lowerPanel.add(panel);
        lowerPanel.add(Box.createRigidArea(new Dimension(20, 20)));
        lowerPanel.add(ver);

        pack();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                UI1 ui = new UI1();
                ui.setVisible(true);
                ui.setResizable(false);
                ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
    }
}
