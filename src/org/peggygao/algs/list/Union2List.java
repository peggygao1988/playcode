package org.peggygao.algs.list;

public class Union2List {

    private static class Node {
	int value;
	Node next;

	public Node(int value, Node next) {
	    this.value = value;
	    this.next = next;
	}
    }

    private static Node union(Node n1, Node n2) {

	if (n1 == null) {
	    return n2;
	}
	if (n2 == null) {
	    return n1;
	}

	Node head = null;

	if (n1.value < n2.value) {
	    head = n1;
	    head.next = union(n1.next, n2);
	} else if (n1.value > n2.value) {
	    head = n2;
	    head.next = union(n1, n2.next);
	} else {
	    head = n1;
	    head.next = union(n1.next, n2.next);
	}

	return head;
    }

    public static void main(String[] args) {
	// Node n1 = new Node(9, null);
	Node n2 = new Node(7, null);
	Node n3 = new Node(3, n2);
	Node n4 = new Node(2, n3);
	Node n5 = new Node(1, n4);

	// Node n6 = new Node(10, null);
	Node n7 = new Node(5, null);
	Node n8 = new Node(4, n7);
	Node n9 = new Node(3, n8);
	Node n10 = new Node(2, n9);

	Node head = union(n5, n10);

	for (Node i = head; i != null; i = i.next) {
	    System.out.print(i.value + "\t");
	}
	System.out.println();
    }

}
