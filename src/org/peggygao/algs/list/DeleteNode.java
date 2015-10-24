package org.peggygao.algs.list;

public class DeleteNode {

    private static class Node {
	int value;
	Node next;

	public Node(int value, Node next) {
	    this.value = value;
	    this.next = next;
	}
    }

    private static Node deleteNode(Node head, Node toBeDelete) {

	if (head == null || toBeDelete == null) {
	    return null;
	}

	if (toBeDelete.next != null) {

	    Node next = toBeDelete.next;
	    toBeDelete.value = next.value;
	    toBeDelete.next = next.next;

	    next = null;
	    return head;
	} else if (head == toBeDelete) {

	    head = null;
	    toBeDelete = null;
	    return head;

	} else {

	    Node pre = head;
	    while (pre.next != toBeDelete) {
		pre = pre.next;
	    }

	    pre.next = null;
	    toBeDelete = null;

	    return head;

	}
    }
    
    private static void print(Node head){
	while(head!=null){
	    System.out.print(head.value+"\t");
	    head = head.next;
	}
	System.out.println();
    }

    public static void main(String[] args) {
	Node n1 = new Node(1, null);
	Node n2 = new Node(2, n1);
	Node n3 = new Node(3,n2);
	print(n3);
	n3 = deleteNode(n3, n1);
	print(n3);
    }

}
