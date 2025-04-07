
package hotel.management.service;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class Managerinfo extends JFrame implements ActionListener {

    JButton back;
    JTable table;
    
Managerinfo() {
    
    getContentPane().setBackground(Color.pink);
    setLayout(null);
    
    JLabel l1 = new JLabel("Name");
    l1.setBounds(40, 10, 100, 20);
    add(l1);
    
    JLabel l2 = new JLabel("Age");
    l2.setBounds(160, 10, 100, 20);
    add(l2);
    
    JLabel l3 = new JLabel("Gender");
    l3.setBounds(280, 10, 100, 20);
    add(l3);
    
    JLabel l4 = new JLabel("Job");
    l4.setBounds(400, 10, 100, 20);
    add(l4);
    
    JLabel l5 = new JLabel("Salary");
    l5.setBounds(510, 10, 100, 20);
    add(l5);
    
    JLabel l6 = new JLabel("Phone No.");
    l6.setBounds(620, 10, 100, 20);
    add(l6);
    
    
    JLabel l7 = new JLabel("Email");
    l7.setBounds(730, 10, 100, 20);
    add(l7);
    
    JLabel l8 = new JLabel("Aadhar No.");
    l8.setBounds(840, 10, 100, 20);
    add(l8);
    
    table = new JTable();
    table.setBounds(0, 30, 950, 400);
    add(table);
    
    try {
        Conn c = new Conn();
        ResultSet rs = c.s.executeQuery("select * from employee where job = 'Manager'");
        table.setModel(DbUtils.resultSetToTableModel(rs));
    } catch (Exception e){
        e.printStackTrace();
    }
    
    back = new JButton("Back");
    back.setBounds(420, 440, 120, 30);
    back.setForeground(Color.red);
    back.setBackground(Color.black);
    back.addActionListener(this);
    add(back);
    
    setBounds(300, 200, 950, 520);
    setVisible(true);
}    

public void actionPerformed(ActionEvent ae) {
    setVisible(false);
    new Reception();
}

public static void main(String[] args) {
    new Managerinfo();
}
}
