
package hotel.management.service;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Customerinfo extends JFrame implements ActionListener{
    
    JButton back;
    JTable t1;
    
    Customerinfo() {
        
        
        getContentPane().setBackground(Color.pink);
        setLayout(null);
        
        JLabel text = new JLabel("All Customer Information");
        text.setBounds(350, 5, 250, 30);
        text.setFont(new Font("Tohma", Font.BOLD, 20));
        add(text);
        
        JLabel l1 = new JLabel("Document Type");
        l1.setBounds(20, 40, 100, 20);
        add(l1);
        
        JLabel l2 = new JLabel("Number");
        l2.setBounds(140, 40, 100, 20);
        add(l2);
        
        JLabel l3 = new JLabel("Name");
        l3.setBounds(270, 40, 100, 20);
        add(l3);
        
        JLabel l4 = new JLabel("Gender");
        l4.setBounds(390, 40, 100, 20);
        add(l4);
        
        JLabel l5 = new JLabel("Country");
        l5.setBounds(510, 40, 100, 20);
        add(l5);
        
        JLabel l6 = new JLabel("Room No");
        l6.setBounds(640, 40, 100, 20);
        add(l6);
        
        JLabel l7 = new JLabel("Checkin time");
        l7.setBounds(750, 40, 100, 20);
        add(l7);
        
        JLabel l8 = new JLabel("Deposit");
        l8.setBounds(890, 40, 100, 20);
        add(l8);
        
        t1 = new JTable();
        t1.setBounds(0, 60, 990, 400);
        add(t1);
        
        try {
            
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            t1.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            e.printStackTrace();
        } 
        
        
        back = new JButton("Back");
        back.setBounds(430, 475, 100, 30);
        back.setForeground(Color.red);
        back.setBackground(Color.black);
        back.addActionListener(this);
        add(back);
        
        setBounds(300, 200, 1000, 560);
        setVisible(true);
    }
    

    
public void actionPerformed(ActionEvent ae) {
    setVisible(false);
    new Reception();
}    
    
public static void main(String[] args) {
    new Customerinfo();
}    

}
