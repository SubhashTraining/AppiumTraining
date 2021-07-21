package SanjayCo.PracticeEx;

public class fibnocciSeries {
	
	
	public static void main(String args[])
	{
	for(int i=1;i<=10;i++)
	{
		System.out.print(fibnocii(i));
		System.out.print(" ");
	}

	}
	
	public static int fibnocii(int n)
	{
		if(n==1 || n==0) return 1;
		else
			return fibnocii(n-1)+fibnocii(n-2);
		
	}
	
}
