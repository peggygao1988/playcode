package org.peggygao.algs.sort;

public class ShellSort {

    public static void sort(Comparable[] a) {

	for (int step = a.length / 2; step > 0; step /= 2) {

	    for (int i = step; i < a.length; i++) {
		Comparable key = a[i];
		int j = i;
		for (; j >= step && a[j - step].compareTo(key) > 0; j -= step) {
		    a[j] = a[j - step];
		}
		a[j] = key;
	    }

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
	Comparable[] array = { 'S', 'H', 'E', 'L', 'L', 'S', 'O', 'R', 'T',
		'E', 'X', 'A', 'M', 'P', 'L', 'E' };
	sort(array);
	print(array);

    }

}
