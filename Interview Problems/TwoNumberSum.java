import java.util.HashMap;

/**
 * Created by nisarg on 9/22/15.
 */
public class TwoNumberSum {

    public static void main(String[] args) {
        int[] arr = {5, 7 ,2, 8, 3, 6, 4, 9};
        twoNumberSum(arr, 13);
    }

    private static void twoNumberSum(int[] arr, int N) {
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        for(int i=0; i < arr.length; i++ ){
            if(map.containsKey(N-arr[i])){
                System.out.println(arr[i]+"---"+(N-arr[i]));
            }
            map.put(arr[i], true);
        }
    }
}
