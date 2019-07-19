package UserInterface;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import InputOutput.IO_Admin;
import InputOutput.IO_operator;
import Model.Operator;

public class OperatorCollection implements ActionListener
{
	public static void main(String [] args)
	{
		new OperatorCollection();
	}
	JFrame fr;
	JPanel jp;
	JLabel l1,l2,l3,l4,l5;
	JTextField t1;
	JButton b1,b3;
	String [] at=new String[100];
SimpleDateFormat sdf_input,sdf_output;
	
	Date d;
	JComboBox cb;
	
	OperatorCollection()
	{
		int i=1;
		ArrayList arr=IO_Admin.getOperotorIDs();
		at[0]="select";
		for(Object o: arr)
		{   Operator op=(Operator)o;
		    at[i]=op.getOperatorId();
		    i++;
		}
		fr=new JFrame();
		jp=new JPanel();
		t1=new JTextField();
		l1=new JLabel("Operator Ids");
		l1.setBounds(40,100,100,30);
		cb=new JComboBox(at);
		cb.setBounds(140,100,100,30);
		l2=new JLabel("Date");
		l2.setBounds(40,160,100,30);
		l3=new JLabel();
		t1.setBounds(140, 160, 100, 30);
		b1=new JButton("click");
		b1.setBounds(250,160,70,30);
		b3=new JButton("back");
		b3.setBounds(250,250,70,30);
		l4=new JLabel("Total Collection");
		l4.setBounds(40,200,110,30);
		l5=new JLabel();
		l5.setBounds(160, 200, 100, 30);
		jp.setBackground(Color.blue);
		
		
		fr.add(jp);
		jp.add(l1);
		jp.add(l2);
		jp.add(l3);
		jp.add(l4);
		jp.add(l5);
		jp.add(cb);
		jp.add(t1);
		jp.add(b1);
		jp.add(b3);

		jp.setLayout(null);
		fr.setSize(500,500);
		fr.setBackground(Color.CYAN);
		fr.setVisible(true);
		b3.addActionListener(this);

		b1.addActionListener(this);
	}
		
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
					    gt=IO_operator.getCollectionDate(d, cb.getSelectedItem().toString());
					     l5.setText(Integer.toString(gt));
					     
					     
					    
			     	}
						catch(Exception e1)
						{
							e1.printStackTrace();
						}
			}
			if(e.getSource()==b3)
			{
				fr.dispose();
			}
			
		}
		

	}
