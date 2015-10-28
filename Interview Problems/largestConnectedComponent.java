import java.util.Scanner;

/**
 * Created by Nisarg on 14-Mar-15.
 */
public class largestConnectedComponent {
    public static int currentDepth ;

    private static int findMaxDepth(int[][] n, boolean[][] bool, int i, int j) {
        // Check if i, j (indexes) are within the size of array
        // Check if the cell is already traversed or not using bool array
        // Check if the cell value is 1 before counting it as part of a sector
        if (i >= 0 && i < n.length && j >= 0 && j < n[0].length
                && bool[i][j] != true && n[i][j] != 0) {
            currentDepth++;

            // Mark the status of the cell for backtracking purpose
            bool[i][j] = true;

            // left traversal
            findMaxDepth(n, bool, i - 1, j);
            // right traversal
            findMaxDepth(n, bool, i + 1, j);

            // top traversal
            findMaxDepth(n, bool, i, j - 1);
            // bottom traversal
            findMaxDepth(n, bool, i, j + 1);

            // Top-Bottom diagnol
            // diagnol-down traversal
            findMaxDepth(n, bool, i + 1, j + 1);
            // diagnol-up traversal
            findMaxDepth(n, bool, i - 1, j - 1);

            // Bottom-Top diagnol
            // diagnol-down traversal
            findMaxDepth(n, bool, i + 1, j - 1);
            // diagnol-up traversal
            findMaxDepth(n, bool, i - 1, j + 1);
        }
        return currentDepth;
    }


    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner inp = new Scanner(System.in);
        int N = inp.nextInt();
        int M = inp.nextInt();
        int[][] matrix = new int[N][M];
        boolean[][] boolArr = new boolean[N][M];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                matrix[i][j] = inp.nextInt();
            }
        }

        int depth, maxDepth = 0;
        if (matrix != null) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (matrix[i][j] == 1 && boolArr[i][j] == false) {
                        currentDepth = 0;
                        depth = findMaxDepth(matrix, boolArr, i, j);
                        if (depth > maxDepth) {
                            maxDepth = depth;
                        }
                    }
                }
            }
        }

        System.out.println(maxDepth);
    }
}
