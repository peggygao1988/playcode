package org.peggygao.algs.binarySearchTree;

public class MaxDistance {

    static int maxLength = 0;

    private static class Node {
	int value;
	Node left;
	Node right;

	public Node(int value, Node left, Node right) {
	    super();
	    this.value = value;
	    this.left = left;
	    this.right = right;
	}

    }

    private static int findLength(Node root) {

	if (root == null) {
	    return 0;
	}

	int leftLength = findLength(root.left);
	int rightLength = findLength(root.right);

	if (leftLength + rightLength > maxLength) {
	    maxLength = leftLength + rightLength;
	}

	return Math.max(leftLength, rightLength) + 1;

    }

    public static void main(String[] args) {

	Node n1 = new Node(1, null, null);
	Node n2 = new Node(2, n1, null);
	Node n4 = new Node(4, null, null);
	Node n3 = new Node(3, n2, null);
	Node n9 = new Node(9, null, null);
	Node n7 = new Node(7, null, n9);
	Node n8 = new Node(8, null, null);
	Node n6 = new Node(6, null, null);
	Node n5 = new Node(5, n3, null);
	findLength(n5);
	System.out.println(maxLength);

    }

}
