package Lesson150303;

public class Flipping_bits {
	public static void main(String[] args) {

		java.util.Scanner scanner = new java.util.Scanner(System.in);
		
		long a = 0, tests = 0;
		tests = scanner.nextInt();  
		
		for (int t = 0; t < tests; t++) 
		{
			a = scanner.nextInt();
	
			int [] bits = new int [32];
			for (int i = 31; i >= 0; i--)
			{
				if (a%2 == 0)
				{
					bits[i] = 1;
					a = a/2;
				}
				else
				{
					bits[i] = 0;
					a = (a-1)/2;
				}
			}
			long res = 0, pow = 1;
			
			for (int i = 31; i >= 0; i--)
			{
				res = res + bits[i]*pow;
				pow*=2;
			}
			System.out.println(res);
		}
	}
}
