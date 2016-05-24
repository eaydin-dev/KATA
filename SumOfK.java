import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class SumOfK {
    
    public static void main(String[] args) {
    	int t = 430;
    	int k = 8;
    	List<Integer> superSet = new ArrayList<>(Arrays.asList(100,76,56,44,89,73,68,56,64,123,2333,144,50,132,123,34,89)); 		
    	
    	System.out.println(chooseBestSum(t, k, superSet));	// should print null

    	t = 230;
    	k = 4;
    	System.out.println(chooseBestSum(t, k, superSet));	// should print 230
    }

    public static Integer chooseBestSum(int t, int k, List<Integer> ls) {
    	if (t <= 0 || k <= 0 || ls.size() < k)
    		return null;

    	AtomicInteger max = new AtomicInteger(-1);
    	getMaxOfSubsets(ls, t, k, 0, new ArrayList<>(), max);
    	return max.intValue() == -1 ? null : max.intValue();
    }

    private static void getMaxOfSubsets(List<Integer> superSet, int t, int k, int index, List<Integer> currentSubSet, AtomicInteger max){
    	if (currentSubSet.size() == k){
    		int sum = currentSubSet.stream().mapToInt(Integer::intValue).sum();
    		if ( max.intValue() < sum && sum <= t)
    			max.set(sum);
    	}
    	else if(index == superSet.size())
    		return ;
    	else{
    		Integer x = superSet.get(index);
    		currentSubSet.add(x);

    		getMaxOfSubsets(superSet, t, k, index+1, currentSubSet, max);
    		currentSubSet.remove(x);
    		getMaxOfSubsets(superSet, t, k, index+1, currentSubSet, max);
    	}
    }
}