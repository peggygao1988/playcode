package org.peggygao.algs.array;

public class LDS {

    private static int lds(int[] a) {

	int maxLength = 1;

	int[] lds = new int[a.length];
	int[] maxV = new int[a.length + 1];
	for (int i = 0; i < lds.length; i++) {
	    lds[i] = 1;
	}
	maxV[0] = Integer.MAX_VALUE;
	maxV[1] = a[0];

	for (int i = 0; i < a.length; i++) {

	    int j = maxLength;
	    for (; j > 0; j--) {
		if (maxV[j] > a[i]) {
		    lds[i] = j + 1;
		    break;
		}
	    }

	    if (lds[i] > maxLength) {
		maxV[lds[i]] = a[i];
		maxLength = lds[i];
	    } else {
		if (maxV[j] > a[i] && maxV[j + 1] < a[i]) {
		    maxV[j + 1] = a[i];
		}
	    }

	}

	return maxLength;

    }

    public static void main(String[] args) {
	int[] a = { 9, 4, 3, 2, 5, 4, 3, 2, 7, 1 };
	System.out.println(lds(a));

    }
}
