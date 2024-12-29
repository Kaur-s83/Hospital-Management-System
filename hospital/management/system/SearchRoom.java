package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class SearchRoom extends JFrame {

    Choice choice;
    JTable table;
    SearchRoom(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,690,490);
        panel.setBackground(new Color(17,42,70));
        panel.setLayout(null);
        add(panel);

        JLabel searchRoom = new JLabel("SEARCH FOR ROOM");
        searchRoom.setBounds(250,15,186,32);
        searchRoom.setFont(new Font("Tahoma",Font.BOLD,20));
        searchRoom.setForeground(Color.WHITE);
        panel.add(searchRoom);

        JLabel status = new JLabel("Status:");
        status.setBounds(50,71,120,20);
        status.setFont(new Font("Tahoma",Font.BOLD,14));
        status.setForeground(Color.WHITE);
        panel.add(status);

        choice = new Choice();
        choice.setBounds(170,70,120,20);
        choice.add("Available");
        choice.add("Occupied");
        panel.add(choice);

        table = new JTable();
        table.setBounds(20,187,650,210);
        table.setBackground(new Color(17,42,70));
        table.setForeground(Color.WHITE);
        table.setFont(new Font("serif", Font.BOLD, 15));
        panel.add(table);

        try{
            connection c = new connection();
            String q = "select * from room";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel label1 = new JLabel("Room NO.");
        label1.setBounds(23,162,150,15);
        label1.setFont(new Font("serif", Font.BOLD, 15));
        label1.setForeground(Color.WHITE);
        panel.add(label1);


        JLabel label2 = new JLabel("Availability");
        label2.setBounds(185,162,150,15);
        label2.setFont(new Font("serif", Font.BOLD, 15));
        label2.setForeground(Color.WHITE);
        panel.add(label2);

        JLabel label3 = new JLabel("Price");
        label3.setBounds(350,162,150,15);
        label3.setFont(new Font("serif", Font.BOLD, 15));
        label3.setForeground(Color.WHITE);
        panel.add(label3);

        JLabel label4 = new JLabel("Bed Type");
        label4.setBounds(510,162,150,15);
        label4.setFont(new Font("serif", Font.BOLD, 15));
        label4.setForeground(Color.WHITE);
        panel.add(label4);

        JButton search = new JButton("Search");
        search.setBounds(200,430,120,30);
        search.setFont(new Font("serif", Font.BOLD, 15));
        search.setForeground(new Color(17,42,70));
        panel.add(search);
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String q = "select * from Room where availabilty = '"+choice.getSelectedItem()+"'";
                try {
                    connection c = new connection();
                    ResultSet resultSet = c.statement.executeQuery(q);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton back = new JButton("Back");
        back.setBounds(380,430,120,30);
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
        setSize(700,500);
        setLayout(null);
        setLocation(300,250);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SearchRoom();
    }
}
