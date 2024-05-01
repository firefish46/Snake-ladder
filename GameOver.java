import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.io.IOException;

public class GameOver extends HomePage {
    JFrame gameover= new JFrame();
    JLabel title = new JLabel();
    JLabel winner = new JLabel();
    GameOver() throws UnsupportedAudioFileException, LineUnavailableException, IOException {


        gameover.setSize(400,400);
        gameover.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gameover.setVisible(true);
    }
}
