import java.math.BigDecimal;

public class Suite {
	
	public static void main(String[] args) {
		System.out.println("5: " + going(5));
		System.out.println("6: " + going(6));
		System.out.println("7: " + going(7));
		System.out.println("20: " + going(20));
	}

	public static double going(int n) {
		double first = (1.0/factorial(n));
		long chain = chainFactorial(n);
		BigDecimal bd = new BigDecimal(String.valueOf(first * chain)).setScale(6, BigDecimal.ROUND_HALF_UP);
		return Double.parseDouble(bd.toString());
	}

	public static long chainFactorial(int n){
		long result = 0;
		for (int i = 1; i <= n; ++i)
			result += factorial(i);
		
		return result;
	}

	public static long factorial(int n) {
	    long fact = 1;
	    for (int i = 1; i <= n; i++)
	        fact *= i;
	    
	    return fact;
	}
}

