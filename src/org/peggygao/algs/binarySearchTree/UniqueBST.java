package org.peggygao.algs.binarySearchTree;

public class UniqueBST {

    private static int numOfBST(int n) {
	if (n < 1) {
	    return 0;
	}

	return dfs(1, n);
    }

    private static int dfs(int start, int end) {

	if (start >= end) {
	    return 1;
	}

	int total = 0;

	for (int i = start; i <= end; i++) {
	    int lnum = dfs(i + 1, end);
	    int rnum = dfs(start, i - 1);

	    total += lnum * rnum;
	}

	return total;
    }

    private static int numTrees(int n) {

	if (n <= 1) {
	    return n;
	}

	int[] dp = new int[n + 1];

	dp[0] = 1;
	dp[1] = 1;

	for (int i = 2; i <= n; i++) {
	    dp[i] = 0;
	    for (int j = 0; j < i; j++) {
		dp[i] += dp[j] * dp[i - j - 1];
	    }
	}

	return dp[n];

    }

    public static void main(String[] args) {

	System.out.println(numOfBST(3));
	System.out.println(numTrees(3));
    }

}
