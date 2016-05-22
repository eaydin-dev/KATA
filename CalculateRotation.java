



public class CalculateRotation {
	  

  	public static void main(String[] args) {
		//System.out.println((-2%4));
		System.out.println(shiftedDiff2("coffee", "eecoff"));
	}

	static int shiftedDiff(String first, String second){
	    
	    if (first == null || second == null || first.length() != second.length())
	    	return -1;

	   	for (int i = 1; i < first.length(); ++i) {
	   		String rotated = rotate(first, i);
	   		if (second.equals(rotated))
	   			return i;
	   	}

	   	return -1;
	}

	static int shiftedDiff2(String first, String second){
	    if (first.length() != second.length())
	            return -1;
	    return (second + second).indexOf(first);
	}

  	public static String rotate(String inp, int n) {
  	// Your code here
  		char[] data = inp.toCharArray();
		int num = n % data.length;
		//System.out.println("in func: " + num);
		if (n < 0)
			num = data.length + num;

		if (num == 0 || num % data.length == 0)
			return null;

		//num = num % data.length;

		char[] temp = new char[data.length];

		for (int j = 0; j < data.length; ++j) {
			temp[(j+num)%data.length] = data[j];
		}

		return new String(temp);
    }
}