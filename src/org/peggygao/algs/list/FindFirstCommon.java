package org.peggygao.algs.list;

public class FindFirstCommon {

    private static class Node {
	int value;
	Node next;

	public Node(int value, Node next) {
	    super();
	    this.value = value;
	    this.next = next;
	}

    }

    private static int getLength(Node head) {

	int count = 0;
	Node index = head;
	while (index != null) {
	    count++;
	    index = index.next;
	}

	return count;

    }

    private static Node findFirstCommon(Node n1, Node n2) {
	int length1 = getLength(n1);
	int length2 = getLength(n2);

	int dif = length1 - length2;
	Node longList;
	Node shortList;
	if (dif > 0) {
	    longList = n1;
	    shortList = n2;
	} else {
	    longList = n2;
	    shortList = n1;
	}

	while (dif > 0) {
	    longList = longList.next;
	    dif--;
	}

	while (longList != null && shortList != null) {
	    if (longList == shortList) {
		return shortList;
	    }

	    longList = longList.next;
	    shortList = shortList.next;

	}

	return null;
    }

    public static void main(String[] args) {
	Node n7 = new Node(7, null);
	Node n6 = new Node(6, null);
	Node n3 = new Node(3, n6);
	Node n2 = new Node(2, n3);
	Node n1 = new Node(1, n2);

	Node n5 = new Node(5, n6);
	Node n4 = new Node(4, n5);

	Node result = findFirstCommon(n1, n2);
	System.out.println(result.value);

    }

}
