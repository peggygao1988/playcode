package org.peggygao.algs.binarySearchTree;

import org.peggygao.algs.collections.Queue;

public class LevelPrint {

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

    private static void printInLevel(Node root) {
	if (root == null) {
	    return;
	}

	Queue<Node> queue = new Queue<Node>();
	queue.enqueue(root);

	while (!queue.isEmpty()) {
	    Node current = queue.dequeue();
	    System.out.print(current.value + "\t");
	    if (current.left != null) {
		queue.enqueue(current.left);
	    }
	    if (current.right != null) {
		queue.enqueue(current.right);
	    }
	}
    }

    public static void main(String[] args) {
	
	Node n1 = new Node(5, null, null);
	Node n2 = new Node(7, null, null);
	Node n3 = new Node(6, n1, n2);

	Node n4 = new Node(9, null, null);
	Node n5 = new Node(11, null, null);
	Node n6 = new Node(10, n4,n5);
	Node n7 = new Node(8, n3, n6);

	printInLevel(n7);
    }

}
