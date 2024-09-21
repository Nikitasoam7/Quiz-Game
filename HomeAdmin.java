//homeAdminpage
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class HomeAdmin implements ActionListener
{
JFrame f;
JLabel l;
JMenuBar mb;
JMenu m1,m2;
JMenuItem mi1,mi2,mi3;
Font f1;
DelUpdAccount dl;
HomeAdmin()
{
f=new JFrame("Transaction Admin");
f.setSize(1920,1030);
f.setLayout(null);
f.setResizable(false);
f1=new Font("Time New Roman",Font.BOLD,25);

mb=new JMenuBar();
f.setJMenuBar(mb);

l=new JLabel(new ImageIcon("background1.jpg"),JLabel.CENTER);
l.setBounds(0,0,1920,1080);
f.add(l);

m1=new JMenu("Details");
mb.add(m1);
m1.setFont(f1);
mi1=new JMenuItem("Manage Account");
mi2=new JMenuItem("Report Account");
mi1.setFont(f1);
mi2.setFont(f1);
m1.add(mi1);
m1.add(mi2);

m2=new JMenu("Exit");
m2.setFont(f1);
mb.add(m2);
mi3=new JMenuItem("Exit");
mi3.setFont(f1);
m2.add(mi3);

mi1.addActionListener(this);
mi2.addActionListener(this);
mi3.addActionListener(this);

f.setVisible(true);
}
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==mi1)
dl=new DelUpdAccount();
else if(ae.getSource()==mi2)
{
Transaction ta=new Transaction();
}
else if(ae.getSource()==mi3)
{
f.setVisible(false);
}
}
}