import java.util.*;

/**
 * Created by Nisarg on 08-Mar-15.
 */
public class EditDistanceAnagrams {
    public static String sort(String s){
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner inp = new Scanner(System.in);
        int arg = Integer.parseInt(inp.nextLine());
        for(int i = 0; i < arg; i++){
            String line = inp.nextLine();
            if((line.length()) % 2 != 0){
                System.out.println(-1);
            }
            else if(sort(line.substring(0,(line.length()/2))).equals(sort(line.substring((line.length()/2),(line.length())))))
                System.out.println(0);
            else {
                if (line.length() == 2)
                    System.out.println(1);
                else {
                    String s1 = sort(line.substring(0, (line.length() / 2)));

                    String s2 = sort(line.substring((line.length() / 2), (line.length())));

                    int count1 = 0, count2 = 0;
                    Integer[] set1 = new Integer[256];
                    Integer[] set2 = new Integer[256];
                    for(int l = 0; l < 256; l++){
                        set1[l] = 0;
                        set2[l] = 0;
                    }
                     for (int j = 0; j < s1.length(); j++) {
                        set1[s1.charAt(j)] += 1;
                         set2[s2.charAt(j)] += 1;
                    }

                    int temp;
                    for (int k = 0; k < 256; k++) {
                        temp = set1[k] - set2[k];
                        if (temp < 0) {
                            count2 += temp * (-1);
                        } else
                            count1 += temp;
                    }
                    System.out.println(Math.min(count1,count2));
                }
            }

        }
    }
}
