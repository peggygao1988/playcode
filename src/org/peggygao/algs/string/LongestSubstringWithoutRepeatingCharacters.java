package org.peggygao.algs.string;

public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {

	int[] map = new int[256];

	int length = 0;
	int maxLength = 0;

	int start = 0;
	int end = 0;

	while (end < s.length()) {

	    char c = s.charAt(end);
	    if (map[c] == 0) {
		map[c]++;
		end++;
		length++;
	    } else {
		if (length > maxLength) {
		    maxLength = length;
		}

		length--;
		map[s.charAt(start++)]--;

	    }
	}

	if (length > maxLength) {
	    maxLength = length;
	}
	return maxLength;
    }

    public static void main(String[] args) {
	String s = "qopubjguxhxdipfzwswybgfylqvjzhar";
	System.out.println(lengthOfLongestSubstring(s));
    }

}
