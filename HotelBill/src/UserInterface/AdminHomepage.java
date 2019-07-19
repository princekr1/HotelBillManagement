package UserInterface;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import InputOutput.IO_operator;
import Model.Operator;
public class AdminHomepage implements ActionListener
{
	JFrame fr;
	JPanel jp;
	//String []s1={"Operator","Add Operator"," update operator","delete operator"};
	//String []s2={"room","Add Room","update room","delete room"};
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,lid,lname,logo;
	//JComboBox cbOperator,cbRoom;
	JButton b1,b2,b3,b4,b5,b6,b7,b8;
	Operator op;
	AdminHomepage()
	{
		fr=new JFrame();
		jp=new JPanel();
		logo=new JLabel();
		l1=new JLabel("ADMIN PAGE");
		l2=new JLabel("Admin Id:");
		lid=new JLabel(Login.oid);
		op=IO_operator.getOperator(Login.oid);
		l3=new JLabel(op.getOperatorName());
		l4=new JLabel("Name:");
		l5=new JLabel(op.getOperatorMobileNo());
		l6=new JLabel("Mobile No:");
		
		l8=new JLabel("Status");
		l9=new JLabel("Active");
		l10=new JLabel("Admin Details");
		l11=new JLabel("Operator");
		l12=new JLabel("Room");
		b1=new JButton("Add Operator");
		b2=new JButton("Update Operator");
		b3=new JButton("delete operator");
		b4=new JButton("Add Room");
		b5=new JButton("update Room");
		b6=new JButton("delete Room");
		b7=new JButton("Collection by Date");
		b8=new JButton("Collection by Operator");
		lname=new JLabel("GRAND HOTEL PRIMORETZ");
		lname.setFont(new Font("GRAND HOTEL PRIMORETZ",Font.ITALIC,30));
		l1.setFont(new Font("ADMIN PAGE",Font.ITALIC,30));
		//b6=new JButton();
		
		//cbOperator=new JComboBox(s1);
		//cbRoom=new JComboBox(s2);
		b1.setSize(150,30);
		b1.setLocation(100,220);
		b2.setSize(150, 30);
		b2.setLocation(100, 260);
		b3.setSize(150,30);
		b3.setLocation(100,300);
		b4.setSize(150,30);
		b4.setLocation(100, 400);
		b5.setSize(150,30);
		b5.setLocation(100,440);
		b6.setSize(150,30);
		b6.setLocation(100, 480);
		b7.setSize(180,30);
		b7.setLocation(120,550);
		b8.setSize(180,30);
		b8.setLocation(340,550);
		lid.setSize(100,30);
		lid.setLocation(550, 250);
		jp.add(lid);
		jp.add(b1);
		jp.add(b2);
		jp.add(b3);
		jp.add(b4);
		jp.add(b5);
		jp.add(b6);
		jp.add(b7);
		jp.add(b8);
		jp.setBackground(Color.blue);
		logo.setIcon(new ImageIcon(this.getClass().getResource("images/logos.jpg")));
		logo.setBounds(550,40, 200, 90);
		
		jp.setLayout(null);
		l1.setSize(300,60);
		l1.setLocation(60, 130);
		lname.setSize(500,80);
		lname.setLocation(60,20);
		l11.setSize(100,30);
		l11.setLocation(30, 230);
		l12.setSize(100,30);
		l12.setLocation(30, 410);
		l10.setSize(100,30);
		l10.setLocation(420, 200);
		l2.setSize(100,30);
		l2.setLocation(450, 250);
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
		//cbOperator.setSize(100,30);
		//cbOperator.setLocation(100, 300);
		//cbRoom.setSize(100, 30);
		//cbRoom.setLocation(100, 350);
		//jp.add(cbOperator);
		//jp.add(cbRoom);
		fr.add(jp);
		jp.add(l1);
		jp.add(l2);
		jp.add(l3);
		jp.add(l4);
		jp.add(l5);
		jp.add(l6);
		jp.add(lname);
		jp.add(logo);

		jp.add(l8);
		jp.add(l9);
		jp.add(l10);
		jp.add(l11);
		jp.add(l12);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		
		fr.setSize(800,800);
		fr.setVisible(true);
	
	}
	public static void main(String args[])
	{
		new AdminHomepage();
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		if(e.getSource()==b1)
		{
			new AddOperator();
		}
		if(e.getSource()==b2)
		{
			new Modified_Operator();
		}
		if(e.getSource()==b3)
		{
			new DeleteOperator();
		}
		if(e.getSource()==b4)
		{
			new AddRoom();
		}
		if(e.getSource()==b5)
		{
			new UpdateRoom();
		}
		if(e.getSource()==b6)
		{
			new DeleteRoom();
		}
		if(e.getSource()==b8)
		{
			new OperatorCollection();
		}
		if(e.getSource()==b7)
		{
			new AddDate();
		}
	}
	
	

}
