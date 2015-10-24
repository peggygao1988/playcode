package org.peggygao.algs.string;

public class RegularExpressionMatch {

    private static boolean isMatch(String s, String p) {
	if (s == null) {
	    return p == null;
	}
	return match(s, p, 0, 0);
    }

    private static boolean match(String s, String p, int i, int j) {
	if (j == p.length()) {
	    return i == s.length();
	}

	if (j == p.length() - 1 || p.charAt(j + 1) != '*') {

	    if (i == s.length()) {
		return false;
	    }

	    return (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.')
		    && match(s, p, i + 1, j + 1);
	}

	while (i < s.length()
		&& (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.')) {
	    if (match(s, p, i++, j + 2)) {
		return true;
	    }
	}

	return match(s, p, i, j + 2);
    }

    public static void main(String[] args) {
	String s = "";
	String p = ".";

	System.out.println(isMatch(s, p));
    }
}
