package org.peggygao.algs.list;

public class ReverseLastHalf {

    public static class Node {
	int val;
	Node next;

	public Node(int val, Node next) {
	    this.val = val;
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
	Node nn = next.next;

	current.next = null;
	next.next = current;

	current = next;
	next = nn;
	while (next != null) {
	    nn = next.next;
	    next.next = current;
	    current = next;
	    next = nn;
	}

	return current;

    }

    private static Node merge(Node head) {

	int length = 0;
	Node n = head;
	while (n != null) {
	    n = n.next;
	    length++;
	}

	int half = length / 2;
	if ((length & 1) == 1) {
	    half++;
	}

	Node second = head;
	while (half > 1) {
	    second = second.next;
	    half--;

	}

	Node last = second.next;
	second.next = null;

	last = reverse(last);

	Node first = head;
	while (last != null) {
	    Node fn = first.next;
	    Node sn = last.next;
	    first.next = last;
	    last.next = fn;
	    first = fn;
	    last = sn;

	}

	return head;

    }

    public static void print(Node n) {
	while (n != null) {
	    System.out.print(n.val + "  ");
	    n = n.next;
	}
	System.out.println();
    }

    public static void main(String[] args) {
	Node n8 = new Node(8, null);
	Node n7 = new Node(7, n8);
	Node n6 = new Node(6, n7);
	Node n5 = new Node(5, n6);
	Node n4 = new Node(4, n5);
	Node n3 = new Node(3, n4);
	Node n2 = new Node(2, n3);
	Node n1 = new Node(1, n2);

	print(n1);
	Node r = merge(n1);
	print(r);

    }
}
