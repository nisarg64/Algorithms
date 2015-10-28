public class getListOfPrimes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		listOfPrimes(100);
	}

	private static void listOfPrimes(int max) {
		// TODO Auto-generated method stub
		boolean[] flags = new boolean[max + 1];
		for (int i = 2; i <= max; i++)
			flags[i] = true;

		int prime = 2;

		while (prime <= Math.sqrt(max)) {
			crossOff(flags, prime);
			prime = getNextPrime(flags, prime);
			if (prime >= flags.length)
				break;
		}
		for(int j = 0 ; j < flags.length; j++){
			if(flags[j])
				System.out.print(j + " ");
		}
	}

	private static void crossOff(boolean[] flags, int prime) {
		// TODO Auto-generated method stub
		for (int i = prime * prime; i < flags.length; i += prime)
			flags[i] = false;
	}

	private static int getNextPrime(boolean[] flags, int prime) {
		// TODO Auto-generated method stub
		int next = prime + 1;
		while (next < flags.length && !flags[next])
			next++;
		return next;
	}

}
