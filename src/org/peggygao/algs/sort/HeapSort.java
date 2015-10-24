package org.peggygao.algs.sort;

public class HeapSort {

    public static void sort(Comparable[] a) {

	int N = a.length - 1;

	for (int k = N / 2; k >= 1; k--) {
	    sink(a, k, N);
	}

	while (N > 1) {
	    Comparable temp = a[1];
	    a[1] = a[N--];
	    a[N + 1] = temp;

	    sink(a, 1, N);
	}
    }

    private static void sink(Comparable[] a, int k, int N) {

	while (2 * k <= N) {
	    int j = 2 * k;
	    if (j < N && a[j].compareTo(a[j + 1]) < 0) {
		j++;
	    }
	    if (a[k].compareTo(a[j]) < 0) {
		Comparable temp = a[k];
		a[k] = a[j];
		a[j] = temp;
		k = j;
	    } else {
		break;
	    }

	}
    }

    private static void swim(Comparable[] a, int k, int N) {

	while (k > 1) {
	    if (a[k].compareTo(a[k / 2]) > 0) {
		Comparable temp = a[k];
		a[k] = a[k / 2];
		a[k / 2] = temp;
		k /= 2;
	    } else {
		break;
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
	Comparable[] array = { ' ', 'S', 'O', 'R', 'T', 'E', 'X', 'A', 'M',
		'P', 'L', 'E' };
	sort(array);
	print(array);
    }

}
