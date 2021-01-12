package login;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class adminpage extends JFrame implements ActionListener {
	JButton btn1,btn2,btn3,btn4,btn5;
	JLabel bg;
	
	adminpage()
	{
    setLayout(null);
	btn1=new JButton("USERDATA");
	btn2=new JButton("BOOKING DATA");
	btn3=new JButton("TIME UPDATE");
	btn4=new JButton("FARE WINDOW");
	btn5=new JButton("LOGOUT");
	ImageIcon bgicon=new ImageIcon("C:\\Users\\Hp\\Documents\\Apple\\Busmanagement\\src\\login\\bg1.jpg");
     bg=new JLabel( bgicon,JLabel.CENTER);
   


	add(btn1);
	add(btn2);
	add(btn3);
	add(btn4);
	add(btn5);
	  add(bg);
	btn1.setBounds(70, 80, 190, 65);
	btn2.setBounds(310, 80, 190, 65);
	btn3.setBounds(550, 80, 190, 65);
	btn4.setBounds(790, 80, 190, 65);
	btn5.setBounds(880, 490, 100, 40);
	bg.setBounds(0, 0, 1100, 600);
	
	btn1.addActionListener(this);
	btn2.addActionListener(this);
	btn3.addActionListener(this);
	btn4.addActionListener(this);
	btn5.addActionListener(this);
		 
		   
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		 if(e.getSource()==btn1)
		 {
             userdata v=new userdata();
			 v.setVisible(true);
			 v.setDefaultCloseOperation(v.EXIT_ON_CLOSE);
			 this.dispose();
		 }
		  if(e.getSource()==btn2)
		 {
			  bookingdata u=new bookingdata();
				u.setVisible(true);
				this.dispose();
		 }
		  if(e.getSource()==btn3)
		 {
			  busadmin a=new busadmin();
			 a.setVisible(true);
			 a.setDefaultCloseOperation(a.EXIT_ON_CLOSE);
			 this.dispose();
		 }
		  if(e.getSource()==btn4)
		 {
			  fareupdate f=new fareupdate();
			  f.setVisible(true);
			  f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		 }
		  if(e.getSource()==btn5)
		 {
			    loginpage p=new loginpage();
				p.setVisible(true);
				p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			 this.dispose();
		 }
		
	}

}
