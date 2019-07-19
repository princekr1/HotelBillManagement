package UserInterface;
import java.awt.*;
import Model.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import InputOutput.IO_Admin;
public class UpdateRoom implements ActionListener {
	private JFrame jf;
	private JPanel jp;
	private JButton b1,b2,b3;
	private JComboBox rno_cb;
	private JTextField t1,t2,t3;
	private JLabel l1,l2,l3,l4,l5,msg,lroom,logo;
	private JRadioButton r1,r2;
	private ButtonGroup bg;
	private JComboBox jc;
	private static ArrayList arr;
	UpdateRoom()
	{
		jf=new JFrame();
		jp=new JPanel();
		t1=new JTextField();
		t2=new JTextField();
		
		b1=new JButton("Update");
		b2=new JButton("Cancel");
		b3=new JButton("Reset");
		jf.add(jp);
		jp.add(b1);
		jp.add(b2);
		jp.add(b3);
		jp.setLayout(null);
		
		//String []s={"Catagory","Single","Double","Family"};
		t3=new JTextField();
		t3.setSize(100,30);
		t3.setLocation(200,200);
		l1=new JLabel("Room No:");
		l2=new JLabel("Room Type:");
		l3=new JLabel("Room Catagory:");
		l4=new JLabel("Room Price:");
		l5=new JLabel("Prince");
		bg=new ButtonGroup();
		r1=new JRadioButton("Ac");
		r2=new JRadioButton("Non Ac");
		jf.add(jp);
		jp.add(r2);
		jp.add(r1);
		bg.add(r1);
		bg.add(r2);
		jp.add(l1);
		jp.add(l2);
		jp.add(l3);
		jp.add(l4);
		jp.add(l5);
		jp.add(b1);
		jp.add(t1);
		jp.add(t2);
		jp.add(t3);
		jp.setBackground(Color.blue);
		lroom=new JLabel();
		logo=new JLabel();
		lroom.setIcon(new ImageIcon(this.getClass().getResource("images/Room.jpeg")));
  	     lroom.setBounds(500,100, 470, 460);
  	   logo.setIcon(new ImageIcon(this.getClass().getResource("images/logos.jpg")));
	     logo.setBounds(815,20, 200, 80);
	     jp.add(lroom);
	     jp.add(logo);
	     
		arr=IO_Admin.getAllRooms();
		String rno []=new String[arr.size()+1];
		int i=1;
		rno[0]="Select";
		if(arr==null)
		arr=new ArrayList();
			
		for(Object o:arr)
		{
			Room r=(Room)o;
			rno[i++]=Integer.toString(r.getRoomno());
		}
		rno_cb=new JComboBox(rno);
		jp.add(rno_cb);
		r1.setSize(100, 30);
		r1.setLocation(200, 150);
		r2.setSize(100, 30);
		r2.setLocation(300, 150);
		l1.setSize(100, 30);
		l1.setLocation(70, 100);
		l2.setSize(100, 30);
		l2.setLocation(70, 150);
		l3.setSize(100, 30);
		l3.setLocation(70, 200);
		l4.setSize(100, 30);
		l4.setLocation(70, 250);
		
		l5.setSize(100, 30);
		l5.setLocation(70, 350);
		//t1.setSize(100, 30);
		//t1.setLocation(160, 50);
		t2.setSize(150, 30);
		t2.setLocation(180, 250);
		b1.setSize(100,30);
		b1.setLocation(400, 300);
		b1.addActionListener(this);
		b2.setSize(100,30);
		b2.setLocation(300, 300);
		b2.addActionListener(this);
		b3.setSize(100,30);
		b3.setLocation(200, 300);
		b3.addActionListener(this);
		rno_cb.addActionListener(this);
		
		rno_cb.setBounds(150,100,100,20);
		
	
		jf.setSize(1000,600);
		jf.setResizable(false);
		jf.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==rno_cb)
		{
			int rno=Integer.parseInt(rno_cb.getSelectedItem().toString());
			for(Object o: arr)
			{
			       
					Room temp=(Room)o;
					if(temp.getRoomno()==rno)
					{ 
						//r1.setText(temp.getRoomType());
						t2.setText(Integer.toString(temp.getRate()));
						t3.setText(temp.getRoomCategory());
						if(temp.getRoomType().equals("AC"))
							r1.setSelected(true);
						else
							r2.setSelected(true);	
					}
					
				}
				
					
			}
		if(e.getSource()==b1)
		{
			if(IO_Admin.Update_RoomRateByRoomno(Integer.parseInt(rno_cb.getSelectedItem().toString()),Integer.parseInt(t2.getText())))
					
				{  for(Object o:arr)
				    {
					Room r=(Room)o;
					if(r.getRoomno()==Integer.parseInt(rno_cb.getSelectedItem().toString()))
					{
					  r.setRate(Integer.parseInt(t2.getText()));
					  break;
					}
				    }
					l5.setText("updated success");
				}
			else
			{
				l5.setText("some problem");
			}		
				
				
		}
			
		}
		
		
	
	public static void main(String []args)
	{
		new UpdateRoom();
	}
	
}


