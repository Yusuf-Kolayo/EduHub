import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.JFrame;

public class UpdateMember extends JFrame implements ActionListener {
  
    JLabel lblFirstName, lblLastName, lblGender, lblEmail, lblPassword;
    JTextField txtFirstName, txtLastName, txtGender, txtEmail, txtPassword;
    JButton cancelButton, updateButton;
    
    Connection conn = null;

  
    UpdateMember() {
        this.setTitle("Update Member");
        this.setSize(350,350);
        this.setResizable(false);
        Container contentPane = this.getContentPane();
        contentPane.setLayout(null); 
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
   
       String  first_name, last_name, email, gender, password;
    
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

       txtFirstName = new JTextField(first_name);
       txtFirstName.setBounds(136,36, 150,26); 

       txtLastName = new JTextField(last_name);
       txtLastName.setBounds(136,76, 150,26);

       txtGender = new JTextField(gender);
       txtGender.setBounds(136,116, 150,26);

       txtEmail = new JTextField(email);
       txtEmail.setBounds(136,156, 150,26);

       txtPassword = new JTextField(password);
       txtPassword.setBounds(136,196, 150,26);

       cancelButton = new JButton("Close");
       cancelButton.setBounds(26,236, 120,30);
       cancelButton.addActionListener(this);

       updateButton = new JButton("Update");
       updateButton.setBounds(166,236, 120,30);
       updateButton.addActionListener(this);

       


       // Add all components to the ContentPane
       contentPane.add(lblFirstName);  
       contentPane.add(txtFirstName);  
       contentPane.add(lblLastName);  
       contentPane.add(txtLastName);  
       contentPane.add(lblGender);
       contentPane.add(txtGender);
       contentPane.add(lblEmail);
       contentPane.add(txtEmail);
       contentPane.add(lblPassword);
       contentPane.add(txtPassword);
       contentPane.add(cancelButton); 
       contentPane.add(updateButton); 

       this.setVisible(true); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        if (e.getSource()==cancelButton) {
            try {
                dispose();   
                Dashboard.frm_dashboard.setVisible(true);
            } catch (Exception ex) {
                //TODO: handle exception
            }
         }

         if (e.getSource()==updateButton) {
            
 
            String firstName = txtFirstName.getText();
            String lastName = txtLastName.getText();
            String gender = txtGender.getText();
            String email = txtEmail.getText();
            String password = txtPassword.getText();
            String user_id = Dashboard.selected_id;
            // String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());  // this data is now generated in the db only
   

             String SQL = "update members set first_name='"+ firstName +"', last_name='"+ lastName +"', gender='"+ gender + 
                         "', email='"+ email + "', password='"+ password + "' where id='" + user_id + "'";
             Statement stmt = null;       // System.out.println(SQL);
             
              try {
  
                // conn = JDBCUtil.getConnection();
                conn = DBConnect.DBConnect();
  
                stmt = conn.createStatement();
                stmt.executeUpdate(SQL);
   
                JOptionPane.showMessageDialog(null, "Record updated successfully!", "FYI", JOptionPane.INFORMATION_MESSAGE);
                Dashboard.fetch_members();
                
              } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
              }
              finally {
                  try {
                    stmt.close();
                  } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                  }
              }



         }
        
    }
}
 
