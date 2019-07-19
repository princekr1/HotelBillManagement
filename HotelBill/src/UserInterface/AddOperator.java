package UserInterface;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import InputOutput.IO_Admin;
import Model.*;

public class AddOperator  implements ActionListener
{
	JRadioButton r1,r2;
	ButtonGroup gr;
	JLabel l1,l2,l3,l4,l5;
	JButton b1,b2,b3;
	JFrame fr;
	JPanel jp;
	JTextField t1,t2,t3,t4;
	
	AddOperator()
	{
		fr=new JFrame("Add Operator");
		r1=new JRadioButton("Staff(Operator)");
		r2=new JRadioButton("Admin");
		t1=new JTextField();
		t2=new JTextField();
		t3=new JTextField();
		t4=new JTextField();
		gr=new ButtonGroup();
		gr.add(r1);
		gr.add(r2);
		l1=new JLabel("Operator ID:");
		l2=new JLabel("Name:");
		l3=new JLabel("Phn No:");
		l4=new JLabel("Password:");
		l5=new JLabel("");
		b1=new JButton("Reset");
		b2=new JButton("Add");
		b3=new JButton("Cancel");
		l1.setBounds(20,20,80,60);
		l2.setBounds(20,60,80,60);
		l3.setBounds(20,100,80,60);
		l4.setBounds(20,140,80,60);
		t1.setBounds(100,40,120,20);
		t1.setBackground(Color.CYAN);
		t2.setBounds(100,80,120,20);
		t2.setBackground(Color.CYAN);
		t3.setBounds(100,120,120,20);
		t3.setBackground(Color.CYAN);
		t4.setBounds(100,160,120,20);
		t4.setBackground(Color.CYAN);
		r1.setBounds(20,180,140,30);
		r2.setBounds(160,180,80,30);
		b1.setBounds(20,220,80,30);
		b2.setBounds(110,220,60,30);
		b3.setBounds(180,220,80,30);
		l5.setBounds(20,300,200,20);
		b2.addActionListener(this);
		b1.addActionListener(this);
		b3.addActionListener(this);

		fr.add(r1);
		fr.add(r2);
		fr.add(t1);
		fr.add(t2);
		fr.add(t3);
		fr.add(t4);
		fr.add(l1);
		fr.add(l2);
		fr.add(l3);
		fr.add(l4);
		fr.add(b1);
		fr.add(b2);
		fr.add(b3);
		fr.add(l5);
		fr.setLayout(null);
		fr.setSize(400,400);
		fr.setVisible(true);
				
	}
	public void actionPerformed(ActionEvent e)
	{   String o="";
	if(e.getSource()==b2)
	{
		if(Validations.isDigit(t1.getText())==false)
		{
			l5.setText("OperatorId must be numeric");
			return;
		}
		if(Validations.isDigit(t3.getText())==false)
		{
			l5.setText("Phone no. must be numeric");
			return;
		}
	if(Validations.isAlpha(t2.getText())==false)
	{
		l5.setText("Username must be Alphabet");
		return;
	}
	if(Validations.isAlphaNum(t4.getText())==false)
	{
		l5.setText("Password must be Alphanumeric");
		return;
	}
		if(e.getSource()==b2)
		{  
		if(r1.isSelected()==true)
			o="Staff";
		else if(r2.isSelected()==true)
			o="Admin";
		else
		{
			l5.setText("Please select oper");
			return ;
		}
		if(t1.getText().equals("")||t2.getText().equals("")||t3.getText().equals("")||t4.getText().equals(""))
		{
			l5.setText("kindly fill all the textFields");
			return;
		}
			Operator temp=new Operator(t1.getText(),t2.getText(),t3.getText(),t4.getText(),o,"Active");
			if(IO_Admin.checkOperatorId(t1.getText())==false)
			{
				if(IO_Admin.addOperator(temp))
				{
					l5.setText("Added");
				}
				else
				{
					l5.setText("Some problem");	
				}
			}
			else
				l5.setText("Already Exist");
		}
	}
		if(e.getSource()==b1)
		{
			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
			gr.clearSelection();
		}
		if(e.getSource()==b3)
		{
			fr.dispose();
		}
	}
	
	public static void main(String []args)
	{
		new AddOperator();
	}
	

	
}
