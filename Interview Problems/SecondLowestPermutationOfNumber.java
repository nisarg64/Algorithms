/**
 * Given a number n, return a number formed from the same digits of n that is
 * the number right before n. Example: Given 1342, you must return the number
 * 1324.
 * 
 * @author Nisarg
 *
 */
public class SecondLowestPermutationOfNumber {
	public static void main(String[] args) {
		getlowerPermutation(1243);
	}

	public static void getlowerPermutation(int x) {
		// TODO Auto-generated method stub
		int[] arr = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		int numLength = (int) Math.floor(Math.log10(x));
		Integer[] number = new Integer[numLength + 1];
		for (int i = numLength; i >= 0; i--) {
			number[i] = x % 10;
			x = x / 10;
		}
		arr[numLength] = 1;
		for (int i = numLength - 1; i >= 0; i--) {
			if (number[i] <= number[i + 1])
				arr[i] = 1;
			else {
				int k = 0;
				for (int j = (number[i] - 1); j >= 0; j--) {
					if (arr[j] == 1) {
						k = j;
						break;
					}
				}
				System.out.println(k + " " + i);
				int temp = number[i];
				number[i] = number[k];
				number[k] = temp;
				break;
			}
		}
		StringBuilder res = new StringBuilder();
		for (int i = 0; i <= numLength; i++)
			res.append(number[i]);
		System.out.println(res.toString());
	}
}
