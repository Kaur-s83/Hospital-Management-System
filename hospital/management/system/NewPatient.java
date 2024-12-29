package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class NewPatient extends JFrame implements ActionListener {

    JComboBox comboBox;
    JTextField textFieldNum, textName, textFieldDisease, textFieldDeposit;
    JRadioButton r1,r2;
    Choice c1;
    JLabel date;
    JButton btn1,btn2;

    NewPatient(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,840,490);
        panel.setBackground(new Color(17,42,70));
        panel.setLayout(null);
        add(panel);

        // Image
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("Icons/patient.png"));
        Image image = imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(550,150,200,200);
        panel.add(label);

                      // LABELS //
        // LABEL FOR THE TOP
        JLabel labelName = new JLabel("NEW PATIENT FORM");
        labelName.setBounds(118,11,260,53);
        labelName.setFont(new Font("Tahoma",Font.BOLD,20));
        labelName.setForeground(Color.WHITE);
        panel.add(labelName);

        // Patient ID Type label;
        JLabel labelID = new JLabel("ID :");
        labelID.setBounds(35,76,200,14);
        labelID.setFont(new Font("Tahoma",Font.BOLD,14));
        labelID.setForeground(Color.WHITE);
        panel.add(labelID);

        // DROPDOWN for type of ID and we used JComboBox for that
        comboBox = new JComboBox(new String[] {"Driving Licence", "Passport Number","Voter ID"});
        comboBox.setBounds(271,73,150,20);
        comboBox.setForeground(new Color(172,200,229));
        comboBox.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(comboBox);

        // Patient ID Number Label
        JLabel labelNumber = new JLabel("Number :");
        labelNumber.setBounds(35,111,200,14);
        labelNumber.setFont(new Font("Tahoma",Font.BOLD,14));
        labelNumber.setForeground(Color.WHITE);
        panel.add(labelNumber);

        // TEXT FIELD FOR ID NUMBER
        textFieldNum = new JTextField();
        textFieldNum.setBounds(271,111,150,20);
        textFieldNum.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textFieldNum.setBackground(new Color(255,255,255));
        panel.add(textFieldNum);


        // Patient Name Label
        JLabel labelName1 = new JLabel("Patient Name :");
        labelName1.setBounds(35,151,200,14);
        labelName1.setFont(new Font("Tahoma",Font.BOLD,14));
        labelName1.setForeground(Color.WHITE);
        panel.add(labelName1);

        // TEXT FIELD FOR Patient Name
        textName = new JTextField();
        textName.setBounds(271,151,150,20);
        textName.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textName.setBackground(new Color(255,255,255));
        panel.add(textName);

        // Patient's Gender Label
        JLabel labelGender = new JLabel("Gender :");
        labelGender.setBounds(35,191,200,14);
        labelGender.setFont(new Font("Tahoma",Font.BOLD,14));
        labelGender.setForeground(Color.WHITE);
        panel.add(labelGender);

        // RADIO BUTTON FOR MALE
        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Tahoma",Font.BOLD,14));
        r1.setForeground(Color.WHITE);
        r1.setBackground(new Color(17,42,70));
        r1.setBounds(271,191,80,15);
        panel.add(r1);

        // RADIO BUTTON FOR FEMALE
        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Tahoma",Font.BOLD,14));
        r2.setForeground(Color.WHITE);
        r2.setBackground(new Color(17,42,70));
        r2.setBounds(350,191,80,15);
        panel.add(r2);

        // Patient's Disease Label
        JLabel labelDisease = new JLabel("Disease :");
        labelDisease.setBounds(35,231,200,14);
        labelDisease.setFont(new Font("Tahoma",Font.BOLD,14));
        labelDisease.setForeground(Color.WHITE);
        panel.add(labelDisease);

        // TEXT FIELD FOR Patient Name
        textFieldDisease = new JTextField();
        textFieldDisease.setBounds(271,231,150,20);
        textFieldDisease.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textFieldDisease.setBackground(new Color(255,255,255));
        panel.add(textFieldDisease);

        // Room Label
        JLabel labelRoom = new JLabel("Room :");
        labelRoom .setBounds(35,274,200,14);
        labelRoom .setFont(new Font("Tahoma",Font.BOLD,14));
        labelRoom .setForeground(Color.WHITE);
        panel.add(labelRoom );

        // Room Choice DropDown
        c1 = new Choice();
        try{
            connection c = new connection();
            ResultSet resultSet = c.statement.executeQuery("select * from room");
            while(resultSet.next()){
                c1.add(resultSet.getString("roomNum"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        c1.setBounds(271,274,150,20);
        c1.setFont(new Font("Tahoma",Font.BOLD,14));
        c1.setForeground(new Color(17,42,70));
        c1.setBackground(new Color(172,200,229));
        panel.add(c1);



        // Date Label
        JLabel labelDate = new JLabel("Time :");
        labelDate.setBounds(35,316,200,14);
        labelDate.setFont(new Font("Tahoma",Font.BOLD,14));
        labelDate.setForeground(Color.WHITE);
        panel.add(labelDate );

        // Date field
        Date date1 = new Date();

        date = new JLabel(""+date1);
        date.setBounds(271,316,250,14);
        date.setForeground(Color.WHITE);
        date.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(date);

        // Deposit Label
        JLabel labelDeposit = new JLabel("Deposit :");
        labelDeposit.setBounds(35,359,200,17);
        labelDeposit.setFont(new Font("Tahoma",Font.BOLD,14));
        labelDeposit.setForeground(Color.WHITE);
        panel.add(labelDeposit);

        // TEXT FIELD FOR DEPOSIT
        textFieldDeposit = new JTextField();
        textFieldDeposit.setBounds(271,359,150,20);
        textFieldDeposit.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textFieldDeposit.setBackground(new Color(255,255,255));
        panel.add(textFieldDeposit);


        // ADD Patient BUTTON
        btn1 = new JButton("ADD");
        btn1.setBounds(100,430,120,30);
        btn1.setFont(new Font("serif", Font.BOLD, 15));
        btn1.setForeground(new Color(17,42,70));
        panel.add(btn1);
        btn1.addActionListener(this);

        // BACK BUTTON
        btn2 = new JButton("BACK");
        btn2.setBounds(260,430,120,30);
        btn2.setFont(new Font("serif", Font.BOLD, 15));
        btn2.setForeground(new Color(17,42,70));
        panel.add(btn2);
        btn2.addActionListener(this);



        setUndecorated(true);
        setSize(850,500);
        setLayout(null);
        setLocation(300,250);
        setVisible(true);
    }
    public static void main(String[] args) {
        new NewPatient();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1){
            connection c = new connection();
            String radioBtn = null;
            if(r1.isSelected()){
                radioBtn = "Male";
            }else if(r2.isSelected()){
                radioBtn = "Female";
            }
            String s1 = (String)comboBox.getSelectedItem();
            String s2 = textFieldNum.getText();
            String s3 = textName.getText();
            String s4 = radioBtn;
            String s5 = textFieldDisease.getText();
            String s6 = c1.getSelectedItem();
            String s7 = date.getText();
            String s8 = textFieldDeposit.getText();

            try{
                String q = "insert into patientInfo values ('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"')";
                String q1 = "update room set availabilty = 'Occupied' where roomNum = "+s6;
                c.statement.executeUpdate(q);
                c.statement.executeUpdate(q1);
                JOptionPane.showMessageDialog(null, "Added Successfully");
                setVisible(false);

            }catch (Exception E){
                E.printStackTrace();
            }

        }else{
            setVisible(false);
        }

    }
}
