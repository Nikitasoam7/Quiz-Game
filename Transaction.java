//Accounts Report
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.sql.*;

class Transaction
{
JFrame f;
JTable jt;
DefaultTableModel model;
Connection con;
PreparedStatement st;
ResultSet rs;
String id,nm,fname,email;
int balance;
JLabel l;
JTextField t;
Transaction()
{
f=new JFrame("Accounts Report");
f.setSize(900,700);
f.setLocationRelativeTo(null);
f.setResizable(false);
f.setLayout(null);

jt=new JTable();
String heads[]={"Customer id","Name","Balance","Email","Father's name"};
model=new DefaultTableModel();
jt.setModel(model);
model.setColumnIdentifiers(heads);
try
{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/bankdetails","root","");
String user="user";
st=con.prepareStatement("select custid,name,balance,email,father_name from signup where role=?");
st.setString(1,user);
rs=st.executeQuery();
while(rs.next())
{
id=rs.getString(1);
nm=rs.getString(2);
balance=rs.getInt(3);
email=rs.getString(4);
fname=rs.getString(5);
model.addRow(new Object[]{id,nm,balance,email,fname});
}
}
catch(Exception e)
{
JOptionPane.showMessageDialog(f,e);
}
JScrollPane js=new JScrollPane(jt);
js.setBounds(50,50,780,550);
f.add(js);

f.setVisible(true);
}
}