package org.peggygao.algs.string;

public class LCSubString {

    private static int lcss(char[] s1, char[] s2) {

	int max = 0;
	int end = -1;

	int[][] dp = new int[s1.length + 1][s2.length + 1];

	for (int i = 0; i < s1.length + 1; i++) {
	    dp[i][0] = 0;
	}
	for (int j = 0; j < s2.length + 1; j++) {
	    dp[0][j] = 0;
	}

	for (int i = 1; i < s1.length + 1; i++) {

	    for (int j = 1; j < s2.length + 1; j++) {

		if (s1[i - 1] == s2[j - 1]) {

//		    if (i == 1 || j == 1) {
//			dp[i][j] = 1;
//		    } else {
			dp[i][j] = dp[i - 1][j - 1] + 1;
//		    }

		    if (dp[i][j] > max) {
			max = dp[i][j];
			end = i;
		    }

		} else {
		    dp[i][j] = 0;
		}

	    }
	}
	System.out.println(new String(s1).substring(end - max, end));
	return max;
    }

    public static void main(String[] args) {

	char[] s1 = "21232523311324".toCharArray();
	char[] s2 = "312123223445".toCharArray();

	System.out.println(lcss(s1, s2));
    }

}
