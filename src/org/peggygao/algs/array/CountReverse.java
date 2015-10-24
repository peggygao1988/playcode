package org.peggygao.algs.array;

public class CountReverse {

    private static int[] aux;

    private static int countReverse(int[] a) {

	if (a == null || a.length == 0) {
	    return 0;
	}
	aux = new int[a.length];
	return count(a, 0, a.length - 1);
    }

    private static int count(int[] a, int start, int end) {

	if (start == end) {
	    return 0;
	}

	int mid = start + (end - start) / 2;

	int left = count(a, start, mid);
	int right = count(a, mid + 1, end);

	int middle = merge(a, start, mid, end);

	return left + right + middle;
    }

    private static int merge(int[] a, int start, int mid, int high) {

	int count = 0;
	for (int i = start; i <= high; i++) {
	    aux[i] = a[i];
	}

	int i = start;
	int j = mid + 1;

	for (int k = start; k <= high; k++) {

	    if (i > mid) {
		a[k] = aux[j++];
	    } else if (j > high) {
		a[k] = aux[i++];
	    }

	    else if (aux[i] > aux[j]) {
		count += mid - i + 1;
		a[k] = aux[j++];
	    } else {
		a[k] = aux[i++];
	    }

	}

	return count;
    }

    public static void main(String[] args) {
	System.out.println(countReverse(new int[] { 176, 178, 180, 170, 171 }));

    }
}
