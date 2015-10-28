import java.util.Scanner;

/**
 * Created by Nisarg on 10-Mar-15.
 */
public class bSearch {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner inp = new Scanner(System.in);
        int K = inp.nextInt();
        int N = inp.nextInt();
        int[] in = new int[N];
       for(int i =0; i< N; i++){
           in[i] = inp.nextInt();
       }
        int l = 0, r = N  , m;
        while(l < r){
            m = (l + r)/2;
            if(in[m] == K){
                System.out.println(m);
                break;
            }else if(in[m] < K){
                l = m + 1;
            }else
                r = m - 1;
        }
    }
}
