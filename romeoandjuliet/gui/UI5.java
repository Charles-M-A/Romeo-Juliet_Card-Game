package cst4010.romeoandjuliet.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UI5 extends JFrame {
    final JSplitPane splitPane;
    final JPanel leftPanel;
    final JPanel rightPanel;
    final JScrollPane scrollPane;
    final JTextArea textArea;
    final JPanel inputPanel;
    final JTextField textField;
    final int FINAL_CARDS_NUMBER = 49;
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JLabel playerLabel;
    JLabel roundLabel;
    JPanel topPanel;
    JPanel botPanel;

    public UI5() {


        splitPane = new JSplitPane();

        leftPanel = new JPanel();
        rightPanel = new JPanel();

        scrollPane = new JScrollPane();
        textArea = new JTextArea();


        inputPanel = new JPanel();
        textField = new JTextField();
        button1 = new JButton("Move");
        button2 = new JButton("Swap");
        button3 = new JButton("Home");
        button4 = new JButton("Quit");
        topPanel = new JPanel();
        botPanel = new JPanel();
        playerLabel = new JLabel("Player");
        roundLabel = new JLabel("Rounds");

        shuffle();

        setPreferredSize(new Dimension(800, 830));

        getContentPane().setLayout(new GridLayout());

        getContentPane().add(splitPane);


        splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setDividerLocation(500);
        splitPane.setTopComponent(leftPanel);
        splitPane.setBottomComponent(rightPanel);

        leftPanel.setLayout(new GridLayout(7, 1, 2, 2));


        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        button1.setMaximumSize(new Dimension(100, 100));
        button2.setMaximumSize(new Dimension(100, 100));
        button3.setMaximumSize(new Dimension(100, 100));
        button4.setMaximumSize(new Dimension(100, 100));

        button3.setAlignmentX(Component.CENTER_ALIGNMENT);
        button4.setAlignmentX(Component.CENTER_ALIGNMENT);
        playerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        roundLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        button1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                System.out.println("CLICKED " + button1.getText());
            }
        });

        button2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                System.out.println("CLICKED " + button2.getText());
            }
        });

        button3.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                System.out.println("CLICKED " + button3.getText());
                UI1.main(null);
                dispose();
            }
        });

        button4.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                System.out.println("CLICKED " + button4.getText());
                System.exit(1);
            }
        });

        rightPanel.add(Box.createRigidArea(new Dimension(20, 20)));
        rightPanel.add(playerLabel);
        rightPanel.add(Box.createRigidArea(new Dimension(20, 20)));
        rightPanel.add(roundLabel);
        rightPanel.add(Box.createRigidArea(new Dimension(20, 20)));
        rightPanel.add(Box.createRigidArea(new Dimension(20, 20)));
        rightPanel.add(topPanel);
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.LINE_AXIS));
        topPanel.add(button1);
        topPanel.add(Box.createRigidArea(new Dimension(10, 10)));
        topPanel.add(button2);

        rightPanel.add(Box.createRigidArea(new Dimension(40, 70)));

        rightPanel.add(scrollPane);
        scrollPane.setViewportView(textArea);

        inputPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 75));
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.X_AXIS));

        inputPanel.add(textField);
        rightPanel.add(Box.createRigidArea(new Dimension(20, 50)));
        rightPanel.add(botPanel);
        botPanel.setLayout(new BoxLayout(botPanel, BoxLayout.LINE_AXIS));

        botPanel.add(button3);
        botPanel.add(Box.createRigidArea(new Dimension(10, 10)));
        botPanel.add(button4);

        rightPanel.add(Box.createRigidArea(new Dimension(20, 20)));


        pack();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                UI5 UI = new UI5();
                UI.setVisible(true);
                UI.setResizable(false);
                UI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
    }

    public void shuffle() {
        Integer[] arr = new Integer[49];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }


        ImageIcon[] deckOfCards = new ImageIcon[FINAL_CARDS_NUMBER];
        String[] suite = {"D", "C", "H", "S"};
        String[] num = {"2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String[] card = {"A", "Q", "K", "J"};
        String joker = "joker";
        int deck = 0;
        for (int flag = 0; flag < 2; flag++) {
            if (deck == 49) {
                deck = 0;
            }
            if (flag == 0) {
                for (int i = 0; i < suite.length; i++) {
                    for (int j = 0; j < num.length; j++) {
                        if ((num[j] + suite[i]).equals("7S")) {
                        } else if ((num[j] + suite[i]).equals("7H") || (num[j] + suite[i]).equals("7D") || (num[j] + suite[i]).equals("7C")) {
                            deckOfCards[deck] = new ImageIcon("Source_Code/src/cst4010/romeoandjuliet/gui/resources/joker.jpg");
                        } else {
                            deckOfCards[deck] = new ImageIcon("Source_Code/src/cst4010/romeoandjuliet/gui/resources/" + (num[j] + suite[i]) + ".jpg");
                            deck++;
                        }
                    }
                }
            } else if (flag == 1) {
                for (int i = 0; i < suite.length; i++) {
                    for (int j = 0; j < card.length; j++) {
                        if ((card[j] + suite[i]).equals("QS") || (card[j] + suite[i]).equals("QD")) {
                        } else if ((card[j] + suite[i]).equals("QH")) {
                            deckOfCards[48] = new ImageIcon("Source_Code/src/cst4010/romeoandjuliet/gui/resources/" + (card[j] + suite[i]) + ".jpg");
                        } else if ((card[j] + suite[i]).equals("QC")) {
                            deckOfCards[47] = new ImageIcon("Source_Code/src/cst4010/romeoandjuliet/gui/resources/" + (card[j] + suite[i]) + ".jpg");
                        } else {
                            deckOfCards[deck] = new ImageIcon("Source_Code/src/cst4010/romeoandjuliet/gui/resources/" + (card[j] + suite[i]) + ".jpg");
                            deck++;

                        }
                    }
                }
            }
        }


        JLabel[] label = new JLabel[FINAL_CARDS_NUMBER];
        ImageIcon[] deckIm = new ImageIcon[2];
        for (int i = 1; i <= FINAL_CARDS_NUMBER; i++) {
            if (arr[i - 1] == 47 || arr[i - 1] == 48) {

            }
            int f = i - 1;
            if (i == 7) {
                deckIm[0] = deckOfCards[f];
                ImageIcon t = deckOfCards[48];
                String name = Integer.toString(f);
                label[f] = new JLabel(name, t, 0);
                leftPanel.add(label[f]);
                int finalI = f;
                label[f].addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent me) {
                        System.out.println("CLICKED " + label[finalI].getText());
                    }
                });
            } else if (i == 43) {
                deckIm[1] = deckOfCards[f];
                ImageIcon t = deckOfCards[47];
                String name = Integer.toString(f);
                label[f] = new JLabel(name, t, 0);
                leftPanel.add(label[f]);
                int finalI = f;
                label[f].addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent me) {
                        System.out.println("CLICKED " + label[finalI].getText());
                    }
                });
            } else if (i == 48) {
                ImageIcon t = deckIm[0];
                String name = Integer.toString(f);
                label[f] = new JLabel(name, t, 0);
                leftPanel.add(label[f]);
                int finalI = f;
                label[f].addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent me) {
                        System.out.println("CLICKED " + label[finalI].getText());
                    }
                });
            } else if (i == 49) {
                ImageIcon t = deckIm[1];
                String name = Integer.toString(f);
                label[f] = new JLabel(name, t, 0);
                leftPanel.add(label[f]);
                int finalI = f;
                label[f].addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent me) {
                        System.out.println("CLICKED " + label[finalI].getText());
                    }
                });
            } else {
                ImageIcon t = deckOfCards[arr[f]];
                String name = Integer.toString(f);
                label[f] = new JLabel(name, t, 0);
                leftPanel.add(label[f]);
                int finalI = f;
                label[f].addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent me) {
                        System.out.println("CLICKED " + label[finalI].getText());
                    }
                });
            }
        }


    }
}
