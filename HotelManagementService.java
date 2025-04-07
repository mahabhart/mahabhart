
package hotel.management.service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HotelManagementService extends JFrame implements ActionListener {
    
    HotelManagementService() {
    //    setSize(1366, 565);
    //    setLocation(100, 100);
        setBounds(100, 100, 1266, 565);   // setContentPane(300,300,1366,390); frame size 
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(1266, 565, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1266, 565);  //locationx. locationy
        add(image); 
        
        JLabel text = new JLabel("HOTEL MANAGEMENT SERVICE");
        text.setBounds(280, 60, 1000, 90);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("serif", Font.PLAIN, 50));
        image.add(text);
        
        JButton click = new JButton("Please Click Next For Login");
        click.setBounds(1020, 500, 220, 20);
        click.setBackground(Color.black);
        click.setForeground(Color.MAGENTA);        
        click.setFont(new Font ("serif", Font.PLAIN, 15));
        image.add(click);
        
        JButton next = new JButton("Next");
        next.setBounds(1050, 450, 150, 50);
        next.setBackground(Color.WHITE);
        next.setForeground(Color.MAGENTA);
        next.addActionListener(this);
        next.setFont(new Font("serif", Font.PLAIN, 24));
        image.add(next);
        
        setVisible(true);
        
        while(true) {
            text.setVisible(false);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
            text.setVisible(true);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
            
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new login();
    }
    
    public static void main(String[] args) {
        new HotelManagementService();
    }
    
}
