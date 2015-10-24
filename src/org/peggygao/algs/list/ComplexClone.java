package org.peggygao.algs.list;

import java.sql.NClob;

public class ComplexClone {

    private static class Node {
	int value;
	Node next;
	Node sibling;

	public Node(int value, Node next, Node sibling) {
	    super();
	    this.value = value;
	    this.next = next;
	    this.sibling = sibling;
	}

    }

    private static void cloneNodes(Node head) {

	Node current = head;
	while (current != null) {
	    Node clone = new Node(current.value, current.next, null);
	    current.next = clone;
	    current = clone.next;
	}
    }

    private static void cloneSibling(Node head) {
	Node first = head;

	while (first != null) {
	    Node second = first.next;
	    if (first.sibling != null)
		second.sibling = first.sibling.next;
	    first = second.next;
	}

    }

    private static Node connect(Node head) {

	if (head == null) {
	    return null;
	}
	Node first = head;
	Node cloneHead = head.next;
	Node clone = cloneHead;
	first.next = clone.next;
	first = first.next;

	while (first != null) {
	    clone.next = first.next;
	    clone = clone.next;
	    first.next = clone.next;
	    first = first.next;
	}
	return cloneHead;
    }

    private static Node complexClone(Node head) {
	cloneNodes(head);
	cloneSibling(head);
	return connect(head);
    }

    public static void main(String[] args) {

	Node n5 = new Node(5, null, null);
	Node n4 = new Node(4, n5, null);
	Node n3 = new Node(3, n4, null);
	Node n2 = new Node(2, n3, null);
	Node n1 = new Node(1, n2, null);

	n1.sibling = n3;
	n2.sibling = n5;
	n4.sibling = n2;

	Node result = complexClone(n1);
	System.out.println(result.sibling.value);
    }

}
