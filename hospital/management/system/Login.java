package hospital.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JTextField textField;
    JPasswordField passwordField;
    JButton btn1, btn2;


    Login(){
        // FOR UserName
        JLabel nameLabel = new JLabel("Username");
        nameLabel.setBounds(40,20,100,30);
        nameLabel.setFont(new Font("Tahoma",Font.BOLD, 16));
        nameLabel.setForeground(new Color(17,42,70));
        add(nameLabel);

        // Password
        JLabel password = new JLabel("Password");
        password .setBounds(40,70,100,30);
        password .setFont(new Font("Tahoma",Font.BOLD, 16));
        password .setForeground(new Color(17,42,70));
        add(password);

        // TextField for Username
        textField = new JTextField("user1");
        textField.setBounds(150,20,150,30);
        textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textField.setBackground(new Color(255,255,255));
        add(textField);

        // PasswordField for Password
        passwordField = new JPasswordField("1234567");
        passwordField.setBounds(150,70,150,30);
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        passwordField.setBackground(new Color(255,255,255));
        add(passwordField);

        // LOGO
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource(("Icons/login.png")));
        Image i = imageIcon.getImage().getScaledInstance(500,450, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon((i));
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(300,-30,400,300);
        add(label);

        // LOGIN BUTTON
        btn1 = new JButton("Login");
        btn1.setBounds(40,140,120,30);
        btn1.setFont(new Font("serif", Font.BOLD, 15));
        btn1.setForeground(new Color(17,42,70));
        btn1.addActionListener(this);
        add(btn1);

        // CANCEL BUTTON
        btn2 = new JButton("Cancel");
        btn2.setBounds(180,140,120,30);
        btn2.setFont(new Font("serif", Font.BOLD, 15));
        btn2.setForeground(new Color(17,42,70));
        btn2.addActionListener(this);
        add(btn2);


        getContentPane().setBackground(new Color(172,200,229));
        setSize(750,300);
        setLocation(400,250);
        setLayout(null);
        setVisible(true);         // Always  write it in the end to see all the feature we add


    }
    public static void main(String[] args){
         Login login = new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btn1){
            try{
                connection c = new connection();
                String user = textField.getText();
                String pass = passwordField.getText();

                String q = "select * from login where ID = '"+user+"' and PW ='"+pass+"'";
                ResultSet resultSet = c.statement.executeQuery(q);

                if(resultSet.next()){
                    new Reception();
                    setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid");
                }


            }catch (Exception E){
                E.printStackTrace();
            }
        }
        else{
            System.exit(10);
        }
    }
}
