package UserInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Table  implements ActionListener
{

	JFrame f1;
	JComboBox cb;
	JLabel lbl1;
	JTable table;
	String oper="";
	String []course={ "Select","B.Tech","M.Tech","BCA","MCA"};
	
	String []stud_det={"Name","Roll","Marks","Course","Grade"};
	String [][]bca_data=new String[200][10];
	JScrollPane scroll;	
	Table()
	{
		f1=new JFrame("Show Details");		
		lbl1=new JLabel("Course:");
		lbl1.setBounds(20, 20, 80, 20);		
		cb=new JComboBox(course);
		cb.setBounds(120, 20, 120, 20);
		table=new JTable(bca_data,stud_det);
		table.setBackground(Color.CYAN);
		table.setBounds(40, 80, 400, 400);
		scroll=new JScrollPane(table);
		scroll.setBounds(450, 80, 10, 400);
		f1.add(lbl1);f1.add(cb);f1.add(table);f1.add(scroll);
		f1.setLayout(null);
	    f1.setExtendedState(JFrame.MAXIMIZED_BOTH);
	   
	    f1.setResizable(false);
	    f1.setVisible(true); 
	    f1.setSize(500, 500);
	    cb.addActionListener(this);
		
	}
	public void actionPerformed(ActionEvent e)
	{
		
		
	}
	public static void main(String []args)
	{
		new Table();
	}
	
	
}

