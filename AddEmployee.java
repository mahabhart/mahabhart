
package hotel.management.service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AddEmployee extends JFrame implements ActionListener {
    
    JTextField tfname, tfemail, tfphone, tfage, tfsalary, tfaadhar;
    JRadioButton rbmale, rbfemale;
    JButton submit;
    JComboBox cbjob;
    
    AddEmployee() {
        setLayout(null);
        
        JLabel text = new JLabel("Add Employee");
        text.setBounds(330, 5, 150, 30);
        text.setFont(new Font("Tohma", Font.BOLD, 20));
        add(text);
        
        JLabel lblname = new JLabel("NAME");
        lblname.setBounds(60, 50, 120, 30);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(200, 50, 150, 30);
        add(tfname);
        
        JLabel lblage = new JLabel("AGE");
        lblage.setBounds(60, 100, 120, 30);
        lblage.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblage);
        
        tfage = new JTextField();
        tfage.setBounds(200, 100, 150, 30);
        add(tfage);
        
        
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(60, 150, 120, 30);
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblgender);
        
        rbmale = new JRadioButton("Male");
        rbmale.setBounds(200, 150, 70, 30);
        rbmale.setFont(new Font("Tahoma", Font.PLAIN, 14));
        rbmale.setBackground(Color.WHITE);
        add(rbmale);
        
        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(280, 150, 70, 30);
        rbfemale.setFont(new Font("Tahoma", Font.PLAIN, 14));
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);
        
        JLabel lbljob = new JLabel("Job");
        lbljob.setBounds(60, 200, 120, 30);
        lbljob.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lbljob);
        
        String str[] = { "Manager", "Front Desk Clerks", "Porters", "Housekeeping", "Kitchen Staff", "Room Service", "Chefs", "Waiter/Waitress", "Accountant" };
        cbjob = new JComboBox(str);
        cbjob.setBounds(200, 200, 150, 30);
        cbjob.setBackground(Color.WHITE);
        add(cbjob);
        
        JLabel lbsalary = new JLabel("SALARY");
        lbsalary.setBounds(60, 250, 120, 30 );
        lbsalary.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lbsalary);
        
        tfsalary = new JTextField();
        tfsalary.setBounds(200, 250, 150, 30);
        add(tfsalary);
        
        JLabel lbphone = new JLabel("PHONE");
        lbphone.setBounds(60, 300, 120, 30);
        lbphone.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lbphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(200, 300, 150, 30);
        add(tfphone);
        
        JLabel lbemail = new JLabel("EMAIL");
        lbemail.setBounds(60, 350, 120, 30);
        lbemail.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lbemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200, 350, 150, 30);
        add(tfemail);
        
        JLabel lblaadhar = new JLabel("AADHAR");
        lblaadhar.setBounds(60, 400, 120, 30);
        lblaadhar.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblaadhar);
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(200, 400, 150, 30);
        add(tfaadhar);
        
        submit = new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(160, 455, 100, 30);
        submit.addActionListener(this);
        add(submit);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(380, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380, 70, 400, 350);
        add(image);
        
        setBounds(350, 200, 820, 540);
        getContentPane().setBackground(Color.pink);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        String name = tfname.getText();
        String age = tfage.getText();
        String salary = tfsalary.getText();
        String phone = tfphone.getText();
        String email = tfemail.getText();
        String aadhar = tfaadhar.getText();
        
        
        String gender = null;
        
        if (name.equals("")) {
            JOptionPane.showMessageDialog(null, "Name sould not be empty");
            return;
        }
        
        if (rbmale.isSelected()) {
            gender = "Male";
        } else if (rbfemale.isSelected()) {
            gender = "Female";
        }
        
        String job = (String) cbjob.getSelectedItem();
        
        try {
            Conn conn = new Conn();
            
            String query = "insert into employee values('"+name+"', '"+age+"', '"+gender+"', '"+job+"', '"+salary+"', '"+phone+"', '"+email+"', '"+aadhar+"')";
            
            conn.s.executeUpdate(query);
            
            JOptionPane.showMessageDialog(null, "Employee added successfully");
            
            setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        new AddEmployee();
    }
    
}
