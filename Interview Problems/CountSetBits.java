/**
 * Created by nisarg on 9/22/15.
 */
public class CountSetBits {
    public static void main(String[] args) {
        countSetBits(8);
    }

    private static void countSetBits(int N) {
        int count=0;
        while(N > 0){
            count += N & 1;
            N >>= 1;
        }
        System.out.println(count);
    }


}
