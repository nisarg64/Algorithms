public class StringAddition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getSum("123", "37");
	}

	public static void getSum(String num1, String num2) {
		// TODO Auto-generated method stub
		char[] num1Char = num1.toCharArray();
		char[] num2Char = num2.toCharArray();

		int i = num1Char.length - 1;
		int j = num2Char.length - 1;

		StringBuilder sumString = new StringBuilder();
		int carry = 0;

		while (i >= 0 || j >= 0) {
			int d1 = 0;
			int d2 = 0;

			if (i >= 0)
				d1 = num1Char[i--] - '0';
			if (j >= 0)
				d2 = num2Char[j--] - '0';

			int sum = d1 + d2 + carry;
			if (sum >= 10) {
				carry = sum / 10;
				sum = sum % 10;
			} else
				carry = 0;

			sumString.insert(0, sum);
		}
		System.out.println("Sum of two strings:" + sumString.toString());
	}
}
