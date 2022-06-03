import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;

import javax.swing.*;
import javax.swing.JFrame;

public class ViewMember extends JFrame implements ActionListener {
  
    JLabel lblFirstName, lblLastName, lblGender, lblEmail, lblPassword;
    JLabel dpFirstName, dpLastName, dpGender, dpEmail, dpPassword;
    JButton saveButton, cancelButton;
    
    Connection conn = null;

  
    ViewMember() {
        this.setTitle("Welcome to your Dashboard");
        this.setSize(350,350);
        this.setResizable(false);
        Container contentPane = this.getContentPane();
        contentPane.setLayout(null); 
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
   
       

        lblFirstName = new JLabel("First Name");
       lblFirstName.setBounds(26,36, 100,26);
      //  lblFirstName.setBackground(Color.yellow);
       lblFirstName.setOpaque(true);

       lblLastName = new JLabel("Last Name");
       lblLastName.setBounds(26,76, 100,26);
      //  lblLastName.setBackground(Color.yellow);
       lblLastName.setOpaque(true);

       lblGender = new JLabel("Gender");
       lblGender.setBounds(26,116, 100,26);
      //  lblGender.setBackground(Color.yellow);
       lblGender.setOpaque(true);

       lblEmail = new JLabel("Email Address");
       lblEmail.setBounds(26,156, 100,26);
      //  lblEmail.setBackground(Color.yellow);
       lblEmail.setOpaque(true);

       lblPassword = new JLabel("Password");
       lblPassword.setBounds(26,196, 100,26);
      //  lblPassword.setBackground(Color.yellow);
       lblPassword.setOpaque(true);

       dpFirstName = new JLabel();
       dpFirstName.setBounds(136,36, 150,26); 

       dpLastName = new JLabel();
       dpLastName.setBounds(136,76, 150,26);

       dpGender = new JLabel();
       dpGender.setBounds(136,116, 150,26);

       dpEmail = new JLabel();
       dpEmail.setBounds(136,156, 150,26);

       dpPassword = new JLabel();
       dpPassword.setBounds(136,196, 150,26);

       cancelButton = new JButton("Close");
       cancelButton.setBounds(26,236, 120,30);
       cancelButton.addActionListener(this);

       saveButton = new JButton("Save");
       saveButton.setBounds(166,236, 120,30);
       saveButton.addActionListener(this);


       // Add all components to the ContentPane
       contentPane.add(lblFirstName);  
       contentPane.add(dpFirstName);  
       contentPane.add(lblLastName);  
       contentPane.add(dpLastName);  
       contentPane.add(lblGender);
       contentPane.add(dpGender);
       contentPane.add(lblEmail);
       contentPane.add(dpEmail);
       contentPane.add(lblPassword);
       contentPane.add(dpPassword);
       contentPane.add(cancelButton);
       contentPane.add(saveButton);

       this.setVisible(true); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
}
