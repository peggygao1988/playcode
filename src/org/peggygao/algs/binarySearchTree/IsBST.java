package org.peggygao.algs.binarySearchTree;

public class IsBST {

    private static boolean isBST(int[] a, int start, int end) {

	if (start == end) {
	    return true;
	}

	int root = a[end];

	int i = start;
	for (; i < end; i++) {
	    if (a[i] > root)
		break;
	}

	int leftEnd = i - 1;

	for (int j = i; j < end; j++) {
	    if (a[j] < root)
		return false;
	}

	return isBST(a, start, leftEnd) && isBST(a, leftEnd + 1, end - 1);

    }

    public static void main(String[] args) {

	int[] a = { 7, 4, 6, 5 };
	System.out.println(isBST(a, 0, a.length - 1));

    }

}
