package UserInterface;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import InputOutput.IO_operator;
import Model.Operator;
public class OperatorHomepage implements ActionListener {
	JFrame fr;
	JPanel jp;
	String []s1={"Operator","Add Operator",};
	String []s2={"Bill","Add Bill","Check Bill"};
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,lid,lname,logo;
	//JComboBox cbOperator,cbBill;
	JButton b1,b2,b3;
	Operator op;
	
	OperatorHomepage()
	{
		fr=new JFrame();
		jp=new JPanel();
		l1=new JLabel("OPERATOR PAGE");
		l2=new JLabel("Operator Id:");
		lid=new JLabel(Login.oid);
		op=IO_operator.getOperator(Login.oid);
		l3=new JLabel(op.getOperatorName());
		l4=new JLabel("Name:");
		lname=new JLabel("GRAND HOTEL PRIMORETZ");
		l5=new JLabel(op.getOperatorMobileNo());
		l6=new JLabel("Mobile No:");
		
		l8=new JLabel("Status");
		l9=new JLabel("Active");
		l10=new JLabel("Operator Details");
		l11=new JLabel("Operator");
		l12=new JLabel("Bill");
		b1=new JButton("CollectionByDate");
		b2=new JButton("Room");
		b3=new JButton("Change password");
		b1.setSize(150,30);
		b1.setLocation(100,300);
		b2.setSize(150,30);
		b2.setLocation(100,350);
		b3.setSize(150,30);
		b3.setLocation(100,400);
		jp.add(b1);
		jp.setBackground(Color.blue);;
		jp.add(b2);
		jp.add(b3);
		//cbOperator=new JComboBox(s1);
		//cbBill=new JComboBox(s2);
		jp.setLayout(null);
		l1.setSize(300,60);
		l1.setLocation(60, 160);
		lname.setBounds(60,80,400,60);
		//l11.setSize(100,30);
		//l11.setLocation(30, 300);
	//	l12.setSize(100,30);
		//l12.setLocation(30, 350);
		l10.setSize(100,30);
		l10.setLocation(420, 200);
		l2.setSize(100,30);
		l2.setLocation(450, 250);
		lid.setSize(100,30);
		lid.setLocation(550, 250);
		l3.setSize(200,30);
		l3.setLocation(520, 300);
		l5.setSize(200,30);
		l5.setLocation(550, 350);
		l4.setSize(200,30);
		l4.setLocation(450, 300);
		l6.setSize(100,30);
		l6.setLocation(450, 350);
		l8.setSize(100,30);
		l8.setLocation(450, 400);
		l9.setSize(200,30);
		l9.setLocation(550, 400);
		//cbOperator.setSize(80,30);
		//cbOperator.setLocation(100, 300);
		//cbBill.setSize(90, 30);
		//cbBill.setLocation(100, 350);
		//jp.add(cbOperator);
		//jp.add(cbBill);
		logo=new JLabel();
		l1.setFont(new Font("OPERATOR PAGE",Font.ITALIC,30));
		lname.setFont(new Font("GRAND HOTEL PRIMORETZ",Font.ITALIC,30));
		logo.setIcon(new ImageIcon(this.getClass().getResource("images/logos.jpg")));
		logo.setBounds(550,40, 200, 90);
		fr.add(jp);
		jp.add(l1);
		jp.add(lid);
		jp.add(l2);
		jp.add(l3);
		jp.add(l4);
		jp.add(l5);
		jp.add(l6);
		//jp.add(l7);
		jp.add(l8);
		jp.add(l9);
		jp.add(l10);
		jp.add(lname);
		jp.add(logo);
		//jp.add(l11);
		//jp.add(l12);
		fr.setSize(800,800);
		jp.setLayout(null);
		fr.setVisible(true);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
	
	}
	public static void main(String args[])
	{
		new OperatorHomepage();
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1)
		{
			new AddDate();
			return;
		}
		if(e.getSource()==b2)
		{
			new Book_Room();
			return;
		
		}
		if(e.getSource()==b3)
		{
			new NewPassword();
			return;
		}
		
		
	}
	
	

}
