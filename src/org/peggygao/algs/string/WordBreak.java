package org.peggygao.algs.string;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {

    private static HashSet<String> dict = new HashSet<String>();
    static {
	dict.add("hello");
	dict.add("world");
	dict.add("lee");
    }

    private static boolean wordBreak(String s, Set<String> dict) {

	if (s == null || s.length() == 0) {
	    return false;
	}

	boolean[] dp = new boolean[s.length()];

	for (int i = 0; i < s.length(); i++) {

	    for (int j = 0; j <= i; j++) {

		if (j == 0 || j == i) {
		    if (dict.contains(s.substring(j, i + 1))) {
			dp[i] = true;
			break;
		    }
		} else {
		    if (dp[j] == true
			    && dict.contains(s.substring(j + 1, i + 1))) {
			dp[i] = true;
			break;
		    }
		}

	    }
	}

	return dp[s.length() - 1];

    }

    public static void main(String[] args) {

	System.out.println(wordBreak("hellohelloworldlee", dict));
    }

}
