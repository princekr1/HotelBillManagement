package UserInterface;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import InputOutput.IO_Admin;
import Model.Room;
public class AddRoom implements ActionListener {
	private JFrame jf;
	private JPanel jp;
	private JButton b1,b2,b3;
	private JTextField t1,t2,t3;
	private JLabel l1,l2,l3,l4,l5,l6,msg,lroom,logo;
	private JRadioButton r1,r2;
	private ButtonGroup bg;
	private JComboBox jc;
	private JTextArea ta;
	AddRoom()
	{
		lroom=new JLabel();
		logo=new JLabel();
		lroom.setIcon(new ImageIcon(this.getClass().getResource("images/Room.jpeg")));
  	     lroom.setBounds(500,100, 470, 460);
  	   logo.setIcon(new ImageIcon(this.getClass().getResource("images/logos.jpg")));
	     logo.setBounds(815,20, 200, 80);
  	     
		jf=new JFrame();
		jp=new JPanel();
		jf.add(jp);
		
		jp.add(logo);
		jp.add(lroom);
		t1=new JTextField();
		t2=new JTextField();
		b1=new JButton("Cancel");
		b2=new JButton("Reset");
		b3=new JButton("Add");
		l6=new JLabel("Room Rate");
		jp.setBackground(Color.blue);
		
	
		//jf.add(jp);
		jp.add(b1);
		jp.setLayout(null);
		JTable jt;		
		 JScrollPane js;
		String []s={"Select","Single","Double","Family"};
		jf=new JFrame("Add Room");
		jc=new JComboBox(s);
		jc.setSize(100,30);
		jc.setLocation(200,200);
		l1=new JLabel("Room Type:");
		l2=new JLabel("Room Catagory:");
		l3=new JLabel("Room No");
		l4=new JLabel("Room Feature");
		l5=new JLabel("prince");
		ta=new JTextArea();
		bg=new ButtonGroup();
		r1=new JRadioButton("Ac");
		r2=new JRadioButton("Non Ac");
		
        
		jf.add(jp);
		jp.add(jc);
		jp.add(r2);
		jp.add(r1);
		jp.add(l6);
		//jp.add(jt);
		//jp.add(js);
		bg.add(r1);
		bg.add(r2);
		jp.add(l1);
		jp.add(l2);
		jp.add(l3);
		jp.add(l4);
		jp.add(b1);
		jp.add(t1);
		//jt.setPreferredSize(new Dimension(300,100));
		//jt.setFillsViewportHeight(true);
		//jt.add(js);
		//jt.setLocation(100,300);
		l1.setSize(100,30);
		l1.setLocation(100, 100);
		l2.setSize(100,30);
		l2.setLocation(100, 150);
		l3.setSize(100,30);
		l3.setLocation(100, 200);
		l6.setSize(100,30);
		l6.setLocation(270, 200);
		r1.setSize(100,30);
		r1.setLocation(200, 100);
		r2.setSize(100,30);
		r2.setLocation(300, 100);
		jc.setSize(100,30);
		jc.setLocation(220, 150);
		t1.setSize(60,30);
		t1.setLocation(180, 200);
		l4.setSize(100,30);
		l4.setLocation(80, 250);
		ta.setSize(200, 200);
		ta.setLocation(200, 250);
		jp.add(ta);
		b1.setSize(100,30);
		b1.setLocation(100, 500);
		b2.setSize(100,30);
		b2.setLocation(200, 500);
		b3.setSize(100,30);
		b3.setLocation(300, 500);
		
   	  	
        //logo.setIcon(new ImageIcon(this.getClass().getResource("images/Logo.jpg")));
  	   // logo.setBounds(400,50,100,30);
  	    //jp.add(logo); 
		t3=new JTextField();
		t3.setBounds(340,200,80,30);
		msg=new JLabel();
		msg.setBounds(100,20, 300, 20);
		jp.add(b1);
		jp.add(b2);
		jp.add(b3);
		jp.add(t3);
		jp.add(msg);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		jf.setSize(1000,600);
		jf.setResizable(false);
		jf.setVisible(true);
		
	}
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==b2)
		{
			t1.setText("");
			t3.setText("");
			jc.setSelectedIndex(0);
			ta.setText("");
			bg.clearSelection();
				
		}
		
		else if(e.getSource()==b3)	
	    {
	    	if(t1.getText().equals("")||t3.getText().equals(""))
			{
				msg.setText("Enter Room no and rate");
				return;
			}
			if(ta.getText().equals(""))
			{
				msg.setText("Enter Room features");
				return;
			}
			if(jc.getSelectedIndex()==0)
			{
				msg.setText("Enter Room Category");
				return;
			}
			if(r1.isSelected()!=true&&r2.isSelected()!=true)
			{
				msg.setText("Enter Room Type");
				return;
			}
			
			if(Validations.isDigit(t1.getText())==false||Validations.isDigit(t3.getText())==false)
			{
				msg.setText("Room no and rate must be Digit");
				return;
			}
			if(Validations.isAlpha(ta.getText())==false)
			{
				msg.setText("Room Features must be Alphabet");
				return;
			}
	    	
			
	    	int rate=Integer.parseInt(t3.getText());
	    	//String rn=t2.getText();
	    	int rno=Integer.parseInt(t1.getText());
	    	String rd=ta.getText();
	    	String rt="";
	    	if(r1.isSelected()==true)
	    		rt="AC";
	    	else if(r2.isSelected()==true)
	    		rt="NON AC";
	    	else
	    	{
	    		return;
	    	}
	    	String rcatg=jc.getSelectedItem().toString();
	    	Room r=new Room("Active",rate,rt,rno,jc.getSelectedItem().toString(),rd);
	    	if(IO_Admin.checkRoomNO(Integer.parseInt(t1.getText()))==false)
	    	{
	    	if(IO_Admin.addRoom(r))
	    	{
	    		msg.setText("added");	
	    	}
	    	else 
	    	{
	    		msg.setText("not");
	    	}
	    	}
	    	else
	    		msg.setText("Already Exist");
	    }
		if(e.getSource()==b1)
		{
			if(e.getSource()==b1)
			{
				jf.dispose();
			}
		}
		
		
	}

	      
	public static void main(String []args)
	{
		new AddRoom();
		
	}
	
}


