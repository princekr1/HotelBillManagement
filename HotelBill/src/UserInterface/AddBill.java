package UserInterface;

import javax.swing.*;
import Model.*;

import InputOutput.IO_operator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Date;
public class AddBill implements ActionListener, MouseListener
{
	public static void main(String []args)
	{
		new AddBill();
	}
	JFrame fr;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18,l19,jk,jbill,jmsg;
	JButton b1,b2,b3,b4,b5;
	JTextField t1,t2,t3,t4,t5,t6;
	JTextArea ta1;
	JComboBox cb;
	Date cd=new Date();
	SimpleDateFormat sdf_input,sdf_output;
	int []sr;
	Date d;
	AddBill()
	{
		sr=IO_operator.getAllBillNo();
		String ss1[]=new String[100];
		for(int j=0;j<sr.length;j++)
			ss1[j]=Integer.toString(sr[j]);
		
		fr=new JFrame("Generating Bill");
		l1=new JLabel("Bill no:");
		l2=new JLabel(Integer.toString(IO_operator.genBillNo()));
		l3=new JLabel("Billing Date:");
		l4=new JLabel("");
		l5=new JLabel("Operater ID:");
		l6=new JLabel("Customer Name:");
		l7=new JLabel("Customer Details:");
		l8=new JLabel("Total Amount:");
		l9=new JLabel("Min. av. Amount:");
		l10=new JLabel("Advance Amount:");
		l11=new JLabel("Rem. Amount:");
		jk =new JLabel("click");
		jbill =new JLabel("BillNO");
		l12=new JLabel(Login.oid);
		l14=new JLabel(Integer.toString(Book_Room.rate));
		int k=Integer.parseInt(l14.getText())/2;
		l13=new JLabel();
		l13.setText(Integer.toString(k));
		l15=new JLabel("Room no");
		l16=new JLabel(Integer.toString(Book_Room.rno));
		l17=new JLabel("Are you sure ?");
		l18=new JLabel("Bill Status");
		l19=new JLabel(Book_Room.status);
		cb=new JComboBox(ss1);
		
		b1=new JButton("show");
		b2=new JButton("Cancel");
		b3=new JButton("Confirm");
		b4=new JButton("No");
		b5=new JButton("Yes");
		
		t1=new JTextField();
		t2=new JTextField();
		t3=new JTextField();
		t4=new JTextField();
		t4=new JTextField();
		t5=new JTextField();
		t6=new JTextField();
		
		ta1=new JTextArea();
		
		
		l1.setBounds(60, 50, 50, 20);
		l2.setBounds(170, 50, 100, 20);
		l3.setBounds(60, 80, 70, 20);
		l4.setBounds(170, 80, 100, 20);
		l5.setBounds(280, 50, 100, 20);
		t1.setBounds(395, 50, 100, 20);
		l6.setBounds(60, 110, 100, 20);
		t2.setBounds(170, 110, 100, 20);
		ta1.setBounds(170, 140, 250, 60);
		l7.setBounds(60, 140, 100, 20);
		l8.setBounds(60, 210, 100, 20);
		t3.setBounds(165, 210, 100, 20);
		l9.setBounds(290, 210, 100, 20);
		t4.setBounds(395, 210, 100, 20);
		l10.setBounds(60, 240, 100, 20);
		jk.setBounds(270,240,100,20);
		t5.setBounds(165, 240, 100, 20);
		l11.setBounds(60, 270, 100, 20);
		l12.setBounds(395, 50, 100, 20);
		l13.setBounds(395, 210, 100, 20);
		l14.setBounds(165, 210, 100, 20);
		l16.setBounds(395, 80, 100, 20);
		l15.setBounds(280, 80, 100, 20);
		l17.setBounds(330, 370, 150, 20);
		t6.setBounds(165, 270, 100, 20);
		b1.setBounds(10, 7, 80, 20);
		b2.setBounds(140, 330, 80, 20);
		l18.setBounds(100, 300, 100, 20);
		l19.setBounds(200, 300, 100, 20);
		b3.setBounds(300, 330, 80, 20);
		b4.setBounds(330, 400, 80, 20);
		b5.setBounds(420, 400, 80, 20);
		cb.setBounds(325, 15, 90, 20);
		jbill.setBounds(280, 15, 100, 20);
		jmsg=new JLabel("prince");
		jmsg.setBounds(100, 450, 400, 20);
		
		fr.add(jmsg);
		fr.add(jbill);
		fr.add(l1);
		fr.add(l2);
		fr.add(l3);
		fr.add(l4);
		fr.add(l5);
		fr.add(l6);
		fr.add(l7);
		fr.add(l8);
		fr.add(l9);
		fr.add(l10);
		fr.add(l11);
		fr.add(l12);
		fr.add(l13);
		fr.add(l14);
		fr.add(l15);
		fr.add(l16);
		fr.add(l17);
		fr.add(l18);
		fr.add(l19);
		fr.add(jk);

		fr.add(b1);
		fr.add(b2);
		fr.add(b3);
		fr.add(b4);
		fr.add(b5);
		//fr.add(t1);
		fr.add(t2);
		//fr.add(t3);
		//fr.add(t4);
		fr.add(t5);
		fr.add(t6);
		fr.add(ta1);
		fr.add(cb);
		 try
     	{
		     sdf_input=new SimpleDateFormat("dd-MMM-yyyy");
		     sdf_output=new SimpleDateFormat("MMM-yyyy-dd");
		     //String input=t1.getText();
		    // Date d=sdf_input.parse(input);
		     d=new Date();
		     
		     String output=sdf_output.format(d);
		     l4.setText(output);
		    
     	}
			catch(Exception e1)
			{
				e1.printStackTrace();
			}	
			
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		jk.addMouseListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		fr.setLayout(null);
		fr.setSize(600,600);
		fr.setVisible(true);
		b4.setVisible(false);
		b5.setVisible(false);
		l17.setVisible(false);
		
		
		
	}
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==b3)	
	    {
			b4.setVisible(true);
			b5.setVisible(true);
			l17.setVisible(true);
	    }
			
			if(e.getSource()==b5)
			{
			Bill b1=new Bill(IO_operator.genBillNo(),d,l12.getText(),t2.getText(),ta1.getText(),l19.getText(),Integer.parseInt(l16.getText()),Integer.parseInt(l14.getText()),Integer.parseInt(t5.getText()),Integer.parseInt(t6.getText()),d);
			//Bill b=new Bill(t2.getText(),ta1.getText(),t5.getText(),)
			if(IO_operator.addBill(b1)==true)
			{
				System.out.println("********");
			}
			}
			else if(e.getSource()==b4)
			{
				b4.setVisible(false);
				b5.setVisible(false);
				l17.setVisible(false);
			}
		
		if(e.getSource()==b1)
		{
			System.out.println("**********");
			
				Bill b1=IO_operator.showBillDetail(Integer.parseInt((String) cb.getSelectedItem()));
				System.out.println(b1.getBill_no());
				l4.setText(b1.getBilling_date().toString());
				l2.setText(Integer.toString(b1.getBill_no()));
				t2.setText(b1.getCustomer_name());
				ta1.setText(b1.getCustomer_details());
				l19.setText(b1.getStatus());
				t5.setText(Integer.toString(b1.getAdvance_amount()));
				t6.setText(Integer.toString(b1.getRemaining_amount()));
				//l4.setText(b1.getBilling_date());
				
			
		}
			
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int rm=Book_Room.rate-Integer.parseInt(t5.getText());
		if(Integer.parseInt(l13.getText())<=Integer.parseInt(t5.getText()))
			t6.setText(Integer.toString(rm));
		else{
			jmsg.setText("Adv. amount should be greater than min adv amount");
		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}

