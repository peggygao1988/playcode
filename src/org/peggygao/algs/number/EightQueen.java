package org.peggygao.algs.number;

public class EightQueen {

    private static int count = 0;;

    private static void permutation(int[] columnIndex, int index,
	    boolean[] marked) {

	if (index == 8) {
	    int i = 0;
	    int j = 0;
	    for (; i < 8; i++) {
		for (j = i + 1; j < 8; j++) {
		    if (i - j == columnIndex[i] - columnIndex[j]
			    || j - i == columnIndex[i] - columnIndex[j]) {
			return;
		    }
		}
	    }

	    if (i == 8 && j == 8) {
		for (int k = 0; k < 8; k++) {
		    System.out.print(columnIndex[k]);
		}
		System.out.println();
		count++;
	    }
	}

	for (int i = 0; i < 8; i++) {
	    if (marked[i]) {
		continue;
	    }
	    columnIndex[index] = i;
	    marked[i] = true;

	    permutation(columnIndex, index + 1, marked);
	    marked[i] = false;
	}
    }

    private static void per2(int[] columns, int index) {
	if (index == 8) {

	    int i = 0;
	    int j = 0;
	    for (i = 0; i < 8; i++) {
		for (j = i + 1; j < 8; j++) {
		    if (i - j == columns[i] - columns[j]
			    || j - i == columns[i] - columns[j]) {
			return;
		    }
		}
	    }

	    if (i == 8 && j == 8) {
		for (int k = 0; k < 8; k++) {
		    System.out.print(columns[k]);
		}
		System.out.println();
		count++;
	    }

	}

	for (int i = index; i < 8; i++) {
	    swap(columns, index, i);
	    per2(columns, index + 1);
	    swap(columns, index, i);
	}

    }

    private static void swap(int[] a, int i, int j) {
	int temp = a[i];
	a[i] = a[j];
	a[j] = temp;
    }

    public static void main(String[] args) {

	 permutation(new int[8], 0, new boolean[8]);
//	per2(new int[] { 0, 1, 2, 3, 4, 5, 6, 7 }, 0);
	System.out.println(count);

    }

}
