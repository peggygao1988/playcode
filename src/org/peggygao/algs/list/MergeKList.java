package org.peggygao.algs.list;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKList {

    public static class Node {
	int val;
	Node next;

	public Node(int val, Node next) {
	    this.val = val;
	    this.next = next;
	}

    }

    public static Node mergeKList(ArrayList<Node> list) {

	Comparator<Node> cmp = new Comparator<Node>() {

	    @Override
	    public int compare(Node o1, Node o2) {
		if (o1.val < o2.val) {
		    return -1;
		} else if (o1.val > o2.val) {
		    return 1;
		} else {
		    return 0;
		}
	    }

	};

	PriorityQueue<Node> pq = new PriorityQueue<Node>(list.size(), cmp);

	for (int i = 0; i < list.size(); i++) {
	    Node n = list.get(i);
	    if (n != null) {
		pq.add(n);
	    }
	}

	Node head = null;
	Node cur = null;

	while (!pq.isEmpty()) {

	    Node n = pq.poll();
	    if (head == null) {
		head = n;
		cur = head;
		if (cur.next != null) {
		    pq.add(cur.next);
		}
	    } else {
		cur.next = n;
		cur = n;
		if (n.next != null) {
		    pq.add(n.next);
		}

	    }
	}

	return head;
    }

    public static void main(String[] args) {

    }

}
