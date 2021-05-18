package labcollectionproject;

import java.util.HashMap;
import java.util.Map;

public class LabEx02 {

	public static void main(String[] args) {

		char chars[] = { 'A', 'N', 'O', 'X', 'A', 'P', 'N', 'A', 'Y', 'Y', 'Q' };

		Map<Character, Integer> x = countChars(chars);
		
		System.out.println(x);

	}

	static Map<Character, Integer> countChars(char[] ch) {

		Map<Character, Integer> m = new HashMap<>();

		for (Character c : ch) {
			Integer count = m.get(c);
			if (count == null)
				m.put(c, 1);
			else {
				count++;
				m.put(c, count);
			}
		}
		return m;
	}
}
