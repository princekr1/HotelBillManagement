package Model;
import java.io.Serializable;
import java.util.*;
public class Room implements Serializable
{
	private String room_status;
	private int rate;			
	private String room_type;				//room type
	private int room_no;
	private String room_cat;
	private String room_feature;
	ArrayList ar=new ArrayList();        //textarea
	public Room(String rs,int r,String rt,int rno,String rc,String rf){
		room_status=rs;
		rate=r;
		room_type=rt;
		room_no=rno;
		room_cat=rc;
		room_feature=rf;
	}
	public String getRoomType()
	{
		return room_type;
	}
	
	public int getRate()
	{
		return rate;
	}
	public int getRoomno()
	{
		return room_no;
	}
	public void setRate(int r)
	{
		rate=r;
	}
	public void setType(String ty)
	{
		room_type=ty;
	}
	public void setRoomFeature(String fet)
	{
		room_feature=fet;
	}
	public String getRoomFeature()
	{
		return room_feature;
	}
	public String getRoomCategory()
	{
		return room_cat;
	}
	public void setRoomStatus(String st)
	{
		room_status=st;
	}
	public String getRoomStatus()
	{
		return room_status;
	}

}
