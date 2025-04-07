
package hotel.management.service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddDriver extends JFrame implements ActionListener {
    
    JButton add, back;
    JTextField tfname, tfage, tfcompany, tfmodel, tflocation;
    JComboBox gendercombo, availablecombo;
    
    AddDriver() {
        
        getContentPane().setBackground(Color.orange);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Driver");
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        heading.setBounds(150, 20, 200, 20);
        add(heading);
        
        JLabel lbname = new JLabel("Name:-");
        lbname.setBounds(60, 80, 120, 30);
        lbname.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lbname);
        
        tfname = new JTextField();
        tfname.setBounds(200, 80, 150, 27);
        add(tfname);
        
        JLabel  lbage = new JLabel("Age:-");
        lbage.setBounds(60, 120, 120, 30);
        lbage.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lbage);
        
        tfage = new JTextField();
        tfage.setBounds(200, 120, 150, 27);
        add(tfage);
        
        JLabel lbgender = new JLabel("Gender:-");
        lbgender.setBounds(60, 160, 120, 30);
        lbgender.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lbgender);
        
        String genderOption[] = {"Male", "FeMale" };
        gendercombo = new JComboBox(genderOption);
        gendercombo.setBounds(200, 160, 150, 27);
        gendercombo.setBackground(Color.pink);
        add(gendercombo);
        
        JLabel lbcompany = new JLabel("Car Company:-");
        lbcompany.setBounds(60, 200, 120, 30);
        lbcompany.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lbcompany);
        
        tfcompany = new JTextField();
        tfcompany.setBounds(200, 200, 150, 27);
        add(tfcompany);
        
        JLabel lbmodel = new JLabel("Car Model:-");
        lbmodel.setBounds(60, 240, 120, 30);
        lbmodel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lbmodel);
        
        tfmodel = new JTextField();
        tfmodel.setBounds(200, 240, 150, 27);
        add(tfmodel);
        
        JLabel lbavailable = new JLabel("Available:-");
        lbavailable.setBounds(60, 280, 120, 30);
        lbavailable.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lbavailable);
        
        String availableOption[] = { "Available", "Busy"};
        availablecombo = new JComboBox(availableOption);
        availablecombo.setBounds(200, 280, 150, 27);
        availablecombo.setBackground(Color.pink);
        add(availablecombo);
        
        JLabel lblocation = new JLabel("Location:-");
        lblocation.setBounds(60, 320, 120, 30);
        lblocation.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lblocation);
        
        tflocation = new JTextField();
        tflocation.setBounds(200, 320, 150, 27);
        add(tflocation);
        
        add = new JButton("Add");
        add.setBounds(100, 370, 100, 30);
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.addActionListener(this);
        add(add);
        
        back = new JButton("Back");
        back.setBounds(240, 370, 100, 30);
        back.setForeground(Color.red);
        back.setBackground(Color.BLACK);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(420, 330, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(370, 80, 420, 330);
        add(image);
        
        setBounds(330, 200, 805, 450);
        setVisible(true);
        
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String name = tfname.getText();
            String age = tfage.getText();
            String gender = (String) gendercombo.getSelectedItem();
            String company = tfcompany.getText();
            String model = tfmodel.getText();
            String availability = (String) availablecombo.getSelectedItem();
            String location = tflocation.getText();
            
            try {
                Conn conn = new Conn();
                String str = "insert into driver values('"+name+"', '"+age+"', '"+gender+"', '"+company+"', '"+model+"', '"+availability+"', '"+location+"')";
                
                conn.s.executeUpdate(str);
                
                JOptionPane.showMessageDialog(null, "New Driver Added Succesfully");
                
                setVisible(false);
                
            } catch (Exception e) {
                e.printStackTrace();
            } 
        } else {
            setVisible(false);
        }
    } 
    
     public static void main(String[] args) {
            new AddDriver();
    }       
}
