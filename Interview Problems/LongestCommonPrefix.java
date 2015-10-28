/**
 * Created by nisarg on 10/26/15.
 */
public class LongestCommonPrefix {
    public static String getLCP(String[] strs) {
        if(strs.length==0)
            return "";
        String minStr = strs[0];
        for(int i = 1; i<strs.length;i++)
        {
            if (strs[i].length() < minStr.length())
                minStr = strs[i];
        }

        StringBuilder str = new StringBuilder();
        for(int prefixLen = 0; prefixLen<minStr.length();prefixLen++)
        {
            char c = minStr.charAt(prefixLen);
            for (int i = 0; i < strs.length; i++) {
                if (strs[i].charAt(prefixLen) != c) {
                    return str.toString();
                }
            }
            str.append(c);
        }
        return str.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"ab", "bc"};
        System.out.println(getLCP(strs));
    }
}
