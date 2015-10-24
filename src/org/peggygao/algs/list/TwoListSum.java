package org.peggygao.algs.list;

public class TwoListSum {

    private static class Node {
	int value;
	Node next;

	public Node(int value, Node next) {
	    super();
	    this.value = value;
	    this.next = next;
	}

    }

    private static Node add(Node n1, Node n2) {

	Node a1 = n1;
	Node a2 = n2;

	Node prev = null;
	Node current = null;

	while (a1 != null && a2 != null) {

	    int sum = a1.value + a2.value;
//	    if (sum > 9) {
//	    }
	    current = new Node(sum, prev);
	    prev = current;
	    a1 = a1.next;
	    a2 = a2.next;
	}

	return current;
    }

    private static Node reverseAndCarry(Node result) {

	if (result == null) {
	    return null;
	}
	if (result.next == null) {
	    return result;
	}

	int carry = 0;
	Node current = result;
	if (current.value > 9) {
	    current.value -= 10;
	    carry = 1;
	}
	Node next = current.next;
	current.next = null;

	while (next != null) {

	    Node nn = next.next;
	    next.next = current;
	    next.value += carry;
	    if (next.value > 9) {
		next.value -= 10;
		carry = 1;
	    }
	    current = next;
	    next = nn;
	}

	if (carry != 0) {
	    Node head = new Node(1, current);
	    current = head;
	}

	return current;
    }

    private static void print(Node node) {
	Node n = node;
	while (n != null) {
	    System.out.print(n.value + "\t");
	    n = n.next;
	}
	System.out.println();
    }

    public static void main(String[] args) {

	Node n6 = new Node(6, null);
	Node n7 = new Node(7, n6);
	Node n5 = new Node(5, n7);
	Node n4 = new Node(4, n5);

	Node n1 = new Node(1, null);
	Node n4_1 = new Node(4, n1);
	Node n6_1 = new Node(6, n4_1);
	Node n9 = new Node(9, n6_1);

	Node midResult = add(n4, n9);
	print(midResult);

	Node finalResult = reverseAndCarry(midResult);
	print(finalResult);
    }
}
