
package hotel.management.service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;


public class SearchRoom extends JFrame implements ActionListener{
    
    JButton back, submit;
    JTable table;
    JComboBox bedType;
    JCheckBox available;
    
    SearchRoom() {
        
        getContentPane().setBackground(Color.pink);
        setLayout(null);
        
/*        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500, 0, 600, 600);
        add(image);
*/

        JLabel text = new JLabel("Search For Room");
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        text.setBounds(300, 10, 200, 30);
        add(text);
        
        bedType = new JComboBox(new String[]{"Single Bed", "Double Bed"});
        bedType.setBounds(210, 60, 150, 25);
        bedType.setBackground(Color.white);
        add(bedType);
        
        available = new JCheckBox("Only display Available");
        available.setBounds(410, 60, 150, 25);
        available.setBackground(Color.white);
        add(available);

        JLabel l1 = new JLabel("Room Number");
        l1.setBounds(30, 100, 100, 30);
        add(l1);
        
        JLabel l2 = new JLabel("Availibility");
        l2.setBounds(190, 100, 100, 30);
        add(l2);
        
        JLabel l3 = new JLabel("Cleaning Status");
        l3.setBounds(350, 100, 100, 30);
        add(l3);
        
        JLabel l5 = new JLabel("Price");
        l5.setBounds(510, 100, 100, 30);
        add(l5);
        
        JLabel lblbed = new JLabel("Bed Type");
        lblbed.setBounds(670, 100, 100, 30);
        add(lblbed);
        
        table = new JTable();
        table.setBounds(1, 125, 800, 250);
        add(table);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from room");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
           e.printStackTrace();
        }
        
        submit = new JButton("Submit");
        submit.setBounds(250, 390, 120, 30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        add(submit);
        
        back = new JButton("Back");
        back.setBounds(450, 390, 120, 30);
        back.setBackground(Color.black);
        back.setForeground(Color.red);
        back.addActionListener(this);
        add(back);
        
        setBounds(300, 200, 801, 480);
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            
            try {
                String query1 = "select * from room where bed_type = '"+bedType.getSelectedItem()+"'";
                String query2 = "select * from room where availability = 'Available' AND bed_type = '"+bedType.getSelectedItem()+"'";
                
                Conn conn = new Conn();
                ResultSet rs;
                if (available.isSelected()) {
                    rs = conn.s.executeQuery(query2);
                } else {
                    rs = conn.s.executeQuery(query1);
                }
                
                table.setModel(DbUtils.resultSetToTableModel(rs));
                
            } catch (Exception e){
               e.printStackTrace();
            }
            
        } else {           
        setVisible(false);
        new Reception();
        }
    }
    
    public static void main(String[] args){
        new SearchRoom();
    }
}
