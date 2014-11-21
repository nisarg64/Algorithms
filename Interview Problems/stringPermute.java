public class stringPermute {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "ABCD";
		permute(str, "");
	}

	private static void permute(String str, String prefix) {
		// TODO Auto-generated method stub
		//System.out.println("Prefix:" + prefix);
		//System.out.println("String:" + str);
		int n = str.length();
		if (n == 0)
			System.out.println(prefix);
		else {
			for (int i = 0; i < n; i++)
				permute(str.substring(0, i) + str.substring(i + 1, n), prefix
						+ str.charAt(i));
		}
	}
}
