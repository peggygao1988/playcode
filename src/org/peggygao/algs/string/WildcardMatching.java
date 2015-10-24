package org.peggygao.algs.string;

public class WildcardMatching {

    private static boolean isMatch(String s, String p) {

	if (p == null) {
	    return s == null;
	}

	return dfs(s, 0, p, 0);

    }

    private static boolean dfs(String s, int i, String p, int j) {
	if (j == p.length()) {
	    return i == s.length();
	}

	if (i == s.length()) {
	    if (p.substring(j).equals("*")) {
		return true;
	    } else {
		return false;
	    }
	}

	char c1 = s.charAt(i);
	char c2 = p.charAt(j);

	if (c1 == c2 || c2 == '?') {
	    return dfs(s, i + 1, p, j + 1);
	}

	if (c2 != '*') {
	    return false;
	}
	boolean result = false;
	for (int k = 0; k <= s.length() - i; k++) {
	    result = dfs(s, k + i, p, j + 1);
	    if (result) {
		return true;
	    }
	}

	return false;
    }

    public static boolean isMatch2(String s, String p) {

	if (p == null) {
	    return s == null;
	}

	if (s == null) {
	    return false;
	}

	int i = 0;
	int j = 0;
	int starJ = -1;
	int starI = -1;
	while (i < s.length()) {

	    if (j < p.length() && s.charAt(i) == p.charAt(j)
		    || (j < p.length() && p.charAt(j) == '?')) {
		i++;
		j++;
	    } else if (j < p.length() && p.charAt(j) == '*') {
		while (j < p.length() && p.charAt(j) == '*') {
		    j++;
		}

		if (j == p.length()) {
		    return true;
		}

		starJ = j;
		starI = i;
	    } else if ((j == p.length() || (j < p.length() && s.charAt(i) != p
		    .charAt(j))) && starJ != -1) {

		i = ++starI;
		j = starJ;
	    } else {
		return false;
	    }

	}

	while (j < p.length()) {
	    if (p.charAt(j) != '*') {
		return false;
	    }
	    j++;
	}

	return true;

    }

    public static void main(String[] args) {

	String s1 = "aaa";
	String s2 = "a*";
	System.out.println(isMatch2("cabab", "*ab"));
    }

}
