import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;

import javax.swing.*;
import javax.swing.JFrame;

public class ViewMember extends JFrame implements ActionListener {
  
    JLabel lblFirstName, lblLastName, lblGender, lblEmail, lblPassword;
    JLabel dpFirstName, dpLastName, dpGender, dpEmail, dpPassword;
    JButton closeButton;
    
    Connection conn = null;

  
    ViewMember() {
        this.setTitle("Welcome to your Dashboard");
        this.setSize(350,350);
        this.setResizable(false);
        Container contentPane = this.getContentPane();
        contentPane.setLayout(null); 
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
   
       String first_name, last_name, email, gender, password;
       first_name = Dashboard.selected_fn;
       last_name = Dashboard.selected_ln;
       email = Dashboard.selected_em;
       gender = Dashboard.selected_gd;
       password = Dashboard.selected_pw;

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

       dpFirstName = new JLabel(first_name);
       dpFirstName.setBounds(136,36, 150,26); 

       dpLastName = new JLabel(last_name);
       dpLastName.setBounds(136,76, 150,26);

       dpGender = new JLabel(gender);
       dpGender.setBounds(136,116, 150,26);

       dpEmail = new JLabel(email);
       dpEmail.setBounds(136,156, 150,26);

       dpPassword = new JLabel(password);
       dpPassword.setBounds(136,196, 150,26);

       closeButton = new JButton("Close");
       closeButton.setBounds(166,236, 120,30);
       closeButton.addActionListener(this);

       


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
       contentPane.add(closeButton); 

       this.setVisible(true); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        if (e.getSource()==closeButton) {
            try {
                dispose();   
                Dashboard.frm_dashboard.setVisible(true);
            } catch (Exception ex) {
                //TODO: handle exception
            }
         }
        
    }
}
