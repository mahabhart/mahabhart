
package hotel.management.service;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class Reception extends JFrame  implements ActionListener {
    
    JButton newCustomer, rooms, department, allemployee, managerinfo, customers, searchroom, update, roomStatus, pickup, checkout, logout;
    
    Reception() {
        
        getContentPane().setBackground(Color.PINK);
        setLayout(null);
        
        
        newCustomer = new JButton("New Customer Form");
        newCustomer.setBounds(10, 30, 200, 30);
        newCustomer.setBackground(Color.BLACK);
        newCustomer.setForeground(Color.white);
        newCustomer.addActionListener(this);
        add(newCustomer);
        
        rooms = new JButton("Rooms");
        rooms.setBounds(10, 70, 200, 30);
        rooms.setBackground(Color.black);
        rooms.setForeground(Color.white);
        rooms.addActionListener(this);
        add(rooms);
        
        department = new JButton("Department");
        department.setBounds(10, 110, 200, 30);
        department.setBackground(Color.black);
        department.setForeground(Color.white);
        department.addActionListener(this);
        add(department);
        
        allemployee = new JButton("All Employee");
        allemployee.setBounds(10, 150, 200, 30);
        allemployee.setBackground(Color.black);
        allemployee.setForeground(Color.white);
        allemployee.addActionListener(this);
        add(allemployee);
        
        customers = new JButton("Customer Info");
        customers.setBounds(10, 190, 200, 30);
        customers.setBackground(Color.BLACK);
        customers.setForeground(Color.white);
        customers.addActionListener(this);
        add(customers);
        
        managerinfo = new JButton("Manager Info");
        managerinfo.setBounds(10, 230, 200, 30);
        managerinfo.setBackground(Color.black);
        managerinfo.setForeground(Color.white);
        managerinfo.addActionListener(this);
        add(managerinfo);
        
        checkout = new JButton("Checkout");
        checkout.setBounds(10, 270, 200, 30);
        checkout.setBackground(Color.black);
        checkout.setForeground(Color.white);
        checkout.addActionListener(this);
        add(checkout);
        
        update = new JButton("Update Status");
        update.setBounds(10, 310, 200, 30);
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        update.addActionListener(this);
        add(update);
        
        roomStatus = new JButton("Update Room Status");
        roomStatus.setBounds(10, 350, 200, 30);
        roomStatus.setBackground(Color.BLACK);
        roomStatus.setForeground(Color.white);
        roomStatus.addActionListener(this);
        add(roomStatus);
        
        pickup = new JButton("Pickup Service");
        pickup.setBounds(10, 390, 200, 30);
        pickup.setBackground(Color.black);
        pickup.setForeground(Color.white);
        pickup.addActionListener(this);
        add(pickup);
        
        searchroom = new JButton("Search Room");
        searchroom.setBounds(10, 430, 200, 30);
        searchroom.setBackground(Color.black);
        searchroom.setForeground(Color.white);
        searchroom.addActionListener(this);
        add(searchroom);
        
        logout = new JButton("Logout");
        logout.setBounds(60, 470, 100, 30);
        logout.setBackground(Color.black);
        logout.setForeground(Color.white);
        logout.addActionListener(this);
        add(logout);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
         Image i2 = i1.getImage().getScaledInstance(520, 430, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(250, 30, 520, 430);
        add(image);
        
        
    
    
        
        setBounds(350, 200, 800, 570);
        setVisible(true);
    }
    
      public void actionPerformed(ActionEvent ae) {
          if (ae.getSource() == newCustomer) {
              setVisible(false);
              new AddCustomer();
          } else if (ae.getSource() == rooms) {
              setVisible(false);
              new Room();
          } else if (ae.getSource() == department) {
              setVisible(false);
              new Department();
          } else if (ae.getSource() == allemployee) {
              setVisible(false);
              new Employeeinfo();
          } else if (ae.getSource() == managerinfo) {
              setVisible(false);
              new Managerinfo();
          } else if (ae.getSource() == customers) {
              setVisible(false);
              new Customerinfo();
          } else if (ae.getSource() == searchroom) {
              setVisible(false);
              new SearchRoom();
          } else if (ae.getSource() == update) {
              setVisible(false);
              new UpdateCheck();
          } else if (ae.getSource() == roomStatus) {
              setVisible(false);
              new UpdateRoom();
          } else if (ae.getSource() == pickup) {
              setVisible(false);
              new Pickup();
          } else if (ae.getSource() == checkout) {
              setVisible(false);
              new Checkout();
          } else if (ae.getSource() == logout) {
              setVisible(false);
              new login();
          }
      }

public static void main(String[] args) {
        new Reception();
    }  
}