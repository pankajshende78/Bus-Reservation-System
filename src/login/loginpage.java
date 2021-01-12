package login;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;

public class loginpage extends JFrame implements ActionListener   {
	 JLabel l1,l2,bg,l3,l4;
	 JTextField t1;
	 JPasswordField t2;
	 JButton btn1,btn2;
	 JComboBox cb1;
	 String value="";
	 
	
	loginpage()
	{
		
			
		    final int WIDTH =270;
		    final int HEIGHT=220;
		    setSize(500,500);
		    setVisible(true);
		    setBounds(250, 150, 1100, 600);
		
		    setTitle("TRAVEL");
		    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    setLayout(null);
		    
		    setResizable(false);
		   
		    
		    ImageIcon bgicon=new ImageIcon("C:\\Users\\Hp\\Documents\\Apple\\Busmanagement\\src\\login\\bg1.jpg");
		     bg=new JLabel( bgicon,JLabel.CENTER);
		     
		    String n[]= {"--SELECT--","Admin","Other"};
		     
		   
		    l1=new JLabel("-: WELCOME :-");
		    l2=new JLabel("USERNAME :");
		    l3=new JLabel("PASSWORD :");
		    l4=new JLabel("USER TYPE");
		    t1=new JTextField(15);
		    t2=new JPasswordField(15);
		    cb1=new JComboBox(n);
		    
		    

		   		  
		    l2.setForeground(Color.WHITE);
		    l3.setForeground(Color.WHITE);
		    l4.setForeground(Color.WHITE);
		   
		    btn1=new JButton("Login");
		    btn2=new JButton("Create Account");
		    
		    add(l1);
		    add(l2);
		    add(l3);
		    add(l4);
		    add(t1);
		    add(t2);
		    add(btn1);
		    add(btn2);
		    add(cb1);
		    add(bg);
		 
		    
		    l1.setBounds(450, 25, 990,200);
		    Font f=new Font("italic", Font.HANGING_BASELINE, 30);
		    l1.setFont(f);
		   
		    l2.setBounds(480, 195, 960, 60);
		    t1.setBounds(570, 215, 150, 25);
		    l3.setBounds(480, 250, 960, 60);
		    l4.setBounds(500, 400, 100, 28);
		    t2.setBounds(570, 265, 150, 25);
		  
		    btn1.setBounds(500, 330, 100,28);
		    btn2.setBounds(610, 330, 150, 28);
		    bg.setBounds(0, 0, 1100, 600);
		    cb1.setBounds(580, 400, 100, 28);
		    
		  
		
		    
		    btn1.addActionListener(this);  
		    btn2.addActionListener(this);
		  }
	     
	          public void actionPerformed(ActionEvent e) {        //Action Listner 
				if(e.getSource()==btn1)
				{
					 value=cb1.getSelectedItem().toString();
				
				
				if(value=="Other")
				{
//					String s1=t1.getText();					
//					String s2=t2.getText(); 
					try
					{
						String username=t1.getText();
						String password=t2.getText();
						 
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pankaj","root","root");
//						Statement st=con.createStatement();
						PreparedStatement pst=con.prepareStatement("select * from busdata1 where username=? and password=?");
						pst.setString(1, username);
						pst.setString(2, password);
						
						ResultSet rs=pst.executeQuery();
						
						if(rs.next())
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
						
					     else
						{
							JOptionPane.showMessageDialog(btn1, "incorrect username and password","Error",JOptionPane.ERROR_MESSAGE);
						}
						
						
					}
					catch(Exception e1)
					{
				        e1.printStackTrace();
					}
					


				}
				
				
				else if(value=="Admin")
				{

					String s3=t1.getText();					
					String s4=t2.getText();
					if(s3.equals("admin")&&s4.equals("admin"))
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
					

				    else
					{
						JOptionPane.showMessageDialog(btn1, "incorrect username and password","Error",JOptionPane.ERROR_MESSAGE);
					}
					
					
				}
				} 
				else if(e.getSource()==btn2)
				{
					newAcount na=new newAcount();
					 
					 na.setVisible(true);
					 na.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				     na.setLayout(null);
				     
					 na.setResizable(false);
					
					 Container c1=na.getContentPane();
					
					
					
				
					
					
					
					 }
	          }
				
			
	
			 public static void main(String[] args) {
		 		loginpage frame=new loginpage ();
		 		 Container c= frame.getContentPane();
				    c.setLayout(null);
				    c.setBackground(Color.LIGHT_GRAY);
				
				 
				    
			 
	 }
}



		
			    



