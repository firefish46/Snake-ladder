import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JOptionPanel {
    ImageIcon yesIcon = new ImageIcon("user.png");
    ImageIcon noIcon = new ImageIcon("path/to/no.png");

    // Create buttons with images
    JLabel yesButton = new JLabel(yesIcon);
    JButton noButton = new JButton(noIcon);

    // Create a JPanel to hold the buttons
    JPanel buttonPanel = new JPanel();
        String msg= "player";
void show(){
    buttonPanel.add(yesButton);
    buttonPanel.add(noButton);

        // Show JOptionPane with custom buttons
        int choice = JOptionPane.showOptionDialog(
                null,
                msg+" wins",
                "GAMEover",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                yesIcon,
                new Object[]{},
                null
        );


    }
}
