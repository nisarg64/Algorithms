import java.util.Scanner;

/**
 * Created by Nisarg on 14-Mar-15.
 */
public class kaprekarNUmber {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner inp = new Scanner(System.in);
        int L = inp.nextInt();
        int H = inp.nextInt();
        boolean present = false;
        for(int i = L; i <= H; i++){

            int d = (i + "").length();
            long square = (long)Math.pow(i, 2);
            long l = (long)(square/Math.pow(10,d));
            long h = (long)(square%Math.pow(10,d));
            //System.out.println(l+" "+h);
            if(i == (l+h)){
                present = true;
                System.out.print(i + " ");
            }
        }
        if(present == false)
            System.out.print("INVALID RANGE");
    }
}
