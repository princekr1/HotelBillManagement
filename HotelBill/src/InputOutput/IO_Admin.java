package InputOutput;
import java.io.*;
import java.util.*;

import Model.*;


public class IO_Admin
{
	
   static FileOutputStream fout;
   static FileInputStream fin;
   static ObjectInputStream oin;
   static ObjectOutputStream oout;
   static ArrayList arr=new ArrayList();
	 public static boolean addOperator(Operator op)
	 {
		   try
		   {
			   File f= new File("room.dat");
				  
			 if(f.exists()==true)
			 {
			   fin=new FileInputStream("operator.dat");
			   	oin=new ObjectInputStream(fin);
			   	arr=(ArrayList)oin.readObject();
			   	fin.close();
				oin.close();  
			 }
		    fout=new FileOutputStream("operator.dat");
			oout=new ObjectOutputStream(fout);
			arr.add(op);
			oout.writeObject(arr);
			System.out.print(op.getOperatorId());
			System.out.println(op.getPassword());
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
	 public static boolean deleteOperator(String id)
	 {
		 try
		   {
			   fin=new FileInputStream("operator.dat");
			   	oin=new ObjectInputStream(fin);
			   	arr=(ArrayList)oin.readObject();
			   	fin.close();
				oin.close();
				Operator t;
				System.out.println(id);
				for(Object o: arr)
				{   t=(Operator)o;
				    if(t.getOperatorId().equals(id))
				    {
				    	arr.remove(t);
						fout=new FileOutputStream("operator.dat");
						oout=new ObjectOutputStream(fout);
					
						oout.writeObject(arr);
						oout.close();
						fout.close();
				       return true;
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
	public static boolean Update_OperatorPwdMob(String oid,String pwd,String ph) 
	{
		 try
		   {
		    fin=new FileInputStream("operator.dat");
		   	oin=new ObjectInputStream(fin);
		   	arr=(ArrayList)oin.readObject();
		   	fin.close();
			oin.close();
			for(Object o:arr)
			{
				Operator op=(Operator)o;
				if(op.getOperatorId().equals(oid))
				{
				op.setPassword(pwd);
				op.setMobile(ph);
				fout=new FileOutputStream("operator.dat");
				oout=new ObjectOutputStream(fout);
				
				oout.writeObject(arr);
				oout.close();
				fout.close();
				return true;
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
	//public static 
	public static ArrayList getOperotorIDs()
	{  		try
		{
		     fin=new FileInputStream("operator.dat");
		   	oin=new ObjectInputStream(fin);
		   	arr=(ArrayList)oin.readObject();
		   	
		   	fin.close();
			oin.close();
			return arr;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
	}
	public static Operator getOperator(String id)
	{
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
				       return t;
				}
				return null;
		   }
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
	}
	public static ArrayList getRoomsByCatgType(String rct,String rt)
	{
		try
		{
		fin=new FileInputStream("room.dat");
	   	oin=new ObjectInputStream(fin);
	   	arr=(ArrayList)oin.readObject();
	   	ArrayList temp=new ArrayList();
	   	for(Object o : arr)
	   	{
	   		Room r=(Room)o;
	   		
	   		if(r.getRoomCategory().equals(rct) && r.getRoomType().equals(rt))
	   			{System.out.println(r.getRoomno()+" "+r.getRoomCategory()+ " "+r.getRoomType()+" "+r.getRate());
	   				temp.add(r);
	   			}
	   	}
	   	fin.close();
		oin.close();
		return temp;
		}
		catch(Exception e)
		{
			return null;
		}
	}
	public static ArrayList getAllRooms()
	{
		try
		{
		fin=new FileInputStream("room.dat");
	   	oin=new ObjectInputStream(fin);
	   	arr=(ArrayList)oin.readObject();   	
	   	
	   	fin.close();
		oin.close();
		return arr;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	 public static boolean addRoom(Room r)
	 {
		   try
		   {
			  File f= new File("room.dat");
			  
		     if(f.exists()==true)
		     {
			   fin=new FileInputStream("room.dat");
			   	oin=new ObjectInputStream(fin);
			   	arr=(ArrayList)oin.readObject();
			   	fin.close();
				oin.close();  
		     }
		     
		    fout=new FileOutputStream("room.dat");
			oout=new ObjectOutputStream(fout);
			arr.add(r);
			System.out.println(r.getRoomno()+" "+r.getRoomCategory()+" "+r.getRate());
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
	 public static boolean Update_RoomRateByRoomno(int roomno, int nrate) 
		{
		 System.out.println(roomno+" "+nrate);
			 try
			   {
			    fin=new FileInputStream("room.dat");
			   	oin=new ObjectInputStream(fin);
			   	arr=(ArrayList)oin.readObject();
			   	fin.close();
				oin.close();
				for(Object o:arr)
				{
					Room r=(Room)o;
					if(r.getRoomno()==roomno)
					{
					  r.setRate(nrate);
					fout=new FileOutputStream("room.dat");
					oout=new ObjectOutputStream(fout);
					
					oout.writeObject(arr);
					oout.close();
					fout.close();
					return true;
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
	 public static boolean delete_RoomRateByRoomno(int roomno) 
		{
		
			 try
			   {
			    fin=new FileInputStream("room.dat");
			   	oin=new ObjectInputStream(fin);
			   	arr=(ArrayList)oin.readObject();
			   	fin.close();
				oin.close();
				for(Object o:arr)
				{
					Room r=(Room)o;
					if(r.getRoomno()==roomno)
					{
					 arr.remove(r);
					fout=new FileOutputStream("room.dat");
					oout=new ObjectOutputStream(fout);
					
					oout.writeObject(arr);
					oout.close();
					fout.close();
					return true;
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
	public static boolean checkRoomNO(int rno) {
		try
		   {
		    fin=new FileInputStream("room.dat");
		   	oin=new ObjectInputStream(fin);
		   	arr=(ArrayList)oin.readObject();
		   	fin.close();
			oin.close();
			for(Object o:arr)
			{
				Room r=(Room)o;
				if(r.getRoomno()==rno)
				{
					return true;
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
	public static boolean checkOperatorId(String o_id)
	{
		 try
		   {
		    fin=new FileInputStream("operator.dat");
		   	oin=new ObjectInputStream(fin);
		   	arr=(ArrayList)oin.readObject();
		   	fin.close();
			oin.close();
			for(Object o:arr)
			{
				Operator op=(Operator)o;
				if(op.getOperatorId().equals(o_id))
				{
					return true;
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
	
}
