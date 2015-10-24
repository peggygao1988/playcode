package org.peggygao.algs.list;

public class ReverseList {
    private static class Node {
	int value;
	Node next;

	public Node(int value, Node next) {
	    this.value = value;
	    this.next = next;
	}
    }

    private static Node reverse(Node head) {

	if (head == null) {
	    return null;
	}
	if (head.next == null) {
	    return head;
	}
	Node current = head;
	Node next = current.next;
	current.next = null;
	while (next != null) {

	    Node nn = next.next;
	    next.next = current;
	    current = next;
	    next = nn;
	}

	return current;
    }

    private static Node reverseHead = null;

    private static Node recursive(Node current) {

	if (current.next == null) {
	    reverseHead = current;
	    return current;
	}

	Node first = recursive(current.next);
	first.next = current;
	current.next = null;

	return current;

    }

    private static void recursiceReverse(Node head) {
	if (head == null) {
	    reverseHead = null;
	} else if (head.next == null) {
	    reverseHead = head;
	} else {
	    recursive(head);
	}

    }

    public static void main(String[] args) {
	Node n1 = new Node(1, null);
	Node n2 = new Node(2, n1);
	Node n3 = new Node(3, n2);
	Node n4 = new Node(4, n3);
	Node n5 = new Node(5, n4);
	recursiceReverse(n2);
	for (Node n = reverseHead; n != null; n = n.next)
	    System.out.println(n.value);
    }

}
