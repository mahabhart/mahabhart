
package hotel.management.service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;


public class Pickup extends JFrame implements ActionListener {
    Choice typeofcar;
    JTable table;
    JButton back, submit;
    Pickup() {
        
        
        
        
        getContentPane().setBackground(Color.pink);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(430, 260, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(610, 60, 500, 400);
        add(image);
        
        
        JLabel text = new JLabel("Pickup Service");
        text.setBounds(250, 10, 200, 20);
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(text);
        
        JLabel lbltype = new JLabel("Type of Car:");
        lbltype.setBounds(150, 60, 100, 25);
        lbltype.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(lbltype);
        
        typeofcar = new Choice();
        typeofcar.setBounds(250, 60, 150, 25);
        add(typeofcar);
        
        try {
            Conn c = new Conn();
            
            ResultSet rs = c.s.executeQuery("select * from driver");
            
            while(rs.next()) {
                typeofcar.add(rs.getString("brand"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JLabel l1 = new JLabel("Name");
        l1.setBounds(20, 105, 100, 25);
        l1.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(l1);
        
        JLabel l2 = new JLabel("Age");
        l2.setBounds(110, 105, 100, 25);
        l2.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(l2);
        
        JLabel l3 = new JLabel("Gender");
        l3.setBounds(190, 105, 100, 25);
        l3.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(l3);
        
        JLabel l4 = new JLabel("Company");
        l4.setBounds(280, 105, 100, 25);
        l4.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(l4);
        
        JLabel l5 = new JLabel("Brand");
        l5.setBounds(370, 105, 100, 25);
        l5.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(l5);
        
        JLabel l6 = new JLabel("Availability");
        l6.setBounds(465, 105, 100, 25);
        l6.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(l6);
        
        JLabel l7 = new JLabel("Location");
        l7.setBounds(565, 105, 100, 25);
        l7.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(l7);
        
        table = new JTable();
        table.setBounds(5, 130, 640, 260);
        add(table);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from driver");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e){
            e.printStackTrace();
        }
        
        back = new JButton("Back");
        back.setBounds(100, 410, 100, 30);
        back.setFont(new Font("Tahoma", Font.BOLD, 15));
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);
        
        submit = new JButton("Submit");
        submit.setBounds(350, 410, 100, 30);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);
        
        setBounds(300, 200, 1090, 500);
        setVisible(true);
        
    }
    
public void actionPerformed (ActionEvent ae) {
    if (ae.getSource() == submit) {
      try {
          String query = "select * from driver where brand = '"+typeofcar.getSelectedItem()+"'";
          
          Conn conn = new Conn();
          ResultSet rs;
          rs = conn.s.executeQuery(query);
          table.setModel(DbUtils.resultSetToTableModel(rs));
          
      } catch (Exception e) {
        e.printStackTrace();
    }
    } else {
        setVisible(false);
        new Reception();
    } 
}    
    
public static void main(String[] args) {
    new Pickup();
}    
}
