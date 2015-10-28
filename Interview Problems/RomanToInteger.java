/**
 * Created by nisarg on 10/26/15.
 */
public class RomanToInteger {
    public static void main(String[] args) {
        System.out.println(convertRomanToInteger("XLIX"));
    }
    public static int RtoI(char str){
        switch(str){
            case 'I':return 1;
            case 'V':return 5;
            case 'X':return 10;
            case 'L':return 50;
            case 'C':return 100;
            case 'D':return 500;
            case 'M':return 1000;
        }
        return 0;
    }

    private static int convertRomanToInteger(String s) {
        if(s == null){
            return 0;
        }

        int convertedInt = 0;
        int i=0, j=1;
        while(j <= s.length()){
            int r1 = RtoI(s.charAt(i));
            if( j <  s.length()){
                int r2 = RtoI(s.charAt(j));

                if(r1 < r2){
                    convertedInt += (r2-r1);
                    i += 2;
                    j += 2;
                }else{
                    convertedInt += r1;
                    i++;
                    j++;
                }
            }else{
                convertedInt += r1;
                i++;
                j++;
            }

        }

        return convertedInt;
    }
}
