package UserInterface;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import InputOutput.IO_operator;

public class AddDate implements ActionListener
{
	public static void main(String [] args)
	{
		new AddDate();
	}
	JFrame fr;
	JPanel jp;
	JLabel l1,l3,l4;
	JButton b1,b2;
	JTextField t1;
	SimpleDateFormat sdf_input,sdf_output;
	
	Date d;
	AddDate()
	{
		fr=new JFrame();
		jp=new JPanel();
		t1=new JTextField();
		l1=new JLabel("Date:(dd-Mon-yyyy)");
		
		l3=new JLabel("Total Collection");
		l4=new JLabel();
		b1=new JButton("click");
		b2=new JButton("back");

		l1.setBounds(60,80,100,30);
		t1.setBounds(160,80,120,30);
		b1.setBounds(290,80,70,25);
		b2.setBounds(200,250,70,25);

		l3.setBounds(60,150,100,30);
		l4.setBounds(180, 150, 120, 30);
		jp.setBackground(Color.blue);
		fr.add(jp);
		jp.add(l1);
		
		jp.add(l3);
		jp.add(l4);
		jp.add(t1);
		jp.add(b1);
		
		jp.add(b2);

		
		 b1.addActionListener(this);
		 b2.addActionListener(this);

		
		jp.setLayout(null);
		fr.setSize(900,600);
		fr.setVisible(true);
		fr.setResizable(false);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{   int gt=0;
		if(e.getSource()==b1)
		{
			 try
		     	{
				     sdf_input=new SimpleDateFormat("dd-MMM-yyyy");
				    System.out.println("oid:"+Login.oid);
				     String input=t1.getText();
				     Date d;
				     d=sdf_input.parse(input);
				    gt=IO_operator.getCollectionDate(d, Login.oid);
				     l4.setText(Integer.toString(gt));
				     
				     
				    
		     	}
					catch(Exception e1)
					{
						e1.printStackTrace();
					}
		}
		if(e.getSource()==b2)
		{
			fr.dispose();
		}
		
	}
	

}
