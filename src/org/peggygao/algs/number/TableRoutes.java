package org.peggygao.algs.number;

public class TableRoutes {

    private static int routes(int N) {

	int[][] routes = new int[N + 1][N + 1];

	for (int i = 0; i < N + 1; i++) {
	    routes[i][0] = 1;
	}
	for (int i = 0; i < N + 1; i++) {
	    routes[0][i] = 1;
	}
	for (int i = 1; i < N + 1; i++) {

	    for (int j = 1; j < N + 1; j++) {
		routes[i][j] = routes[i - 1][j] + routes[i][j - 1];
	    }
	}

	return routes[N][N];
    }

    public static int uniquePaths(int m, int n) {
	// Start typing your Java solution below
	// DO NOT write main() function

	int[][] dp = new int[m][n];

	for (int i = 0; i < m; i++) {
	    dp[i][0] = 1;
	}
	for (int i = 0; i < n; i++) {
	    dp[0][i] = 1;
	}

	for (int i = 1; i < m; i++) {

	    for (int j = 1; j < n; j++) {

		dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
	    }
	}

	return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
	System.out.println(routes(1));
	System.out.println(uniquePaths(2, 2));
    }

}
