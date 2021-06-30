package com.trg.sting.main;

public class WordCountMain {

	public static void main(String[] args) {

		String text = "abc qqq  \n rtyu \t www \n opuyth\n"; // 5 words, 3 lines

		int nl = 0;
		int nw = 0;
		int nc = 0;

		boolean newWord = true;

		int len = text.length();

		for (int i = 0; i < len; i++) {
			nc++;

			char ch = text.charAt(i);

			if (ch == ' ' || ch == '\n' || ch == '\t')
				newWord = true;

			if (ch == '\n') {
				nl++;
				continue;
			}

			if (ch != ' ' && ch != '\t' && newWord) {
				nw++;
				newWord = false;
			}
		}

		if (text.charAt(len - 1) != '\n')
			nl++;
		
		System.out.println("No of characters: " + nc);
		System.out.println("Number of words: " + nw);
		System.out.println("Number of lines: " + nl);

	}

}
