public class StringEditDistance {

    static int differ(String string1, String string2) {

	String[] s1 = string1.split(" ");
	String[] s2 = string2.split(" ");

	int[][] dp = new int[s1.length + 1][s2.length + 1];

	for (int i = 0; i <= s1.length; i++) {
	    dp[i][0] = i;
	}
	for (int j = 0; j <= s2.length; j++) {
	    dp[0][j] = j;
	}

	for (int i = 1; i <= s1.length; i++) {

	    for (int j = 1; j <= s2.length; j++) {
		if (s1[i - 1].equals(s2[j - 1])) {
		    dp[i][j] = dp[i - 1][j - 1];
		} else {

		    dp[i][j] = Math.min(dp[i - 1][j],
			    Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
		}
	    }
	}

	return dp[s1.length][s2.length];

    }
    
    

    public static void main(String[] args) {
	System.out.println(differ("Kindle Fire HD Tablet", "Kindle Fire HD 8.9\" 4G LTE Wireless Tablet"));
    }

}
