package org.peggygao.algs.string;

public class InterleavingString {

    public static boolean isInterleave(String s1, String s2, String s3) {

	if (s1.length() + s2.length() != s3.length()) {
	    return false;
	}

	return recursion(s1, 0, s2, 0, s3, 0);
    }

    private static boolean recursion(String s1, int i, String s2, int j,
	    String s3, int k) {
	if (i == s1.length() && j == s2.length() && k == s3.length()) {
	    return true;
	}

	if (k == s3.length() && (i != s1.length() || s2.length() != j)) {
	    return false;
	}

	if (i == s1.length() && j == s2.length() && k != s3.length()) {
	    return false;
	}

	boolean result = false;
	if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
	    result = recursion(s1, i + 1, s2, j, s3, k + 1);
	}
	if (!result && j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
	    result = recursion(s1, i, s2, j + 1, s3, k + 1);
	}

	return result;
    }

    
    private static boolean isInterleaving(String s1, String s2, String s3){
	
	if (s1.length() + s2.length() != s3.length()) {
	    return false;
	}
	
	int m = s1.length();
	int n = s2.length() ; 
	boolean[][] dp = new boolean[m+1][n+1];
	
	dp[0][0] = true;
	for(int i = 1 ; i < m+1 ; i++){
	    if(s1.charAt(i-1) == s3.charAt(i-1) ){
		dp[i][0] = true;
	    }else{
		dp[i][0] = false;
	    }
	    
	}
	
	for(int i = 1; i<n+1 ; i++){
	    if(s2.charAt(i-1) == s3.charAt(i-1)){
		dp[0][i] = true;
	    }else{
		dp[0][i] = false;
	    }
	}
	
	for(int i = 1; i< m+1; i++){
	    for(int j = 1; j < n+1; j++){
		
		if(s1.charAt(i-1) == s3.charAt(i+j-1)){
		    dp[i][j] |= dp[i-1][j];
		}
		if(s2.charAt(j-1) == s3.charAt(i+j-1)){
		    dp[i][j] |=dp[i][j-1];
		}
	    }
	}
		
	
	return dp[m][n];
	
	
	
    }
    public static void main(String[] args) {

	String s1 = "aabcc";
	String s2 = "dbbca";
	String s3 = "aadbbcbcac";

	System.out.println(isInterleave(s1, s2, s3));
	System.out.println(isInterleaving(s1, s2, s3));
    }

}
