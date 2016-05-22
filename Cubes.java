import java.util.List;
import java.util.ArrayList;

class Cubes {
  
  public String isSumOfCubes(String s) {
    int num, cubicSum = 0;
    s = s.replaceAll("[^0-9]+", " ");  // use regex to select nums
    String[] strArr = s.trim().split(" ");  // take them as array
    
    List<Integer> intList = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < strArr.length; ++i){
      num = Integer.parseInt(strArr[i]);
      if (numOfDigits(num) > 3) // if this num has more than 3 digits, then handle it
        handleLargeNum(num, intList);
      else
        intList.add(num); // otherwise, add it to the list that contain the nums to be processed
    }
      
      for (int i = 0; i < intList.size(); ++i){ // process the nums that extracted from given string
        if (isCubic(intList.get(i))){  
           sb.append(intList.get(i)).append(" ");  // if this is a cubic num, append it to our result string
          cubicSum += intList.get(i);             // calculate sum of them
        }
      }

      if (sb.toString().length() > 0){  // if there was some cubic numbers, return them with the sum
        sb.append(cubicSum).append(" Lucky");
        return sb.toString();
      }

      else 
        return "Unlucky";
  }

  private boolean isCubic(int num){
    int temp = num;
    int sum = 0;

    while(temp > 0){  // calculate cube of the digits
      sum += Math.pow(temp%10, 3);
      temp /= 10;
    }

    return sum == num;  // check if the sum is equal to the num...
  }

  private void handleLargeNum(int num, List<Integer> list){
    String s = "" + num;  // given number as string
    String n = "";        // new number
    String r = "";        // rest of the given number

    char[] arr = s.toCharArray();

    int i;
    for(i = 0; i < 3; ++i) // take first 3 digit as a number to the string
      n += arr[i];
    
    for (; i < arr.length; ++i) // take rest of the give number as another number
      r += arr[i];
    

    list.add(Integer.parseInt(n)); // add new number to the list

    int remain = Integer.parseInt(r);
    if (numOfDigits(remain) <= 3)  // if the remain provides the condition, just add it to the list and we are done
      list.add(remain);
    else
      handleLargeNum(remain, list); // otherwise, handle this number recursively (since we have the same list)
  }


  // calculates the number of digits of a num
  private int numOfDigits(int num){
    int c = 0;
    while(num > 0){
      c++;
      num /= 10;
    }

    return c;
  }
}