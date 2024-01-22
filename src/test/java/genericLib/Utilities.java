package genericLib;

import java.util.Iterator;
import java.util.Random;

import org.testng.Reporter;

import net.bytebuddy.utility.RandomString;

public class Utilities {

	public String generateRandomGmail()
	{
		String rand=RandomString.make(5);
		return rand+"123"+"@gmail.com";
	}
	
	public void verifyExpString(String input, String expString)
	{
		boolean rv = input.equals(expString);
		if (rv) 
		{
			Reporter.log(expString+" is matchig",true);
		}
		else
		{
			Reporter.log(expString+" is not matchig",true);
		}
	}
	
	public int generateRandomNum(int digits)
	{
		int min=1;
		int max=1;
		for (int i = 1; i < digits; i++) 
		{
			min=min*10;
		}
		for (int i = 1; i <= digits; i++) 
		{
			max=max*10;
		}
		
		Random rand=new Random();
		return rand.nextInt(min, max-1);
	}
}
