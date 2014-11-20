public class SquareRoot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getSquareRoot(20);
	}

	public static void getSquareRoot(float num) {
		if (num < 0) {
			System.out.println("Square root of negative numbers do not exist");
		} else {
			float low = 0;
			float high = num;
			float mid = (low + high) / 2;
			while (0.00001 < Math.abs((mid * mid) - num)) {
				if (mid * mid > num)
					high = mid;
				else if (mid * mid < num)
					low = mid;
				mid = (low + high) / 2;
			}
			float sqrt = mid;
			System.out.println("Square Root:" + sqrt);
		}
	}
}
