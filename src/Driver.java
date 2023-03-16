import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;


public class Driver extends javax.swing.JFrame {

    protected static JFrame f;
    protected static JPanel panel;
    protected static SquareM squarem;

    //default constructor
    public Driver() {

        f = new JFrame(); //create sub frame
        
        //set the size of the window
        f.setSize(new Dimension(550, 560));
        f.setMinimumSize(new Dimension(50, 100));
        f.setResizable(false);
        f.setTitle("BFS PathFinder");
        f.setVisible(true);
        
        f.setLocationRelativeTo(null);
        
        
        GridLayout figure = new GridLayout(1, 1);

        //create a panel
        panel = new JPanel(figure);
        
        f.add(panel);
        mainSquare();
        mainOptions();
        
        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //method for starting the square
    public static void mainSquare() {
        GridLayout figure = new GridLayout(20, 20);
        JPanel p = new JPanel(figure);
        JButton[][] mainDisplay = new JButton[20][20];
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                JButton button = new JButton();
                button.setBackground(Color.BLACK);
                mainDisplay[i][j] = button;
                p.add(button);
            }
        }
        panel.add(p);
        squarem = new SquareM(mainDisplay);
        

    }

    //method for the square menu
    public static void mainOptions() {
        JMenuBar booBoo = new JMenuBar(); //create new menubar

        JMenu squareChoices = new JMenu("Choose to");
        JMenuItem breadthFirst = new JMenuItem("Start BFS");
        JMenuItem moveBack = new JMenuItem("Undo");
        JMenuItem resetSquare = new JMenuItem("Clear");
        
        
            //ActionListener BFS
        breadthFirst.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                squarem.showOff();
                squarem.bFS();
            }

        });
        //ActionListener Undo
        moveBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                squarem.moveBack();
            }

        });
        //ActionListener Reset
        resetSquare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                squarem.showOn();
                squarem.eraseAll();

            }

        });
        
        
        squareChoices.add(breadthFirst);
        squareChoices.add(moveBack);
        squareChoices.add(resetSquare);
        booBoo.add(squareChoices);
        f.setJMenuBar(booBoo);
  }
}
