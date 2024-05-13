package GenericUtility;

import java.util.Random;

public class JavaUtils {
	
	public static int randomNumber()
	{
		Random ran=new Random();
		int randomInteger = ran.nextInt(10000);
		return randomInteger;
	}
   public static String AlphaNumeric(int n)
   {
	   String AlphaNumericstring = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrst";
	   StringBuilder sb = new StringBuilder(n);
	   for(int i=0;i<n;i++)
	   {
		   int index 
		    = (int)(AlphaNumericstring.length() 
		      * Math.random()); 
		   sb.append(AlphaNumericstring).charAt(index);
	   }
	   
	   return sb.toString();
   }
   
   
}
