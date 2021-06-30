package com.trg.sting.main;

public class ConsonantsMain {

	public static void main(String[] args) {

// check if the character is alphabet and also not vowel

		String st = "abcde34suyeiczzdf";
		System.out.println(st);
		StringBuilder sb = new StringBuilder();
		int len = st.length();

		for (int i = 0; i < len; i++) {

			char ch = st.charAt(i);

			if (ch >= 'a' && ch <= 'z') {
				if (!(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')) {
					if (ch == 'z')
						ch = 'a';
					else
						ch = (char) (ch + 1);
				}
			}
			sb.append(ch);
		}

		System.out.println(sb);
		
	}

}
