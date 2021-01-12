package login;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class clock extends JFrame{
	JTextField timeF;
	JPanel panel;
	clock()
	{      setSize(225,200);
	       setVisible(true);
	       setResizable(true);
	       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	       panel=new JPanel();
	       panel.setLayout(new FlowLayout());
		   timeF=new JTextField();
		   timeF.setEditable(false);
		   timeF.setFont(new Font("Arial",Font.PLAIN,10));
		   
		  add(timeF);
		  Timer t=new Timer(1000,new Listener());
		  t.start();
	}
	class Listener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Calendar r=Calendar.getInstance();
			int h=r.get(Calendar.HOUR_OF_DAY);
			int m=r.get(Calendar.MINUTE);
			int s=r.get(Calendar.SECOND);
			timeF.setText(h+":"+m+":"+s);
			
		}
	}

}
