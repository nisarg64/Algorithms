/**
 * Created by nisarg on 4/1/15.
 */
public class stringReverse {
    public static void main(String[] args) {
        reverseString("Nisarg");
    }

    public static void reverseString(String strn){
        int len = strn.length();
        int i = 0, j = len -1 ;
        char temp;
        char[] str = strn.toCharArray();
        while(i < j){
            temp = str[i];
            str[i++] = str[j];
            str[j--] = temp;
        }
        System.out.println(str);
    }
}
