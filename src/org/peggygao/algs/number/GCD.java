package org.peggygao.algs.number;

public class GCD {

    static int gcd1(int x, int y) {

	if (y == 0) {
	    return x;
	}

	return gcd1(y, x % y);

    }

    static int gcd2(int x, int y) {
	if (y > x) {
	    return gcd2(y, x);
	}

	if (y == 0) {
	    return x;
	}

	return gcd2(x - y, y);
    }

    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }

}
