import java.util.Scanner;

/**
 * Created by nisarg on 9/2/15.
 */
public class countSquare {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();

        for(int i = 0; i < count; i++){
            int min = scanner.nextInt();
            int max = scanner.nextInt();
            System.out.println((int)(Math.floor(Math.sqrt(max)) - Math.ceil(Math.sqrt(min)) + 1));
        }
    }
}
