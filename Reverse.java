

public class Reverse {
	public static int n;
	public static void main(String[] args) {
		n = 1;
		System.out.println(reverse("abcde"));
	}

    public static String reverse(String str) {

       if (str.length() > 0)
         return str.charAt(str.length()-1) + reverse(str.substring(0, str.length()-1));

       return "";
    }
}