package InputOutput;
import java.io.*;
import java.util.*;
import Model.*;
public class IO_operator 
{
	private static ArrayList arr=new ArrayList();
	private static FileOutputStream fout;
	private static FileInputStream fin;
	private static ObjectInputStream oin;
	private static ObjectOutputStream oout;
	private static Scanner scan;
	public static boolean logIn(String id,String pwd)
	{
		System.out.println("id:"+id+"  pwd:"+pwd);
			   try
			   {
				   fin=new FileInputStream("operator.dat");
				   	oin=new ObjectInputStream(fin);
				   	arr=(ArrayList)oin.readObject();
				   	fin.close();
					oin.close();  
					Operator t;
					for(Object o: arr)
					{   t=(Operator)o;
					    if(t.getOperatorId().equals(id))
					    {
					    	if(t.getPassword().equals(pwd))
					    	{
					    		return true;
					    	}
					    }  			    
				   
					}
					
				return false;
			}
				catch(Exception e)
				{
					e.printStackTrace();
					return false;
				}
				
		
	}
	public boolean addOperator(String id,String pwd,String at)
	{
		return false;
	}
	public static int changePassword(String id,String opwd,String npwd)
	{
		try
		{
			  File f= new File("Operator.dat");
			  
		     if(f.exists()==true)
		     {
		    	 
			   fin=new FileInputStream("Operator.dat");
			   	oin=new ObjectInputStream(fin);
			   	arr=(ArrayList)oin.readObject();
			   	fin.close();
				oin.close(); 
			    Operator op;
			     for(Object o : arr)
				   	{
				   		op=(Operator)o;
				   		if(op.getOperatorId().equals(id))
				   		{
				   			if(op.getPassword().equals(opwd))
				   			{
				   				op.setPassword(npwd);
				   				fout=new FileOutputStream("operator.dat");
				   				oout=new ObjectOutputStream(fout);
				   				arr.add(op);
				   				oout.writeObject(arr);
				   				fout.close();
				   				oout.close();
				   				
				   				return 0;
				   			
				   			}
				   			return 1;
				   		}
				   	}
		     }
		    
		     return 2;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return 3;
		}	
	}
	public static boolean addBill(Bill b1)
	{ 
		System.out.println(b1.getBill_no()+" "+b1.getOperatorId()+" "+b1.getCustomer_name()+" "+b1.getCustomer_details()+b1.getStatus()+" "+b1.getRoom_no()+" "+b1.getTotal_amount()+" "+b1.getRemaining_amount()+" "+b1.getBooking_date());
		try
		{
			  File f= new File("Bill.dat");
			  
		     if(f.exists()==true)
		     {
			   fin=new FileInputStream("Bill.dat");
			   	oin=new ObjectInputStream(fin);
			   	arr=(ArrayList)oin.readObject();
			   	fin.close();
				oin.close();  
		     }
		     
		    fout=new FileOutputStream("Bill.dat");
			oout=new ObjectOutputStream(fout);
			arr.add(b1);
			oout.writeObject(arr);
			
			oout.close();
			fout.close();
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		} 
	 
	}
	public static int genBillNo()
	{
		Bill b;
		 int newbill=1000;
		File f= new File("Bill.dat");
		  
	     if(f.exists()==false)
	     {
		    return (newbill+1);
	     }
	     try
		   {
	        fin=new FileInputStream("Bill.dat");
		   	oin=new ObjectInputStream(fin);
		   	arr=(ArrayList)oin.readObject();
		   	fin.close();
			oin.close(); 
			for(Object o : arr)
		   	{
		   		b=(Bill)o;
		   		if(b.getBill_no()>newbill)
		   			newbill=b.getBill_no();
		   	}
			
		
			return (newbill+1);
		   }
			catch(Exception e)
			{
				e.printStackTrace();
				return 0;
			} 
	}
	public static int getRoomRate(int rno)
	{
		try
		{
		fin=new FileInputStream("room.dat");
	   	oin=new ObjectInputStream(fin);
	   	arr=(ArrayList)oin.readObject();
	   
	   	for(Object o : arr)
	   	{
	   		Room r=(Room)o;
	   		System.out.println(r.getRoomno()+" "+r.getRoomCategory()+ " "+r.getRoomType()+" "+r.getRate());
	   		if(r.getRoomno()==rno)
	   				return (r.getRate());
	   	}
	   	fin.close();
		oin.close();
		return 0;
		}
		catch(Exception e)
		{
			return 1;
		}
	}
	public static String getStatus(int rno)
	{
		try{
		fin=new FileInputStream("room.dat");
	   	oin=new ObjectInputStream(fin);
	   	arr=(ArrayList)oin.readObject();
	   
	   	for(Object o : arr)
	   	{
	   		Room r=(Room)o;
	   		System.out.println(r.getRoomno()+" "+r.getRoomCategory()+ " "+r.getRoomType()+" "+r.getRate());
	   		if(r.getRoomno()==rno)
	   				return (r.getRoomStatus());
	   	}
	   	fin.close();
		oin.close();
		return null;
		}
		catch(Exception e)
		{
			return null ;
		}
	}
		
	
	public static int [] getAllBillNo()
	{
		try
		   {
	        fin=new FileInputStream("Bill.dat");
		   	oin=new ObjectInputStream(fin);
		   	arr=(ArrayList)oin.readObject();
		   	fin.close();
			oin.close();
			Bill b;
			int []s = new int[arr.size()];
			int i=0;
			for(Object o : arr)
		   	{
		   		b=(Bill)o;
		   		s[i]=b.getBill_no();
		   		i++;
		   	}
			return s;
		   }
			catch(Exception e)
			{
				e.printStackTrace();
				return null;
			} 
	}

	public static Bill showBillDetail(int bill_no)
	{
		Bill b = null;
		 File f= new File("Bill.dat");
		  
	     if(f.exists()==false)
	     {
		    return b;
	     }
	     try
		   {
	        fin=new FileInputStream("Bill.dat");
		   	oin=new ObjectInputStream(fin);
		   	arr=(ArrayList)oin.readObject();
		   	fin.close();
			oin.close(); 
			for(Object o : arr)
		   	{
		   		b=(Bill)o;
		   		if(b.getBill_no()==bill_no)
		   		{
		   			return b;
		   			
		   		}
		   	}
		  }	
	     catch(Exception e)
			{
				e.printStackTrace();
				return null;
			}
		return b; 
	}
	public static Operator getOperator(String id)
	{
		Operator op = null;
		 File f= new File("Bill.dat");
		  
	     if(f.exists()==false)
	     {
		    return op;
	     }
	     try
		   {
	        fin=new FileInputStream("operator.dat");
		   	oin=new ObjectInputStream(fin);
		   	arr=(ArrayList)oin.readObject();
		   	fin.close();
			oin.close(); 
			for(Object o : arr)
		   	{
		   		op=(Operator)o;
		   		if(op.getOperatorId()==id)
		   		{
		   			return op;
		   			
		   		}
		   	}
		  }	
	     catch(Exception e)
			{
				e.printStackTrace();
			}
		return op;
		
	}
	public static int getCollectionDate(Date d, String oid)
	{
		try
		{
			File f= new File("Bill.dat");
			  
		     if(f.exists()==false)
		     {
			    return 0;
		     }
		fin=new FileInputStream("Bill.dat");
	   	oin=new ObjectInputStream(fin);
	   	arr=(ArrayList)oin.readObject();   	
	   	
	   	fin.close();
		oin.close();
		
		int tot=0;
		for(Object o:arr)
		{
			Bill b=(Bill)o;
			Date d1=b.getBilling_date();
			
			System.out.println(b.getOperatorId()+" "+d1.getDate()+ " "+d.getDate()+"  "+b.getTotal_amount());
			if(d1.getYear()==d.getYear() && d1.getMonth()==d.getMonth() && d1.getDate()==d.getDate() && oid.equals(b.getOperatorId()))
					tot=tot+b.getTotal_amount();
		}
		System.out.println("total:"+tot);
		return tot;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return 0;
		}
	}

	
}
