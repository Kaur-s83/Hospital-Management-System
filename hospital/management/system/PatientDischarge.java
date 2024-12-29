package hospital.management.system;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.*;
import java.sql.ResultSet;
import java.util.Date;

public class PatientDischarge extends JFrame {

    PatientDischarge(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,790,390);
        panel.setBackground(new Color(17,42,70));
        panel.setLayout(null);
        add(panel);

        JLabel label1 = new JLabel("PATIENT DISCHARGE");
        label1.setBounds(108,20,150,20);
        label1.setFont(new Font("Tahoma",Font.BOLD,20));
        label1.setForeground(Color.WHITE);
        panel.add(label1);

        // Image
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("Icons/discharge.png"));
        Image image = imageIcon.getImage().getScaledInstance(280,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(500,50,280,300);
        panel.add(label);

        JLabel label2 = new JLabel("Patient ID");
        label2.setBounds(30,80,150,15);
        label2.setFont(new Font("serif", Font.BOLD, 15));
        label2.setForeground(Color.WHITE);
        panel.add(label2);

        // Choice for Patient ID
        Choice c1 = new Choice();
        c1.setBounds(200,80,150,25);
        c1.setFont(new Font("Tahoma",Font.BOLD,14));
        c1.setForeground(new Color(17,42,70));
        c1.setBackground(new Color(172,200,229));
        panel.add(c1);

        try{
            connection c = new connection();
            ResultSet resultSet = c.statement.executeQuery("select * from patientInfo");
            while(resultSet.next()){
                c1.add(resultSet.getString("IdNum"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel label3 = new JLabel("Room No.");
        label3.setBounds(30,130,100,15);
        label3.setFont(new Font("serif", Font.BOLD, 15));
        label3.setForeground(Color.WHITE);
        panel.add(label3);

        JLabel rNo = new JLabel();
        rNo.setBounds(200,130,100,15);
        rNo.setFont(new Font("serif", Font.BOLD, 15));
        rNo.setForeground(Color.WHITE);
        panel.add(rNo);

        JLabel label4 = new JLabel("CheckIn Time");
        label4.setBounds(30,180,250,15);
        label4.setFont(new Font("serif", Font.BOLD, 15));
        label4.setForeground(Color.WHITE);
        panel.add(label4);

        JLabel inTime = new JLabel();
        inTime.setBounds(200,180,250,15);
        inTime.setFont(new Font("serif", Font.BOLD, 15));
        inTime.setForeground(Color.WHITE);
        panel.add(inTime);

        JLabel label5 = new JLabel("CheckOut Time");
        label5.setBounds(30,230,120,15);
        label5.setFont(new Font("serif", Font.BOLD, 15));
        label5.setForeground(Color.WHITE);
        panel.add(label5);

        Date date = new Date();
        JLabel outTime = new JLabel(""+date);
        outTime.setBounds(200,230,250,15);
        outTime.setFont(new Font("serif", Font.BOLD, 15));
        outTime.setForeground(Color.WHITE);
        panel.add(outTime);

        // Discharge Patient BUTTON
        JButton discharge = new JButton("Discharge");
        discharge.setBounds(30,300,120,30);
        discharge.setFont(new Font("serif", Font.BOLD, 15));
        discharge.setForeground(new Color(17,42,70));
        panel.add(discharge);
        discharge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connection c = new connection();
                try {
                    c.statement.executeUpdate("delete from patientInfo where IdNum = '"+c1.getSelectedItem()+"'");
                    c.statement.executeUpdate("update room set availabilty = 'Available' where roomNum = '"+rNo.getText()+"'");
                    JOptionPane.showMessageDialog(null,"Done");
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        JButton check = new JButton("Check");
        check.setBounds(170,300,120,30);
        check.setFont(new Font("serif", Font.BOLD, 15));
        check.setForeground(new Color(17,42,70));
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connection c = new connection();
                try{
                    ResultSet resultSet = c.statement.executeQuery("select * from patientInfo where IdNum = '"+c1.getSelectedItem()+"'");
                    while (resultSet.next()){
                        rNo.setText(resultSet.getString("roomNumber"));
                        inTime.setText(resultSet.getString("Time"));
                    }
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton back = new JButton("Back");
        back.setBounds(300,300,120,30);
        back.setFont(new Font("serif", Font.BOLD, 15));
        back.setForeground(new Color(17,42,70));
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(800,400);
        setLayout(null);
        setLocation(400,250);
        setVisible(true);
    }

    public static void main(String[] args) {
        new PatientDischarge();
    }
}
