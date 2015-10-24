package org.peggygao.algs.array;

public class JumpGame {
    public static int jump(int[] A) {

	if (A == null || A.length == 0) {
	    return 0;
	}

	int[] dp = new int[A.length];
	dp[0] = 0;

	for (int i = 1; i < A.length; i++) {

	    dp[i] = Integer.MAX_VALUE;
	    for (int j = 0; j < i; j++) {

		if (A[j] >= i - j && dp[i] > dp[j] + 1) {
		    dp[i] = dp[j] + 1;
		    break;
		}
	    }
	}

	return dp[A.length - 1];

    }

    public static void main(String[] args) {

	int[] a = { 1, 3, 5, 2, 9, 3, 1, 1, 8 };
	System.out.println(jump(a));
    }
}
