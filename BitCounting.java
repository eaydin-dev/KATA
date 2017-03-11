public class BitCounting {

    public static void main(String[] args) {
        System.out.println("> " + countBits(5));
    }

    public static int countBits(int n){
        return (int) Integer.toString(n, 2).chars().filter(value -> value == '1').count();
    }
}
