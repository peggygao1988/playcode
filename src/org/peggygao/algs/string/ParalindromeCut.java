package org.peggygao.algs.string;

public class ParalindromeCut {
    public static int minCut(String s) {
	// Start typing your Java solution below
	// DO NOT write main() function

	int n = s.length();
	int cut[] = new int[n + 1];
	boolean[][] dp = new boolean[n][n];

	for (int i = 0; i < n; i++) {
	    cut[i] = Integer.MAX_VALUE;
	    dp[i][i] = true;
	}

	cut[n] = -1;
	for (int i = n - 1; i >= 0; i--) {

	    for (int j = i; j < n; j++) {

		dp[i][j] = (s.charAt(i) == s.charAt(j))
			&& (j - i + 1 <= 2 || dp[i + 1][j - 1]);
		if (dp[i][j]) {
		    cut[i] = Math.min(cut[i], cut[j + 1] + 1);
		}
	    }
	}

	return cut[0];
    }

    public static int minCut2(String s) {
	int n = s.length();
	int cut[] = new int[n + 1];
	boolean[][] dp = new boolean[n][n];

	for (int i = 0; i < n; i++) {
	    cut[i] = i - 1;
	    dp[i][i] = true;
	}
	cut[n] = n - 1;
	cut[0] = -1;
	for (int i = 0; i < n; i++) {

	    for (int j = 0; j <= i; j++) {

		dp[i][j] = (s.charAt(i) == s.charAt(j))
			&& (i - j + 1 <= 2 || dp[i - 1][j + 1]);
		if (dp[i][j]) {
		    cut[i + 1] = Math.min(cut[i + 1], cut[j] + 1);
		}
	    }
	}

	return cut[n];
    }

    public static void main(String[] args) {
	System.out.println(minCut2("ab"));

    }
}
