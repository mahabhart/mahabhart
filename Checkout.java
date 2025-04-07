
package hotel.management.service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
import net.proteanit.sql.DbUtils;
        
public class Checkout extends JFrame implements ActionListener{
    Choice ccustomer;
    JLabel lblroomnumber, lblcheckintime, lblcheckouttime, lblavailability;
    JButton checkout, back, tick;
Checkout() {
    
    getContentPane().setBackground(Color.pink);
    setLayout(null);
    
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
    Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    tick = new JButton(i3);
    tick.setBounds(280, 80, 20, 20);
    tick.addActionListener(this);
    add(tick);
    
    
    
    JLabel text = new JLabel("Checkout From Hotel");
    text.setBounds(100, 20, 200, 30);
    text.setForeground(Color.blue);
    text.setFont(new Font("Tahoma", Font.PLAIN, 20));
    add(text);
    
    JLabel lblid = new JLabel("Customer Id:");
    lblid.setBounds(30, 80, 80, 25);
    add(lblid);
    
    ccustomer = new Choice();
    ccustomer.setBounds(130, 80, 130, 30);
    add(ccustomer);
    
    
    
    JLabel lblroom = new JLabel("Room Number:");
    lblroom.setBounds(30, 120, 100, 30);
    add(lblroom);
    
    lblroomnumber = new JLabel();
    lblroomnumber.setBounds(130, 120, 130, 30);
    add(lblroomnumber);
    
    JLabel lblavailable = new JLabel("Availability:");
    lblavailable.setBounds(30, 140, 100, 30);
    add(lblavailable);
    
    lblavailability = new JLabel();
    lblavailability.setBounds(130, 140, 100, 30);
    add(lblavailability);
    
    JLabel lblcheckin = new JLabel("Checkin Time:");
    lblcheckin.setBounds(30, 170, 100, 30);
    add(lblcheckin);
    
    lblcheckintime = new JLabel();
    lblcheckintime.setBounds(130, 170, 130, 30);
    add(lblcheckintime);
    
    JLabel lblcheckout = new JLabel("Checkout Time:");
    lblcheckout.setBounds(30, 220, 100, 30);
    add(lblcheckout);
    
    Date date = new Date();
    lblcheckouttime = new JLabel("" + date);
    lblcheckouttime.setBounds(130, 220, 170, 30);
    add(lblcheckouttime);
    
    checkout = new JButton("Checkout");
    checkout.setBackground(Color.BLACK);
    checkout.setForeground(Color.WHITE);
    checkout.setBounds(30, 280, 100, 30);
    checkout.setFont(new Font("Tahoma", Font.PLAIN, 15));
    checkout.addActionListener(this);
    add(checkout);
    
    back = new JButton("Back");
    back.setBounds(200, 280, 100, 30);
    back.setBackground(Color.BLACK);
    back.setForeground(Color.WHITE);
    back.setFont(new Font("Tahoma", Font.PLAIN, 15));
    back.addActionListener(this);
    add(back);
    
    try {
        
        Conn c = new Conn();
        ResultSet rs = c.s.executeQuery("select * from customer ");
        while (rs.next()) {
            ccustomer.add(rs.getString("number"));
        //    lblroomnumber.setText(rs.getString("room"));
        //    lblcheckintime.setText(rs.getString("checkintime"));
        }
        
        
    } catch (Exception e) {
        e.printStackTrace();
    }
    
    ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
    Image i5 = i4.getImage().getScaledInstance(450, 363, Image.SCALE_DEFAULT);
    ImageIcon i6 = new ImageIcon(i5);
    JLabel image = new JLabel(i6);
    image.setBounds(335, 0, 450, 363);
    add(image);
    
    setBounds(300, 200, 800, 400);
    setVisible(true);
    
    
}   

public void actionPerformed (ActionEvent ae) {
    
    if (ae.getSource() == tick) {
        String id = ccustomer.getSelectedItem();
        String query = "select * from customer where number = '"+id+"'";
        
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                lblroomnumber.setText(rs.getString("room"));
                lblcheckintime.setText(rs.getString("checkintime"));
                
            }
            ResultSet rs2 = c.s.executeQuery("select * from room where room_number = '"+lblroomnumber.getText()+"'");
            while(rs2.next()) {
                lblavailability.setText(rs2.getString("availability"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    } else if (ae.getSource() == checkout) {
        
    //    String available = lblavailability.getText();
        
        String query1 = "delete from customer where number = '"+ccustomer.getSelectedItem()+"'";
        String query2 = "update room set availability = 'Available' where room_number = '"+lblroomnumber.getText()+"'";
     
        
        try {
            
            Conn c = new Conn();
            c.s.executeUpdate(query1);
            c.s.executeUpdate(query2);
            
            JOptionPane.showMessageDialog(null, "Checkout Done");
            
            setVisible(false);
            new Reception();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    } else {
        setVisible(false);
        new Reception();
    }
}

public static void main(String[] args) {
    new Checkout();
}
}
