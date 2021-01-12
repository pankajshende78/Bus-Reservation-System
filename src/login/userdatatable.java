package login;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;



public class userdatatable extends JFrame implements ActionListener{
	JTable table;
	JButton b1;
	  
			String  x []= {"name","lastname","Username","Password",};
			String y[][]=new String [50][50];
	
		
		
	  userdatatable(){
		  
		  setTitle("user login data");
		  setBounds(350, 225, 800, 480);
    try
    {
  
	int i=0,j=0;
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pankaj","root","root");
	Statement st=con.createStatement();
	//PreparedStatement pst=con.prepareStatement("select * from busdata");
	ResultSet rs=st.executeQuery("select * from busdata1");
	while(rs.next())
	{
		y[i][j++]=rs.getString("name");
		y[i][j++]=rs.getString("lastname");
		y[i][j++]=rs.getString("Username");
		y[i][j++]=rs.getString("Password");
//		y[i][j++]=rs.getString("repassword");
		i++;
		j=0;
		
		
	}
	//table.setModel(DbUtils.resultSetToTableModel(rs));
	table=new JTable(y,x);
	
}
catch(Exception ee)
{
	JOptionPane.showMessageDialog(null, ee);
}
    b1=new JButton("BACK");
    add(b1,"South");
  
   JScrollPane sp=new JScrollPane(table);
   add(sp);
   b1.addActionListener(this);
}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1)
		{
			userdata u=new userdata ();
			u.setVisible(true);
			this.dispose();
		}
	
		
	}
	
}


  
