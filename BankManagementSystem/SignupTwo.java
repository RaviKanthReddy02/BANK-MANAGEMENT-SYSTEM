
package bank.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random;

public class SignupTwo extends JFrame implements ActionListener{
   String formno;
   JLabel cardNumber,details, accNo, text1,text,pin,pinNumber,password;
   JButton submit, Cancel;
    public SignupTwo(String formno){
        this.formno=formno;
        
        setLayout(null);
        
        details =new JLabel("Page 2: Account Details");
        details.setFont(new Font("Raleway", Font.BOLD, 22));
        details.setBounds(200, 50, 400, 30);
        add(details);
       
        cardNumber = new JLabel("Card Number:");
        cardNumber.setFont(new Font("Raleway", Font.BOLD, 18));
        cardNumber.setBounds(100, 140, 200, 30);   
        add(cardNumber);
        
        accNo= new JLabel("XXXX-XXXX-XXXX-4184");
        accNo.setFont(new Font("Raleway", Font.BOLD, 18));
        accNo.setBounds(330,140,250,30);
        add(accNo);
        
        text1 = new JLabel("(Your 16-digit Card number)");
        text1.setFont(new Font("Raleway", Font.BOLD, 12));
        text1.setBounds(100,170,200,20); 
        add(text1);
        
        text = new JLabel("It would appear on ATM Card/Cheque Book and Statements");
        text.setFont(new Font("Raleway", Font.BOLD, 12));
        text.setBounds(330,170,250,20); 
        add(text);
        
        pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 18));
        pin.setBounds(100,230,200,30);
        add(pin);
        
        pinNumber = new JLabel("XXXX");
        pinNumber.setFont(new Font("Raleway", Font.BOLD, 18));
        pinNumber.setBounds(330,230,400,30);
        add(pinNumber);
        
        password = new JLabel("(4-digit password)");
        password.setFont(new Font("Raleway", Font.BOLD, 12));
        password.setBounds(100,270,200,20); 
        add(password);
           
        submit = new JButton("Submit");
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(130, 330, 100, 30);
        add(submit);
        submit.addActionListener(this);
        
        Cancel = new JButton("Cancel");
        Cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        Cancel.setBackground(Color.BLACK);
        Cancel.setForeground(Color.WHITE);     
        Cancel.setBounds(330, 330, 100, 30);
        add(Cancel);
        Cancel.addActionListener(this);
         
        setSize(800, 480);
        setVisible(true);
        setLocation(350, 200);
    
    }
    
    public void actionPerformed(ActionEvent ae){
       
        
        Random ran = new Random();
        long first7 = (ran.nextLong() % 90000000L) + 5040936000000000L;
        String cardno = "" + Math.abs(first7);
        
        long first3 = (ran.nextLong() % 9000L) + 1000L;
        String pin = "" + Math.abs(first3);
        
        
        try{
            if(ae.getSource()==submit){
                Conn c1 = new Conn();
                    String q1 = "insert into signuptwo  values('"+formno+"','"+cardno+"','"+pin+"')";  
                    String q2 = "insert into login values('"+formno+"','"+cardno+"','"+pin+"')";
                    c1.s.executeUpdate(q1);
                    c1.s.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null, "Card Number: " + cardno + "\n Pin:"+ pin);
                    
                    new Deposit(pin).setVisible(true);
                    setVisible(false);
                
                }
                    
          
            
            else if(ae.getSource()==Cancel){
                System.exit(0);
            }
            
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        
    }   
    
    public static void main(String args[]) {
        new SignupTwo("").setVisible(true);
    }
}
