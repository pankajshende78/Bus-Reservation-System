package login;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.AncestorListener;

public class Home extends JFrame implements ActionListener {

	JButton btn1,btn2,btn3,btn4;
	JLabel bg;
	  
	
	  
	Home()
	{
		

		
		setLayout(null);
		btn1=new JButton("Reservation");
		btn2=new JButton("Available Bus");
		btn3=new JButton("fare window");
		btn4=new JButton("Logout");
		ImageIcon bgicon=new ImageIcon("C:\\Users\\Hp\\Documents\\Apple\\Busmanagement\\src\\login\\bg1.jpg");
	     bg=new JLabel( bgicon,JLabel.CENTER);
	   
	
	
		add(btn1);
		add(btn2);
		add(btn3);
		add(btn4);
		  add(bg);
		btn1.setBounds(70, 80, 190, 65);
		btn2.setBounds(310, 80, 190, 65);
		btn3.setBounds(550, 80, 190, 65);
		btn4.setBounds(790, 80, 190, 65);
		bg.setBounds(0, 0, 1100, 600);
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn4.addActionListener(this);
		btn3.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn4)
		{
		loginpage p=new loginpage();
		p.setVisible(true);
		p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.dispose();
		}
		if(e.getSource()==btn1)
		{
			reservationbus r=new reservationbus();
			r.setVisible(true);
			r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.dispose();
	    }
		if(e.getSource()==btn2)
		{
			busview b=new busview();
			b.setVisible(true);
			b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		if(e.getSource()==btn3)
		{
			userviewfaretable u=new userviewfaretable();
			u.setVisible(true);
			u.setDefaultCloseOperation(u.EXIT_ON_CLOSE);
		}
		
		
		
		
	

}
}
