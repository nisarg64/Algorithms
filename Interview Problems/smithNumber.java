import java.util.Scanner;

/**
 * Created by Nisarg on 14-Mar-15.
 */
public class smithNumber {
    public static int getFactorsSum(int x){
        int y= 2;
        int sum = 0;
        while(x!=1)
        {
            if(x%y==0)
            {
                x=x/y;
                if(y < 10)
                    sum += y;
                else{
                    int tmp = y;
                    while( tmp > 0){
                        sum += tmp % 10;
                        tmp = tmp/10;
                    }
                }
                if(y==1)
                {
                    y++;
                }
            }
            else
            {
                y+=1;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner inp = new Scanner(System.in);
        int number = inp.nextInt();
        int sumOfFactors = getFactorsSum(number);
        int sumOfDigits = 0;
        while( number > 0){
            sumOfDigits += number % 10;
            number = number/10;
        }
        System.out.println(sumOfDigits+" "+sumOfFactors);
        if(sumOfDigits == sumOfFactors)
            System.out.println(1);
        else
            System.out.println(0);
    }

}
