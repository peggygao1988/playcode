package org.peggygao.algs.array;

/**
 * find a number which is larger than the left and smaller than the right
 * @author peggygao
 *
 */

public class SmallBig {

    private static void findSmallBig(int[] a) {

	int[] rightMin = new int[a.length];

	int min = Integer.MAX_VALUE;
	for (int i = a.length - 1; i >= 0; i--) {
	    if (a[i] < min) {
		rightMin[i] = a[i];
		min = a[i];
	    } else {
		rightMin[i] = min;
	    }
	}

	int max = Integer.MIN_VALUE;
	for (int i = 0; i < a.length; i++) {
	    if (max < a[i]) {
		max = a[i];
		if (a[i] == rightMin[i]) {
		    System.out.println(a[i]);
		}
	    }
	}

    }

    public static void main(String[] args) {

	int[] a = { 7, 10, 2, 6, 19, 22, 32 };
	findSmallBig(a);
    }

}
