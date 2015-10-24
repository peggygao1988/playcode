package org.peggygao.algs.binarySearchTree;

public class IsPostOrder {

    private static class Node {
	int value;
	Node left;
	Node right;

	public Node(int value, Node left, Node right) {

	    this.value = value;
	    this.left = left;
	    this.right = right;
	}
    }

    private static boolean isPostOrder(int[] order, int start, int end) {

	if (start == end) {
	    return true;
	}

	int root = order[end];
	int rightStart = start;
	while (order[rightStart] < root) {
	    rightStart++;
	}

	for (int i = rightStart; i < end; i++) {
	    if (order[i] < root) {
		return false;
	    }
	}

	return isPostOrder(order, start, rightStart - 1)
		&& isPostOrder(order, rightStart, end - 1);

    }

    public static void main(String[] args) {
	System.out.println(isPostOrder(new int[] { 7, 4, 6, 5 }, 0, 3));

    }

}
