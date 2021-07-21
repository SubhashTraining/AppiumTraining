package SanjayCo.PracticeEx;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringToIntger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner (System.in);
		System.out.println("Enter the String with numbers:");
		String input = in.nextLine();
		stringToInteger(input);
		
	}
	
	public static void stringToInteger(String input)
	{
		
		Pattern pattern = Pattern.compile("(.)([\\d]+)(.)");
		Matcher matcher = pattern.matcher(input);
		
		List<Integer> integer= new ArrayList<>(); 
		while(matcher.find())
		{
			String match = matcher.group(2);
			integer.add(Integer.parseInt(match));		
					
		}
		
		integer.forEach( i-> System.out.println(i));
	}
	

}
