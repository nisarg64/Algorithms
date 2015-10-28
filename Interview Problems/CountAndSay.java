/**
 * Created by nisarg on 10/27/15.
 * The count-and-say sequence is the sequence of integers beginning as follows:
 1, 11, 21, 1211, 111221, ...

 1 is read off as "one 1" or 11.
 11 is read off as "two 1s" or 21.
 21 is read off as "one 2, then one 1" or 1211.
 Given an integer n, generate the nth sequence.
 3 -> 21
 */
public class CountAndSay {
    public static void main(String[] args) {
        System.out.println(countAndSay(3));
    }

    public static String countAndSay(int n) {
        if(n == 1)
            return "1";

        String prevString = "1", curString = "";
        int i = 1;

        while(i < n){
            curString = countAndSayHelper(prevString);
            prevString = curString;
            i++;
        }

        return curString;
    }

    private static String countAndSayHelper(String prevString) {
        StringBuilder str = new StringBuilder();
        char curChar = prevString.charAt(0);
        int count = 1;
        for(int j = 1 ; j < prevString.length(); j++){
            if(curChar == prevString.charAt(j))
                count++;
            else{
                str.append(count);
                str.append(curChar);
                curChar = prevString.charAt(j);
                count = 1;
            }
        }
        str.append(count);
        str.append(curChar);
        return str.toString();
    }
}
