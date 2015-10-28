/**
 * Created by nisarg on 9/22/15.
 */
public class PowerOfNumber {
    public static void main(String[] args){
        System.out.println(pow(-2,0));
    }

    private static long pow(int i, int j) {
        if(j < 0)
            return 0;
        else if(j == 0)
            return 1;
        else if(j == 1)
            return i;
        else{
            if(j % 2 == 0){
                long half = pow(i, j/2);
                return half * half;
            }else{
                long half = pow(i, (j-1)/2);
                return i * half *half;
            }
        }
    }
}
