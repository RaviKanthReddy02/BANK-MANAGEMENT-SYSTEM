package bank.management.system;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class BalEnquiry extends JFrame implements ActionListener {
    JLabel text;
    JButton back;
    String pinnumber;
    BalEnquiry(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
           Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
           ImageIcon i3=new ImageIcon(i2);
            JLabel image = new JLabel(i3);
            image.setBounds(0,0,900,900);
            add(image);
            
            back = new JButton("Back");
            back.setBounds(355, 520,150, 30);
            back.addActionListener(this);
            add(back);
            
            Conn c = new Conn();
            double bal=0;
            try{
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            while(rs.next()){
                
                if(rs.getString("type").equals("Deposit")){
                   bal+=Double.parseDouble(rs.getString("amount")); 
                }
                else{
                   bal-=Double.parseDouble(rs.getString("amount"));
                      }
               }
            }
               catch (Exception e){
                   System.out.println(e);
               }
            String formattedBalance = String.format("%.2f", bal);
        text = new JLabel("Your current balance is: Rs " + formattedBalance);
        text.setForeground(Color.WHITE);
        text.setBounds(170, 300,400,30);
        image.add(text);
            
            
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    
    }
    public void actionPerformed(ActionEvent ae){
        try{
            if(ae.getSource()==back){
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }
                
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String args[]) {
     new BalEnquiry("");
    }
}




