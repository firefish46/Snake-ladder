import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SnakeAndLadderGame extends JFrame {
    private JButton rollButton;
    private JTextArea displayArea;
    private int currentPlayer;
    private int[] playerPositions;

    // Constructor
    public SnakeAndLadderGame() {
        setTitle("Snake and Ladder Game");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        currentPlayer = 1;
        playerPositions = new int[]{1, 1};

        JPanel buttonPanel = new JPanel();
        rollButton = new JButton("Roll Dice");
        rollButton.addActionListener(new RollButtonListener());
        buttonPanel.add(rollButton);

        displayArea = new JTextArea();
        displayArea.setEditable(false);

        add(buttonPanel, BorderLayout.NORTH);
        add(new JScrollPane(displayArea), BorderLayout.CENTER);

        setVisible(true);
    }

    // RollButtonListener class
    private class RollButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int diceRoll = rollDice();
            int newPosition = playerPositions[currentPlayer - 1] + diceRoll;
            playerPositions[currentPlayer - 1] = newPosition;
            displayArea.append("Player " + currentPlayer + " rolled a " + diceRoll + ".\n");
            displayArea.append("Player " + currentPlayer + " moved to position " + newPosition + ".\n");

            checkSnake();
            checkWin();

            currentPlayer = currentPlayer == 1 ? 2 : 1;
        }
    }

    // Method to simulate dice roll
    private int rollDice() {
        return (int) (Math.random() * 6) + 1;
    }

    // Method to check if a player has landed on a snake
    private void checkSnake() {
        int[] snakes = {17, 20, 51, 63, 89, 95, 99};
        int[] snakeTails = {7, 38, 67, 81, 26, 75, 78};

        for (int i = 0; i < snakes.length; i++) {
            if (playerPositions[currentPlayer - 1] == snakes[i]) {
                playerPositions[currentPlayer - 1] = snakeTails[i];
                displayArea.append("Oops! Player " + currentPlayer + " landed on a snake at position " + snakes[i] + ".\n");
                displayArea.append("Player " + currentPlayer + " moved back to position " + snakeTails[i] + ".\n");
                break;
            }
        }
    }

    // Method to check if a player has won
    private void checkWin() {
        if (playerPositions[currentPlayer - 1] >= 100) {
            displayArea.append("Player " + currentPlayer + " wins!\n");
            rollButton.setEnabled(false);
        }
    }

    // Main method
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SnakeAndLadderGame();
            }
        });
    }
}
