/**
 * Created by nisarg on 4/1/15.
 */
public class FibonacciIndex {
    public static void main(String[] args) {
        getFibonacciIndex(6);
    }

    private static void getFibonacciIndex(int num) {
        int fib = 0;
        int i = 2;
        int fib1 = 0, fib2 = 1;
        while(fib != num){
            fib = fib1 + fib2;
            fib1 = fib2;
            fib2 = fib;
            i++;
            if(fib > num) {
                System.out.println("Invalid Number");
                return;
            }
        }
        System.out.println(i);
    }
}
