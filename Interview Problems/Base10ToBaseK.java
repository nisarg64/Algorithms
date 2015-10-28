import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Nisarg on 09-Mar-15.
 */
public class Base10ToBaseK {
    static void ConvertToBaseK(int num, int K){
        int index = 0,remainder;
        Stack<Integer> stack = new Stack<Integer>();
        StringBuilder str = new StringBuilder();
        while(num != 0){
            remainder = num % K;
            num = num / K;
            stack.push(remainder);
        }

        while(!stack.isEmpty()){
            if(stack.peek() < 10)
                str.append(stack.pop());
            else{
                str.append((char) ((stack.pop() - 10) + 'A'));
            }

        }
        System.out.println(str.toString());
    }

    static void ConvertToBase10(String num, int K){
        char[] numb = num.toCharArray();
        int sum=0;
        int i, j = 0;
        for(i = (num.length()- 1); i >= 0; i--){
            int numc = (int)numb[i];
            if(numc > 64)
                numc = numc - 55;// n - 65 + 10
            else
                numc = Integer.parseInt(String.valueOf(numb[i]));

            sum += Math.pow(K, j) * numc;
            j++;
        }
        System.out.println(sum);

    }
    public static void main(String[] args){
        ConvertToBaseK(156,16);
        ConvertToBase10("9C",16);
    }
}
