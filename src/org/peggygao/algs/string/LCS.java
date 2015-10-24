package org.peggygao.algs.string;

public class LCS {

    private static int lcs(char[] a, char[] b) {

	if (a == null || b == null) {
	    return Integer.MIN_VALUE;
	}

	int[][] dp = new int[a.length + 1][b.length + 1];

	int[][] path = new int[a.length + 1][b.length + 1];

	for (int i = 0; i <= a.length; i++) {
	    dp[i][0] = 0;
	}
	for (int j = 0; j <= b.length; j++) {
	    dp[0][j] = 0;
	}

	for (int i = 1; i <= a.length; i++) {

	    for (int j = 1; j <= b.length; j++) {

		if (a[i - 1] == b[j - 1]) {
		    dp[i][j] = dp[i - 1][j - 1] + 1;
		    path[i][j] = 0;
		} else {

		    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
		    path[i][j] = dp[i - 1][j] > dp[i][j - 1] ? 1 : -1;
		}
	    }
	}

	print(a, path, a.length, b.length);

	return dp[a.length][b.length];

    }

    private static void print(char[] a, int[][] path, int i, int j) {

	if (i == 0 || j == 0) {
	    return;
	}

	if (path[i][j] == 0) {
	    print(a, path, i - 1, j - 1);
	    System.out.print(a[i - 1]);
	} else if (path[i][j] == 1) {
	    print(a, path, i - 1, j);
	} else {
	    print(a, path, i, j - 1);
	}
    }

    public static void main(String[] args) {
	char[] a = { 'B', 'D', 'C', 'A', 'B', 'A' };
	char[] b = { 'A', 'B', 'C', 'B', 'D', 'A', 'B' };

	System.out.println(lcs(a, b));

    }

}
