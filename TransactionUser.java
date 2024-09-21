import javax.swing.*;
import java.awt.*;
import javax.swing.table.*;
import java.sql.*;

class TransactionUser
{
JFrame f;
JTable jt;
DefaultTableModel model;
Connection con;
PreparedStatement st;
ResultSet rs;
String id,dt,type;
int amount;
JLabel l;
JTextField t;
TransactionUser()
{}
TransactionUser(String cust)
{
id=cust;
f=new JFrame("Transaction Report");
f.setSize(700,700);
f.setLocationRelativeTo(null);
f.setResizable(false);
f.setLayout(null);

t=new JTextField();
t.setBounds(300,600,250,30);
t.setFont(new Font("time new roman",Font.BOLD,20));
f.add(t);
t.setEditable(false);

l=new JLabel("Total Balance");
l.setBounds(100,600,150,30);
l.setFont(new Font("time new roman",Font.BOLD,20));
f.add(l); 

jt=new JTable();
String heads[]={"Customer id","Date","Amount","Type"};
model=new DefaultTableModel();
jt.setModel(model);
model.setColumnIdentifiers(heads);
try
{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/bankdetails","root","");
st=con.prepareStatement("select custid,date,amount,transtype from Transaction where custid=?");
st.setString(1,id);
rs=st.executeQuery();
while(rs.next())
{
id=rs.getString(1);
dt=rs.getString(2);
amount=rs.getInt(3);
type=rs.getString(4);

model.addRow(new Object[]{id,dt,amount,type});
}
st=con.prepareStatement("select balance from signup where custid=?");
st.setString(1,id);
rs=st.executeQuery();
if(rs.next())
t.setText(rs.getString(1));
}
catch(Exception e)
{
JOptionPane.showMessageDialog(f,e);
}
JScrollPane js=new JScrollPane(jt);
js.setBounds(50,50,600,500);
f.add(js);
f.setVisible(true);
}
}