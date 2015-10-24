package org.peggygao.algs.string;

public class DecodeWays {

    private static int numOfDecodings(String s) {

	if (s == null || s.length() == 0) {
	    return 0;
	}

	int[] num = new int[s.length() + 1];
	num[0] = 1;
	if (s.charAt(0) == '0')
	    num[1] = 0;
	else {
	    num[1] = 1;
	}

	for (int i = 2; i < s.length() + 1; i++) {

	    if (s.charAt(i - 1) != '0') {
		num[i] = num[i - 1];
	    }
	    if (s.charAt(i - 2) != '0') {
		int k = (s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0');
		if (k <= 26 && k > 0) {
		    num[i] += num[i - 2];
		}
	    }
	}

	return num[s.length()];

    }

    public static void main(String[] args) {
	System.out.println(numOfDecodings("01"));
    }

}
