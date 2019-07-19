package UserInterface;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Welcome implements ActionListener

{
	public static void main(String args[])
	{
		new Welcome();
	}
	JFrame fr;
	JPanel jp;
	JButton b1;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,lroom,logo;
	Welcome ()
	{
		fr=new JFrame();
		jp=new JPanel();
		l1=new JLabel("WELCOME");
		l1.setBounds(50,20,250,50);
		l2=new JLabel("GRAND HOTEL ");
		l2.setBounds(150,80,600,80);
		l11=new JLabel("PRIMORTEZ");
		l11.setBounds(200, 180, 390, 80);
		l3=new JLabel("grandhotel@gmail.com");
		l3.setBounds(500,340,180,20);
		l12=new JLabel("Email:- ");
		l12.setBounds(440,335,80,30);
		l4=new JLabel("Fax no:-");
		l4.setBounds(470,380,100,30);
		l5=new JLabel("033-22596437");
		l5.setBounds(570,380,120,30);
		l6=new JLabel("Mobile no:-");
		l6.setBounds(470,420,120,30);
		l7=new JLabel("9163885927");
		l7.setBounds(590,420,100,20);
		l8=new JLabel("8820514634");
		lroom=new JLabel();
		logo=new JLabel();
		jp.add(logo);
		jp.add(lroom);
		lroom.setIcon(new ImageIcon(this.getClass().getResource("images/Room.jpeg")));
 	     lroom.setBounds(10,270, 420, 400);
 	   logo.setIcon(new ImageIcon(this.getClass().getResource("images/logos.jpg")));
	     logo.setBounds(600,20, 200, 80);
		l8.setBounds(590,460,100,20);
		l9=new JLabel("9002737979 ,");
		l9.setBounds(590,500,100,20);
		l10=new JLabel("8961032787");
		l10.setBounds(590,540,100,20);
		b1=new JButton("Enter");
		b1.setBounds(620,600,80,30);
		l1.setBackground(Color.darkGray);
		jp.setBackground(Color.blue);
		l1.setFont(new Font("WELCOME",Font.ITALIC,40));
		l2.setFont(new Font("GRAND HOTEL",Font.ITALIC,60));
		l11.setFont(new Font("PRIMORTEZ",Font.ITALIC,60));
		
		
		
		fr.add(jp);
		jp.add(l1);
		jp.add(l2);
		jp.add(l3);
		jp.add(l4);
		jp.add(l5);
		jp.add(l6);
		jp.add(l7);
		jp.add(l8);
		jp.add(l9);
		jp.add(l10);
		jp.add(l11);
		jp.add(l12);
		
		jp.add(b1);
		
		b1.addActionListener(this);
		
		jp.setLayout(null);
		fr.setSize(800, 800);
		fr.setVisible(true);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==b1)
		{
			new Login();
		}
		
	}
	
	

}
