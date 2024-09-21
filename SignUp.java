//signup page
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class SignUp extends WindowAdapter implements ActionListener,KeyListener
{
JFrame f;
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13;
JTextField t1,t2,t3,t4,t5,t6;
JTextArea ta;
JButton b1,b2;
JRadioButton r1,r2,r3,r4,r5;
ButtonGroup rg1,rg2;
Font f1,f2;
Connection con;
ResultSet rs;
PreparedStatement ps;
String id;
SignUp()
{
f=new JFrame("New Account Form");
f.setSize(800,850);
f.setLocationRelativeTo(null);
f.setResizable(false);
f.setLayout(null);
f1=new Font("Time New Roman",Font.BOLD,20);

l1=new JLabel("Application Form");
l1.setFont(new Font("Time New Roman",Font.BOLD,40));
l1.setBounds(200,20,600,40);
l1.setForeground(Color.BLUE);
f.add(l1);

l2=new JLabel("Personal Details");
l2.setFont(f1);
l2.setBounds(250,70,400,35);
f.add(l2);

l3=new JLabel("Customer Id");
l3.setFont(f1);
l3.setBounds(100,140,150,30);
f.add(l3);

l4=new JLabel("Pin");
l4.setFont(f1);
l4.setBounds(100,190,200,30);
f.add(l4);

l5=new JLabel("Name");
l5.setFont(f1);
l5.setBounds(100,240,150,30);
f.add(l5);

l6=new JLabel("Father's Name");
l6.setFont(f1);
l6.setBounds(100,290,150,30);
f.add(l6);

l7=new JLabel("Date Of Birth");
l7.setFont(f1);
l7.setBounds(100,340,150,30);
f.add(l7);

l8=new JLabel("Gender");
l8.setFont(f1);
l8.setBounds(100,390,150,30);
f.add(l8);

l9=new JLabel("E-mail");
l9.setFont(f1);
l9.setBounds(100,440,150,30);
f.add(l9);

l10=new JLabel("Marital Status");
l10.setFont(f1);
l10.setBounds(100,490,150,30);
f.add(l10);

l11=new JLabel("Pin code");
l11.setFont(f1);
l11.setBounds(100,540,150,30);
f.add(l11);

l12=new JLabel("Address");
l12.setFont(f1);
l12.setBounds(100,590,150,30);
f.add(l12);

l13=new JLabel();
l13.setBounds(300,140,400,30);
l13.setFont(new Font("Time New Roman",Font.BOLD,30));
l13.setForeground(Color.RED);
f.add(l13);

t4=new JTextField();
t4.setBounds(300,340,400,30);
t4.setFont(f1);
f.add(t4);

t1=new JTextField();
t1.setBounds(300,190,400,30);
t1.setFont(f1);
f.add(t1);
t1.setText("");

t2=new JTextField();
t2.setBounds(300,240,400,30);
t2.setFont(f1);
f.add(t2);

t3=new JTextField();
t3.setBounds(300,290,400,30);
t3.setFont(f1);
f.add(t3);

t5=new JTextField();
t5.setBounds(300,440,400,30);
t5.setFont(f1);
f.add(t5);

t6=new JTextField();
t6.setBounds(300,540,400,30);
t6.setFont(f1);
f.add(t6);

ta=new JTextArea();
ta.setBounds(300,590,400,80);
ta.setFont(f1);
f.add(ta);

b1=new JButton("Submit");
b1.setBounds(225,700,150,40);
b1.setFont(f1);
f.add(b1);


b2=new JButton("Back");
b2.setBounds(425,700,150,40);
b2.setFont(f1);
f.add(b2);

rg1=new ButtonGroup();
r1=new JRadioButton("Male");
r1.setBounds(300,390,100,30);
r1.setFont(f1);
f.add(r1);
rg1.add(r1);

r2=new JRadioButton("Female");
r2.setBounds(420,390,100,30);
r2.setFont(f1);
f.add(r2);
rg1.add(r2);

rg2=new ButtonGroup();
r3=new JRadioButton("Unmarried");
r3.setBounds(300,490,130,30);
r3.setFont(f1);
f.add(r3);
rg2.add(r3);

r4=new JRadioButton("Married");
r4.setBounds(430,490,100,30);
r4.setFont(f1);
f.add(r4);
rg2.add(r4);

r5=new JRadioButton("Divorce");
r5.setBounds(540,490,100,30);
r5.setFont(f1);
f.add(r5);
rg2.add(r5);

try
{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/bankdetails","root","");
ps=con.prepareStatement("select max(custid) from signup");
rs=ps.executeQuery();
if(rs.next())
{
id=rs.getString(1);
id=String.valueOf(Integer.parseInt(id)+1);
ps=con.prepareStatement("select LPAD('"+id+"',6,'"+0+"')");
rs=ps.executeQuery();
if(rs.next())
{
id=rs.getString(1);
l13.setText(id);
}
}
}
catch(Exception e)
{
JOptionPane.showMessageDialog(null,e);
}

b1.addActionListener(this);
b2.addActionListener(this);
t1.addKeyListener(this);
t2.addKeyListener(this);
t3.addKeyListener(this);
t4.addKeyListener(this);
t6.addKeyListener(this);
t5.addKeyListener(this);
f.addWindowListener(this);

f.setVisible(true);
}
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b1)
{
try
{
String pin=t1.getText();
String nm=t2.getText();
String fn=t3.getText();
String date=t4.getText();
String em=t5.getText();
String pic=t6.getText();
String adrs=ta.getText();
String gender="";
if(r1.isSelected())
gender="Male";
else if(r2.isSelected())
gender="Female";
String mrtst="";
if(r5.isSelected())
mrtst="Divorce";
else if(r4.isSelected())
mrtst="Married";
else if(r3.isSelected())
mrtst="Unmarried";
String rol="User";
if(pin.equals("")||em.equals("")||pic.equals("")||gender.equals("")||mrtst.equals("")||nm.trim().isEmpty()||fn.trim().isEmpty()||date.trim().isEmpty()||adrs.trim().isEmpty())
{
JOptionPane.showMessageDialog(f,"Enter your details");
}
else
{
ps=con.prepareStatement("insert into signup values(?,?,?,?,?,?,?,?,?,?,?,?)");
ps.setString(1,id);
ps.setString(2,pin);
ps.setString(3,nm);
ps.setString(4,fn);
ps.setString(5,date);
ps.setString(6,gender);
ps.setString(7,em);
ps.setString(8,mrtst);
ps.setString(10,pic);
ps.setString(9,adrs);
ps.setInt(11,0);
ps.setString(12,rol);
int r=ps.executeUpdate();
if(r>0)
{
JOptionPane.showMessageDialog(null,"Account created");
id=String.valueOf(Integer.parseInt(id)+1);
ps=con.prepareStatement("select LPAD('"+id+"',6,'"+0+"')");
rs=ps.executeQuery();
if(rs.next())
{
id=rs.getString(1);
l13.setText(id);
}
t1.setText("");
t2.setText("");
t3.setText("");
t4.setText("");
t5.setText("");
t6.setText("");
ta.setText("");
r1.setSelected(false);
r2.setSelected(false);
r3.setSelected(false);
r4.setSelected(false);
r5.setSelected(false);
t1.requestFocus();
}
else
JOptionPane.showMessageDialog(null,"problem in creating account");
}
}
catch(Exception e)
{System.out.println("error" +e);}
}
else if(ae.getSource()==b2)
{
Login l=new Login();
f.setVisible(false);
}
}
public void keyPressed(KeyEvent ke)
{}
public void keyReleased(KeyEvent ke)
{}
public void keyTyped(KeyEvent ke)
{
int l;
char ch=ke.getKeyChar();
if(t1==ke.getSource()||t6==ke.getSource())
{
if(ch>='0'&&ch<='9')
{}
else 
ke.consume();
}
else if(t3==ke.getSource()||t2==ke.getSource())
{
if(ch>='a'&&ch<='z'||ch>='A'&&ch<='Z'||ch==32||ch==46)
{}
else
ke.consume();
}
else if(t5==ke.getSource()&&ch==32)
{
JOptionPane.showMessageDialog(null,"invalid character");
ke.consume();
}
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
if(l<20)
{}
else
ke.consume();
}
else if(ke.getSource()==t3)
{
l=t3.getText().length();
if(l<20)
{}
else
ke.consume();
}
else if(ke.getSource()==t4)
{
l=t4.getText().length();
if(l<11)
{}
else
ke.consume();
}
else if(ke.getSource()==t5)
{
l=t5.getText().length();
if(l<30)
{}
else
ke.consume();
}
else if(ke.getSource()==t6)
{
l=t6.getText().length();
if(l<8)
{}
else
ke.consume();
}
else if(ke.getSource()==ta)
{
l=ta.getText().length();
if(l<40)
{}
else
ke.consume();
}
}
public void windowClosing(WindowEvent we)
{
f.dispose();
Login l=new Login();
}
}