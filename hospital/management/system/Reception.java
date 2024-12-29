package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame {

    Reception(){

        // Bottom Panel
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,160,1525,670);
        panel.setBackground(new Color(172,200,229));
        add(panel);

        // Top Panel
        JPanel panelT = new JPanel();
        panelT.setLayout(null);
        panelT.setBounds(5,5,1525,150);
        panelT.setBackground(new Color(17,42,70));
        add(panelT);

        // Doctor Image for top Panel
        ImageIcon di1 = new ImageIcon(ClassLoader.getSystemResource("Icons/dr.png"));
        Image image = di1.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon di2 = new ImageIcon(image);
        JLabel label = new JLabel(di2);
        label.setBounds(1200,0,250,250);
        panelT.add(label);

        // Ambulance Image for top Panel
        ImageIcon l1 = new ImageIcon(ClassLoader.getSystemResource("Icons/logo.png"));
        Image image1 = l1.getImage().getScaledInstance(400,250,Image.SCALE_DEFAULT);
        ImageIcon l2 = new ImageIcon(image1);
        JLabel label1 = new JLabel(l2);
        label1.setBounds(900,-40,390,250);
        panelT.add(label1);

        // BUTTONS
        // ADD NEW PATIENT BUTTON
        JButton btn1 = new JButton("Add New Patient");
        btn1.setBounds(30,15,200,30);
        btn1.setFont(new Font("serif", Font.BOLD, 15));
        btn1.setForeground(new Color(17,42,70));
        panelT.add(btn1);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NewPatient();
            }
        });

        // ROOM BUTTON
        JButton btn2 = new JButton("Room");
        btn2.setBounds(30,58,200,30);
        btn2.setFont(new Font("serif", Font.BOLD, 15));
        btn2.setForeground(new Color(17,42,70));
        panelT.add(btn2);
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Room();
            }
        });

        // DEPARTMENT BUTTON
        JButton btn3 = new JButton("Department");
        btn3.setBounds(30,100,200,30);
        btn3.setFont(new Font("serif", Font.BOLD, 15));
        btn3.setForeground(new Color(17,42,70));
        panelT.add(btn3);
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Department();
            }
        });

        // EMPLOYEE INFO BUTTON
        JButton btn4 = new JButton("Employee Info");
        btn4.setBounds(270,15,200,30);
        btn4.setFont(new Font("serif", Font.BOLD, 15));
        btn4.setForeground(new Color(17,42,70));
        panelT.add(btn4);
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EmployeeInfo();
            }
        });

        //  PATIENT INFO BUTTON
        JButton btn5 = new JButton("Patient Info");
        btn5.setBounds(270,58,200,30);
        btn5.setFont(new Font("serif", Font.BOLD, 15));
        btn5.setForeground(new Color(17,42,70));
        panelT.add(btn5);
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PatientInfo();
            }
        });

        // PATIENT DISCHARGE BUTTON
        JButton btn6 = new JButton("Patient Discharge");
        btn6.setBounds(270,100,200,30);
        btn6.setFont(new Font("serif", Font.BOLD, 15));
        btn6.setForeground(new Color(17,42,70));
        panelT.add(btn6);
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PatientDischarge();
            }
        });

        // UPDATE PATIENT DETAIL BUTTON
        JButton btn7 = new JButton("Update Patient Details");
        btn7.setBounds(510,15,200,30);
        btn7.setFont(new Font("serif", Font.BOLD, 15));
        btn7.setForeground(new Color(17,42,70));
        panelT.add(btn7);
        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UpdatePatientDetails();
            }
        });

        // HOSPITAL AMBULANCE BUTTON
        JButton btn8 = new JButton("Hospital Ambulance");
        btn8.setBounds(510,58,200,30);
        btn8.setFont(new Font("serif", Font.BOLD, 15));
        btn8.setForeground(new Color(17,42,70));
        panelT.add(btn8);
        btn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Ambulance();
            }
        });

        // SEARCH ROOM BUTTON
        JButton btn9 = new JButton("Search Room");
        btn9.setBounds(510,100,200,30);
        btn9.setFont(new Font("serif", Font.BOLD, 15));
        btn9.setForeground(new Color(17,42,70));
        panelT.add(btn9);
        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SearchRoom();
            }
        });

        // LOGOUT BUTTON
        JButton btn10 = new JButton("Logout");
        btn10.setBounds(750,15,170,30);
        btn10.setFont(new Font("serif", Font.BOLD, 15));
        btn10.setForeground(new Color(17,42,70));
        panelT.add(btn10);
        btn10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Login();
            }
        });


        setSize(1950,1090);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args){
        new Reception();
    }
}
