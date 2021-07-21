package SanjayCo.PracticeEx;

public class BinaryToDecimal {
	
	public static void main(String args[])
	{
		
		binaryToDecimal("1111");
		
	}
	
	
	public static void binaryToDecimal(String binary)
	{
		
		Integer[] integerArray = new Integer[binary.length()];
		for(int i=0;i<binary.length();i++)
		{
			
			integerArray[i]= Integer.parseInt(Character.toString(binary.charAt(i)));
			
			
		}
		
		int decimal=0;
		int power=0;
		for(int i=integerArray.length-1;i>=0;i--)
		{
			decimal = (int) (decimal+ (integerArray[i]*Math.pow(2, power)));
			power++;
		}
		System.out.println(decimal);
		
	}
	

}
