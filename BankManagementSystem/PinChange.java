package bank.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
 public class PinChange extends JFrame implements ActionListener {
    JPasswordField pin, repin;
    JButton cancel, change;
    String pinnumber;
     PinChange(String pinnumber){
         this.pinnumber =  pinnumber;
         
         setLayout(null);
         
         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
           Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
           ImageIcon i3=new ImageIcon(i2);
            JLabel image = new JLabel(i3);
            image.setBounds(0,0,900,900);
            add(image);
            
            JLabel text = new JLabel("Please change your pin");
            text.setBounds(250, 280, 500, 35);
            text.setForeground(Color.WHITE);
            text.setFont(new Font("System", Font.BOLD,16));
            image.add(text);
            
            JLabel pintext = new JLabel("New Pin");
            pintext.setBounds(165, 360, 180, 25);
            pintext.setForeground(Color.WHITE);
            pintext.setFont(new Font("System", Font.BOLD,16));
            image.add(pintext);
            
            pin = new JPasswordField();
            pin.setFont(new Font("Ralewsy", Font.BOLD, 15));
            pin.setBounds(330, 360, 180, 25);
            add(pin);
            
            JLabel repintext = new JLabel("Re-enter  Pin");
            repintext.setBounds(165, 400, 180, 25);
            repintext.setForeground(Color.WHITE);
            repintext.setFont(new Font("System", Font.BOLD,16));
            image.add(repintext);
            
            repin = new JPasswordField();
            repin.setFont(new Font("Ralewsy", Font.BOLD, 15));
            repin.setBounds(330, 400, 180, 25);
            add(repin);
            
            change =new JButton("Change");
            change.setBounds(360, 485, 150, 30);
            change.addActionListener(this);
            image.add(change);
            
            cancel =new JButton("Cancel");
            cancel.setBounds(360, 520, 150, 30);
            cancel.addActionListener(this);
            image.add(cancel);
            
            
            setSize(900, 900);
            setLocation(300, 0);
            setUndecorated(true);
            setVisible(true);
     }
     public void actionPerformed(ActionEvent ae){
         if(ae.getSource()==change){
         
           try{
             String npin = pin.getText();
             String rpin = repin.getText();
             if(!npin.equals(rpin)){
             JOptionPane.showMessageDialog(null, "Passwords Doesn't match");
             return;
            }
              if(npin.equals("")){
                 JOptionPane.showMessageDialog(null, "Please enter new  pin");
                 return;
             }
              if(rpin.equals("")){
                 JOptionPane.showMessageDialog(null, "Please re-enter new pin");
                 return;
             }
              else{
                                JOptionPane.showMessageDialog(null, "PIN changed successfully");

              }
              Conn conn = new Conn();
              String q1= "update bank set pin = '"+rpin+"' where pin = '"+pinnumber+"' ";
              String q2= "update login set pin = '"+rpin+"' where pin = '"+pinnumber+"' ";
              String q3= "update signuptwo set pin = '"+rpin+"' where pin = '"+pinnumber+"' ";
              conn.s.executeUpdate(q1);
               conn.s.executeUpdate(q2);
                conn.s.executeUpdate(q3);
              setVisible(false);
              new Transactions(rpin).setVisible(true);
              
              
             
           }
         catch(Exception e){
             System.out.println(e);
             
         }
        }
         else{
             setVisible(false);
             new Transactions(pinnumber).setVisible(true);
         }
     }
    
    public static void main(String args[]) {
        new PinChange("").setVisible(true);
    }
}
