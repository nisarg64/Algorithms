import java.util.Scanner;

/**
 * Created by Nisarg on 14-Mar-15.
 */
public class BlackList {
    public static int min(int x, int y, int z) {
        if (x < y)
            return (x < z) ? x : z;
        else
            return (y < z) ? y : z;
    }

    public static int minCost(int[][] cost, int m, int n) {
        int i, j;

        // Instead of following line, we can use int tc[m+1][n+1] or
        // dynamically allocate memory to save space. The following line is
        // used to keep te program simple and make it working on all compilers.
        int[][] tc = new int[m][n];

        tc[0][0] = cost[0][0];

     /* Initialize first column of total cost(tc) array */
        for (i = 1; i < m; i++)
            tc[i][0] = tc[i - 1][0] + cost[i][0];

     /* Initialize first row of tc array */
        for (j = 1; j < n; j++)
            tc[0][j] = tc[0][j - 1] + cost[0][j];

     /* Construct rest of the tc array */
        for (i = 1; i < m; i++) {
            for (j = 1; j < n; j++)
                tc[i][j] = min(tc[i - 1][j - 1], tc[i - 1][j], tc[i][j - 1]) + cost[i][j];
        }

        return tc[m-1][n-1];
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner inp = new Scanner(System.in);
        int N = inp.nextInt();
        int K = inp.nextInt();
        int[][] gangsterCost = new int[K][N];
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < N; j++) {
                gangsterCost[i][j] = inp.nextInt();
            }
        }
        System.out.println(minCost(gangsterCost, K, N));
    }
}
