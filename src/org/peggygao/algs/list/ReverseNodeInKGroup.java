package org.peggygao.algs.list;

import java.util.Stack;

public class ReverseNodeInKGroup {

    public static class ListNode {

	int val;
	ListNode next;

	ListNode(int x, ListNode n) {
	    this.val = x;
	    this.next = n;
	}
    }

    public static ListNode reverseKGroup(ListNode head, int k) {

	if (head == null) {
	    return null;
	}

	int count = 0;
	ListNode m = head;
	while (m != null) {
	    count++;
	    m = m.next;
	}

	if (count < k) {
	    return head;
	}
	ListNode[] list = new ListNode[k];
	ListNode[] p = new ListNode[k];
	int i = 0;
	ListNode n = head;
	while (n != null) {
	    ListNode temp = n;
	    n = n.next;
	    temp.next = null;
	    if (list[i % k] == null) {
		list[i % k] = temp;
		p[i % k] = temp;
	    } else {
		p[i % k].next = temp;
		p[i % k] = temp;
	    }

	    i++;
	}

	if (i < k) {
	    return head;
	}

	for (int j = 0; j < k; j++) {
	    p[j] = list[j];
	}

	ListNode cur = null;
	boolean flag = false;
	while (i > 0 && !flag) {

	    for (int j = k - 1; j >= 0; j--) {
		if (p[j] != null) {
		    ListNode temp = p[j];
		    if (cur == null)
			cur = temp;
		    else {
			cur.next = temp;
			cur = cur.next;
		    }

		    p[j] = p[j].next;
		    i--;
		} else {
		    flag = true;
		    break;
		}
	    }
	}

	for (int j = 0; j < k; j++) {
	    if (p[j] != null) {
		ListNode temp = p[j];
		cur.next = temp;
		cur = cur.next;
	    } else {
		break;
	    }
	}

	int j = k - 1;
	while (j >= 0) {
	    if (list[j] == null) {
		j--;
	    } else {
		break;
	    }
	}

	return list[j];

    }

    public static ListNode reverse(ListNode head, int k) {

	if (head == null || k < 1) {
	    return head;
	}

	Stack<ListNode> stack = new Stack<ListNode>();

	ListNode top = null;
	ListNode curr = head;
	ListNode temp = null;

	while (curr != null) {

	    for (int i = 0; i < k; i++) {
		if (curr == null) {
		    if (top == null) {
			return head;
		    } else {
			return top;
		    }

		}
		stack.push(curr);
		curr = curr.next;
	    }

	    while (!stack.isEmpty()) {
		ListNode n = stack.pop();
		if (top == null) {
		    top = n;
		    temp = top;
		} else {
		    temp.next = n;
		    temp = n;
		}

	    }

	    temp.next = curr;

	}

	return top;
    }

    public static void print(ListNode n) {
	while (n != null) {
	    System.out.print(n.val + "  ");
	    n = n.next;
	}
	System.out.println();
    }

    public static void main(String[] args) {

	ListNode n7 = new ListNode(7, null);
	ListNode n6 = new ListNode(6, n7);
	ListNode n5 = new ListNode(5, null);
	ListNode n4 = new ListNode(4, n5);
	ListNode n3 = new ListNode(3, n4);
	ListNode n2 = new ListNode(2, n3);
	ListNode n1 = new ListNode(1, n2);

	print(n1);
	ListNode h = reverseKGroup(n1, 3);
	print(h);
    }
}
