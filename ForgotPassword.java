//ForgotPassword 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
class ForgotPassword extends WindowAdapter implements KeyListener,ActionListener
{
JFrame f;
JLabel l1,l2,l3;
JButton b1,b2,b3;
JTextField t1,t2;
Font f1;
Connection con;
PreparedStatement ps;
ResultSet rs;
String id;
ForgotPassword()
{
f=new JFrame("Forgot Password");
f.setSize(700,400);
f.setLayout(null);
f.setLocationRelativeTo(null);
f.setResizable(false);
f1=new Font("Time new roman",Font.BOLD,20);

l1=new JLabel("Forgot Password Form");
l1.setFont(new Font("Time new roman",Font.BOLD,40));
l1.setForeground(Color.RED);
l1.setBounds(100,20,450,50);
f.add(l1);

l2=new JLabel("Customer id");
l2.setFont(f1);
l2.setBounds(100,90,200,30);
f.add(l2);

t1=new JTextField();
t1.setFont(f1);
t1.setBounds(300,90,300,30);
f.add(t1);

l3=new JLabel("E-mail id");
l3.setFont(f1);
l3.setBounds(100,140,200,30);
f.add(l3);

t2=new JTextField();
t2.setFont(f1);
t2.setBounds(300,140,300,30);
f.add(t2);

b1=new JButton("Submit");
b1.setFont(f1);
b1.setBounds(75,270,150,40);
f.add(b1);

b2=new JButton("Cancel");
b2.setFont(f1);
b2.setBounds(275,270,150,40);
f.add(b2);


b3=new JButton("Back");
b3.setFont(f1);
b3.setBounds(475,270,150,40);
f.add(b3);

b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
t2.addKeyListener(this);
t1.addKeyListener(this);
f.addWindowListener(this);

try
{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/bankdetails","root","");
}
catch(Exception e)
{JOptionPane.showMessageDialog(f,e);}
f.setVisible(true);
}
public void keyPressed(KeyEvent ke)
{}
public void keyReleased(KeyEvent ke)
{}
public void keyTyped(KeyEvent ke)
{
int l;
char ch=ke.getKeyChar();
if(t1==ke.getSource())
{
l=t1.getText().length();
if(l<6)
{}
else
ke.consume();
if(ch>='0'&&ch<='9')
{}
else
ke.consume();
}
else if(t2==ke.getSource())
{
l=t2.getText().length();
if(l<30)
{}
else
ke.consume();
if(ch==32)
{
ke.consume();
JOptionPane.showMessageDialog(f,"invalid key");
}
}
}
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b1)
{
String id=t1.getText();
String email=t2.getText();
try
{
ps=con.prepareStatement("select pin from signup where custid=? and email=?");
ps.setString(1,id);
ps.setString(2,email);
rs=ps.executeQuery();
if(rs.next())
{
String no=rs.getString(1);
JOptionPane.showMessageDialog(f,"your pin is "+no);
}
else
JOptionPane.showMessageDialog(f,"Invalid Details");
}
catch(Exception e)
{
JOptionPane.showMessageDialog(f,e);}
}
else if(ae.getSource()==b2)
{
t1.setText("");
t2.setText("");
}
if(ae.getSource()==b3)
{
Login l=new Login();
f.setVisible(false);
}
}
public void windowClosing(WindowEvent we)
{
f.dispose();
Login l=new Login();
}
}