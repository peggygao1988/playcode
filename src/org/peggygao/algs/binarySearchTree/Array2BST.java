package org.peggygao.algs.binarySearchTree;

public class Array2BST {

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

    private static Node array2BST(int[] a, int start, int end) {

	if (start == end) {
	    return new Node(a[start], null, null);
	}

	int mid = start + (end - start) / 2;
	Node node = new Node(a[mid], null, null);

	if (mid - 1 >= start) {
	    node.left = array2BST(a, start, mid - 1);
	}
	if (mid + 1 <= end) {
	    node.right = array2BST(a, mid + 1, end);
	}
	return node;
    }

    private static void print(Node root) {
	if (root == null) {
	    return;
	}
	print(root.left);
	System.out.print(root.value + "\t");
	print(root.right);
    }

    public static void main(String[] args) {

	int[] a = { 1, 2, 3, 4, 5, 6, 7 };
	print(array2BST(a, 0, a.length - 1));

    }

}
