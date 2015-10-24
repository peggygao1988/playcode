package org.peggygao.algs.sort;

public class InsertionSort {

    public static void sort(Comparable[] a) {

	for (int i = 1; i < a.length; i++) {

	    Comparable key = a[i];
	    int j = i;
	    for (; j >= 1 && a[j - 1].compareTo(key) > 0; j--) {

		a[j] = a[j - 1];
	    }

	    a[j] = key;
	}
    }

    public static void sort2(Comparable[] a) {

	for (int i = 1; i < a.length; i++) {
	    Comparable key = a[i];
	    int j = i - 1;
	    for (; j >= 0; j--) {
		if (a[j].compareTo(key) > 0) {
		    a[j + 1] = a[j];
		} else {
		    break;
		}
	    }

	    a[j + 1] = key;
	}
    }

    public static void print(Comparable[] a) {
	for (Comparable e : a)

	{
	    System.out.print(e + "  ");
	}
	System.out.println();
    }

    public static void main(String[] args) {
	Comparable[] array = { 'S', 'O', 'R', 'T', 'E', 'X', 'A', 'M', 'P',
		'L', 'E' };
	sort2(array);
	print(array);

    }

}
