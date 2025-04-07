
package hotel.management.service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import net.proteanit.sql.*;
import java.sql.ResultSet;
import java.sql.*;


public class Room extends JFrame implements ActionListener {
          
        JTable table;
        JButton back;
    Room(){
        
        getContentPane().setBackground(Color.pink);
        setLayout(null);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(433, 25, 535, 450);
        add(image);
        
        JLabel text = new JLabel("Available Rooms");
        text.setBounds(160, 5, 170, 20);
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(text);
        
        JLabel l0 = new JLabel("_______________________________________________________________________");
        l0.setBounds(0, 15, 500, 20);
        add(l0);
        
        JLabel l1 = new JLabel("Room Number |");
        l1.setBounds(5, 30, 100, 20);
        l1.setFont(new Font("Dialog", Font.BOLD, 13));
        add(l1);
        
        JLabel l2 = new JLabel("Availibility     |");
        l2.setBounds(110, 30, 100, 20);
        l2.setFont(new Font("Dialog", Font.BOLD, 13));
        add(l2);
        
        JLabel l4 = new JLabel("Room Price   |");
        l4.setBounds(310, 30, 100, 20);
        l4.setFont(new Font("Dialog", Font.BOLD, 13));
        add(l4);
       
        JLabel l3 = new JLabel("Room Status  |");
        l3.setBounds(210, 30, 100, 20);
        l3.setFont(new Font("Dialog", Font.BOLD, 13));
        add(l3);       
        
        JLabel l5 = new JLabel("Bed Type       |");
        l5.setBounds(410, 30, 100, 20);
        l5.setFont(new Font("Dialog", Font.BOLD, 13));
        add(l5);
        
        table = new JTable();
        table.setBounds(0, 50, 500, 400);
        add(table);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from room");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.red);        
        back.setBounds(200, 460, 80, 30);
        back.setFont(new Font("Raleway", Font.BOLD, 15));
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
new Room();
}

}