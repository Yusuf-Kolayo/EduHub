import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.Console;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class InsertMember implements ActionListener {

    JFrame insertFrame;
    JLabel lblFirstName, lblLastName, lblGender, lblEmail, lblPassword;
    JTextField txtFirstName, txtLastName, txtGender, txtEmail, txtPassword;
    JButton saveButton, cancelButton;
    
    Connection conn = null;


    InsertMember () {
       insertFrame = new JFrame("Add New Member");
       insertFrame.setSize(350,350);
       insertFrame.setResizable(false);
       Container contentPane = insertFrame.getContentPane();
       contentPane.setLayout(null); 
       insertFrame.setLocationRelativeTo(null);
       insertFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
 
 
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

       txtFirstName = new JTextField();
       txtFirstName.setBounds(136,36, 150,26); 

       txtLastName = new JTextField();
       txtLastName.setBounds(136,76, 150,26);

       txtGender = new JTextField();
       txtGender.setBounds(136,116, 150,26);

       txtEmail = new JTextField();
       txtEmail.setBounds(136,156, 150,26);

       txtPassword = new JTextField();
       txtPassword.setBounds(136,196, 150,26);

       cancelButton = new JButton("Close");
       cancelButton.setBounds(26,236, 120,30);
       cancelButton.addActionListener(this);

       saveButton = new JButton("Save");
       saveButton.setBounds(166,236, 120,30);
       saveButton.addActionListener(this);


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
       contentPane.add(saveButton);
       insertFrame.setVisible(true); 

      //  Point lblPoint = lblFirstName.getLocation();
      //  int x = lblPoint.x;    int y = lblPoint.y;
      //  System.out.println("X is "+ x + " : Y is " + y);
    }




    @Override
    public void actionPerformed(ActionEvent e) {
       
       if (e.getSource()==cancelButton) {
        insertFrame.dispose();  
        Dashboard.frm_dashboard.setVisible(true);
       }

       if (e.getSource()==saveButton) {
          String firstName = txtFirstName.getText();
          String lastName = txtLastName.getText();
          String gender = txtGender.getText();
          String email = txtEmail.getText();
          String password = txtPassword.getText();

          // String txtTimeStamp = new java.util.Date();
          String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());

           // Create a SQL string
           String SQL = "insert into members  (first_name, last_name, gender, email, password, timestamp)  values (" +
           "'" + firstName + "'," +
           "'" + lastName + "'," + 
           "'" + gender + "'," + 
           "'" + email + "'," + 
           "'" + password + "'," +
           "'" + timestamp + "')";
           Statement stmt = null;        System.out.println(SQL);
           
            try {

              // conn = JDBCUtil.getConnection();
              conn = DBConnect.DBConnect();

              stmt = conn.createStatement();
              stmt.executeUpdate(SQL);
 
              JOptionPane.showMessageDialog(null, "New Record inserted successfully!", "FYI", JOptionPane.INFORMATION_MESSAGE);
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
