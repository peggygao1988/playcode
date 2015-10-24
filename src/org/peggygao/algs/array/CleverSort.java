package org.peggygao.algs.array;

public class CleverSort {

    private static void cleverSort(int[] a) {

	if (a == null || a.length == 0) {
	    return;
	}

	int p1 = 0;
	while (a[p1] == 1) {
	    p1++;
	}

	int p2 = p1;

	int p3 = a.length - 1;
	while (a[p3] == 3) {
	    p3--;
	}

	while (p2 <= p3) {
	    if (a[p2] == 2) {

	    } else if (a[p2] == 1) {
		swap(a, p1, p2);
		while (a[p1] == 1) {
		    p1++;
		}
	    } else if (a[p2] == 3) {
		swap(a, p2, p3);
		while (a[p3] == 3) {
		    p3--;
		}
	    }
	    p2++;
	}

    }

    private static void swap(int[] a, int p1, int p2) {
	int temp = a[p1];
	a[p1] = a[p2];
	a[p2] = temp;
    }

    private static void print(int[] a) {
	for (int i : a) {
	    System.out.print(i + "\t");
	}
	System.out.println();
    }

    public static void main(String[] args) {
	int[] a = { 3, 1, 3, 1, 3, 1, 2, 2, 2 };
	cleverSort(a);
	print(a);

    }
}
