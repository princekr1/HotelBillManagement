package UserInterface;
import javax.swing.*;
import java.util.*;
import Model.*;
import InputOutput.IO_Admin;

import java.awt.*;
import java.awt.event.*;
public class Modified_Operator implements ActionListener
{
	public static void main(String []args)
	{
		Modified_Operator mp=new Modified_Operator();
	}
	JFrame fr;
	//JPanel jp;
	JTextField t1,t2,t3;
	JTextField pf1;
	JLabel id,name,phno,pass,l1,l2;
	JComboBox j1;
	JButton b1,b2,b3;
	String [] at=new String[100];
	Modified_Operator()
	{
	fr=new JFrame("Modified_Operator");
	//jp=new JPanel();
	//t1=new JTextField();
	t2=new JTextField();
	t3=new JTextField();
	pf1=new JTextField();
	ArrayList arr=IO_Admin.getOperotorIDs();
	l2=new JLabel();

	int i=1;
	at[0]="select";
	for(Object o: arr)
	{   Operator op=(Operator)o;
	    at[i]=op.getOperatorId();
	    i++;
	}
	j1=new JComboBox(at);
	//j1.setBounds(380,40,80,30);
	id=new JLabel("operator id");
	id.setBounds(70,100,100,30);
	j1.setBounds(170,100,180,30);
	j1.setBackground(Color.GRAY);
	name=new JLabel("name");
	name.setBounds(70,140,100,30);
	t2.setBounds(170,140,180,30);
	t2.setBackground(Color.PINK);
	phno=new JLabel("phone no");
	phno.setBounds(70,180,100,30);
	t3.setBounds(170,180,180,30);
	t3.setBackground(Color.gray);
	pass=new JLabel("password");
	pass.setBounds(70, 220, 100, 30);
	pf1.setBounds(170,220,180,30);
	pf1.setBackground(Color.GRAY);
	l1=new JLabel("");
	b1=new JButton("cancel");
	b1.setBounds(80,320,80,25);
	b2=new JButton("update");
	b2.setBounds(180,320,80,25);
	b3=new JButton("Reset");
	b3.setBounds(280,320,100,25);
	l1.setBounds(180,380,100,25);
	l2.setBounds(70,400,100,25);
	fr.add(id); fr.add(name); fr.add(phno);
	fr.add(j1);fr.add(b1); fr.add(b2);
	fr.add(b3);fr.add(t2);fr.add(t3);fr.add(l2);
	fr.add(pf1);fr.add(pass);fr.add(l1);
	b1.addActionListener(this);
	b2.addActionListener(this);
	b3.addActionListener(this);

	j1.addActionListener(this);
	fr.setSize(500,500);
	fr.setBackground(Color.CYAN);
	fr.setLayout(null);
	fr.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		
		if(e.getSource()==b2)	
		{
			
			if(j1.getSelectedIndex()==0)
			{
				l2.setText("Please enter Operator ID");
			}
		
			if(Validations.isAlphaNum(t3.getText())==false)
			{
			l2.setText("Password must be Alphanumeric");
			return;
			}
		}
		if(e.getSource()==j1)
		{
			String oid=j1.getSelectedItem().toString();
			if(!oid.equals("select"))
			{
			Operator temp=IO_Admin.getOperator(oid);
			t2.setText(temp.getOperatorName());
			t3.setText(temp.getOperatorMobileNo());
			}
			else
			{
				t3.setText("");
				t2.setText("");
			}
			//pf1.setText(temp.getPassword());
		}
		if(e.getSource()==b2)
		{  
			
			if(IO_Admin.Update_OperatorPwdMob(j1.getSelectedItem().toString(), pf1.getText(),t3.getText()))
				
				{
					l1.setText("updated success");
				}
			else
			{
				l1.setText("some problem");
			}
		}
		if(e.getSource()==b3)
		{
		  
			t3.setText("");
			t2.setText("");
			j1.setSelectedIndex(0);
			
		}
		if(e.getSource()==b1)
		{
			fr.dispose();
		}
		
	}
}
