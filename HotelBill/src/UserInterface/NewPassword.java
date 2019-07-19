package UserInterface;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import InputOutput.IO_operator;

public class NewPassword implements ActionListener {
	private JPasswordField op,np,cp;
	private JFrame fr;
	private JButton b1,b2;
	private JLabel l1,l2,l3,msg,l4;
	private JPanel jp;
	private JTextField t1;
	NewPassword()
	{
		fr=new JFrame();
		jp=new JPanel();
		l4=new JLabel("Operator id:");
		msg=new JLabel();
		t1=new JTextField();
		msg.setBounds(100,450, 300, 20);
		jp.add(msg);
		jp.setBackground(Color.blue);
		fr.add(jp);
		l1=new JLabel("Old Password");
		jp.add(l1);
		jp.setLayout(null);
		l1.setSize(100,30);
		l1.setLocation(100,100);
		l4.setSize(100,30);
		l4.setLocation(100,70);
		t1.setSize(170,20);
		t1.setLocation(200,70);
		l2=new JLabel("New Password");
		jp.add(l2);
		jp.add(t1);
		jp.add(l4);
		l2.setSize(100,30);
		l2.setLocation(100, 160);
		l3=new JLabel("Confirm Password");
		jp.add(l3);
		l3.setSize(150,30);
		l3.setLocation(80, 220);
		op=new JPasswordField();
		jp.add(op);
		op.setSize(170,20);
		op.setLocation(200, 110);
		np=new JPasswordField();
		jp.add(np);
		np.setSize(170,20);
		np.setLocation(200, 170);
		cp=new JPasswordField();
		jp.add(cp);
		cp.setSize(170,20);
		cp.setLocation(200, 230);
		
		b1=new JButton("ok");
		jp.add(b1);
		b1.setSize(100,30);
		b1.setLocation(270, 270);
		
		b2=new JButton("cancel");
		jp.add(b2);
		b2.setSize(100,30);
		b2.setLocation(80,270);
		
		
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		fr.setSize(1000,600);
		fr.setResizable(false);
		fr.setVisible(true);
		
	}
	
	
	public void actionPerformed(ActionEvent e)
	{
	
		if(e.getSource()==b1)
		{
			if(op.getText().equals("")||np.getText().equals("")||cp.getText().equals(""))
			{
				msg.setText("Enter fields details");
				return;
			}
			if(Validations.isAlphaNum(op.getText())==false||Validations.isAlphaNum(np.getText())==false||Validations.isAlphaNum(cp.getText())==false)
			{
				msg.setText("All Password must be Alphanumeric");
				return;
			}
			if(Validations.isDigit(t1.getText())==false)
			{
				msg.setText("Operator ID must be digit");
				return;
			}
			if(np.getText().equals(cp.getText()))
			{
				int c=IO_operator.changePassword(t1.getText(),op.getText(), np.getText());
				if(c==0)
				{
					msg.setText("password changed");
				}
				if(c==1)
				{
					msg.setText("old password is wrong");
				}
			
				if(c==2)
				{
					msg.setText("new password and conform password doesnot match");
					return;
				}
					
			
			}
			else
				msg.setText("new password and confirm password doesnot match" );
		}
		
		if(e.getSource()==b2)
		{
			fr.dispose();
		}
	}
	public static void main(String args[])
	{
		new NewPassword();
	}
}
