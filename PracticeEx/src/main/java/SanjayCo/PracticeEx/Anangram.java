package SanjayCo.PracticeEx;

import java.util.Arrays;

public class Anangram {
	
	public static void main(String args[])
	{
		
		anagram1("maam","aamm");
		anagram1("mama","maaa");
		
		anagram2("maam","aamm");
		anagram2("mama","maaa");
	}
	
	
	public static void anagram1(String input1, String input2)
	{
		
		char[] string1 = input1.toCharArray();
		char[] string2 = input2.toCharArray();
		Arrays.sort(string1);
		Arrays.sort(string2);
		
		if(Arrays.equals(string1, string2))
		{
			System.out.println("The two Strings are anagaram");
		}
		else
		{
			System.out.println("The two string are not ananagram");
		}
	}
	
	public static void anagram2(String input1, String input2)
	{
			
		
		char[] string1 = input1.toCharArray();
		String string2 = input2;
		
		for(int i=0;i<=input1.length()-1;i++)
		{
			
			int index = string2.indexOf(string1[i]);
			if(index==-1)
			{
				System.out.println("The strings are not anagram");return;
			}
				
			string2 = string2.substring(0,index)+string2.substring(index+1);	
		}
		if(string2.isEmpty())
		{
			System.out.println("The strings are anagaram");
		}
		else
		{
			System.out.println("The strings are not anagram");
		}
		
			
		
			
			
			
					
		
		
		
	
	}
	

}
