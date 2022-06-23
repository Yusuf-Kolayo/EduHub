import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

 

public class Dashboard implements ActionListener {

    static JFrame frm_dashboard;
    JButton btn_new_mem;
    JButton btn_update_mem;
    JButton btn_delete_mem;
    JButton btn_view_mem;
    JPanel btn_panel;
    JPanel view_panel; 
    JPanel mem_view_panel;
    JScrollPane jscroll_pane1;
    static JTable jtable1;

    static String selected_id,selected_fn, selected_ln, selected_em, selected_pw, selected_gd;

    static Connection conn = null;
    static PreparedStatement PStatement = null;
    static ResultSet rs = null;
    // for delete
    Statement stmt = null;
    
    Dashboard () { 
        frm_dashboard = new JFrame("Welcome to your Dashboard");
        frm_dashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frm_dashboard.setSize(1000, 600);
        // frm_dashboard.setResizable(false);
        frm_dashboard.setLocationRelativeTo(null);

        Container contentPane = frm_dashboard.getContentPane();
        contentPane.setLayout(null);

       

        btn_panel = new JPanel();
        btn_panel.setBorder(BorderFactory.createEtchedBorder());
        btn_panel.setBounds(16,16,144,504);
        btn_panel.setBackground(Color.orange);  
        btn_panel.setLayout(null);
        btn_panel.setOpaque(true);


        view_panel = new JPanel();
        view_panel.setBorder(BorderFactory.createEtchedBorder());
        view_panel.setBounds(164,16,800,504);
        view_panel.setBackground(Color.orange);  
        view_panel.setLayout(null);
        view_panel.setOpaque(true);

        jscroll_pane1 = new JScrollPane();
        jtable1 = new JTable();

        jtable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "First Name", "Last Name", "Email Address", "Gender", "Password"
            }
        ));
        
        jscroll_pane1.setViewportView(jtable1);
        jscroll_pane1.setBounds(5,5,700,300);

        btn_new_mem = new JButton("Add New"); 
        btn_new_mem.setFocusable(false);
        btn_new_mem.setBounds(12,12,120,30);
        btn_new_mem.addActionListener(this);

        btn_view_mem = new JButton("View"); 
        btn_view_mem.setFocusable(false);
        btn_view_mem.setBounds(12,52,120,30);
        btn_view_mem.addActionListener(this);

        btn_update_mem = new JButton("Edit"); 
        btn_update_mem.setFocusable(false);
        btn_update_mem.setBounds(12,92,120,30);
        btn_update_mem.addActionListener(this);

        btn_delete_mem = new JButton("Delete"); 
        btn_delete_mem.setFocusable(false);
        btn_delete_mem.setBounds(12,132,120,30);
        btn_delete_mem.addActionListener(this);

        btn_panel.add(btn_new_mem);
        btn_panel.add(btn_view_mem);
        btn_panel.add(btn_update_mem);
        btn_panel.add(btn_delete_mem);

        view_panel.add(jscroll_pane1);
        
        contentPane.add(btn_panel);
        contentPane.add(view_panel); 

        // frm_dashboard.pack();
        frm_dashboard.setVisible(true);  

 
        fetch_members();  // fetch members unto the view
        
        // // Get the components added to the content pane
        // Component[] comps = frm_dashboard.getContentPane().getComponents();
        // // Display how many components the content pane has
        // System.out.println("Content Pane has " + comps.length + " components.");
    }




    public static void fetch_members() { 
        conn = DBConnect.DBConnect();
           String sql = "SELECT * FROM members";
        try {
            
            PStatement = conn.prepareStatement(sql);
            rs = PStatement.executeQuery();
            // Define jtable
            DefaultTableModel model = (DefaultTableModel) jtable1.getModel();
            model.setRowCount(0);

            while(rs.next()){
                // set value to jtable
                String id = rs.getString("id");
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                String gender = rs.getString("gender");
                String email = rs.getString("email");
                String password = rs.getString("password");
                Object[] row = { id, first_name,last_name, email, gender, password };    // System.out.println(fname);
                // Insert value to jtable row and column
                model.addRow(row);
            }
            
        } catch(Exception ex) {
            System.out.println("Error: "+ex);
        }
     }


     public static String[] fetchSelectedRow() {

        int selected_row = jtable1.getSelectedRow();
        String first_name = (String) jtable1.getValueAt(selected_row, 1);
        return null;

     }

    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource()==btn_new_mem) {
           new InsertMember();
        }
        if (e.getSource()==btn_view_mem) {
            
            int selected_rows = jtable1.getSelectedRows().length;
            if (selected_rows==1) { 
                int selected_row = jtable1.getSelectedRow();
                selected_fn = (String) jtable1.getValueAt(selected_row, 1); //  System.out.println(selected_row + ": " + first_name );
                selected_ln = (String) jtable1.getValueAt(selected_row, 2); 
                selected_em = (String) jtable1.getValueAt(selected_row, 3);
                selected_gd = (String) jtable1.getValueAt(selected_row, 4);  
                selected_pw = (String) jtable1.getValueAt(selected_row, 5); 
                new ViewMember();
            } else {
                JOptionPane.showMessageDialog(null, "You have to select 1 row from the table before viewing!", "FYI", JOptionPane.INFORMATION_MESSAGE);
            }

           
         }
         if (e.getSource()==btn_update_mem) {
            
            int selected_rows = jtable1.getSelectedRows().length;
            if (selected_rows==1) { 
                int selected_row = jtable1.getSelectedRow();
                selected_id = (String) jtable1.getValueAt(selected_row, 0);
                selected_fn = (String) jtable1.getValueAt(selected_row, 1); //  System.out.println(selected_row + ": " + first_name );
                selected_ln = (String) jtable1.getValueAt(selected_row, 2); 
                selected_em = (String) jtable1.getValueAt(selected_row, 3);
                selected_gd = (String) jtable1.getValueAt(selected_row, 4);  
                selected_pw = (String) jtable1.getValueAt(selected_row, 5); 
                new UpdateMember();
            } else {
                JOptionPane.showMessageDialog(null, "You have to select 1 row from the table before viewing!", "FYI", JOptionPane.INFORMATION_MESSAGE);
            }

           
         }

         if (e.getSource()==btn_delete_mem) {
            
            int selected_rows = jtable1.getSelectedRows().length;
            if (selected_rows==1) { 
                int selected_row = jtable1.getSelectedRow();
                selected_id = (String) jtable1.getValueAt(selected_row, 0);
                selected_fn = (String) jtable1.getValueAt(selected_row, 1); //  System.out.println(selected_row + ": " + first_name );
                selected_ln = (String) jtable1.getValueAt(selected_row, 2); 
                selected_em = (String) jtable1.getValueAt(selected_row, 3);
                selected_gd = (String) jtable1.getValueAt(selected_row, 4);  
                selected_pw = (String) jtable1.getValueAt(selected_row, 5); 
                new DeleteMember();
            } else {
                JOptionPane.showMessageDialog(null, "You have to select 1 row from the table before viewing!", "FYI", JOptionPane.INFORMATION_MESSAGE);
            }

           
         }
      
        
    } 
 
}
