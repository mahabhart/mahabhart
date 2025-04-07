
package hotel.management.service;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;


public class UpdateCheck extends JFrame implements ActionListener{
    
    JButton check, update, back;
    Choice ccustomer;
    JTextField tfroom, tfname, tfcheckin, tfpaid, tfpending;
    
    
    UpdateCheck() {
        
        getContentPane().setBackground(Color.pink);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
        Image i2 = i1.getImage().getScaledInstance(535, 430,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 0, 535, 430);
        add(image);
        
        JLabel text = new JLabel("Update Status");
        text.setBounds(100, 5, 200, 30);
        text.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(text);
        
        JLabel lblid = new JLabel("Customer ID:");
        lblid.setBounds(50, 60, 100, 25);
        lblid.setFont(new Font("Tahoma", Font.ITALIC, 15));
        add(lblid);
        
        ccustomer = new Choice();
        ccustomer.setBounds(180, 60, 150, 25);
        add(ccustomer);
        
        try {
            
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            
            while(rs.next()) {
                ccustomer.add(rs.getString("number"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JLabel lblroom = new JLabel("Room Number:");
        lblroom.setBounds(50, 100, 100, 25);
        add(lblroom);
        
        tfroom = new JTextField();
        tfroom.setBounds(180, 100, 150, 25);
        add(tfroom);
        
        JLabel lblname = new JLabel("Name:");
        lblname.setBounds(50, 140, 100, 25);
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(180, 140, 150, 25);
        add(tfname);
        
        JLabel lblcheckin = new JLabel("Checkin Time:");
        lblcheckin.setBounds(50, 180, 100, 25);
        add(lblcheckin);
        
        tfcheckin = new JTextField();
        tfcheckin.setBounds(180, 180, 150, 25);
        add(tfcheckin);
        
        JLabel lblpaid = new JLabel("Amount Paid:");
        lblpaid.setBounds(50, 220, 100, 25);
        add(lblpaid);
        
        tfpaid = new JTextField();
        tfpaid.setBounds(180, 220, 150, 25);
        add(tfpaid);
        
        JLabel lblpending = new JLabel("Pending Amount:");
        lblpending.setBounds(50, 260, 100, 25);
        add(lblpending);
        
        tfpending = new JTextField();
        tfpending.setBounds(180, 260, 150, 25);
        add(tfpending);
        
        check = new JButton("Check");
        check.setBackground(Color.black);
        check.setForeground(Color.white);
        check.setBounds(100, 305,100,30);
        check.setFont(new Font("Tahoma", Font.ITALIC, 15));
        check.addActionListener(this);
        add(check);
        
        update = new JButton("Update");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setFont(new Font("Tahoma", Font.ITALIC, 15));
        update.setBounds(260, 305, 100, 30);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setBounds(180, 355, 100, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.red);
        back.setFont(new Font("Tahoma", Font.PLAIN, 15));
        back.addActionListener(this);
        add(back);
        
        setBounds(300, 200, 950, 440);
        setVisible(true);
    }
    
public void actionPerformed (ActionEvent ae) { 
  if (ae.getSource() == check) { 
        String id = ccustomer.getSelectedItem();
        String query = "select * from customer where number = '"+id+"'";
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery(query);
         
            while(rs.next()) {
                tfroom.setText(rs.getString("room"));
                tfname.setText(rs.getString("name"));
                tfcheckin.setText(rs.getString("checkintime"));
                tfpaid.setText(rs.getString("deposit"));
            }
            
            ResultSet rs2 = c.s.executeQuery("select * from room where room_number = '"+tfroom.getText()+"'");
            while(rs2.next()){
                String price = rs2.getString("price");
                int amountPaid = Integer.parseInt(price) - Integer.parseInt(tfpaid.getText());
                tfpending.setText("" + amountPaid);
        }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    } else if (ae.getSource() == update) {
        String number = ccustomer.getSelectedItem();
        String room = tfroom.getText();
        String name = tfname.getText();
        String checkin = tfcheckin.getText();
        String deposit = tfpaid.getText();
        
        try {
            Conn c = new Conn();
             
            c.s.executeUpdate("update customer set room = '"+room+"', name '"+name+"', checkintime '"+checkin+"', deposit '"+deposit+"' where number = '"+number+"'");

           
            JOptionPane.showMessageDialog(null, "Data Updated Successfully");
            
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
new UpdateCheck();
        
        
}
}
