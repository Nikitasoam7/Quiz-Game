//homeuserpage
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class HomeUser implements ActionListener
{
JFrame f;
JLabel l;
JMenuBar mb;
JMenu m1,m2;
JMenuItem mi1,mi2,mi4,mi5,mi6;
String id;
Font f1;
HomeUser()
{}
HomeUser(String cid)
{
id=cid;
f=new JFrame("Transaction");
f.setSize(1920,1030);
f.setLayout(null);
f.setResizable(false);
f1=new Font("Time New Roman",Font.BOLD,25);

mb=new JMenuBar();
f.setJMenuBar(mb);

m1=new JMenu("Manage Transaction");
mb.add(m1);
m1.setFont(f1);
mi1=new JMenuItem("Deposit");
mi2=new JMenuItem("Withdraw");
mi1.setFont(f1);
mi2.setFont(f1);
m1.add(mi1);
m1.add(mi2);

mi4=new JMenuItem("Balance Enquiry");
mi4.setFont(f1);
m1.add(mi4);
mi5=new JMenuItem("Pin Change");
mi5.setFont(f1);
m1.add(mi5);

l=new JLabel(new ImageIcon("background1.jpg"));
l.setBounds(0,0,1920,1080);
f.add(l);

m2=new JMenu("Exit");
m2.setFont(f1);
mb.add(m2);
mi6=new JMenuItem("Exit");
mi6.setFont(f1);
m2.add(mi6);

mi1.addActionListener(this);
mi2.addActionListener(this);
mi4.addActionListener(this);
mi5.addActionListener(this);
mi6.addActionListener(this);


f.setVisible(true);
}
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==mi1)
{
Deposit d=new Deposit(id);
}
else if(ae.getSource()==mi2)
{
Withdraw w=new Withdraw(id);
}
else if(ae.getSource()==mi4)
{
TransactionUser t=new TransactionUser(id);
}
else if(ae.getSource()==mi5)
{
ChangePin cp=new ChangePin(id);
}
else if(ae.getSource()==mi6)
{
f.setVisible(false);
}
}
}