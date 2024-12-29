package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Ambulance extends JFrame {

    Ambulance(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,790,490);
        panel.setLayout(null);
        panel.setBackground(new Color(17,42,70));
        add(panel);

        JTable table = new JTable();
        table.setBounds(25,110,780,260);
        table.setBackground(new Color(17,42,70));
        table.setForeground(Color.WHITE);
        table.setFont(new Font("serif", Font.BOLD, 12));
        panel.add(table);

        // INTRODUCTION ABOUT THE PANEL
        JLabel labelName = new JLabel("AMBULANCE");
        labelName.setBounds(300,11,260,53);
        labelName.setFont(new Font("Tahoma",Font.BOLD,20));
        labelName.setForeground(Color.WHITE);
        panel.add(labelName);

        try {
            connection c = new connection();
            String q = "select * from ambulance";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel label1 = new JLabel("Driver Name");
        label1.setBounds(32,80,150,15);
        label1.setFont(new Font("serif", Font.BOLD, 15));
        label1.setForeground(Color.WHITE);
        panel.add(label1);


        JLabel label2 = new JLabel("Driver Gender");
        label2.setBounds(186,80,150,15);
        label2.setFont(new Font("serif", Font.BOLD, 15));
        label2.setForeground(Color.WHITE);
        panel.add(label2);

        JLabel label3 = new JLabel("Ambulance Type");
        label3.setBounds(340,80,150,15);
        label3.setFont(new Font("serif", Font.BOLD, 15));
        label3.setForeground(Color.WHITE);
        panel.add(label3);

        JLabel label4 = new JLabel("Availability");
        label4.setBounds(500,80,150,15);
        label4.setFont(new Font("serif", Font.BOLD, 15));
        label4.setForeground(Color.WHITE);
        panel.add(label4);

        JLabel label5 = new JLabel("Location");
        label5.setBounds(650,80,150,15);
        label5.setFont(new Font("serif", Font.BOLD, 15));
        label5.setForeground(Color.WHITE);
        panel.add(label5);


        // BAck Button
        JButton back = new JButton("Back");
        back.setBounds(300,400,120,30);
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
        setSize(800,500);
        setLayout(null);
        setLocation(350,250);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Ambulance();
    }
}
