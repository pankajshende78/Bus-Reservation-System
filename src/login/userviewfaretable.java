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

public class userviewfaretable extends JFrame implements ActionListener {
	JTable table;
	JButton b1;
	  
			String  x []= {"Destination","fare"};
			String y[][]=new String [50][50];
	
		
		
			userviewfaretable(){
		  
		  setTitle("FARE TABLE");
		  setBounds(700, 200, 350, 500);
    try
    {
  
	int i=0,j=0;
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/faretable","root","root");
	Statement st=con.createStatement();
	//PreparedStatement pst=con.prepareStatement("select * from busdata");
	ResultSet rs=st.executeQuery("select * from farewindow");
	while(rs.next())
	{
		y[i][j++]=rs.getString("destination");
		y[i][j++]=rs.getString("fare");
		
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
				}
				
			}

}
