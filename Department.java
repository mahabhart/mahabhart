
package hotel.management.service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Department extends JFrame implements ActionListener {

    JTable table;
    JButton back;
    
   Department() {
      
       getContentPane().setBackground(Color.pink);
       setLayout(null);
       
       
       JLabel lbltitle = new JLabel("Deaprtment Budget (2023&24)");
       lbltitle.setBounds(200, 10, 700, 25);
       lbltitle.setFont(new Font ("Dialog", Font.BOLD, 20));
       add(lbltitle);
       
       
       JLabel l1 = new JLabel("DEPARTMENT");
       l1.setBounds(100, 55, 120, 25);
       l1.setFont(new Font ("Raleway", Font.BOLD, 15));
       add(l1);
       
       JLabel l2 = new JLabel("BUDGET");
       l2.setBounds(450, 55, 120, 25);
       l2.setFont(new Font ("Raleway", Font.BOLD, 15));
       add(l2);
       
       table = new JTable();
       table.setBounds(2, 80, 680, 290);
       table.setFont(new Font("Style", Font.PLAIN, 15));
       add(table);
       
       try {
           Conn c = new Conn();
           ResultSet rs = c.s.executeQuery("select * from department");
           table.setModel(DbUtils.resultSetToTableModel(rs));
           
       } catch (Exception e) {
       e.printStackTrace();
       }
       
       back = new JButton("Back");
       back.setBackground(Color.BLACK);
       back.setForeground(Color.red);
       back.addActionListener(this);
       back.setBounds(280, 380, 100, 30);
       add(back);
       
       setBounds(400, 200, 700, 460);
       setVisible(true);
    }
   
   public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Reception();       
        }
    
    public static void main(String[] args) {
        new Department();
    }            
}
