package org.peggygao.algs.sort;

public class MergeSort {

    private static Comparable[] aux;

    private static void merge(Comparable[] a, int low, int mid, int high) {

	for (int k = low; k <= high; k++) {
	    aux[k] = a[k];
	}

	int i = low;
	int j = mid + 1;

	for (int k = low; k <= high; k++) {
	    if (i > mid)
		a[k] = aux[j++];
	    else if (j > high)
		a[k] = aux[i++];
	    else if (aux[i].compareTo(aux[j]) < 0)
		a[k] = aux[i++];
	    else {
		a[k] = aux[j++];
	    }

	}

    }

    private static void sort(Comparable[] a, int low, int high) {

	if (low >= high) {
	    return;
	}
	int mid = low + (high - low) / 2;

	sort(a, low, mid);
	sort(a, mid + 1, high);
	merge(a, low, mid, high);
    }

    private static void sortBU(Comparable[] a) {
	aux = new Comparable[a.length];

	int N = a.length;
	for (int sz = 1; sz < N; sz += sz) {
	    for (int low = 0; low < N - sz; low += sz + sz) {
		merge(a, low, low + sz - 1, Math.min(low + sz + sz - 1, N - 1));
	    }
	}

    }

    private static void sort(Comparable[] a) {
	aux = new Comparable[a.length];
	sort(a, 0, a.length - 1);
    }

    public static void print(Comparable[] a) {
	for (Comparable e : a)

	{
	    System.out.print(e + "  ");
	}
	System.out.println();
    }

    public static void main(String[] args) {
	Comparable[] array = { 'M', 'E', 'R', 'G', 'E', 'S', 'O', 'R', 'T',
		'E', 'X', 'A', 'M', 'P', 'L', 'E' };
	sortBU(array);
	print(array);

    }

}
