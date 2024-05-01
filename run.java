import javax.swing.*;
import java.awt.*;

public class run {
    JFrame gameover= new JFrame();
    JLabel title = new JLabel();
    JLabel winner = new JLabel();
    run() throws InterruptedException {

        gameover.setBounds(400,100,400,400);
        gameover.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gameover.setVisible(true);
        gameover.setLayout(null);
        gameover.add(title);
        title.setBounds(100,100,300,50);
        title.setFont(new Font("Showcard Gothic", Font.BOLD, 30));
        for (int j=10;j>0;j--){

            title.setText("countdown: "+j);
            Thread.sleep(1000);
        }
    }
}
