/**
	*** IMPORTANT ***

	BEFORE LOOKING AT THIS PIECE OF CODE, TRY TO SOLVE THE PROBLEM. THE PROBLEM IS:
	Consider the following numbers (where n! is factorial(n)):

	u1 = (1 / 1!) * (1!)

	u2 = (1 / 2!) * (1! + 2!)

	u3 = (1 / 3!) * (1! + 2! + 3!)

	un = (1 / n!) * (1! + 2! + 3! + ... + n!)

	Which will win: 1 / n! or (1! + 2! + 3! + ... + n!)?

	Are these number going to 0 because of 1/n! or to infinity due to the sum of factorials?
	Task:

	Calculate (1 / n!) * (1! + 2! + 3! + ... + n!) for a given n. Call this function "going(n)" where n is an integer greater or equal to 1.

	To avoid discussions about rounding, if the result of the calculation is designed by "result", going(n) will return "result" truncated to 6 decimal places.
	Examples:

	1.0000989217538616 will be truncated to 1.000098

	1.2125000000000001 will be truncated to 1.2125
	Remark:

	Keep in mind that factorials grow rather rapidly, and you can need to handle large inputs.
 
*/



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

