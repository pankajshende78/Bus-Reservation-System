package login;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class userdata extends JFrame implements ActionListener{
	JTable table;
	JButton load,back;
	JLabel bg,firstname,lastname,username,password,repassword;
	userdata()
	{
		setVisible(true);
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 150, 1100, 600);
		setTitle("usertable");

	
				        
		
		load=new JButton("Load Data");
		back=new JButton("Back");
		
		

		
		Container c=getContentPane();
		
	    ImageIcon bgicon=new ImageIcon("C:\\Users\\Hp\\Documents\\Apple\\Busmanagement\\src\\login\\tb1.jpg");
	     bg=new JLabel( bgicon,JLabel.CENTER);
	

				
		
		load.setBounds(60, 150, 110, 40);
		back.setBounds(200, 150, 110, 40);
		bg.setBounds(0, 0, 1100, 600);

		
		
		
		
		add(load);
		add(back);
		add(bg);
		


		load.addActionListener(this);
		back.addActionListener(this);
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==load)
		{
           userdatatable u=new userdatatable();
			u.setVisible(true);
			
	  }
		 if(e.getSource()==back)
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
