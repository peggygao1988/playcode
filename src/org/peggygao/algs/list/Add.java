package org.peggygao.algs.list;

public class Add {

    static class Node {
	int value;
	Node next;

	public Node(int value, Node next) {
	    this.value = value;
	    this.next = next;
	}
    }

    private static Node append(Node result, int num) {

	if (result == null) {
	    result = new Node(num, null);
	} else {
	    Node n = result;
	    while (n.next != null) {
		n = n.next;
	    }
	    n.next = new Node(num, null);
	}
	return result;

    }

    private static Node add(Node a1, Node a2) {
	if (a1 == null) {
	    return a2;
	} else if (a2 == null) {
	    return a1;
	}

	Node result = null;
	int carry = 0;

	while (a1 != null && a2 != null) {
	    int sum = a1.value + a2.value + carry;

	    if (sum > 9) {
		sum -= 10;
		carry = 1;
	    } else {
		carry = 0;
	    }

	    result = append(result, sum);

	    a1 = a1.next;
	    a2 = a2.next;
	}

	while (a1 != null) {

	    int sum = a1.value + carry;
	    if (sum > 9) {
		sum -= 10;
		carry = 1;
	    } else {
		carry = 0;
	    }
	    result = append(result, sum);
	    a1 = a1.next;
	}
	while (a2 != null) {
	    int sum = a2.value + carry;
	    if (sum > 9) {
		sum -= 10;
		carry = 1;
	    } else {
		carry = 0;
	    }
	    result = append(result, sum);
	    a2 = a2.next;
	}

	if (carry != 0) {
	    result = append(result, carry);
	}
	return result;
    }

    public static void main(String[] args) {
	Node n1 = new Node(9, null);
	Node n2 = new Node(9, n1);
	Node n3 = new Node(9, null);

	Node n4 = new Node(9, n3);
	Node n5 = new Node(9, n4);
	Node n6 = new Node(9, n5);

	Node result = add(n6, n2);

	while (result != null) {
	    System.out.print(result.value + " ");
	    result = result.next;
	}

	System.out.println();

    }
}
