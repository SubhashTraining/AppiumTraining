package SanjayCo.PracticeEx;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ReverseString("Subhash");
		

	}
	
	
	public static void ReverseString(String input)
	{
		
		char[] array = input.toCharArray();
		
		int i=0;int j= input.length()-1;
		while(i<j)
		{
			swap(i,j,array);
			i++;j--;
			
			
		}
		
		System.out.println(array);
	}
	
	public static void swap(int i,int j, char[] input)
	{
		
		
		char temp = input[i];
		input[i] = input[j];
		input[j]= temp;
		
		
	}

}
