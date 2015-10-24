package org.peggygao.algs.binarySearchTree;

public class Mirror {

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

    private static void mirror(Node root) {

	if (root == null) {
	    return;
	}

	Node temp = root.left;
	root.left = root.right;
	root.right = temp;

	mirror(root.left);
	mirror(root.right);

    }

    private static void printInOrder(Node root) {

	if (root == null) {
	    return;
	}
	printInOrder(root.left);
	System.out.print(root.value + "\t");
	printInOrder(root.right);
    }

    public static void main(String[] args) {
	Node n1 = new Node(5, null, null);
	Node n2 = new Node(7, null, null);
	Node n3 = new Node(6, n1, n2);

	Node n4 = new Node(9, null, null);
	Node n5 = new Node(11, null, null);
	Node n6 = new Node(10, n4, n5);
	Node n7 = new Node(8, n3, n6);

	printInOrder(n7);
	System.out.println();
	mirror(n7);
	printInOrder(n7);

    }

}
