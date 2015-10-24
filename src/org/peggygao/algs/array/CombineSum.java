package org.peggygao.algs.array;

public class CombineSum {

    private static void getCombine(int[] numbers, int targetSum) {
	boolean[] marked = new boolean[numbers.length];
	for (int i = 1; i <= numbers.length; i++) {
	    combineSum(targetSum, numbers, marked, i, 0, 0);
	}
    }

    private static void combineSum(int sum, int[] numbers, boolean[] marked,
	    int n, int m, int current) {

	if (n == m) {
	    if (checkSum(sum, numbers, marked)) {
		print(numbers, marked);
	    }
	    return;
	}
	if (current >= marked.length) {
	    return;
	}

	marked[current] = true;
	combineSum(sum, numbers, marked, n, m + 1, current + 1);

	marked[current] = false;
	combineSum(sum, numbers, marked, n, m, current + 1);

    }

    private static void print(int[] numbers, boolean[] marked) {
	for (int i = 0; i < marked.length; i++) {
	    if (marked[i] == true) {
		System.out.print(numbers[i] + "\t");
	    }
	}
	System.out.println();
    }

    private static boolean checkSum(int target, int[] numbers, boolean[] marked) {

	int sum = 0;
	for (int i = 0; i < marked.length; i++) {
	    if (marked[i] == true) {
		sum += numbers[i];
	    }
	}

	if (sum == target) {
	    return true;
	}

	return false;
    }

    private static int dp(int[] numbers, int sum) {
	int[][] dp = new int[numbers.length + 1][sum + 1];

	for (int i = 0; i < sum + 1; i++) {
	    dp[0][i] = 0;

	}

	for (int j = 0; j < numbers.length + 1; j++) {
	    dp[j][0] = 0;
	}
	dp[0][0] = 1;

	for (int i = 1; i < dp.length; i++) {

	    for (int j = 0; j <= sum; j++) {

		dp[i][j] = dp[i - 1][j];
		if (j >= numbers[i - 1]) {
		    dp[i][j] += dp[i - 1][j - numbers[i - 1]];
		}

	    }

	}
	return dp[numbers.length][sum];

    }

    public static void main(String[] args) {
	int[] numbers = { 5, 5, 10, 2, 3 };
	// getCombine(numbers, 15);

	System.out.println(dp(numbers, 15));
    }

}
