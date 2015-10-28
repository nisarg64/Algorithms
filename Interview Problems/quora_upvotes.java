import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by nisarg on 10/6/15.
 */
public class quora_upvotes {

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt(); // Number of Upvotes
        int K = scan.nextInt(); // Window size
        int MAX = 100001;
        int i;
        Integer[] inp = new Integer[MAX];
        for(i = 0; i < N; i++)
            inp[i] = scan.nextInt();

        // 2-D Arrays to track the length of increasing/decresing sub-ranges
        Integer[][] length_inc = new Integer[2][MAX];
        Integer[][] length_dec = new Integer[2][MAX];

        for(i = 0; i < N; i++)
        {
            length_inc[0][i] = 1 + (i >= 1 && inp[i] >= inp[i-1] ? length_inc[0][i-1] : 0);
            length_dec[0][i] = 1 + (i >= 1 && inp[i] <= inp[i-1] ? length_dec[0][i-1] : 0);
        }
        for(i = N-1; i >= 0; i--)
        {
            length_inc[1][i] = 1 + (i < N-1 && inp[i] >= inp[i+1] ? length_inc[1][i+1] : 0);
            length_dec[1][i] = 1 + (i < N-1 && inp[i] <= inp[i+1] ? length_dec[1][i+1] : 0);
        }

        long ninc = 0, ndec = 0; // number of increasing/decreasing sub-ranges
        for(i = 0; i < K-1; i++)
        {
            ninc += length_inc[0][i];
            ndec += length_dec[0][i];
        }

        for(i = K - 1; i < N; i++)
        {
            ninc += Math.min(K, length_inc[0][i]);
            ndec += Math.min(K, length_dec[0][i]);
            System.out.println(ninc - ndec);
            ninc -= Math.min(K, length_dec[1][i - (K - 1)]);
            ndec -= Math.min(K, length_inc[1][i - (K - 1)]);
        }
    }
}
