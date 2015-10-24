package org.peggygao.algs.list;

public class FindMidInList {

    private static class Node {
	int value;
	Node next;

	public Node(int value, Node next) {
	    this.value = value;
	    this.next = next;
	}
    }

    private static Node findMid(Node head) {

	if (head == null) {
	    return null;
	}
	Node one = head;
	Node two = head;

	while (two.next != null && two.next.next != null) {

	    one = one.next;
	    two = two.next.next;
	}
	return one;

    }

    public static void main(String[] args) {
	Node n1 = new Node(1, null);
	Node n2 = new Node(2, n1);
	Node n3 = new Node(3, n2);
	Node n4 = new Node(4, n3);
	Node n5 = new Node(5, n4);
	Node result = findMid(n5);
	System.out.println(result.value);

    }

}
