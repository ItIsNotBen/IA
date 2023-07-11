import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Top level class - Deals with player interaction. Displays the whole game.

public class Window extends JFrame {

    private JButton handButton;
    private JButton gridButton;
    private Game game;
    private Controller controller;

    public Window(char[] hand, char[][] grid) {
        setSize(600, 750);
        JPanel handPanel = new JPanel();
        handPanel.setSize(300, 100);
//        game = controller.getGame();

        for (int i = 0; i < hand.length; i++) {
            char letter = hand[i];
            handButton = new JButton(Character.toString(letter));
            handPanel.add(handButton);
            handButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JButton button = (JButton) e.getSource();
                    System.out.println("This button is: " + button.getText());
                }
            });
        }
        add(handPanel, BorderLayout.SOUTH);
        setVisible(true);


        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(grid.length, grid[0].length));

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                char square = grid[i][j];
                gridButton = new JButton(Character.toString(square));
                gridPanel.add(gridButton);
                gridButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        JButton button = (JButton) e.getSource();
                        System.out.println("The tile on this grid is: " + button.getText());
                    }
                });
            }
        }


        add(gridPanel, BorderLayout.NORTH);
        setVisible(true);
    }

//    public void addPlayerGrid(char[][] playerGrid) {
//        Player player = game.getPlayer();
//        playerGrid = player.getGrid();
//
//        JButton[] buttons = new JButton[playerGrid.length];
//
//        for (int i = 0; i < playerGrid.length; ++i) {
//            for (int j = 0; j < playerGrid.length - 1; j++) {
//                buttons[i] = new JButton(Character.toString(playerGrid[i][j])); //need to convert char to String first
//                this.add(buttons[i], BorderLayout.SOUTH);
//            }


/*    public char getHandButtonValue() {
        return handButton.getText().charAt(0);
    }
    public char getGridButtonValue() {
        return gridButton.getText().charAt(0);
    }*/


//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if(e.getSource() == handButton){
//            System.out.println("You have selected: " + getHandButtonValue());
//        } else if (e.getSource() == gridButton) {
//            System.out.println("This tile on the grid is: " + getGridButtonValue());
//        }
//    }
}
