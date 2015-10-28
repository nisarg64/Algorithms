/**
 * Created by nisarg on 10/27/15.
 */
public class IntegerToRoman {
    public static void main(String[] args) {
        System.out.println(ConvertIntegerToRoman(48));
    }

    private static String ConvertIntegerToRoman(int romanInt) {
        if(romanInt == 0)
            return "";
        StringBuilder str = new StringBuilder();
        while(romanInt > 0){
            if(romanInt >= 1000){
                str.append("M");
                romanInt -= 1000;
            }else if(romanInt >= 900){
                str.append("CM");
                romanInt -= 900;
            }else if(romanInt >= 500){
                str.append("D");
                romanInt -= 500;
            }else if(romanInt >= 400){
                str.append("CD");
                romanInt -= 400;
            }else if(romanInt >= 100){
                str.append("C");
                romanInt -= 100;
            }else if(romanInt >= 90){
                str.append("XC");
                romanInt -= 90;
            }else if(romanInt >= 50){
                str.append("L");
                romanInt -= 50;
            }else if(romanInt >= 40){
                str.append("XL");
                romanInt -= 40;
            }else if(romanInt >= 10){
                str.append("X");
                romanInt -= 10;
            }else if(romanInt >= 9){
                str.append("IX");
                romanInt -= 9;
            }else if(romanInt >= 5){
                str.append("V");
                romanInt -= 5;
            }else if(romanInt >= 4){
                str.append("IV");
                romanInt -= 4;
            }else if(romanInt >= 1){
                str.append("I");
                romanInt -= 1;
            }
        }
        return str.toString();
    }
}
