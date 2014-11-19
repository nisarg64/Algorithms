public class SquareRoot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getSquareRoot(25);
	}

	public static void getSquareRoot(float num) {
		if (num < 0) {
			System.out.println("Square root of negative numbers do not exist");
		} else {
			float sqrt = SquareRootHelper(num, 0, num);
			System.out.println("Square Root:" + sqrt);
		}
	}

	public static float SquareRootHelper(float n, float low, float high) {
		// TODO Auto-generated method stub
		float mid = (low + high) / 2;
		while (0.00001 < Math.abs((mid * mid) - n)) {
			if (mid * mid > n)
				high = mid;
			else if (mid * mid < n)
				low = mid;
			mid = (low + high) / 2;
		}
		return mid;
	}
}
