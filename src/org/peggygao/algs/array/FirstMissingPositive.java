package org.peggygao.algs.array;

public class FirstMissingPositive {
    public static int firstMissingPositive(int[] A) {

	int n = A.length;

	for (int i = 0; i < n; i++) {

	    if (A[i] > 0 && A[i] < n) {

		if (A[i] - 1 != i && A[A[i] - 1] != A[i]) {

		    int temp = A[A[i] - 1];
		    A[A[i] - 1] = A[i];
		    A[i] = temp;
		    i--;
		}
	    }

	}

	for (int i = 0; i < n; i++) {
	    if (A[i] - 1 != i) {
		return i + 1;
	    }
	}

	return n + 1;

    }

    public static void main(String[] args) {

	System.out.println(firstMissingPositive(new int[] { 2, 1 }));
    }
}
