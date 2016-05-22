import java.util.Arrays;

public class ArrayPrinter {

    public static String printArray(Object array[]) {
      if (array == null) return null;
      
      String s = Arrays.toString(array);
      return s.replaceAll(" ", "").replaceAll("\\[", "").replaceAll("\\]", "");
    }
}