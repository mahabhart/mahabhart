
package hotel.management.service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddRooms extends JFrame implements ActionListener {
    
    JButton add, cancel;
    JTextField tfroomno, tfprice;
    JComboBox bedtypecombo, availablecombo, cleaningcombo;
    
    AddRooms() {
        
        getContentPane().setBackground(Color.pink);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Rooms");
        heading.setBounds(300, 5, 200, 20);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(heading);
        
        JLabel lblroomno = new JLabel("Room Number:-");
        lblroomno.setBounds(60, 60, 120, 30);
        lblroomno.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblroomno);
        
        tfroomno = new JTextField();
        tfroomno.setBounds(200, 60, 130, 30);
        add(tfroomno);
        
        JLabel lblavailable = new JLabel("Available:-");
        lblavailable.setBounds(60, 110, 120, 30);
        lblavailable.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblavailable);
        
        String availableOption[] = { "Available", "Occupied" };
        availablecombo = new JComboBox(availableOption);
        availablecombo.setBounds(200, 110, 130, 30);
        availablecombo.setBackground(Color.pink);
        add(availablecombo);
        
        JLabel lblclean = new JLabel("Cleaning Status:-");
        lblclean.setBounds(60, 160, 130, 30);
        lblclean.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblclean);
        
        String cleaningOption[] = { "Cleaned", "Dirty" };
        cleaningcombo = new JComboBox(cleaningOption);
        cleaningcombo.setBounds(200, 160, 130, 30);
        cleaningcombo.setBackground(Color.pink);
        add(cleaningcombo);
        
        JLabel lblprice = new JLabel("Price:-");
        lblprice.setBounds(60, 210, 120, 30);
        lblprice.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblprice);
        
        tfprice = new JTextField();
        tfprice.setBounds(200, 210, 130, 30);
        add(tfprice);
        
        JLabel lblbedtype = new JLabel("Bed Type:-");
        lblbedtype.setBounds(60, 260, 120, 30);
        lblbedtype.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblbedtype);
        
        String bedtypeOption[] = {"Single Bed", "Double Bed"};
        bedtypecombo = new JComboBox(bedtypeOption);
        bedtypecombo.setBounds(200, 260, 130, 30);
        bedtypecombo.setBackground(Color.pink);
        add(bedtypecombo);
        
        add = new JButton("Add Room");
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.setBounds(60, 315, 100, 30);
        add.addActionListener(this);
        add(add);
        
        cancel = new JButton("Cancel");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(210, 315, 100, 30);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 65, 400, 250);
        add(image);
        
        setBounds(330, 200, 780, 400);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String roomnumber = tfroomno.getText();
            String availability = (String) availablecombo.getSelectedItem();
            String status = (String) cleaningcombo.getSelectedItem();
            String price = tfprice.getText();
            String type = (String) bedtypecombo.getSelectedItem();
            
            
            try {
                Conn conn = new Conn();
                String str = "insert into room values('"+roomnumber+"', '"+availability+"', '"+status+"', '"+price+"', '"+type+"')";
                
                conn.s.executeUpdate(str);
                
                JOptionPane.showMessageDialog(null, "New Room Added Successfully");
                
                setVisible(false);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new AddRooms();
    }
}
