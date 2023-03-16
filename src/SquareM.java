import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class SquareM {
    
    protected static JButton[][] squarem = new JButton[40][40];
    protected static ArrayList<JButton> eraseColor = new ArrayList<>();
    protected static int rate = 20;
    protected static boolean showOn = true;
    
    

    //default constructor
    public SquareM() {

    }

    //constructor for the display
    public SquareM(JButton[][] mainDisplay) {
        squarem = mainDisplay;
        contentsSquareM();
    }
    //method for not displaying the buttons
    public void showOff() {
        showOn = false;
    }
    //outputs the square
    public void displaySquareM() {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if (squarem[i][j].getBackground().equals(Color.YELLOW)) {
                    System.out.print(" 1 ");
                } else {
                    System.out.print(" 0 ");
                }
            }
            System.out.println("");
        }
    }
    //show the buttons
    public void showOn() {
        showOn = true;
    }
    //method that implements BFS 
    public void bFS() {
        Thread thread = new Thread(() -> {

            boolean[][] passed = new boolean[20][20];
            int[][] displaySquareM = new int[20][20];
            

            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 20; j++) {
                    if (squarem[i][j].getBackground().equals(Color.YELLOW)) {
                        displaySquareM[i][j] = 1;
                        passed[i][j] = true;
                    } else {
                        displaySquareM[i][j] = 0;
                    }
                }
            }

            int height = displaySquareM.length;
            int length = displaySquareM[0].length;

            Queue<String> jappu = new LinkedList<>();
            jappu.add(0 + "," + 0);

            System.out.println("Begin BFS");

            while (jappu.isEmpty() == false) {

                if (squarem[19][19].getBackground().equals(Color.WHITE)) {
                    break;
                }
                String m = jappu.remove();
                int row = Integer.parseInt(m.split(",")[0]);
                int col = Integer.parseInt(m.split(",")[1]);

                if (row < 0 || col < 0 || row >= height || col >= length || passed[row][col]) {
                    continue;
                }

                passed[row][col] = true;
                try {
                    Thread.sleep(rate);
                } catch (InterruptedException ex) {

                }
                squarem[row][col].setBackground(Color.WHITE);
                jappu.add(row + "," + (col - 1)); //go left
                jappu.add(row + "," + (col + 1)); //go right
                jappu.add((row - 1) + "," + col); //go up
                jappu.add((row + 1) + "," + col); //go down
            }
        });
        thread.start();
    }
    //method to undo the last move
    public void moveBack() {

        boolean keepGoing = false;

        if (!eraseColor.isEmpty()) {
            for (int i = 0; i < squarem.length; i++) {
                for (int j = 0; j < squarem.length; j++) {
                    if (squarem[i][j].equals(eraseColor.get(eraseColor.size() - 1))) {
                        eraseColor.remove(eraseColor.size() - 1);
                        squarem[i][j].setBackground(Color.BLACK);
                        keepGoing = true;
                        break;
                    }
                    if (keepGoing == true) {
                        break;
                    }
                }
                if (keepGoing == true) {
                    break;
                }
            }
        }
    }

    //resets the whole square
    public void eraseAll() {
        if (!eraseColor.isEmpty()) {
            for (int i = 0; i < squarem.length; i++) {
                for (int j = 0; j < squarem.length; j++) {
                    for (int k = 0; k < eraseColor.size(); k++) {
                        squarem[i][j].setBackground(Color.BLACK);

                    }
                }
            }
            eraseColor.clear();
            squarem[0][0].setBackground(Color.PINK);
            squarem[19][19].setBackground(Color.MAGENTA);
        }

    }
    //GUI setup
    public static void contentsSquareM() {
        squarem[0][0].setBackground(Color.PINK);
        squarem[19][19].setBackground(Color.MAGENTA);
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if (!squarem[i][j].getBackground().equals(Color.PINK) && !squarem[i][j].getBackground().equals(Color.MAGENTA)) {

                    squarem[i][j].addMouseListener(new java.awt.event.MouseAdapter() {


                        @Override
                        public void mouseEntered(MouseEvent evt) {
                            JButton button = (JButton) evt.getSource();
                            if (SwingUtilities.isLeftMouseButton(evt) && showOn == true) {
                                button.setBackground(Color.YELLOW);
                                eraseColor.add(button);
                            }
                        }

                        @Override
                        public void mousePressed(java.awt.event.MouseEvent evt) {
                            JButton button = (JButton) evt.getSource();
                            if (showOn == true) {
                                button.setBackground(Color.yellow);

                                eraseColor.add(button);
                                button.transferFocus();
                                eraseColor.add(button);
                            }
                        }

                        
                    });
                }
            }
        }
    }
}
