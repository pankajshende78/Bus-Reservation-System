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

public class busview extends JFrame implements ActionListener {
	 JTable table;
	JButton load,back;
	
	
	String  x []= {"busno","bustype","bustime"};
	String y[][]=new String [50][50];

	busview()
	{
		 
		  setTitle("user login data");
		  setBounds(350, 225, 800, 480);
  try
  {

	int i=0,j=0;
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dataupdate","root","root");
	Statement st=con.createStatement();
	//PreparedStatement pst=con.prepareStatement("select * from busdata");
	ResultSet rs=st.executeQuery("select * from updatetable");
	while(rs.next())
	{
		y[i][j++]=rs.getString("busno");
		y[i][j++]=rs.getString("bustype");
		y[i][j++]=rs.getString("bustime");
		
		i++;
		j=0;
		
		
	}
	
	table=new JTable(y,x);

	

	
}
catch(Exception ee)
{
	JOptionPane.showMessageDialog(null, ee);
}
  back=new JButton("BACK");
  add(back,"South");

 JScrollPane sp=new JScrollPane(table);
 add(sp);
 back.addActionListener(this);
}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==back)
		{
			 Home h=new Home();
			 h.setVisible(true);
			 h.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			 h.setSize(1100, 600);
			 h.setLayout(null);
			 h.setTitle("TRAVEL");
			 h.setResizable(false);
			 h.setBounds(250, 150, 1100, 600);
			 Container c1=h.getContentPane();
			 c1.setBackground(Color.GRAY);
			 this.dispose();
		}
		
	}

		 
		 
		
}
	


