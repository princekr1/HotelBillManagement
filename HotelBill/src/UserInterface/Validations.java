package UserInterface;
import java.text.SimpleDateFormat;
public class Validations
{
	public static boolean isDigit(String d)
	{
		for(int i=0;i<d.length();i++)
		{
			char c=d.charAt(i);
			if(Character.isDigit(c)==false && c!='.')
				return false;
		}
		return true;
	}
	public static boolean isAlpha(String d)
	{
		for(int i=0;i<d.length();i++)
		{
			char c=d.charAt(i);
			if(Character.isAlphabetic(c)==false && Character.isWhitespace(c)==false)
				return false;
		}
		return true;
		
	}
	public static boolean isAlphaNum(String d)
	{
		for(int i=0;i<d.length();i++)
		{
			char c=d.charAt(i);
			if(Character.isAlphabetic(c)==false && Character.isDigit(c)==false)
				return false;
		}
		return true;
	}
	public static boolean isDate(String d)
	{
		SimpleDateFormat df=new SimpleDateFormat("dd-MMM-YYYY");
		try
		{
			df.parse(d);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

}
