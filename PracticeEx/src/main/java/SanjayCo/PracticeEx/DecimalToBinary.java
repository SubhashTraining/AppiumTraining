package SanjayCo.PracticeEx;

public class DecimalToBinary {
	
	public static void main(String args[])
	{
		
		decimalToBinary(45454);
		
		
		
		
		
		
	}
	
	public static void decimalToBinary(int decimal)
	{
		
		if(decimal!=0)
		{
			decimalToBinary(decimal/2);
			System.out.print(decimal%2);
		}
		
	}

}
