package org.peggygao.algs.array;

public class LongestNumber {

    private static boolean isNumber(char c) {
	if (c >= '0' && c <= '9') {
	    return true;
	}

	return false;
    }

    private static int longestNumber(char[] string) {

	int max = 0;
	int length = 0;
	int start = -1;
	int end = -1;
	for (int i = 0; i < string.length; i++) {

	    if (isNumber(string[i])) {

		length++;
		if (length > max) {
		    max = length;
		    start = i - length + 1;
		    end = i;
		}
	    } else {

		length = 0;
	    }
	}

	char[] output = new char[max];
	for (int i = 0; i < max; i++) {
	    output[i] = string[start + i];
	    System.out.print(output[i]);
	}
	System.out.println();

	return max;
    }

    public static void main(String[] args) {
	System.out.println(longestNumber("abcd12345ed125ss123456789"
		.toCharArray()));
    }

}
