package org.peggygao.algs.array;

public class MedianOf2SortedArray {

    private static double findKthOf2SortedArray(int[] a, int astart, int aend,
	    int[] b, int bstart, int bend, int k) {

	if (aend - astart > bend - bstart) {
	    return findKthOf2SortedArray(b, bstart, bend, a, astart, aend, k);
	}

	if (aend < astart) {
	    return b[k - 1];
	}

	if (k == 1) {
	    return Math.min(a[astart], b[bstart]);

	}

	int ia = Math.min(k / 2, aend - astart + 1);
	int ib = k - ia;

	if (a[astart + ia - 1] == b[bstart + ib - 1]) {
	    return a[astart + ia - 1];
	} else if (a[astart + ia - 1] < b[bstart + ib - 1]) {
	    return findKthOf2SortedArray(a, astart + ia, aend, b, bstart, bend,
		    k - ia);
	} else {
	    return findKthOf2SortedArray(a, astart, aend, b, bstart + ib, bend,
		    k - ib);
	}

    }

    public static void main(String[] args) {
	int[] a = { 2, 4, 6, 8 };
	int[] b = { 1, 3, 5, 7, 9 };
	int m = a.length;
	int n = b.length;

	double r = findKthOf2SortedArray(a, 0, m - 1, b, 0, n - 1, 8);
	// int total = m + n;
	//
	// double r = 0;
	// if (m == 0) {
	// if (n % 2 == 1) {
	// r = b[n / 2] * 1.0;
	// } else {
	// r = (b[n / 2 - 1] + b[n / 2]) / 2.0;
	// }
	// }
	//
	// if (n == 0) {
	// if (m % 2 == 1) {
	// r = a[m / 2] * 1.0;
	// } else {
	// r = (a[m / 2 - 1] + a[m / 2]) / 2.0;
	// }
	// }
	// if (total % 2 == 1) {
	// r = findKthOf2SortedArray(a, 0, a.length - 1, b, 0, b.length - 1,
	// total / 2 + 1);
	// } else {
	//
	// r = (findKthOf2SortedArray(a, 0, a.length - 1, b, 0, b.length - 1,
	// total / 2) + findKthOf2SortedArray(a, 0, a.length - 1, b,
	// 0, b.length - 1, total / 2 + 1)) / 2.0;
	// }

	System.out.println(r);
    }

}
