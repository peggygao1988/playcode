package org.peggygao.algs.binarySearchTree;

public class TreeHeight {

    private static int leftDepth = 0;
    private static int rightDept = 0;

    private static class Node {
	int value;
	Node left;
	Node right;

	public Node(int value, Node left, Node right) {
	    super();
	    this.value = value;
	    this.left = left;
	    this.right = right;
	}

    }

    private static int height(Node root) {

	if (root == null) {
	    return 0;
	}

	int left = height(root.left);
	int right = height(root.right);

	return Math.max(left, right) + 1;

    }

    private static boolean isBalance(Node root, boolean asRight) {

	if (root == null) {
	    if (asRight)
		rightDept = 0;
	    else
		leftDepth = 0;
	    return true;
	}

	boolean left = isBalance(root.left, false);

	if (left == false) {
	    return false;
	}

	int ll = leftDepth;
	boolean right = isBalance(root.right, true);
	if (right == false) {
	    return false;
	}
	int rr = rightDept;

	int dif = ll - rr;
	if (dif > 1 || dif < -1) {
	    return false;
	}

	if (asRight) {
	    rightDept = Math.max(ll, rr) + 1;
	    return true;
	} else {
	    leftDepth = Math.max(ll, rr) + 1;
	    return true;
	}
    }

    public static void main(String[] args) {
	Node n7 = new Node(7, null, null);
	Node n6 = new Node(6, null, null);
	Node n5 = new Node(5, n7, null);
	Node n4 = new Node(4, null, null);
	Node n2 = new Node(2, n4, n5);
	Node n3 = new Node(3, null, n6);
	Node n1 = new Node(1, n2, n3);
	System.out.println(isBalance(n7, false));

    }

}
