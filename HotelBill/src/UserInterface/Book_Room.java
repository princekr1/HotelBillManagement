package UserInterface;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import InputOutput.IO_Admin;
import InputOutput.IO_operator;
import Model.*;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
public class Book_Room implements ActionListener
{
	public static void main(String [] args)
	{
		new Book_Room();
	}
	static int rno=0,rate=0;
	static String status=null;
	
	JFrame fr;
	JPanel jp;
	JRadioButton r1,r2;
	JButton b1,b2,b3;
	JTextField t2,t3,t4;
	ButtonGroup bg;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,lroom,logo;
	JComboBox jc;
	JTable table;
	JScrollPane scroll;	
	String []rt={"select","Single","Double"};
	String [] fields={"Room No","Feature","Type","Rate","Category"};
	String [][]data;
	Date d=new Date();
	SimpleDateFormat sdf_input,sdf_output;
	
	Book_Room()
	{
		fr=new JFrame("Book_Room");
		jp=new JPanel();
		l8=new JLabel();
		t2=new JTextField();
		t3=new JTextField();
		t4=new JTextField();
		
		bg=new ButtonGroup();
		
		l1=new JLabel("Room Type");
		l2=new JLabel("Room Catgory");
		l3=new JLabel("Date");
		l4=new JLabel("Room no");
		l5=new JLabel("");
		l6=new JLabel("Due Amount");
		l7=new JLabel("");
		
		r1=new JRadioButton("Ac");
		r2=new JRadioButton("Non Ac");
		
		b1=new JButton("Cancel");
		b2=new JButton("Confirm");
		b3=new JButton("Show");
		b3.setBounds(20, 20, 80, 30);
		jc=new JComboBox(rt);
		fr.add(jp);
		lroom=new JLabel();
		logo=new JLabel();
		lroom.setIcon(new ImageIcon(this.getClass().getResource("images/Room.jpeg")));
  	     lroom.setBounds(500,100, 470, 460);
  	   logo.setIcon(new ImageIcon(this.getClass().getResource("images/logos.jpg")));
	     logo.setBounds(815,20, 200, 80);
	     jp.add(lroom);
	     jp.add(logo);
	     jp.setBackground(Color.blue);
		l1.setSize(100, 20);
		l1.setLocation(50,80);
		jp.add(l1);
		l2.setSize(100, 20);
		l2.setLocation(200,80);
		jp.add(l2);
		l3.setSize(100, 20);
		l3.setLocation(250,50);
		jp.add(l3);
		l4.setSize(100, 20);
		l4.setLocation(100,250);
		jp.add(l4);
		l5.setSize(200, 20);
		l5.setLocation(100,400);
		jp.add(l5);
		l6.setSize(100, 20);
		l6.setLocation(100,310);
		//jp.add(l6);
		r1.setSize(50, 20);
		r1.setLocation(40,100);
		r2.setSize(80, 20);
		r2.setLocation(100,100);
		jc.setSize(80, 20);
		jc.setLocation(290, 80);
		l8.setSize(100,20);
		l8.setLocation(300, 50);
		t2.setSize(100,20);
		t2.setLocation(200, 250);
		t3.setSize(100,20);
		t3.setLocation(200, 280);
		//t4.setSize(100,20);
		//t4.setLocation(200, 310);
		ArrayList arr=IO_Admin.getAllRooms();
		String [][]arr1=new String[100][5];
		int i=0;
		for(Object o:arr)
		{
			Room r=(Room)o;
			arr1[i][0]=Integer.toString(r.getRoomno());
			arr1[i][1]=r.getRoomFeature();
			arr1[i][2]=r.getRoomType();
			arr1[i][3]=Integer.toString(r.getRate());	
			arr1[i][4]=r.getRoomCategory();	
			i++;
		}
		String []fields={"Room No","Feature","Type","Rate","catagory"};
		table=new JTable(arr1,fields);
		
		table.setBackground(Color.CYAN);
		//table.setBounds(40, 150, 400, 400);
		table.setSize(400,120);
		table.setLocation(40,120);
		scroll=new JScrollPane(table);
		scroll.setSize(20,120);
		scroll.setLocation(450,120);
		jp.add(b3);
		jp.add(table);
		jp.add(scroll);
		
		jp.add(l8);
		jp.add(t2);
		//jp.add(t3);
		jp.add(t4);
		jp.add(jc);
		jp.add(r1);
		jp.add(r2);
		bg.add(r1);
		bg.add(r2);
		b1.setSize(100,30);
		b1.setLocation(100,350);
		b2.setSize(100,30);
		b2.setLocation(350,350);
		jp.add(b1);
		jp.add(b2);
		
		 try
	     	{
			     //sdf_input=new SimpleDateFormat("dd-MMM-yyyy");
			     sdf_output=new SimpleDateFormat("dd-MMM-yyyy");
			     //String input=t1.getText();
			    // Date d=sdf_input.parse(input);
			     d=new Date();
			     
			     String output=sdf_output.format(d);
			     l8.setText(output);
			    
	     	}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}	
		
		jp.setLayout(null);
		fr.setSize(1000,600);
		fr.setVisible(true);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b1.addActionListener(this);

	}


	@Override
	public void actionPerformed(ActionEvent ee) 
	{
		if(ee.getSource()==b3)

		{
			if(jc.getSelectedIndex()==0)
			{
				l5.setText("Enter Room Category");
				return;
			}
			if(r1.isSelected()!=true&&r2.isSelected()!=true)
			{
				l5.setText("Enter Room Type");
				return;
			}
		}
		if(ee.getSource()==b2)
		{
			if(t2.getText().equals(""))
			{
				l5.setText("Enter Room No.");
				return;
			}
			if(Validations.isDigit(t2.getText())==false)
			{
				l5.setText("Room no must be Digit");
				return;
			}
		}
		if(ee.getSource()==b3)
		{
			
			String cat=jc.getSelectedItem().toString();		
			 
			   String ty="";
			   if(r1.isSelected()==true)
				   ty="AC";
			   else if(r2.isSelected()==true)
				   ty="NON AC";
			   else
				   return;
			   ArrayList t=IO_Admin.getRoomsByCatgType(cat,ty);
			   data=new String[t.size()][5];
			   
			   Room r;
			   int i=0;
			   for(Object o:t)
			   {
				   r=(Room)o;
				  data[i][0]=Integer.toString(r.getRoomno()); 
				 // System.out.println(data[i][0]);
				  data[i][1]=r.getRoomFeature();
				  data[i][2]=r.getRoomType();
				  data[i][3]=Integer.toString(r.getRate());
				  data[i][4]=r.getRoomCategory();
	
				  i++;
			   }
				table.setModel(new DefaultTableModel(data,fields));
			
			
		
			table.setModel(new DefaultTableModel(data,fields));
			}
	
		
		if(ee.getSource()==b2)
		{
			
			rno=Integer.parseInt(t2.getText());
			rate=IO_operator.getRoomRate(rno);
			status=IO_operator.getStatus(rno);
			new AddBill();
		}
		if(ee.getSource()==b1)
		{
			fr.dispose();
		}

		
	}
	
}
		