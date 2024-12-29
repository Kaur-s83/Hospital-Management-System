package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Room extends JFrame {
    JTable table;

    Room(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,890,490);
        panel.setBackground(new Color(17,42,70));
        panel.setLayout(null);
        add(panel);

        // Image
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("Icons/roomm.png"));
        Image image = imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(600,200,200,200);
        panel.add(label);

        // Room Table
        table = new JTable();
        table.setBounds(25,100,500,310);
        table.setBackground(new Color(17,42,70));
        table.setForeground(Color.WHITE);
        table.setFont(new Font("serif", Font.BOLD, 15));
        panel.add(table);

        JLabel labelName = new JLabel("ROOMS INFO");
        labelName.setBounds(230,11,260,53);
        labelName.setFont(new Font("Tahoma",Font.BOLD,20));
        labelName.setForeground(Color.WHITE);
        panel.add(labelName);

        try {
            connection c = new connection();
            String q = "select * from room";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel label1 = new JLabel("Room NO.");
        label1.setBounds(27,80,80,15);
        label1.setFont(new Font("serif", Font.BOLD, 15));
        label1.setForeground(Color.WHITE);
        panel.add(label1);


        JLabel label2 = new JLabel("Availability");
        label2.setBounds(150,80,80,15);
        label2.setFont(new Font("serif", Font.BOLD, 15));
        label2.setForeground(Color.WHITE);
        panel.add(label2);

        JLabel label3 = new JLabel("Price");
        label3.setBounds(280,80,80,15);
        label3.setFont(new Font("serif", Font.BOLD, 15));
        label3.setForeground(Color.WHITE);
        panel.add(label3);

        JLabel label4 = new JLabel("Bed Type");
        label4.setBounds(400,80,80,15);
        label4.setFont(new Font("serif", Font.BOLD, 15));
        label4.setForeground(Color.WHITE);
        panel.add(label4);

        // BAck Button
        JButton back = new JButton("Back");
        back.setBounds(200,430,120,30);
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
        setSize(900,500);
        setLayout(null);
        setLocation(300,250);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Room();
    }
}
