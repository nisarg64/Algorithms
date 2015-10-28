import java.util.Scanner;

/**
 * Created by Nisarg on 08-Mar-15.
 */
public class FlipBits {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner inp = new Scanner(System.in);

        int numbers = Integer.parseInt(inp.nextLine());
        for(int i = 0; i < numbers; i++) {
            long dec = Long.parseLong(inp.nextLine());
            long x = (long)Math.pow(2,32) - 1;
            dec = x - dec;
            System.out.println(dec);
        }
    }
}
