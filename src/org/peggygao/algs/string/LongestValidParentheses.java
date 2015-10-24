package org.peggygao.algs.string;

public class LongestValidParentheses {

    private static int maxLength(String s) {

	if (s == null || s.length() == 0) {
	    return 0;
	}
	int max = 0;

	int[] dp = new int[s.length()];

	dp[0] = 0;
	for (int i = 1; i < s.length(); i++) {

	    if (s.charAt(i) == ')') {
		int j = i - dp[i - 1] - 1;

		if (j >= 0 && s.charAt(j) == '(') {
		    dp[i] = dp[i - 1] + 2;
		    int k = 0;
		    if (j - 1 >= 0) {
			k = dp[j - 1];
		    }

		    dp[i] += k;
		}

		if (max < dp[i]) {
		    max = dp[i];
		}

	    }

	}

	return max;

    }

    public static void main(String[] args) {
	System.out.println(maxLength(""));
    }

}
