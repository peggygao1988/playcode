package org.peggygao.algs.number;

public class ReorderEvenOdd {

    private static void reorder(int[] a) {

	if (a == null || a.length == 0) {
	    return;
	}

	int i = -1;
	int j = a.length;
	while (true) {
	    while ((a[++i] & 1) == 1) {
		if (i == a.length - 1) {
		    break;
		}
	    }

	    while ((a[--j] & 1) == 0) {
		if (j == 0) {
		    break;
		}
	    }

	    if (i >= j)
		break;
	    int temp = a[i];
	    a[i] = a[j];
	    a[j] = temp;

	}

    }

    public static void main(String[] args) {
	int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	reorder(a);
	for (int i = 0; i < a.length; i++) {
	    System.out.print(a[i] + "\t");
	}
    }

}
