import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFrame;

public class ViewMember extends JFrame implements ActionListener {
    ViewMember() {
        this.setTitle("Welcome to your Dashboard");
        this.setSize(350,350);
        this.setResizable(false);
        Container contentPane = this.getContentPane();
        contentPane.setLayout(null); 
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
   
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
}
