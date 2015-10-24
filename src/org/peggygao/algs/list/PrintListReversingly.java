package org.peggygao.algs.list;

public class PrintListReversingly {

    private static class Node {
	int value;
	Node next;

	public Node(int value, Node next) {
	    this.value = value;
	    this.next = next;
	}
    }

    private static void printRecursive(Node node) {
	if (node == null) {
	    return;
	}

	printRecursive(node.next);
	System.out.print(node.value + "\t");
    }

    public static void main(String[] args) {

	Node n5 = new Node(5, null);
	Node n4 = new Node(4, n5);
	Node n3 = new Node(3, n4);
	printRecursive(n3);

    }

}
