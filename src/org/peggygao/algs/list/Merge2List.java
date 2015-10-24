package org.peggygao.algs.list;

public class Merge2List {

    private static class Node {
	int value;
	Node next;

	public Node(int value, Node next) {
	    this.value = value;
	    this.next = next;
	}
    }

    private static Node merge(Node n1, Node n2) {

	if (n1 == null) {
	    return n2;
	} else if (n2 == null) {
	    return n1;
	}

	Node mergeNode = null;
	if (n1.value < n2.value) {
	    mergeNode = n1;
	    mergeNode.next = merge(n1.next, n2);
	} else {
	    mergeNode = n2;
	    mergeNode.next = merge(n1, n2.next);
	}

	return mergeNode;

    }

    private static Node merge2(Node n1, Node n2) {

	Node head = null;
	Node result = null;
	if (n1 == null) {
	    return n2;
	} else if (n2 == null) {
	    return n1;
	}

	while (true) {

	    if (n1 == null) {
		if (head == null) {
		    head = n2;
		    result = head;
		} else
		    head.next = n2;
		break;
	    } else if (n2 == null) {
		if (head == null) {
		    head = n1;
		    result = head;
		} else
		    head.next = n1;
		break;
	    } else if (n1.value < n2.value) {

		if (head == null) {
		    head = n1;
		    result = head;
		} else {
		    head.next = n1;
		    head = head.next;
		}
		n1 = n1.next;
	    } else {
		if (head == null) {
		    head = n2;
		    result = head;
		} else {
		    head.next = n2;
		    head = head.next;
		}
		n2 = n2.next;
	    }
	}

	return result;

    }

    public static void main(String[] args) {

	Node n1 = new Node(9, null);
	Node n2 = new Node(7, n1);
	Node n3 = new Node(5, n2);
	Node n4 = new Node(3, n3);
	Node n5 = new Node(1, n4);

	Node n6 = new Node(10, null);
	Node n7 = new Node(8, n6);
	Node n8 = new Node(6, n7);
	Node n9 = new Node(4, n8);
	Node n10 = new Node(2, n9);

	Node result = merge(n5, n10);
	for (Node n = result; n != null; n = n.next)
	    System.out.println(n.value);

	for (Node n = n10; n != null; n = n.next) {
	    System.out.print(n.value);
	}

    }

}
