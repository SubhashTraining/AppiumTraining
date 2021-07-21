package SanjayCo.PracticeEx;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DuplicateWords {
	
	
	public static void main(String args[])
	{
		
		Scanner in  = new Scanner(System.in).useDelimiter("\n");
		
		for(int i =1;i<=5;i++)
		{
			
			System.out.println("Enter the String:");
			DuplicateWord(in.nextLine());
			
		}
		
	}
	
	public static void DuplicateWord(String input)
	{
		
		String[] stringArray = input.split(" ");
		Map<String,Integer> words = new HashMap<>();
		
		for(String word : stringArray)
		{
			
			int count = words.getOrDefault(word, 0);
			words.put(word,count+1);
		}
		
		words.forEach((k,v)->System.out.println(k+":"+v));
		
		
		
	}
	

}
