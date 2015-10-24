package org.peggygao.algs.number;

public class Combination {

    private static char[] chars = { 'a' };

    private static void getCom(char[] chars) {
	for (int i = 0; i <= chars.length; i++) {
	    combination(new boolean[chars.length], i, 0, 0);
	}
    }

    private static void combination(boolean[] marked, int m, int n, int current) {

	if (m == n) {
	    print(marked);
	    return;
	}
	if (current >= marked.length) {
	    return;
	}

	marked[current] = true;
	combination(marked, m, n + 1, current + 1);

	marked[current] = false;
	combination(marked, m, n, current + 1);

    }

    private static void print(boolean[] markded) {
	for (int i = 0; i < markded.length; i++) {
	    if (markded[i]) {
		System.out.print(chars[i]);
	    }
	}
	System.out.println();
    }

    public static void main(String[] args) {
	getCom(chars);
    }

}
