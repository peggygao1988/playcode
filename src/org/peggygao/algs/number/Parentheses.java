package org.peggygao.algs.number;

public class Parentheses {

    private static void paren(char[] result, int index, int left, int right,
	    int n) {
	if (index == n * 2) {
	    print(result);
	    return;
	}

	if (left == n) {
	    result[index] = ')';
	    paren(result, index + 1, left, right + 1, n);
	} else if (left == right) {
	    result[index] = '(';
	    paren(result, index + 1, left + 1, right, n);
	} else {
	    result[index] = '(';
	    paren(result, index + 1, left + 1, right, n);
	    result[index] = ')';
	    paren(result, index + 1, left, right + 1, n);
	}
    }

    private static void print(char[] result) {
	for (char c : result) {
	    System.out.print(c);
	}
	System.out.println();
    }

    public static void main(String[] args) {
	paren(new char[6], 0, 0, 0, 3);
    }

}
