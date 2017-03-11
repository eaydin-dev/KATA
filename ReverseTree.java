
public class ReverseTree {

    public static void main(String[] args) {

        printReverseTree(7);
    }


    /**
     * Call this method to print a reverse tree.
     *
     * @param num the number that will be appear at the bottom of the tree.
     */
    public static void printReverseTree(int num) {
        System.out.println("num: " + num + "\n");

        for (int i = 1; i <= num; ++i){
            printALine(i, num - i + 1, i - 1);
        }
    }

    private static void printALine(int num, int count, int space) {
        //if (num >= 10)
            num = num % 10;

        for (int i = 0; i < space; ++i)
            System.out.print(" ");
        for (int i = 0; i < count; i++)
            System.out.print(num + " ");

        System.out.print("\n");
    }
}