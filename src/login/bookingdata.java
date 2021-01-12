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

public class bookingdata  extends JFrame implements ActionListener {
	JTable table;
	JButton b1;
	  
			String  x []= {"Date","From","To","Setno","Type","Name","MobileNo"};
			String y[][]=new String [50][50];
	
		
	
	bookingdata()
	{
		
		 setTitle("User Booking data");
		  setBounds(350, 225, 800, 480);
   try
   {
 
	int i=0,j=0;
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/reservation1","root","root");
	Statement st=con.createStatement();
	//PreparedStatement pst=con.prepareStatement("select * from busdata");
	ResultSet rs=st.executeQuery("select * from newreservation");
	while(rs.next())
	{
		y[i][j++]=rs.getString("bdate");
		y[i][j++]=rs.getString("bfrom");
		y[i][j++]=rs.getString("bto");
		y[i][j++]=rs.getString("setno");
		y[i][j++]=rs.getString("btype");
		y[i][j++]=rs.getString("cname");
		y[i][j++]=rs.getString("mobileno");
		i++;
		j=0;
		
		
	}
	
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
			 adminpage h1=new adminpage();
			 h1.setVisible(true);
			 h1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			 h1.setSize(1100, 600);
			 h1.setLayout(null);
			 h1.setTitle("ADMIN");
			 h1.setResizable(false);
			 h1.setBounds(250, 150, 1100, 600);
			 Container c1=h1.getContentPane();
			 c1.setBackground(Color.GRAY);
			 this.dispose();
		}
		
		
	}
	
	
	
	

}
