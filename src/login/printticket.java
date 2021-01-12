package login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class printticket extends JFrame  implements ActionListener{
	JTable table;
	
	  
			String  x []= {"Date","From","To","Setno","Type","Name","MobileNo"};
			String y[][]=new String [50][50];
	
	JButton print;
	JPanel panel;
	JLabel l1,l2;
	JTextField t1,t2;
	
	printticket()
	{
		setTitle("ticket print");
		l1=new JLabel();
		l1.setText("Name");
		t1=new JTextField(15);
		l2=new JLabel();
		l2.setText("Mobileno");
		t2=new JTextField(15);
		print=new JButton("submit");
		panel =new JPanel(new GridLayout(3,1));
		panel.add(l1);
		panel.add(t1);
		panel.add(l2);
		panel.add(t2);
		panel.add(t2);
		panel.add(print);
		add(panel,BorderLayout.CENTER);
		
		
		print.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==print)
				{
					try
					{
						String p1=t1.getText();
						String p2=t2.getText();
						 
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/reservation1","root","root");
//						Statement st=con.createStatement();
						PreparedStatement pst=con.prepareStatement("select * from newreservation where p1=? and p2=? ");
						pst.setString(1, p1);
						pst.setString(2, p2);
						ResultSet rs=pst.executeQuery();
						while(rs.next())
						{
							int i=0,j=0;
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
						table.print();
						
					    
						
					}
					catch(Exception e1)
					{
				        e1.printStackTrace();
					}
					
				}
			}
		});
		
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	
	
}
	