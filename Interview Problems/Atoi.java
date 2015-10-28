/**
 * Created by nisarg on 10/26/15.
 * Requirements for atoi:
 1. The function first discards as many whitespace characters as necessary until the first non-whitespace character is found.
 2. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
 3. The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
 4. If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 5. If no valid conversion could be performed, a zero value is returned.
 6. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 */
public class Atoi {
    public static int Atoi(String str){
        str = str.trim();
        if(str == null)
            return 0;
        int convertedInt = 0;
        StringBuilder validString = new StringBuilder();
        int flag = 1;
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(i == 0 && (c == '+' || c == '-')){
                if(c == '-')
                    flag = -1;
            }else if((int) c < 58 && (int) c > 47){
                validString.append(c);
                if(validString.length() > 10){
                    if(flag == 1)
                        return Integer.MAX_VALUE;
                    else
                        return Integer.MIN_VALUE;
                }
                convertedInt = 10 * convertedInt + ((int) c - 48);
                System.out.println(convertedInt);
                if(convertedInt < 0 && flag == 1) {
                    return Integer.MAX_VALUE;
                }else if(convertedInt*flag > 0 && flag == -1 )
                    return Integer.MIN_VALUE;
            }else {
                if(convertedInt > 0)
                    break;
                else
                    return 0;
            }
        }
        return convertedInt * flag;
    }

    public static void main(String[] args) {
        System.out.println(Atoi("    10522545459"));
    }
}
