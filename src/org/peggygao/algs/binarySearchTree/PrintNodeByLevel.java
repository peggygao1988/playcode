package org.peggygao.algs.binarySearchTree;

import java.util.ArrayList;

public class PrintNodeByLevel {

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

    private static void printNodeByLevel(Node root) {

	if (root == null) {
	    return;
	}
	ArrayList<Node> list = new ArrayList<Node>();
	list.add(root);
	int current = 0;
	int last = 1;
	while (current < list.size()) {
	    while (current < last) {
		Node n = list.get(current);
		System.out.print(n.value + "\t");
		if (n.left != null) {
		    list.add(n.left);
		}
		if (n.right != null) {
		    list.add(n.right);
		}
		current++;
	    }
	    System.out.println();
	    last = list.size();
	}

    }

    public static void main(String[] args) {
	Node n1 = new Node(1, null, null);
	Node n2 = new Node(2, n1, null);
	Node n4 = new Node(4, null, null);
	Node n3 = new Node(3, n2, n4);
	Node n9 = new Node(9, null, null);
	Node n7 = new Node(7, null, n9);
	Node n8 = new Node(8, null, null);
	Node n6 = new Node(6, n7, n8);
	Node n5 = new Node(5, n3, n6);

	printNodeByLevel(n5);
    }

}
