import java.util.Arrays;

/**
 * 
 * @author Nisarg
 * 
 *         Check if the given number is prime or not
 */
public class isPrime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		isPrime(37);
		isPrime(97);
		isPrime(57);
	}

	private static void isPrime(int num) {
		// TODO Auto-generated method stub
		if (num < 2) {
			System.out.println(num + ": Not Prime");
			return;
		}
		for (int i = 2; i < Math.sqrt(num); i++) {
			if ((num % i) == 0) {
				System.out.println(num + ": Not Prime");
				return;
			}
		}
		System.out.println(num + ": Prime");
	}

}
