//change pin 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
class ChangePin implements KeyListener,ActionListener
{
JFrame f;
JLabel l1,l2,l3,l4;
JButton b1,b2;
JTextField t1,t2,t3;
Font f1;
Connection con;
PreparedStatement ps;
ResultSet rs;
String id,opin,npin,cpin;
ChangePin()
{}
ChangePin(String cid)
{
id=cid;
f=new JFrame("Pin Change");
f.setSize(700,400);
f.setLayout(null);
f.setLocationRelativeTo(null);
f.setResizable(false);

f1=new Font("Time new roman",Font.BOLD,20);

l1=new JLabel("Change your Pin");
l1.setFont(new Font("Time new roman",Font.BOLD,40));
l1.setForeground(Color.RED);
l1.setBounds(150,20,400,50);
f.add(l1);

l2=new JLabel("Current pin");
l2.setFont(f1);
l2.setBounds(100,90,200,30);
f.add(l2);

t1=new JTextField();
t1.setFont(f1);
t1.setBounds(300,90,300,30);
f.add(t1);

l3=new JLabel("New Pin");
l3.setFont(f1);
l3.setBounds(100,140,200,30);
f.add(l3);

t2=new JTextField();
t2.setFont(f1);
t2.setBounds(300,140,300,30);
f.add(t2);

l4=new JLabel("Re-enter Pin");
l4.setFont(f1);
l4.setBounds(100,190,200,30);
f.add(l4);

t3=new JTextField();
t3.setFont(f1);
t3.setBounds(300,190,300,30);
f.add(t3);

b1=new JButton("Save");
b1.setFont(f1);
b1.setBounds(150,270,150,40);
f.add(b1);

b2=new JButton("Back");
b2.setFont(f1);
b2.setBounds(400,270,150,40);
f.add(b2);

b1.addActionListener(this);
b2.addActionListener(this);
t1.addKeyListener(this);
t2.addKeyListener(this);
t3.addKeyListener(this);

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
char ch=ke.getKeyChar();
if(ch>='0'&&ch<='9')
{}
else
ke.consume();
int l;
if(ke.getSource()==t1)
{
l=t1.getText().length();
if(l<4)
{}
else
ke.consume();
}
else if(ke.getSource()==t2)
{
l=t2.getText().length();
if(l<4)
{}
else
ke.consume();
}
else if(ke.getSource()==t3)
{
l=t3.getText().length();
if(l<4)
{}
else
ke.consume();
}
}
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b1)
{
opin=t1.getText();
npin=t2.getText();
cpin=t3.getText();
if(npin.equals(cpin))
{
try
{
ps=con.prepareStatement("update signup set pin=? where custid=? and pin=?");
ps.setString(1,npin);
ps.setString(2,id);
ps.setString(3,opin);
int r=ps.executeUpdate();
if(r>0)
JOptionPane.showMessageDialog(f,"pin change Successfully");
else
JOptionPane.showMessageDialog(f,"problem in pin changing");
}
catch(Exception e)
{
JOptionPane.showMessageDialog(f,e);
}
}
else
JOptionPane.showMessageDialog(f,"conferm pin doesn't match");
}
else if(ae.getSource()==b2)
{
f.setVisible(false);
}
}
}