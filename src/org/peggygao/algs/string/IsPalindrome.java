package org.peggygao.algs.string;

import java.util.HashMap;

public class IsPalindrome {

    private static int palindromeMax(char[] string) {

	int max = 1;

	for (int i = 0; i < string.length; i++) {
	    int start = i - 1;
	    int end = i + 1;

	    while (start >= 0 && end < string.length
		    && string[start] == string[end]) {
		start--;
		end++;
	    }

	    int length = end - start - 1;
	    if (length > max) {
		max = length;
	    }

	    start = i;
	    end = i + 1;
	    while (start >= 0 && end < string.length
		    && string[start] == string[end]) {
		start--;
		end++;
	    }
	    length = end - start - 1;
	    if (length > max) {
		max = length;
	    }

	}

	return max;

    }

    public static String longestPalindrome(String s) {
	// Start typing your Java solution below
	// DO NOT write main() function
	int maxLength = 1;
	int length = 0;

	int center = 0;
	int start = 0;
	int end = s.length();

	while (center < s.length()) {

	    int i = 1;
	    while (center - i >= 0 && center + i < s.length()
		    && s.charAt(center - i) == s.charAt(center + i)) {
		i++;
	    }

	    length = (i - 1) * 2 + 1;
	    if (length > maxLength) {
		maxLength = length;
		start = center - i + 1;
		end = center + i;
	    }

	    i = 0;
	    while (center - i >= 0 && center + 1 + i < s.length()
		    && s.charAt(center - i) == s.charAt(center + 1 + i)) {
		i++;
	    }

	    length = i == 0 ? 0 : (i) * 2;
	    if (length > maxLength) {
		maxLength = length;
		start = center - i + 1;
		end = center + i + 1;
	    }

	    center++;
	}
	System.out.println(maxLength);
	return s.substring(start, end);

    }

    public static void main(String[] args) {
	char[] s = "a".toCharArray();
	// System.out.println(palindromeMax(s));
	System.out.println(longestPalindrome("abcba"));

    }

}
