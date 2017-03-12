// https://www.codewars.com/kata/5503013e34137eeeaa001648/

public class Diamond {

    public static void main(String[] args) {

        System.out.println(diamond(1));
    }

    public static String diamond(int num) {
        if (num <= 0 || num%2 == 0)
            return null;

        StringBuilder lineHolder = new StringBuilder();
        int numOfLines = 0;
        int printNum = 1;

        while (numOfLines < num) {
            String line = "";
            for (int i = 0; i < Math.abs(num / 2 - (numOfLines)); i++) {
                line += " ";
            }
            for (int i = 0; i < printNum; i++) {
                line += "*";
            }
            if (numOfLines < (num/2))
                printNum += 2;
            else
                printNum -= 2;

            lineHolder.append(line).append("\n");
            ++numOfLines;
        }

        return lineHolder.toString();
    }
}
