import java.util.List;
import java.util.ArrayList;

public class Highest2Factors {
    
	public static void main(String[] args) {
		long[] arr = highestBiPrimeFac(5, 11, 1000);
	}

    public static long[] highestBiPrimeFac(long p1, long p2, long n) {
    	List<int[]> list = new ArrayList<>();
    	int i = 1, j = 1;

        //long t = -1;

        for (i = 1; i < n; ++i){
        	if (Math.pow(p1, i) * Math.pow(p2, 1) > n)
        		break;
        	for (j = 1; j < n; ++j){
        		if (Math.pow(p1, i) * Math.pow(p2, j) > n){
        			//System.out.println("adding: " + Math.pow(p1, i) * Math.pow(p2, j-1));
        			int[] ta = new int[2];
        			ta[0] = i; ta[1] = j-1;
        			list.add(ta);
        			break;
        		}
        	}
        }

        long max = -1;
        long[] res = new long[3];

        for (i = 0; i < list.size(); ++i){
        	//t = Math.pow(p1, list.get(i)[0]) * Math.pow(p2, list.get(i)[1]);
        	if (Math.pow(p1, list.get(i)[0]) * Math.pow(p2, list.get(i)[1]) > max){
        		res[0] = Math.round(Math.pow(p1, list.get(i)[0]) * Math.pow(p2, list.get(i)[1]));
        		res[1] = list.get(i)[0];
        		res[2] = list.get(i)[1];
        		max = res[0];
        	}
        }

        //System.out.println("\n\n" + res[0] + " - " + res[1] + ", " + res[2]); 
        return res
    }

}