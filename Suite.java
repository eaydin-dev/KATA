import java.math.BigDecimal;

public class Suite {
	
	public static void main(String[] args) {
		System.out.println("5: " + going(5));
		System.out.println("6: " + going(6));
		System.out.println("7: " + going(7));
		System.out.println("20: " + going(20));
	}

	public static double going(int n) {
		double result;

		// to calculate extra large factorials, create BigDecimal with initial value of 1
		BigDecimal fact = new BigDecimal(1);//.setScale(6, BigDecimal.ROUND_UNNECESSARY);

		// to sum up all these factorials, create another BigDecimal object with initial value of 0
		// set its scale to 6. fact object does not need this since we are handling it here.
		BigDecimal chainOfFact = new BigDecimal(0).setScale(6, BigDecimal.ROUND_UNNECESSARY);

		for (int i = 1; i <= n; ++i) {
			fact = fact.multiply(BigDecimal.valueOf(i));
			chainOfFact = chainOfFact.add(fact);
		}

		try{
			result = chainOfFact.divide(fact, BigDecimal.ROUND_UNNECESSARY).doubleValue();
		} catch(ArithmeticException ex){
			result = chainOfFact.divide(fact, BigDecimal.ROUND_FLOOR).doubleValue();
		}

		return result; 
	}
}

