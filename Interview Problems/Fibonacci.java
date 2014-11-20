public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int fibo = fibonacciRecursive(7);
		System.out.println("value:" + fibo);
		fibo = fibonacciIterative(7);
		System.out.println("value:" + fibo);
	}

	public static int fibonacciIterative(int n) {
		// TODO Auto-generated method stub
		int[] fib = new int[n + 1];
		fib[0] = 0;
		fib[1] = 1;
		for (int i = 2; i <= n; i++) {
			fib[i] = fib[i - 1] + fib[i - 2];
		}

		return fib[n];
	}

	public static int fibonacciRecursive(int n) {
		// TODO Auto-generated method stub
		if (n == 0)
			return 0;
		else if (n == 1)
			return 1;
		else
			return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
	}

}
