package org.peggygao.algs.sort;

public class SelectionSort {

    public static void sort(Comparable[] a) {

	for (int i = 0; i < a.length; i++) {
	    int min = i;
	    for (int j = i + 1; j < a.length; j++) {
		if (a[j].compareTo(a[min]) < 0) {
		    min = j;
		}
	    }
	    Comparable temp = a[min];
	    a[min] = a[i];
	    a[i] = temp;
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
	sort(array);
	print(array);

    }

}
