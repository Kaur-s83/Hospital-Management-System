package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdatePatientDetails extends JFrame {

    UpdatePatientDetails(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,940,490);
        panel.setBackground(new Color(17,42,70));
        panel.setLayout(null);
        add(panel);

        // Image
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("Icons/updated.png"));
        Image image = imageIcon.getImage().getScaledInstance(340,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(550,50,350,300);
        panel.add(label);

        JLabel label1 = new JLabel("Update Patient Details");
        label1.setBounds(124,15,230,25);
        label1.setFont(new Font("Tahoma",Font.BOLD,20));
        label1.setForeground(Color.WHITE);
        panel.add(label1);

        JLabel label2 = new JLabel("Patient Name:");
        label2.setBounds(25,85,100,15);
        label2.setFont(new Font("serif", Font.BOLD, 15));
        label2.setForeground(Color.WHITE);
        panel.add(label2);

        Choice c1 = new Choice();
        c1.setBounds(208,85,150,25);
        c1.setFont(new Font("Tahoma",Font.PLAIN,15));
        c1.setForeground(new Color(17,42,70));
        c1.setBackground(new Color(172,200,229));
        panel.add(c1);

        try{
            connection c = new connection();
            ResultSet resultSet = c.statement.executeQuery("select * from patientInfo");
            while(resultSet.next()){
                c1.add(resultSet.getString("patientName"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel label3 = new JLabel("Room No.:");
        label3.setBounds(25,129,100,15);
        label3.setFont(new Font("serif", Font.BOLD, 15));
        label3.setForeground(Color.WHITE);
        panel.add(label3);

        JTextField textField = new JTextField();
        textField.setBounds(208,129,150,20);
        panel.add(textField);

        JLabel label4 = new JLabel("Check-In Time:");
        label4.setBounds(25,174,150,15);
        label4.setFont(new Font("serif", Font.BOLD, 15));
        label4.setForeground(Color.WHITE);
        panel.add(label4);

        JTextField textFieldInTime = new JTextField();
        textFieldInTime.setBounds(208,174,150,20);
        panel.add(textFieldInTime);

        JLabel label5 = new JLabel("Amount Paid:");
        label5.setBounds(25,216,120,15);
        label5.setFont(new Font("serif", Font.BOLD, 15));
        label5.setForeground(Color.WHITE);
        panel.add(label5);

        JTextField textFieldAmount = new JTextField();
        textFieldAmount.setBounds(208,216,150,20);
        panel.add(textFieldAmount);

        JLabel label6 = new JLabel("Pending Amount:");
        label6.setBounds(25,261,150,15);
        label6.setFont(new Font("serif", Font.BOLD, 15));
        label6.setForeground(Color.WHITE);
        panel.add(label6);

        JTextField textFieldPendingAmount = new JTextField();
        textFieldPendingAmount .setBounds(208,261,150,20);
        panel.add(textFieldPendingAmount);


        JButton update = new JButton("Update");
        update.setBounds(25,378,120,30);
        update.setFont(new Font("serif", Font.BOLD, 15));
        update.setForeground(new Color(17,42,70));
        panel.add(update);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    connection c = new connection();
                    String q = c1.getSelectedItem();
                    String room = textField.getText();
                    String time = textFieldInTime.getText();
                    String amount = textFieldAmount.getText();
                    String pendingAmount = textFieldPendingAmount.getText();

                    if(Integer.parseInt(pendingAmount) <0){
                        JOptionPane.showMessageDialog(null, "The amount paid exceed the room price. Please correct the amount.");
                        textFieldPendingAmount.setText("0");
                    }else{
                        //textFieldPendingAmount.setText(String.valueOf(pendingAmount));
                        c.statement.executeUpdate("update patientInfo set roomNumber ='"+room+"',Time ='"+time+"',deposite = '"+amount+"'");
                        JOptionPane.showMessageDialog(null,"Update Successfully");


                    }


                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton check = new JButton("Check");
        check.setBounds(170,378,120,30);
        check.setFont(new Font("serif", Font.BOLD, 15));
        check.setForeground(new Color(17,42,70));
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = c1.getSelectedItem();
                String q ="select * from patientInfo where patientName = '"+id+"'";

                try{
                    connection c = new connection();
                    ResultSet resultSet = c.statement.executeQuery(q);
                    while (resultSet.next()){
                        textField.setText(resultSet.getString("roomNumber"));
                        textFieldInTime.setText(resultSet.getString("Time"));
                        textFieldAmount.setText(resultSet.getString("deposite"));

                    }
                    ResultSet resultSet1 = c.statement.executeQuery("select * from room where roomNum = '"+textField.getText()+"'");
                    while (resultSet1.next()){
                        String price = resultSet1.getString("price");
                        int amountPaid = Integer.parseInt(price)- Integer.parseInt(textFieldAmount.getText());
                        textFieldPendingAmount.setText(""+amountPaid);
                    }
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton back = new JButton("Back");
        back.setBounds(300,378,120,30);
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
        setSize(950,500);
        setLayout(null);
        setLocation(300,250);
        setVisible(true);
    }

    public static void main(String[] args) {
        new UpdatePatientDetails();
    }
}
