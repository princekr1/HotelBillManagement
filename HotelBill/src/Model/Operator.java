package Model;

import java.io.Serializable;

public class Operator implements Serializable
{
   private String operatorId;
   private String password;
   private String aType;
   private String name;
   private String mobileNo;
   private String status;
   
   
   public Operator(String oId, String n,String m,String pwd,String type,String s)
   {
	   operatorId=oId;
	   password=pwd;;
	   aType=type;
	   name=n;
	   mobileNo=m;
	   status=s;
   }
   public String getOperatorId()
   {
	   return operatorId;
   }
   public void setPassword(String p)
   {
	   password=p;
   }
   public String getPassword()
   {
	   return password;
   }
   public void  setAtype(String a)
   {
	   aType=a;
   }
   public String getOperatorName()
   {
	   return name;
   }
   public String getOperatorMobileNo()
   {
	   return mobileNo;
   }
   public void setOperatorMobileNo(String m)
   {
	   mobileNo=m;
   }
   public String getOperatorStatus()
   {
	   return status;
   }
   public void setOperatorStatus(String s)
   {
	   status=s;
   }
   public void setMobile(String m)
   {
	   mobileNo=m;
   }
}