package org.peggygao.algs.string;

import java.util.Arrays;

public class ScrambleString {

    private static boolean isScramble(String s1, String s2) {

	if (s1.length() != s2.length()) {
	    return false;
	}

	if (s1.equals(s2)) {
	    return true;
	}

	char[] c1 = s1.toCharArray();
	char[] c2 = s2.toCharArray();

	Arrays.sort(c1);
	Arrays.sort(c2);
	if (!new String(c1).equals(new String(c2))) {
	    return false;

	}

	for (int i = 1; i < s1.length(); i++) {
	    String ss11 = s1.substring(0, i);
	    String ss12 = s1.substring(i, s1.length());

	    String ss21 = s2.substring(0, i);
	    String ss22 = s2.substring(i, s2.length());

	    boolean result = false;

	    result = isScramble(ss11, ss21) && isScramble(ss12, ss22);
	    if (result == true) {
		return true;
	    }

	    ss21 = s2.substring(s2.length() - i);
	    ss22 = s2.substring(0, s2.length() - i);

	    result = isScramble(ss11, ss21) && isScramble(ss12, ss22);

	    if (result == true) {
		return true;
	    }

	}
	return false;

    }

    private static boolean dp(String s1, String s2) {

	if (s1.length() != s2.length()) {
	    return false;
	}

	if (s1.equals(s2)) {
	    return true;
	}

	boolean[][][] dp = new boolean[s1.length()][s2.length()][s1.length() + 1];

	for (int i = 0; i < s1.length(); i++) {
	    for (int j = 0; j < s2.length(); j++) {
		dp[i][j][0] = true;
		dp[i][j][1] = s1.charAt(i) == s2.charAt(j);
	    }
	}

	for (int i = s1.length() - 1; i >= 0; i--) {
	    for (int j = s2.length() - 1; j >= 0; j--) {

		for (int n = 2; n <= Math.min(s1.length() - i, s2.length() - j); n++) {

		    for (int m = 1; m < n; m++) {

			dp[i][j][n] |= (dp[i][j][m] && dp[i + m][j + m][n - m])
				|| (dp[i][j + n - m][m] && dp[i + m][j][n - m]);

			if (dp[i][j][n]) {
			    break;
			}
		    }

		}
	    }
	}

	return dp[0][0][s1.length()];
    }

    public static void main(String[] args) {

	String s1 = "great";
	String s2 = "rgeat";
	System.out.println(isScramble(s1, s2));
	System.out.println(dp(s1, s2));
    }

}
