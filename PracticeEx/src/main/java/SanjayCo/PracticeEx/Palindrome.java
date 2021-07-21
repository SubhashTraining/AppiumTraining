package SanjayCo.PracticeEx;

import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the String");
		String input = in.nextLine();
		Palindrome(input);
		
		
		
		
		
	}
	
	public static void Palindrome(String input)
	{
		
		char[] inputArray = input.toCharArray();
		
		int i=0;
		int j=inputArray.length-1;
		while(i<j)
		{
			
			if(!(inputArray[i]==inputArray[j]))
			{
				System.out.println("The given String is not a Palindrome");
				return;
			}
				
			i++;
			j--;
		}
		
		System.out.println("The given String is a Palindrome");
	}

}
