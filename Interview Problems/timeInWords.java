import java.util.Scanner;

/**
 * Created by Nisarg on 14-Mar-15.
 */
public class timeInWords {
    private static final String[] tensNames = {
            "",
            " ten",
            " twenty",
            " thirty",
            " forty",
            " fifty",
            " sixty",
            " seventy",
            " eighty",
            " ninety"
    };

    private static final String[] numNames = {
            "",
            " one",
            " two",
            " three",
            " four",
            " five",
            " six",
            " seven",
            " eight",
            " nine",
            " ten",
            " eleven",
            " twelve",
            " thirteen",
            " fourteen",
            " fifteen",
            " sixteen",
            " seventeen",
            " eighteen",
            " nineteen"
    };

    public static String numToWord(int number) {
        String soFar = "";
        if (number % 100 < 20) {
            soFar = numNames[number % 100];
            number /= 100;
        } else {
            soFar = numNames[number % 10];
            number /= 10;

            soFar = tensNames[number % 10] + soFar;
            number /= 10;
        }
        return soFar.trim();
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner inp = new Scanner(System.in);
        int H = inp.nextInt();
        int M = inp.nextInt();
        if (M == 00)
            System.out.println(numToWord(H) + " o' clock");
        else if(M == 01)
            System.out.println(numToWord(M) + " minute past " + numToWord(H));
        else if(M == 15)
            System.out.println("quarter past " + numToWord(H));
        else if(M == 30)
            System.out.println("half past " + numToWord(H));
        else if (M < 30)
            System.out.println(numToWord(M) + " minutes past " + numToWord(H));
        else if(M == 45)
            System.out.println("quarter to " + numToWord(H + 1));
        else
            System.out.println(numToWord(60 - M) + " minutes to " + numToWord(H + 1));
    }
}
