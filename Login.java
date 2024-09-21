//sign in page
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
class Login implements ActionListener,KeyListener
{
JFrame f;
JLabel l1,l2,l3,back;
JButton b1,b2,b3,b4;
JTextField t1;
JPasswordField pf1;
Font f1;
ForgotPassword fp;
SignUp ss;
Connection con;
PreparedStatement ps;
ResultSet rs;
Login()
{
f=new JFrame("AUTOMATED TELLER MACHINE");
f.setSize(700,800);
f.setLayout(null);
f.setLocationRelativeTo(null);
f.setResizable(false);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
f1=new Font("Times New Roman",Font.BOLD,50);

ImageIcon icon=new ImageIcon("background2.jpg");
back=new JLabel(icon);
back.setBounds(0,0,700,900);
f.add(back);

l1=new JLabel("WELCOME TO SBI");
l1.setBounds(100,50,500,80);
back.add(l1);
l1.setFont(f1);
l1.setForeground(Color.BLUE);
f1=new Font("Times New Roman",Font.BOLD,25);

l2=new JLabel("Customer Id",JLabel.CENTER);
l2.setBounds(125,230,150,50);
l2.setFont(f1);
l2.setOpaque(true);
l2.setForeground(Color.WHITE);
l2.setBackground(Color.BLACK);
back.add(l2);

l3=new JLabel("Pin",JLabel.CENTER);
l3.setBounds(125,330,150,50);
l3.setFont(f1);
l3.setOpaque(true);
l3.setBackground(Color.BLACK);
l3.setForeground(Color.WHITE);
back.add(l3);

b1=new JButton("Sign in");
b1.setBounds(75,480,150,50);
back.add(b1);
b1.setFont(f1);

b2=new JButton("Sign up");
b2.setBounds(275,480,150,50);
back.add(b2);
b2.setFont(f1);

b3=new JButton("Forget Password");
b3.setBounds(225,580,250,50);
back.add(b3);
b3.setFont(f1);

b4=new JButton("Reset");
b4.setBounds(475,480,150,50);
back.add(b4);
b4.setFont(f1);

t1=new JTextField();
t1.setBounds(350,240,175,40);
back.add(t1);

pf1=new JPasswordField();
pf1.setBounds(350,340,175,40);
back.add(pf1);

b1.addActionListener(this);
b3.addActionListener(this);
b2.addActionListener(this);
b4.addActionListener(this);
t1.addKeyListener(this);
pf1.addKeyListener(this);

//database connectivity
try
{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdetails","root","");
}
catch(Exception e)
{JOptionPane.showMessageDialog(null,e);}
f.setVisible(true);
}
public void actionPerformed(ActionEvent ae)//event handling
{
if(ae.getSource()==b1)
{
String id=t1.getText();
String pin=pf1.getText();
try
{
if(id.equals("")||pin.equals(""))
JOptionPane.showMessageDialog(f,"Enter your Details");
else
{
ps=con.prepareStatement("select role from signup where custid=? and pin=?");
ps.setString(1,id);
ps.setString(2,pin);
rs=ps.executeQuery();
if(rs.next())
{
String srole=rs.getString("role");
if(srole.equals("Admin"))
{
JOptionPane.showMessageDialog(null,"welcome Admin");
HomeAdmin ha=new HomeAdmin();
}
else
{
JOptionPane.showMessageDialog(null,"welcome User");
HomeUser hu=new HomeUser(id);
}
}
else
JOptionPane.showMessageDialog(null,"Invalid customer_id/pin");
}
}
catch(Exception e)
{
JOptionPane.showMessageDialog(null,e);
}
}
else if(ae.getSource()==b2)
{
ss=new SignUp();
f.setVisible(false);
}
else if(ae.getSource()==b3)
{
f.setVisible(false);
fp=new ForgotPassword();
}
else if(ae.getSource()==b4)
{
t1.setText(null);
pf1.setText(null);
}
}
public void keyPressed(KeyEvent ke)
{}
public void keyReleased(KeyEvent ke)
{}
public void keyTyped(KeyEvent ke)//apply validations 
{
char ch=ke.getKeyChar();
if(ch>='0'&&ch<='9')
{}
else
ke.consume();
if(ke.getSource()==t1)
{
int l=t1.getText().length();
if(l<6)
{}
else
ke.consume();
}
else if(ke.getSource()==pf1)
{
int l=pf1.getText().length();
if(l<4)
{}
else
ke.consume();
}
}
public static void main(String... aa)
{
Login l=new Login();
}
}