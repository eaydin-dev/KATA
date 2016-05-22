
import java.util.List;
import java.util.ArrayList;

class Cubes {
	
	public static void main(String[] args) {
		/*List<Integer> intList = new ArrayList<>();
		handleLargeNum(1234567, intList);
		for (int i = 0; i < intList.size(); ++i){
			System.out.println("> " + intList.get(i));
    	}*/

		System.out.println(isSumOfCubes("QK29 45[&erui"));
	}

	public static String isSumOfCubes(String s) {
		int num;
		s = s.replaceAll("[^0-9]+", " ");
		String[] strArr = s.trim().split(" ");
		List<Integer> intList = new ArrayList<>();
		List<Integer> cubics = new ArrayList<>();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < strArr.length; ++i){
			num = Integer.parseInt(strArr[i]);
			if (numOfDigits(num) > 3)
				handleLargeNum(num, intList);
			else
				intList.add(num); 
		}
    	
    	for (int i = 0; i < intList.size(); ++i){
    		if (isCubic(intList.get(i))){
    			//System.out.println("> cubic: " + intList.get(i));
    			sb.append(intList.get(i)).append(" ");
    			cubics.add(intList.get(i));
    		}
    	}

    	if (!cubics.isEmpty()){
    		sb.append(cubics.stream().mapToInt(Integer::intValue).sum()).append(" Lucky");
    		return sb.toString();
    	}

    	else 
    		return "Unlucky";
	}

	private static boolean isCubic(int num){
		int temp = num;
		int sum = 0;

		while(temp > 0){
			sum += Math.pow(temp%10, 3);
			temp /= 10;
		}

		return sum == num;
	}

	private static void handleLargeNum(int num, List<Integer> list){
		String s = "" + num;
		String n = "";
		String r = "";

		char[] arr = s.toCharArray();

		int i;
		for(i = 0; i < 3; ++i){
			n += arr[i];
		}

		for (; i < arr.length; ++i){
			r += arr[i];
		}

		list.add(Integer.parseInt(n));

		int remain = Integer.parseInt(r);
		if (numOfDigits(remain) <= 3)
			list.add(remain);
		else
			handleLargeNum(remain, list);
	}

	private static int numOfDigits(int num){
		int c = 0;
		while(num > 0){
			c++;
			num /= 10;
		}

		return c;
	}
}
