package org.peggygao.algs.string;

public class DistinctSubSequnce {

    private static int distinct(String S, String T) {

	if (S == null || S.length() == 0) {
	    return 0;
	}

	int m = T.length();
	int n = S.length();

	int[][] dp = new int[m + 1][n + 1];

	dp[0][0] = 1;
	for (int i = 1; i < m + 1; i++) {
	    dp[i][0] = 0;
	}

	for (int i = 1; i < n + 1; i++) {
	    dp[0][i] = 1;
	}

	for (int i = 1; i < m + 1; i++) {
	    for (int j = 1; j < n + 1; j++) {
		dp[i][j] = dp[i][j - 1];
		if (T.charAt(i - 1) == S.charAt(j - 1)) {
		    dp[i][j] += dp[i - 1][j - 1];
		}
	    }
	}

	return dp[m][n];
    }

    public static void main(String[] args) {

	String S = "rabbbitt";
	String T = "rabbit";
	System.out.println(distinct(S, T));
    }

}
