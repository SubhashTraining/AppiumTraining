package SanjayCo.PracticeEx;

public class PowerOfNo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(powerOfNumber(4,5));
		
		
	}
	
	public static int powerOfNumber(int no, int power)
	{
		
		if(power==0) return 1;
		else
		{
			return no * powerOfNumber(no,power-1); 
		}
	}

}
