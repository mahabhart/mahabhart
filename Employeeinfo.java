
package hotel.management.service;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Employeeinfo extends JFrame implements ActionListener{
    
    
    JButton back;
    JTable table;
    
    Employeeinfo() {
        
        getContentPane().setBackground(Color.pink);
        setLayout(null);
        
        JLabel text = new JLabel ("All Employee Details");
        text.setBounds(350, 5, 200, 20);
        text.setFont(new Font("Tohma", Font.BOLD, 20));
        add(text);
        
        JLabel l1 = new JLabel("Name");
        l1.setBounds(40, 30, 100, 20);
        text.setFont(new Font("Style", Font.BOLD, 20));
        add(l1);
        
        JLabel l2 = new JLabel("Age");
        l2.setBounds(150, 30, 100, 20);
        text.setFont(new Font("Style", Font.BOLD, 20));
        add(l2);
        
        JLabel l3 = new JLabel("Gender");
        l3.setBounds(260, 30, 100, 20);
        text.setFont(new Font("Style", Font.BOLD, 20));
        add(l3);
        
        JLabel l4 = new JLabel("Job");
        l4.setBounds(370, 30, 100, 20);
        text.setFont(new Font("Style", Font.BOLD, 20));
        add(l4);
        
        JLabel l5 = new JLabel("Salary");
        l5.setBounds(480, 30, 100, 20);
        text.setFont(new Font("Style", Font.BOLD, 20));
        add(l5);
        
        JLabel l6 = new JLabel("Phone No.");
        l6.setBounds(590, 30, 100, 20);
        text.setFont(new Font("Style", Font.BOLD, 20));
        add(l6);
        
        JLabel l7 = new JLabel("Email");
        l7.setBounds(700, 30, 150, 20);
        text.setFont(new Font("Style", Font.BOLD, 20));
        add(l7);
        
        JLabel l8 = new JLabel("Aadhar No.");
        l8.setBounds(800, 30, 100, 20);
        text.setFont(new Font("Style", Font.BOLD, 20));
        add(l8);
        
        table = new JTable();
        table.setBounds(1, 50, 900, 400);
        add(table);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.RED);
        back.setBounds(400, 460, 100, 30);
        back.addActionListener(this);
        add(back);
        
        setBounds(300, 200, 915, 540);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Reception();
    }
    
    public static void main(String[] args) {
        new Employeeinfo();
    }
    
    
}
