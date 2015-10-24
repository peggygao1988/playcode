package org.peggygao.algs.binarySearchTree;

public class SwapTreeNode {

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

    private static Node first = null;
    private static Node second = null;

    private static Node inOrder(Node root, Node last) {

	if (root.left != null) {
	    last = inOrder(root.left, last);
	}

	if (last != null && last.value > root.value) {
	    if (first == null) {
		first = last;
	    } else {
		second = root;
	    }
	}

	last = root;

	if (root.right != null) {
	    last = inOrder(root.right, last);
	}

	return last;

    }

    private static void print(Node root) {
	if (root == null) {
	    return;
	}
	print(root.left);
	System.out.print(root.value + "\t");
	print(root.right);
    }

    private static void swapNode(Node root) {
	inOrder(root, null);
	int temp = first.value;
	first.value = second.value;
	second.value = temp;
    }

    public static void main(String[] args) {
	Node n1 = new Node(1, null, null);
	Node n4 = new Node(4, null, null);
	Node n7 = new Node(7, null, null);
	Node n10 = new Node(10, n4, n7);
	Node n3 = new Node(3, n1, n10);
	Node n13 = new Node(13, null, null);
	Node n14 = new Node(14, n13, null);
	Node n6 = new Node(6, null, n14);
	Node n8 = new Node(8, n3, n6);

	print(n8);
	System.out.println();
	swapNode(n8);
	print(n8);

    }

}
