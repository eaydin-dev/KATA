import java.lang.StringBuilder;

public class DigPow {
  
  public static long digPow(int n, int p) {
    int digit;
    int sum = 0;
    StringBuilder sb = new StringBuilder();
    sb.append(n);

    int t = Integer.parseInt(sb.reverse().toString());
    System.out.println(t);

    while (t > 0){
      digit = t % 10;
      sum += Math.pow(digit, p++);
      t /= 10;
    }

    if (sum % n == 0)
      return sum / n;
    
    return -1;
  }
  
}