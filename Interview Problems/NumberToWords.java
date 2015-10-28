/**
 * Created by nisarg on 10/27/15.
 */
public class NumberToWords {
    public static void main(String[] args) {
        System.out.println(numberToWords(621));
    }

    public static String numberToWords(int num) {
        String[] ones = {"Zero","One", "Two", "Three", "Four",
        "Five", "Six","Seven","Eight","Nine"};
        String[] tens = {"Zero","Ten", "Twenty", "Thirty", "Forty", "Fifty",
        "Sixty","Seventy","Eighty","Ninety"};
        String[] teens = {"Ten","Eleven", "Twelve", "Thirteen", "Fourteen",
        "Fifteen", "Sixteen","Seventeen","Eighteen","Nineteen"};
        int i = 0; // track thousand, million and billion
        StringBuilder result = new StringBuilder();
        if(num == 0) return "Zero";
        while(num > 0){
            int cur = num%1000;
            num = num/1000;
            if(i == 1 && cur > 0) result.insert(0,"Thousand ");
            if(i == 2 && cur > 0) result.insert(0,"Million ");
            if(i == 3 && cur > 0)  result.insert(0,"Billion ");
            int o = cur%10; cur = cur/10; // ones
            int t = cur%10; cur = cur/10; // tens
            int h = cur%10; // hundreds
            if( t == 1){ // handle eleven, twelve...
                result.insert(0,teens[o] + " ");
            }
            else{
                if(o > 0) result.insert(0,ones[o] +" ");
                if(t > 0) result.insert(0,tens[t] + " ");
            }
            if(h > 0) result.insert(0,ones[h] + " Hundred ");
            i++;
        }
        return result.toString().trim();
    }
}
