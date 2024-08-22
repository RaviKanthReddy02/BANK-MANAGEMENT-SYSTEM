package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;

public class SignupOne extends JFrame implements ActionListener{
    
   long random;
   JLabel formno,personalDetails,name,fname,dob,gender,email,marital,address,city,state,pincode;
   JTextField nameTf, fnameTf, emailTf, addressTf, cityTf, stateTf, pincodeTf ;
   JDateChooser dateChooser;
   JRadioButton male, female, married, unmarried;
   JButton next;
    SignupOne(){
        setLayout(null);
        Random ran=new Random();
        random=Math.abs((ran.nextLong() % 9000L)+1000L);
        
        formno =new JLabel("Application Form No. "+ random);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(145, 20, 600, 40);
        add(formno);
        
        personalDetails =new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personalDetails.setBounds(290, 80, 400, 30);
        add(personalDetails);
        
        name =new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        add(name);
        
        nameTf = new JTextField();
        nameTf.setFont(new Font("Raleway", Font.BOLD, 14));
        nameTf.setBounds(300,140,400,30);
        add(nameTf);
        
        fname =new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 190, 200, 30);
        add(fname);
        
        fnameTf=new JTextField();
        fnameTf.setFont(new Font("Raleway", Font.BOLD, 14));
        fnameTf.setBounds(300,190,400,30);
        add(fnameTf);
        
        dob =new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);
        
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 240, 200, 30);
        add(dateChooser);       
        dateChooser.setForeground(new Color(105, 105, 105));
        
        gender =new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 290, 100, 30);
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(300, 290, 60, 30);
        male.setBackground(Color.WHITE);
        add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(450, 290, 120, 30);
        female.setBackground(Color.WHITE);
        add(female);
        
        ButtonGroup gg= new ButtonGroup();
        gg.add(male);
        gg.add(female);
      
        email =new JLabel("Email address:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 340, 200, 30);
        add(email);
        
        emailTf=new JTextField();
        emailTf.setFont(new Font("Raleway", Font.BOLD, 14));
        emailTf.setBounds(300,340,400,30);
        add(emailTf);
        
        marital =new JLabel("Marital status:");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100, 390, 200, 30);
        add(marital);
        
        married = new JRadioButton("Married");
        married.setBounds(300, 390, 100, 30);
        married.setBackground(Color.WHITE);
        add(married);
        
        unmarried = new JRadioButton("Single");
        unmarried.setBounds(450, 390, 100, 30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        
        ButtonGroup other= new ButtonGroup();
        other.add(married);
        other.add(unmarried);
        
        address =new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 440, 200, 30);
        add(address);
        
        addressTf=new JTextField();
        addressTf.setFont(new Font("Raleway", Font.BOLD, 14));
        addressTf.setBounds(300,440,400,30);
        add(addressTf);
        
        
        city =new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 490, 100, 30);
        add(city);
        
        cityTf=new JTextField();
        cityTf.setFont(new Font("Raleway", Font.BOLD, 14));
        cityTf.setBounds(300,490,400,30);
        add(cityTf);
        
        state =new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 540, 100, 30);
        add(state);
        
        stateTf=new JTextField();
        stateTf.setFont(new Font("Raleway", Font.BOLD, 14));
        stateTf.setBounds(300,540,400,30);
        add(stateTf);
        
        pincode =new JLabel("Pincode:");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100, 590, 100, 30);
        add(pincode);
        
        pincodeTf=new JTextField();
        pincodeTf.setFont(new Font("Raleway", Font.BOLD, 14));
        pincodeTf.setBounds(300,590,400,30);
        add(pincodeTf);
        
        next = new JButton("Next");
        next.setBounds(620,660, 80, 30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD,14));
        next.addActionListener(this);
        add(next);
        
        
        getContentPane().setBackground(Color.WHITE);
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true); 
    }
    public void actionPerformed(ActionEvent ae){
        String formno= ""+random;
        String name= nameTf.getText();
        String fname = fnameTf.getText();
        String dob= ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender=null;
        if(male.isSelected()){
            gender="Male";
        }
        else if(female.isSelected()){
            gender = "Female";
        }
        String email = emailTf .getText();
        String marital = null;
        if(married.isSelected()){
            marital = "Married";
        } else if(unmarried.isSelected()){
            marital= "Unmarried";
        }
        String address = addressTf.getText();
        String city = cityTf.getText();
        String state = stateTf.getText();
        String pin = pincodeTf.getText();
        
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is mandatory field.");
            }
            else{
                Conn c = new Conn();
                String query = "insert into signup values('"+formno+"' , '"+name+"', '"+fname+"' , '"+dob+"' , '"+gender+"' , '"+email+"' , '"+marital+"' , '"+address+"' , '"+state+"' , '"+city+"' , '"+pin+"')";  
                c.s.executeUpdate(query);
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
        } catch(Exception e){
            System.out.println(e);
        }
        
        
    }

   
    public static void main(String args[]) {
       new SignupOne();
    }
}