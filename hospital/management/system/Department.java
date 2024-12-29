package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Department extends JFrame {

    Department(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,690,490);
        panel.setLayout(null);
        panel.setBackground(new Color(17,42,70));
        add(panel);

        JTable table = new JTable();
        table.setBounds(25,110,690,280);
        table.setBackground(new Color(17,42,70));
        table.setForeground(Color.WHITE);
        table.setFont(new Font("serif", Font.BOLD, 20));
        panel.add(table);

        // INTRODUCTION ABOUT THE PANEL
        JLabel labelName = new JLabel("DEPARTMENT INFO");
        labelName.setBounds(230,11,260,53);
        labelName.setFont(new Font("Tahoma",Font.BOLD,20));
        labelName.setForeground(Color.WHITE);
        panel.add(labelName);

        // TO view Department table
        try {
            connection c = new connection();
            String q = "select * from department";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel label1 = new JLabel("Department Name");
        label1.setBounds(27,80,200,24);
        label1.setFont(new Font("serif", Font.BOLD, 24));
        label1.setForeground(Color.WHITE);
        panel.add(label1);


        JLabel label2 = new JLabel("Phone Number");
        label2.setBounds(370,80,200,24);
        label2.setFont(new Font("serif", Font.BOLD, 24));
        label2.setForeground(Color.WHITE);
        panel.add(label2);

        // BAck Button
        JButton back = new JButton("Back");
        back.setBounds(350,400,120,30);
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
        setSize(700,500);
        setLayout(null);
        setLocation(350,250);
        setVisible(true);
   }

    public static void main(String[] args) {
        new Department();
    }
}
