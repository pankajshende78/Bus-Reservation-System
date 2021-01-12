package login;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



public class newAcount extends JFrame implements ActionListener{
	JLabel l,l1,l2,l3,l4,l5,bg1;
	JTextField t1,t2,t3;
	JPasswordField t4,t5;
	JButton btn1,btn2;
	
	newAcount()
	{
		l=new JLabel("-: Fill The Details :- ");
		l1=new JLabel("FIRST NAME :");
		l2=new JLabel("LAST NAME :");
		l3=new JLabel("USERNAME");
		l4=new JLabel("PASSWORD");
		l5=new JLabel("RE-PASSWORD");
		btn1=new JButton("Submit");
		btn2=new JButton("Back");
		Container c=getContentPane();
	
		
		
		
	    ImageIcon bgicon1=new ImageIcon("C:\\Users\\Hp\\Documents\\Apple\\Busmanagement\\src\\login\\bg1.jpg");
	     bg1=new JLabel( "",bgicon1,JLabel.CENTER);
		
		t1=new JTextField();
		t2=new JTextField();
		t3=new JTextField();
		t4=new JPasswordField();
		t5=new JPasswordField();
		add(l);
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(l5);
		add(t1);
		add(t2);
		add(t3);
		add(t4);
		add(t5);
		add(btn1);
		add(btn2);
		add(bg1);
		
		l.setForeground(Color.WHITE);
		l1.setForeground(Color.WHITE);
		l2.setForeground(Color.WHITE);
		l3.setForeground(Color.WHITE);
		l4.setForeground(Color.WHITE);
		l5.setForeground(Color.WHITE);
		setTitle("New-Account");
		setVisible(true);
	    setSize(500, 400);
		setResizable(false);	
		setLayout(null);
		
		setBounds(700, 200, 350, 500);
		l.setBounds(115, 5, 115, 80);
		l1.setBounds(45, 80, 100, 20);
		l2.setBounds(45, 130, 100, 20);
		l3.setBounds(45, 180, 100, 20);
		l4.setBounds(45, 230, 100, 20);
		l5.setBounds(35, 280, 100, 20);
		t1.setBounds(135, 82, 140, 20);
		t2.setBounds(135, 131, 140, 20);
		t3.setBounds(135, 180, 140, 20);
		t4.setBounds(135, 229, 140, 20);
		t5.setBounds(135, 278, 140, 20);
		bg1.setBounds(0, 0, 350, 500);
		
		btn1.setBounds(60, 345, 90, 30);
		btn2.setBounds(180, 345, 90, 30);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn2)
		{
			loginpage p=new loginpage();
			p.setVisible(true);
			p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    this.dispose();
			}
		if(e.getSource()==btn1)
		{
			try
			{
				String firstname=t1.getText();
				String lastname=t2.getText();
				String username=t3.getText();
				String password=t4.getText();
				String repassword=t5.getText();
				
				if(password.equals(repassword))
				{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pankaj","root","root");
//				Statement st=con.createStatement();
				PreparedStatement pst=con.prepareStatement("insert into busdata1 values(?,?,?,?)");
				pst.setString(1, firstname);
				pst.setString(2, lastname);
				pst.setString(3, username);
			    pst.setString(4, password);
				
				
				pst.executeUpdate();  
				
					JOptionPane.showMessageDialog(l3, "THANK YOU"," ",JOptionPane.INFORMATION_MESSAGE);
				
				
				
			    }
				else
				{
					JOptionPane.showMessageDialog(l3, "INCORRECT USERNAME AND PASSWORD"," ",JOptionPane.ERROR_MESSAGE);
				}
			}
			
			catch(Exception e1)
			{
		      e1.printStackTrace();
			}
		}
			
		}
	
	
	
		
	}


