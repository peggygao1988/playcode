package org.peggygao.algs.list;

public class LinkedList<Item> {

    private Node first;

    private class Node {
	Item item;
	Node next;

    }

    public LinkedList(Node n) {
	first = n;
    }

    public void deleteLastNode() {
	if (first.next == null) {
	    first = null;
	} else {
	    Node current = first;
	    while (current.next.next != null) {
		current = current.next;
	    }
	    current.next = null;
	}
    }

    public void deleteK(int k) {

	if (k == 1) {
	    first = first.next;
	} else {
	    int i = 2;
	    Node previous = first;
	    Node current = first.next;
	    while (current != null) {
		if (i == k) {
		    previous.next = current.next;
		} else {
		    previous = current;
		    current = current.next;
		    ++i;
		}
	    }
	}
    }

    public static void main(String[] args) {

    }
}
