package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class PatientInfo extends JFrame {

    PatientInfo(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,1290,490);
        panel.setLayout(null);
        panel.setBackground(new Color(17,42,70));
        add(panel);

        JTable table = new JTable();
        table.setBounds(25,110,1320,260);
        table.setBackground(new Color(17,42,70));
        table.setForeground(Color.WHITE);
        table.setFont(new Font("serif", Font.BOLD, 12));
        panel.add(table);

        // INTRODUCTION ABOUT THE PANEL
        JLabel labelName = new JLabel("ALL PATIENT INFO");
        labelName.setBounds(500,11,260,53);
        labelName.setFont(new Font("Tahoma",Font.BOLD,20));
        labelName.setForeground(Color.WHITE);
        panel.add(labelName);

        try {
            connection c = new connection();
            String q = "select * from patientInfo";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel label1 = new JLabel("ID Type");
        label1.setBounds(32,80,130,15);
        label1.setFont(new Font("serif", Font.BOLD, 15));
        label1.setForeground(Color.WHITE);
        panel.add(label1);


        JLabel label2 = new JLabel("ID");
        label2.setBounds(190,80,40,15);
        label2.setFont(new Font("serif", Font.BOLD, 15));
        label2.setForeground(Color.WHITE);
        panel.add(label2);

        JLabel label3 = new JLabel("Patient Name");
        label3.setBounds(355,80,100,15);
        label3.setFont(new Font("serif", Font.BOLD, 15));
        label3.setForeground(Color.WHITE);
        panel.add(label3);

        JLabel label4 = new JLabel("Gender");
        label4.setBounds(520,80,80,15);
        label4.setFont(new Font("serif", Font.BOLD, 15));
        label4.setForeground(Color.WHITE);
        panel.add(label4);

        JLabel label5 = new JLabel("Disease");
        label5.setBounds(685,80,80,15);
        label5.setFont(new Font("serif", Font.BOLD, 15));
        label5.setForeground(Color.WHITE);
        panel.add(label5);

        JLabel label6 = new JLabel("Room No.");
        label6.setBounds(850,80,100,15);
        label6.setFont(new Font("serif", Font.BOLD, 15));
        label6.setForeground(Color.WHITE);
        panel.add(label6);

        JLabel label7 = new JLabel("Time");
        label7.setBounds(1015,80,100,15);
        label7.setFont(new Font("serif", Font.BOLD, 15));
        label7.setForeground(Color.WHITE);
        panel.add(label7);

        JLabel label8 = new JLabel("Deposit");
        label8.setBounds(1200,80,100,15);
        label8.setFont(new Font("serif", Font.BOLD, 15));
        label8.setForeground(Color.WHITE);
        panel.add(label8);

        // BAck Button
        JButton back = new JButton("Back");
        back.setBounds(500,430,120,30);
        back.setFont(new Font("serif", Font.BOLD, 15));
        back.setForeground(new Color(17,42,70));
        back.setBackground(new Color(172,200,229));
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(1300,500);
        setLayout(null);
        setLocation(90,250);
        setVisible(true);
    }

    public static void main(String[] args) {
        new PatientInfo();
    }
}
