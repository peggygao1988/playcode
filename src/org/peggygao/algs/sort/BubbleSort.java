package org.peggygao.algs.sort;

public class BubbleSort {

    private static void sort(Comparable[] a) {

	int N = a.length - 1;

	for (int i = N; i > 0; i--) {

	    for (int j = 0; j < i; j++) {
		if (a[j].compareTo(a[j + 1]) > 0) {
		    Comparable temp = a[j];
		    a[j] = a[j + 1];
		    a[j + 1] = temp;
		}
	    }
	}
    }

    public static void main(String[] args) {
	Integer[] a = { 1, 1, 1, 1, 1, 0 };
	sort(a);
	for (int i = 0; i < a.length; i++) {
	    System.out.print(a[i] + "\t");
	}

    }

}
