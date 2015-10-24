package org.peggygao.algs.array;

import java.util.Arrays;

public class FindLongestArithmeticSequence {

    private static void las(int[] a) {

	Arrays.sort(a);
	int maxD = (a[a.length - 1] - a[0]) / 3;

	int[][] dp = new int[maxD][a.length];

	int max = 1;
	int maxStep = 0;
	int maxEnd = -1;
	for (int step = 1; step <= maxD; step++) {

	    for (int i = 0; i < a.length; i++) {

		dp[step - 1][i] = 1;

		for (int j = i - 1; j >= 0 && a[i] - a[j] <= step; j--) {
		    if (a[i] - a[j] == step
			    && dp[step - 1][j] + 1 > dp[step - 1][i]) {
			dp[step - 1][i] = dp[step - 1][j] + 1;
		    }

		}

		if (max < dp[step - 1][i]) {
		    max = dp[step - 1][i];
		    maxStep = step;
		    maxEnd = i;
		}
	    }

	}

	int[] result = new int[max];
	result[max - 1] = a[maxEnd];
	int j = max - 2;
	for (int i = maxEnd - 1; i >= 0; i--) {
	    if (a[i] + maxStep == result[j + 1] && dp[maxStep - 1][i] == j + 1) {

		result[j] = a[i];
		j--;
	    }
	}

	for (int k : result) {
	    System.out.print(k);
	}

    }

    public static void main(String[] args) {

	int[] a = { 4, 8, 1, 9, 6, 0, 2, 4, 7, 1 };
	las(a);
    }
}
