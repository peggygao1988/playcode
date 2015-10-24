package org.peggygao.algs.list;

import java.util.HashMap;

public class RemoveDup {

    static class Node {
	int vaule;
	Node next;

	public Node(int vaule, Node next) {
	    this.vaule = vaule;
	    this.next = next;
	}
    }

    private static void removeDup(Node head) {
	if (head == null || head.next == null) {
	    return;
	}

	HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
	map.put(head.vaule, true);
	Node prev = head;
	Node current = head.next;
	while (current != null) {

	    if (map.containsKey(current.vaule)) {
		prev.next = current.next;
		current = current.next;

	    } else {
		map.put(current.vaule, true);
		prev = current;
		current = current.next;
	    }
	}

    }

    private static void removeDup2(Node head) {
	if (head == null || head.next == null) {
	    return;
	}

	Node current = head;
	Node succ = null;
	Node prev = null;

	while (current != null) {
	    succ = current.next;
	    prev = current;
	    while (succ != null) {

		if (succ.vaule == current.vaule) {
		    prev.next = succ.next;
		    succ = succ.next;
		}else{

		prev = succ;
		succ = succ.next;
		}
	    }
	    current = current.next;
	}
    }

    public static void main(String[] args) {

	Node n1 = new Node(2, null);
	Node n2 = new Node(5, n1);
	Node n3 = new Node(1, n2);
	Node n4 = new Node(4, n3);
	Node n5 = new Node(5, n4);
	Node n6 = new Node(2, n5);
	Node n7 = new Node(5, n6);
	Node n8 = new Node(1, n7);
	Node head = n8;
	while (head != null) {
	    System.out.print(head.vaule);
	    head = head.next;
	}
	System.out.println();
	removeDup(n8);
	head = n8;
	while (head != null) {
	    System.out.print(head.vaule);
	    head = head.next;
	}
    }
}
