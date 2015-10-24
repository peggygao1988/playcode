package org.peggygao.algs.number;

public class ReverseBit {

    static int reverse(int v) {

	int r =v;
	int s = 32;
	for (; v != 0; v >>= 1) {
	    r <<= 1;
	    r |= (v & 1);

	    s--;
	}

	r <<= s;
	return r;
    }

    public static void main(String[] args) {
	System.out.println(reverse(7));

    }

}
