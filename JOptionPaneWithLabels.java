import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JOptionPaneWithLabels {
    ImageIcon icon= new ImageIcon("user.png");
    ImageIcon icon2= new ImageIcon("user1.png");
    ImageIcon okicon= new ImageIcon("cancel.png");
    // Create JLabels
    JLabel label1 = new JLabel(icon);
    JLabel label2 = new JLabel(icon2);
  String msg="player";
  int i=0;
    JButton ok= new JButton("yes",okicon);
    JButton no= new JButton("no",okicon);

    // Create Object array with labels
    Object[] message = {msg,label1, label2};
    Object[] options ={ok,no};

    // Show JOptionPane with labels
    JOptionPaneWithLabels(){
      JOptionPane.showMessageDialog(null,message,"sd", JOptionPane.ERROR_MESSAGE,okicon);

    }


}
