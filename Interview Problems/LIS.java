/**
 * Created by nisarg on 10/10/15.
 */
public class LIS {
    public static void main(String[] args) {
        Integer[] arr = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        System.out.println(lis(arr));
    }

    private static int lis(Integer[] arr) {
        int i, j, max = 0;
        int n = arr.length;
        Integer[] lis = new Integer[n];

        for(i = 0; i < n; i++){
            lis[i] = 1;
        }

        for(i=1; i<n; i++){
            for(j=0; j < i; j++){
                if(arr[i] > arr[j] && lis[i] < lis[j] + 1)
                    lis[i] = lis[j] + 1;
            }
        }

        for(i=0; i<n; i++)
        {
            if(max < lis[i])
                max = lis[i];
        }

        return max;
    }
}
