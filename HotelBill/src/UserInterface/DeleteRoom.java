package UserInterface;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import InputOutput.IO_Admin;
import Model.Room;

public class DeleteRoom implements ActionListener {

	private JFrame jf;
	private JPanel jp;
	private JButton b1;
	private JTextField t1;
	private JLabel l1,l2,lroom,logo;
	private ArrayList arr;
	private JComboBox rno_cb;
	DeleteRoom()
	{
		jf=new JFrame();
		jp=new JPanel();
		t1=new JTextField();
		b1=new JButton("Delete");
		l1=new JLabel("Room No");
		l2=new JLabel("");
		jf.add(jp);
		jp.add(b1);
		jp.setLayout(null);
		jp.add(l1);
		jp.add(t1);
		jp.add(l2);
		
		lroom=new JLabel();
		logo=new JLabel();
		lroom.setIcon(new ImageIcon(this.getClass().getResource("images/Room.jpeg")));
  	     lroom.setBounds(300,100, 470, 460);
  	   logo.setIcon(new ImageIcon(this.getClass().getResource("images/logos.jpg")));
	     logo.setBounds(615,20, 200, 80);
	     jp.add(lroom);
	     jp.add(logo);
	     jp.setBackground(Color.blue);
		l1.setSize(100, 30);
		l1.setLocation(90, 100);
		//t1.setSize(100, 30);
		//t1.setLocation(150, 100);
		b1.setSize(100, 30);
		b1.setLocation(130, 150);
		l2.setSize(200, 30);
		l2.setLocation(120, 200);
		
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
		rno_cb.setBounds(150, 100, 100, 30);
		
		jp.add(rno_cb);
		b1.addActionListener(this);
		jf.setSize(800,600);
		jf.setResizable(false);
		jf.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(IO_Admin.delete_RoomRateByRoomno(Integer.parseInt(rno_cb.getSelectedItem().toString())))
		{
				l2.setText("Deleted Room");
		}
		else
			l2.setText("room doesnot exist");
		
		
	}
	public static void main(String []args)
	{
		new DeleteRoom();
	}
	
}


	

