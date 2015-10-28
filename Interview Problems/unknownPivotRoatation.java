/**
 * You are given an integer K, and a sorted array as an input which has been
 * rotated about an unknown pivot. For example, 4 5 6 7 8 9 1 2 3. We need to
 * write a function which should return the index of K in the array, if K is
 * present, else return -1
 * 
 * @author Nisarg
 *
 */
public class unknownPivotRoatation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] sortedArray = { 4, 5, 6, 7, 8, 9, 1, 2, 3 };
		System.out.println("Index of key:" + getIntegerIndex(sortedArray, 2));
	}

	public static int getIntegerIndex(int[] sortedArray, int n) {
		// TODO Auto-generated method stub
		if (sortedArray.length < 0)
			return -1;
		int low = 0;
		int high = sortedArray.length - 1;

		while (low <= high) {
			int mid = (low + high) / 2;
			if (sortedArray[mid] == n)
				return mid;
			else if (sortedArray[low] <= sortedArray[mid]) {
				if (sortedArray[low] <= n && n < sortedArray[mid])
					high = mid - 1;
				else
					low = mid + 1;
			} else {
				if (sortedArray[mid] < n && n <= sortedArray[high])
					low = mid + 1;
				else
					high = mid - 1;
			}
		}
		return -1;
	}

}
