package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class EmployeeInfo extends JFrame {

    EmployeeInfo(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,1190,490);
        panel.setLayout(null);
        panel.setBackground(new Color(17,42,70));
        add(panel);

        JTable table = new JTable();
        table.setBounds(25,110,1150,260);
        table.setBackground(new Color(17,42,70));
        table.setForeground(Color.WHITE);
        table.setFont(new Font("serif", Font.BOLD, 12));
        panel.add(table);

        // INTRODUCTION ABOUT THE PANEL
        JLabel labelName = new JLabel("ALL EMPLOYEES INFO");
        labelName.setBounds(500,11,260,53);
        labelName.setFont(new Font("Tahoma",Font.BOLD,20));
        labelName.setForeground(Color.WHITE);
        panel.add(labelName);

        try {
            connection c = new connection();
            String q = "select * from employeeInfo";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel label1 = new JLabel("Employee Name");
        label1.setBounds(32,80,130,15);
        label1.setFont(new Font("serif", Font.BOLD, 15));
        label1.setForeground(Color.WHITE);
        panel.add(label1);


        JLabel label2 = new JLabel("Age");
        label2.setBounds(220,80,40,15);
        label2.setFont(new Font("serif", Font.BOLD, 15));
        label2.setForeground(Color.WHITE);
        panel.add(label2);

        JLabel label3 = new JLabel("Phone No.");
        label3.setBounds(410,80,80,15);
        label3.setFont(new Font("serif", Font.BOLD, 15));
        label3.setForeground(Color.WHITE);
        panel.add(label3);

        JLabel label4 = new JLabel("Salary");
        label4.setBounds(600,80,80,15);
        label4.setFont(new Font("serif", Font.BOLD, 15));
        label4.setForeground(Color.WHITE);
        panel.add(label4);

        JLabel label5 = new JLabel("Email");
        label5.setBounds(800,80,80,15);
        label5.setFont(new Font("serif", Font.BOLD, 15));
        label5.setForeground(Color.WHITE);
        panel.add(label5);

        JLabel label6 = new JLabel("Driver Licence");
        label6.setBounds(1000,80,100,15);
        label6.setFont(new Font("serif", Font.BOLD, 15));
        label6.setForeground(Color.WHITE);
        panel.add(label6);

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
        setSize(1200,500);
        setLayout(null);
        setLocation(120,250);
        setVisible(true);
    }

    public static void main(String[] args) {
        new EmployeeInfo();
    }
}
