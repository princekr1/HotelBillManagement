package UserInterface;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import InputOutput.IO_Admin;
import Model.Operator;
import Model.Room;

public class DeleteOperator implements ActionListener
{
	public static void main(String args[])
	{
		new DeleteOperator();
	}
	JFrame fr;
	JPanel jp;
	JLabel l1,msg;
	JTextField t1;
	JButton b1;
	ArrayList arr;
	JComboBox rno_cb;
	String []at=new String[100];
	JComboBox j1;
	DeleteOperator()
	{
		
		fr=new JFrame();
		jp=new JPanel();
		arr=IO_Admin.getOperotorIDs();
		

		int i=1;
		at[0]="select";
		for(Object o: arr)
		{   Operator op=(Operator)o;
		    at[i]=op.getOperatorId();
		    i++;
		}
		j1=new JComboBox(at);
		j1.setBounds(160, 50, 100, 30);
		jp.add(j1);
		t1=new JTextField();
		l1=new JLabel("Operator id");
		msg=new JLabel("");
		l1.setBounds(60,50,100,30);
		msg.setBounds(60,150,100,30);
		//t1.setBounds(160, 50, 100, 30);
		b1=new JButton("Delete");
		b1.setBounds(100,100,100,30);
		jp.setBackground(Color.BLUE);
		
		fr.add(jp);
		jp.add(l1);
		jp.add(msg);
		//jp.add(t1);
		jp.add(b1);
		
		jp.setLayout(null);
		fr.setSize(300,300);
		fr.setVisible(true);
	
		
		b1.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b1)
		{
		if(IO_Admin.deleteOperator(j1.getSelectedItem().toString())==true)
		{
			msg.setText("deleted");
		}
		}
		
	}
	
}
