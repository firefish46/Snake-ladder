import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class test {
    JFrame gameover= new JFrame();
    JLabel title = new JLabel();
    JLabel winner = new JLabel();
    int i;
    test() throws InterruptedException, UnsupportedAudioFileException, LineUnavailableException, IOException {
        gameover.setBounds(400,100,400,400);
        gameover.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gameover.setVisible(true);
        gameover.setLayout(null);
        gameover.add(title);
        title.setBounds(100,100,300,50);
        title.setFont(new Font("Showcard Gothic", Font.BOLD, 30));
        new HomePage();
        for (i=10;i>0;i--){
            title.setText("countdown: "+i);
            Thread.sleep(1000);
        }

    }
}
