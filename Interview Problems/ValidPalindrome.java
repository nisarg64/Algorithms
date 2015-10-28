/**
 * Created by nisarg on 10/27/15.
 */
public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    private static boolean isPalindrome(String s) {
        if(s == null)
            return true;
        s = s.replaceAll("[^A-Za-z0-9]+","").toLowerCase();
        if(s.length() == 0)
            return true;
        System.out.println(s);
        int i = 0;
        int j = s.length() - 1;
        while(i < j){
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
