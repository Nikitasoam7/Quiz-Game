import java.text.*;
import java.util.Date;
import javax.swing.*;
import java.awt.*;
import com.toedter.calender.JDateChooser;
class Datesdemo
{
JFrame f;
JLabel l;
JDateChooser j;
Datesdemo()
{
f=new JFrame("Date");
f.setSize(500,500);
f.setLayout(null);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

l=new JLabel("Date");
l.setBounds(50,50,80,30);
l.setFont(new Font("Time new roman",Font.BOLD,20));
f.add(l);
/*
date=new com.toedter.calender.JDateChooser();
DateFormat da=new SimpleDateFormat("yyyy-mm-dd");
String dt=da.format(date.getDate());*/

com.toedter.calender.JDateChooser=new com.toedter.calender.JDateChooser();
JDateChooser j=new JDateChooser();
f.add(j);

f.setVisible(true);
}
public static void main(String... aa)
{
Datesdemo dd=new Datesdemo();
}
}