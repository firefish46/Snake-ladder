import javax.swing.*;
import java.awt.*;

public class Noticeboard {
    static JFrame dashboard = new JFrame();
   static JLabel title = new JLabel();
static JLabel player = new JLabel();
    Noticeboard(){

        dashboard.setBounds(350,10,900,100);
        dashboard.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        dashboard.setVisible(true);
        dashboard.setLayout(null);

        dashboard.add(title);
        dashboard.add(player);
        dashboard.getContentPane().setBackground(new Color(0xB0E379));
        title.setFont(new Font("Showcard Gothic", Font.BOLD, 20));
        player.setFont(new Font("Showcard Gothic", Font.BOLD, 20));
        title.setText(" welcome");
        title.setBounds(160, 10, 400, 60);
        player.setBounds(10, 10, 150, 60);
    }
}
