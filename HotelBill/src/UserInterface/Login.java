package UserInterface;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import InputOutput.IO_operator;

public class Login implements ActionListener, MouseListener
{
	JFrame fr;
	JButton login,cancel;
	JLabel user,pass,fp,msg,lroom,logo;
	TextField t1;
	JPasswordField pf;
	static String oid;
	Login()
	{
		fr=new JFrame();
		JPanel jp=new JPanel();
		login=new JButton("Login");
		cancel=new JButton("cancel");
		user=new JLabel("Username:");
		pass=new JLabel("Password:");
		fp=new JLabel("Change Password");
		t1=new TextField();
		pf=new JPasswordField();
		msg=new JLabel();
		msg.setBounds(50, 300, 300, 20);
		lroom=new JLabel();
		logo=new JLabel();
		lroom.setIcon(new ImageIcon(this.getClass().getResource("images/Room.jpeg")));
  	     lroom.setBounds(500,100, 470, 460);
  	   logo.setIcon(new ImageIcon(this.getClass().getResource("images/logos.jpg")));
	     logo.setBounds(815,20, 200, 80);
	     jp.add(lroom);
	     jp.add(logo);
		jp.add(msg);
		jp.add(t1);
		jp.add(pf);
		fr.add(jp);
		jp.add(login);
		//jp.add(cancel);
		jp.add(user);
		jp.add(pass);
		jp.add(fp);
		jp.setLayout(null);getClass();

		jp.setBackground(Color.blue);
		user.setSize(100,50);
		user.setLocation(100,50);
		pass.setSize(100,50);
		pass.setLocation(100,100);
		t1.setSize(150,20);
		t1.setLocation(170, 60);
		pf.setSize(150,20);
		pf.setLocation(170, 110);
		login.setSize(100,40);
		login.setLocation(270, 170);
		cancel.setSize(100,40);
		cancel.setLocation(80, 170);
		fp.setSize(180,40);
		fp.setLocation(80, 230);
		login.addActionListener(this);
		cancel.addActionListener(this);
		fp.addMouseListener(this);
		fr.setSize(1000,600);
		fr.setResizable(false);
		fr.setVisible(true);
	}
			

	public static void main(String args[])
	{
		new Login();
	}


	
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==login)	
		{
			if(t1.getText().trim().equals("") || pf.getText().trim().equals(""))
			{
				msg.setText("Please enter Username and Password");
				return;
			}
			if(Validations.isAlphaNum(t1.getText())==false||Validations.isAlphaNum(pf.getText())==false)
			{
				msg.setText("Username and Password must be Alphanumeric");
				return;
			}
		
			if(t1.getText().trim().equals("") || pf.getText().trim().equals(""))
			{
				msg.setText("Please enter Username and Password");
				return;
			}
			if(t1.getText().trim().equals("admin") || pf.getText().trim().equals("admin"))
			{
				oid=t1.getText();
				new AdminHomepage();
				return;
			}
			if(Validations.isAlphaNum(t1.getText())==false||Validations.isAlphaNum(pf.getText())==false)
			{
				msg.setText("Username and Password must be Alphanumeric");
				return;
			}
			if(IO_operator.logIn(t1.getText(), pf.getText()))
			{
				oid=t1.getText();
				new OperatorHomepage();
				
				return;
			}
			else
			{
				msg.setText("in valid op");
				return;
			}	
				
					
		}
	}
	public void mousePressed(MouseEvent arg0)
	{
		new NewPassword();
	}


	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
}

