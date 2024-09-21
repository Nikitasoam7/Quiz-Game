//withdraw
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
class Withdraw implements KeyListener,ActionListener
{
JFrame f;
JLabel l1,l2,l3,l4,l5;
JButton b1,b2;
JTextField t1;
Font f1;
Connection con;
PreparedStatement ps;
ResultSet rs;
String id,date;
int amount;
Withdraw()
{}
Withdraw(String cid)
{
id=cid;
f=new JFrame("Withdraw");
f.setSize(700,400);
f.setLayout(null);
f.setLocationRelativeTo(null);
f.setResizable(false);

f1=new Font("Time new roman",Font.BOLD,20);

l1=new JLabel("Account no.");
l1.setFont(f1);
l1.setBounds(100,90,200,30);
f.add(l1);

l5=new JLabel(id);
l5.setFont(new Font("Time new roman",Font.BOLD,30));
l5.setForeground(Color.RED);
l5.setBounds(300,90,300,30);
f.add(l5);

l2=new JLabel("Cash");
l2.setFont(f1);
l2.setBounds(100,140,200,30);
f.add(l2);

t1=new JTextField();
t1.setFont(f1);
t1.setBounds(300,140,300,30);
f.add(t1);

l3=new JLabel("Date");
l3.setFont(f1);
l3.setBounds(100,190,200,30);
f.add(l3);

l4=new JLabel();
l4.setFont(f1);
l4.setBounds(300,190,300,30);
f.add(l4);

b1=new JButton("Submit");
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

try
{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/bankdetails","root","");
ps=con.prepareStatement("select curdate()");
rs=ps.executeQuery();
if(rs.next())
l4.setText(rs.getString(1));
else
JOptionPane.showMessageDialog(f,"problem in date");
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
int l=t1.getText().length();
if(l<6)
{}
else
ke.consume();
}
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b1)
{
amount=Integer.parseInt(t1.getText());
try
{
ps=con.prepareStatement("select now()");
rs=ps.executeQuery();
if(rs.next())
date=rs.getString(1);
else
JOptionPane.showMessageDialog(f,"problem in date");
ps=con.prepareStatement("select balance from signup where custid=?");
ps.setString(1,id);
rs=ps.executeQuery();
if(rs.next())
{
int bal=rs.getInt("balance");
if(bal<amount)
JOptionPane.showMessageDialog(f,"Amount not avaliable");
else
{
ps=con.prepareStatement("update signup set balance=? where custid=?");
ps.setInt(1,bal-amount);
ps.setString(2,id);
int r=ps.executeUpdate();
if(r>0)
{
ps=con.prepareStatement("insert into transaction values(?,?,?,?)");
ps.setString(1,id);
ps.setString(2,date);
ps.setInt(3,amount);
ps.setString(4,"W");
int i=ps.executeUpdate();
if(i>0)
JOptionPane.showMessageDialog(f,"Transaction Successfull");
else
JOptionPane.showMessageDialog(f,"Transaction not Successfull");
}
else
{
JOptionPane.showMessageDialog(f,"Problem in Transaction t");
}
}
}
else
JOptionPane.showMessageDialog(f,"Problem in Transaction s");
}
catch(Exception e)
{
JOptionPane.showMessageDialog(f,e);
}
}
else if(ae.getSource()==b2)
{
f.setVisible(false);
}
}
}