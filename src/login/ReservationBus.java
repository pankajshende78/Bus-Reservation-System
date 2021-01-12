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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class ReservationBus extends JFrame implements ActionListener {
	

	/**
	 * 
	 */

	JLabel ldate,lmonth,lyear,bustype,lfrom,lto,seat,lname,lmobile;
	JButton submit,back,print;
	JTextField t1,name,mobile;
	JComboBox fromcom,tocom,datecom,monthcom,yearcom,type,seatnum;
	
	ReservationBus()
	{
		   //  setSize(500,500);
		    setVisible(true);
		    setBounds(450,220, 800, 500);
		    setLayout(null);
		
		    setTitle("reservation page");
		    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    
		    
		    
			 

		  
		    
		    setResizable(false);
//		    
//		    ldate=new JLabel("Date");
//		    add(ldate);
//		    ldate.setBounds(30, 20, 90,50 );
		    ldate=new JLabel("Date");
		    lmonth=new JLabel("month");
		    lyear=new JLabel("year");
		    bustype=new JLabel("Bustpye");
		    lfrom=new JLabel("FROM");
		    lto=new JLabel("TO");
		    seat=new JLabel("CHOOSE BUS SEAT NO :");
		    lname=new JLabel("NAME");
		    lmobile=new JLabel("MOBILE");
		    
//		    t1=new JTextField();
		    name=new JTextField();
		    mobile=new JTextField();
		    
		    submit=new JButton("SUBMIT");
		    back=new JButton("BACK");
		    print =new JButton("PRINT-TICKET");
		   
		    
		
		    
		    
		   ldate.setBounds(30, 20, 90,50);
		    lmonth.setBounds(140, 20,90, 50);
		    lyear.setBounds(260, 20, 90,50);
		   lfrom.setBounds(30, 70, 90, 50);
		   lto.setBounds(230, 70, 90, 50);
		   seat.setBounds(30, 120, 150, 50);
		   seatnum.setBounds(200, 130, 70, 30);
		   lname.setBounds(30, 170,90,50);
		   lmobile.setBounds(30, 210, 90, 50);
		   name.setBounds(90, 190,150, 20);
		   mobile.setBounds(90, 230, 150,20);
		   submit.setBounds(580, 400,90, 30);
		   back.setBounds(680, 400, 90, 30);
		   print.setBounds(400, 400, 150, 30);
		    
		    bustype.setBounds(500, 20, 90, 50);
		    
		   
		    datecom=new JComboBox();
		    yearcom=new JComboBox();
		    
		   
		    
		    
		    String bus[]= {"AC","NON-AC"};
		    String month[]= {"Jan","feb","mar","apr","may","jun","july","aug","sep","oct","nov","dec"};
		    String from[]= {"THANE","MUMBAI","AIROLI","RABALE","GHANSOLI","TURBHE","NERUL","BELAPUR"};
		    String to[]= {"THANE","MUMBAI","AIROLI","RABALE","GHANSOLI","TURBHE","NERUL","BELAPUR"};
		    String number[]= {"AU,AV W,BB,BK W,1,2 W,3,4 W,5,6 W,7,8 W,9,10 W,11,12 W,13,14 W,15,16 W,17,18 W,19,20 W,21,22 W,23,24 W,25,26 W,27,28 W"};
		    
		    fromcom=new JComboBox(from);
		    tocom=new JComboBox(to);
		    
		    for(int i=1;i<=31;i++)
		    {
		    	datecom.addItem(i);
		    }
		    
		
		    for(int j=2018;j<=2030;j++) {
		    	yearcom.addItem(j);
		    }
		   
		    monthcom=new JComboBox(month);
		    type=new JComboBox(bus);
		    seatnum=new JComboBox(number);

		    datecom.setBounds(70, 30, 50, 30);
		    monthcom.setBounds(180, 30, 70, 30);
		    yearcom.setBounds(290, 30, 70, 30);
		    type.setBounds(580, 30, 70, 30);
		    fromcom.setBounds(90, 80, 100, 30);
		    tocom.setBounds(260, 80, 100, 30);
		    
		    add(ldate);
		    add(lmonth);
		    add(lyear);
		    
		    add(datecom); 
		    add(monthcom);
		    add(yearcom);
		    add(bustype);
		    add(type);
		    add(lfrom);
		    add(lto);
		    add(fromcom);
		    add(tocom);
		    add(seat);
		    add(seatnum);
		    add(lname);
		    add(lmobile);
		    add(name);
		    add(mobile);
		    add(submit);
		    add(back);
		    add(print);
		  
		    
		    back.addActionListener(this);
		    
		    submit.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					
					  
				    String usedate=datecom.getSelectedItem().toString();
				    String usemonth=monthcom.getSelectedItem().toString();
				    String useyear=yearcom.getSelectedItem().toString();
				    String strdate=usedate+ "/"+usemonth+"/"+useyear;
				    
				   
				     
				     try
				     {  
				    	 
				     String usefrom =fromcom.getSelectedItem().toString();
				     String useto=tocom.getSelectedItem().toString();
				     String usetype=type.getSelectedItem().toString();
				     String uset1=seatnum.getSelectedItem().toString();
				     String usename=name.getText();
				     String usemobile=mobile.getText();
				    	 
				     System.out.println("pankaj");
				    	 
				    	    Class.forName("com.mysql.cj.jdbc.Driver");
				    		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/reservation1","root","root");
				    		Statement st=con.createStatement();
				    		PreparedStatement pst=con.prepareStatement("insert into newreservation value(?,?,?,?,?,?,?)");
				    		pst.setString(1, strdate);
				    		pst.setString(2, usefrom);
				    		pst.setString(3, useto);
				    		pst.setString(4, uset1);
				    		pst.setString(5, usetype);
				    		pst.setString(6, usename);
				    		pst.setString(7, usemobile);
				    		pst.executeUpdate();
				    		
				    	   }
				    		catch(Exception ep)
				    		{
				    			JOptionPane.showMessageDialog(null, ep);
				    		}
					
					
					
					
				}
			});
		    print.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					printticket p=new printticket();
					p.setVisible(true);
				
					p.setBounds(700, 510, 340, 120);
					p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					
				}
			});
//		    
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
		}
	
		
	}
	

}
