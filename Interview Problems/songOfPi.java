import java.util.Scanner;

/**
 * Created by Nisarg on 14-Mar-15.
 */
public class songOfPi {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner inp = new Scanner(System.in);
        int T = Integer.parseInt(inp.nextLine());
        String piString = "31415926535897932384626433833";
        char[] pi = piString.toCharArray();
        for(int i = 0; i < T; i++){
            String[] line = inp.nextLine().split(" ");
            int j = 0,flag = 0;
            while(j < line.length){
                if(line[j].length() != Integer.parseInt(String.valueOf(pi[j]))){
                    System.out.println("It's not a pi song");
                    flag = 1;
                    break;
                }
                j++;
            }
            if(flag == 0)
                System.out.println("It's a pi song");
        }
    }
}
