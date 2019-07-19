package Model;

import java.io.Serializable;
import java.util.Date;

public class Bill implements Serializable
{
	private int bill_no;
	private Date billing_date;
	private String operatorId;
	private String customer_name;
	private String customer_details;
	private String status;
	private int room_no;
	private int total_amount;
	private int advance_amount;
	private int remaining_amount;
	private Date booking_date;
	
	public Bill(int bn,Date bd,String oid,String cn,String cd,String st,int rn,int ta,int aa,int ra,Date bkd)
	{
		bill_no=bn;
		billing_date=bd;
		operatorId=oid;
		customer_name=cn;
		customer_details=cd;
		status=st;
		room_no=rn;
		total_amount=ta;
		advance_amount=aa;
		remaining_amount=ra;
		booking_date=bkd;

	}
	public int getBill_no()
	{
		return bill_no;
	}
	public Date getBilling_date()
	{
		return billing_date;
	}
	public String getOperatorId()
	{
		return operatorId;
	}
	public String getCustomer_name()
	{
		return customer_name;
	}
	public String getCustomer_details()
	{
		return customer_details;
	}
	public void setStatus(String st)
	{
		status=st;
	}
	public String getStatus()
	{
		return status;
	}
	public int getRoom_no()
	{
		return room_no;
	}
	public int getTotal_amount()
	{
		return total_amount;
	}
	public int getAdvance_amount()
	{
		return advance_amount;
	}
	public void setRemaining_amount(int ra)
	{
		remaining_amount=ra;
	}
	public int getRemaining_amount()
	{
		return remaining_amount;
	}
	public void setBooking_date(Date bkd)
	{
		booking_date=bkd;
		
	}
	public Date getBooking_date()
	{
		return booking_date;
		
	}
	

}
