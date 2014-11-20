import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Anagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		checkAnagram("nisarg", "grains");
		String[] list = { "nisarg", "abcd", "cdba", "grains" };
		String[] list1 = {};
		getAnagramList(list);
	}

	public static void getAnagramList(String[] list) {
		// TODO Auto-generated method stub
		if (list.length == 0)
			return;
		HashMap<String, ArrayList<String>> anagramList = new LinkedHashMap<String, ArrayList<String>>();
		for (String word : list) {
			String key = sortString(word);
			if (!anagramList.containsKey(key)) {
				anagramList.put(key, new ArrayList<String>());
				anagramList.get(key).add(word);
			} else {
				anagramList.get(key).add(word);
			}
		}

		for (String keys : anagramList.keySet()) {

			ArrayList<String> anagrams = anagramList.get(keys.toString());

			for (int i = 0; i < anagrams.size(); i++)
				System.out.print(anagrams.get(i) + " ");
			System.out.print("\n");
		}
	}

	public static void checkAnagram(String string, String string2) {
		// TODO Auto-generated method stub
		if (string == null && string2 == null)
			return;
		else if (string.length() == string2.length()) {
			boolean isAnagram = sortString(string).equals(sortString(string2));
			if (isAnagram)
				System.out.println("Anagrams!");
			else
				System.out.println("Not Anagrams!");
		} else
			System.out.println("Not Anagrams!");
	}

	public static String sortString(String string) {
		// TODO Auto-generated method stub
		char[] content = string.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}

}
