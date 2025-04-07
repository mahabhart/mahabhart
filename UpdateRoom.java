
package hotel.management.service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class UpdateRoom extends JFrame implements ActionListener{

    JButton check, update, back;
    Choice ccustomer;
    JTextField tfroom, tfavailable, tfstatus;
    
    UpdateRoom() {
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 360, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 500, 360);
        add(image);
        
        JLabel text = new JLabel("Update Room Status");
        text.setBounds(70, 5, 250, 25);
        text.setFont(new Font("Tahoma", Font.PLAIN, 25));
        add(text);
        
        JLabel lblid = new JLabel("Customer ID :");
        lblid.setBounds(30, 60, 80, 25);
        add(lblid);
        
        ccustomer = new Choice();
        ccustomer.setBounds(125, 60, 160, 25);
        add(ccustomer);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            
            while(rs.next()){
                ccustomer.add(rs.getString("number"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JLabel lblroom = new JLabel("Room Number:");
        lblroom.setBounds(30, 110, 100, 20);
        add(lblroom);
        
        tfroom = new JTextField();
        tfroom.setBounds(125, 110, 160, 25);
        add(tfroom);
        
        JLabel lblavailable = new JLabel("Availability:");
        lblavailable.setBounds(30, 160, 100, 20);
        add(lblavailable);
        
        tfavailable = new JTextField();
        tfavailable.setBounds(125, 160, 160, 25);
        add(tfavailable);
        
        JLabel lblstatus = new JLabel("Cleaning Status:");
        lblstatus.setBounds(30, 210, 100, 20);
        add(lblstatus);
        
        tfstatus = new JTextField();
        tfstatus.setBounds(125, 210, 160, 25);
        add(tfstatus);
        
        check = new JButton("Check");
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.setFont(new Font("Tahoma", Font.PLAIN, 15));
        check.setBounds(40, 260, 100, 30);
        check.addActionListener(this);
        add(check);
        
        update = new JButton("Update");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.white);
        update.setFont(new Font("Tahoma", Font.PLAIN, 15));
        update.setBounds(200, 260, 100, 30);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.red);
        back.setFont(new Font("Tahoma", Font.PLAIN, 15));
        back.setBounds(120, 310, 100, 30);
        back.addActionListener(this);
        add(back);
        
        setBounds(200, 300, 860, 400);
        setVisible(true);
    }

public void actionPerformed(ActionEvent ae) {
   if (ae.getSource() == check) {
       String id = ccustomer.getSelectedItem();
       String query = "select * from customer where number = '"+id+"'";
    //   String query2 = "select * from room where room_number = '"+id+"' ";
       
       try {
           
           Conn c = new Conn();
           ResultSet rs = c.s.executeQuery(query);
    //       ResultSet rs2 = c.s.executeQuery(query2);
           while(rs.next()) {
               tfroom.setText(rs.getString("room"));
    //           tfavailable.setText(rs2.getString("availability"));
               
           }
           
           ResultSet rs2 = c.s.executeQuery("select * from room where room_number = '"+tfroom.getText()+"'");
           while(rs2.next()) {
               tfavailable.setText(rs2.getString("availability"));
               tfstatus.setText(rs2.getString("cleaning_status"));
           }
           
       } catch (Exception e) {
           e.printStackTrace();
       }
   } else if (ae.getSource() == update) {
       String number = ccustomer.getSelectedItem();
       String room = tfroom.getText();
       String available = tfavailable.getText();
       String status = tfstatus.getText();
       
       try {
           Conn c = new Conn();
           c.s.executeUpdate("update room set availability = '"+available+"', cleaning_status = '"+status+"' where room_number = '"+room+"'");
           
           JOptionPane.showMessageDialog(null, "Data Updated Successfully");
           
           setVisible(false);
           new Reception();
           
       } catch (Exception e) {
           e.printStackTrace();
       }
   } else  {
       setVisible(false);
       new Reception();
   }
}    
    
    
public static void main(String[] args) {
    new UpdateRoom();
}    
}
