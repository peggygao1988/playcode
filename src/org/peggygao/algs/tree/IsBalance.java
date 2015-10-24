package org.peggygao.algs.tree;

public class IsBalance {

    private static int leftHeight;
    private static int rightHeight;
    private static boolean left = true;
    private static boolean right = true;

    public static class Node {
	int value;
	Node left;
	Node right;

	public Node(int value, Node left, Node right) {
	    this.value = value;
	    this.left = left;
	    this.right = right;
	}
    }

    public static boolean isBalanced(Node node, boolean asRight) {
	if (node == null) {
	    if (asRight)
		rightHeight = 0;
	    else
		leftHeight = 0;
	    return true;
	}

	left = isBalanced(node.left, false);

	int ll = leftHeight;
	right = isBalanced(node.right, true);
	int rr = rightHeight;
	if (left && right) {

	    if (ll - rr > 1 || rr - ll > 1) {
		return false;
	    }

	    if (asRight)
		rightHeight = 1 + (ll > rr ? ll : rr);
	    else
		leftHeight = 1 + (ll > rr ? ll : rr);

	    return true;
	}
	return false;

    }

    public static void main(String[] args) {
	Node n7 = new Node(7, null, null);
	Node n5 = new Node(5, n7, null);
	Node n4 = new Node(4, null, null);
	Node n2 = new Node(2, n4, n5);
	// Node n6 = new Node(6,null,null);
	Node n3 = new Node(3, null, null);
	Node n1 = new Node(1, n2, n3);
	boolean result = isBalanced(n1, true);

	if (result) {
	    System.out.println("this tree is balanced");
	} else {
	    System.out.println("this tree is not balanced");
	}
    }

}
