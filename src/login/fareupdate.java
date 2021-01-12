package login;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

public class fareupdate extends JFrame implements ActionListener {
	JButton insert,delete,load1,back1;
	JTextField t1,t2,t3,t4,t5,t6,t7;
	JLabel desti,fare,time,busno1,type1,time1,busno2;
	JTable table1;
	fareupdate()
	{
		setBounds(250, 150, 1100, 600);
		setLayout(null);
		setTitle("Fare update");
		
		table1=new JTable();
		
		insert=new JButton("INSERT");
		
		delete=new JButton("DELETE");
		load1=new JButton("LOAD");
		back1=new JButton("Back");
		
		t1=new JTextField(15);
		t2=new JTextField(15);
		t3=new JTextField(15);
		t4=new JTextField(15);
		t5=new JTextField(15);
		t6=new JTextField(15);
		t7=new JTextField(15);
		
		desti=new JLabel("DESTINATION");
		fare=new JLabel(" FARE");
		
		busno2=new JLabel("DESTINATION");
		
		add(insert);
		add(delete);
		
		add(t1);
		add(t2);
		

		add(t7);
		
		add(fare);
		add(desti);
	

		
		add(busno2);
		add(table1);
		add(load1);
		add(back1);
		
		
   load1.setBounds(20, 330, 100, 28);
   back1.setBounds(20, 400, 100, 28);
		
	insert.setBounds(20, 20, 100, 30);
	t1.setBounds(150, 22, 150, 25);
	t2.setBounds(330, 22, 150, 25);
	t3.setBounds(510, 22, 150, 25);
	
	desti.setBounds(180, 45, 100, 25);
	fare.setBounds(370, 45, 100, 25);
	
	delete.setBounds(20, 130, 100,28);
	t7.setBounds(150, 135, 150, 25);
	busno2.setBounds(180, 156, 100, 25);
	
	table1.setBounds(200, 250, 700,250 );
	
	
	
	
		
		insert.addActionListener(this);
		
		delete.addActionListener(this);
		load1.addActionListener(this);
		back1.addActionListener(this);
		
		
		
		
		
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==insert)
		{
			String destination=t1.getText();
			String fare=t2.getText();
			
			try {
				int i;
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/faretable","root","root");
			Statement st=con.createStatement();
			PreparedStatement pst=con.prepareStatement("insert into farewindow values(?,?)");
			pst.setString(1, destination);
			pst.setString(2, fare);
			
			pst.executeUpdate();
		   }
			catch(Exception ep)
			{
				JOptionPane.showMessageDialog(null, ep);
			}
		}

		if(e.getSource()==delete)
		{
			String destination=t7.getText();
			try {
			int i;
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/faretable","root","root");
			Statement st=con.createStatement();
			PreparedStatement pst=con.prepareStatement("DELETE FROM farewindow  WHERE destination=?");
			pst.setString(1, destination);
			
			i=pst.executeUpdate();
		       }
			catch(Exception ep)
			{
				JOptionPane.showMessageDialog(null, ep);
			}
			
		}
		if(e.getSource()==load1)
			{
	        try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/faretable","root","root");
//				Statement st=con.createStatement();
				PreparedStatement pst1=con.prepareStatement("select * from farewindow ");
				ResultSet rs=pst1.executeQuery();
				table1.setModel(DbUtils.resultSetToTableModel(rs));
			}
			catch(Exception ee)
			{
				JOptionPane.showMessageDialog(null, e);
			}
		  }
		if(e.getSource()==back1)
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
