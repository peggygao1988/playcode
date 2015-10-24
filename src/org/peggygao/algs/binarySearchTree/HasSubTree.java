package org.peggygao.algs.binarySearchTree;

public class HasSubTree {

    private static class Node {
	int value;
	Node left;
	Node right;

	public Node(int value, Node left, Node right) {
	    this.value = value;
	    this.left = left;
	    this.right = right;
	}
    }

    private static int count = 0;

    private static boolean hasSubTree(Node root1, Node root2) {

	boolean result = false;

	if (root1 != null && root2 != null) {
	    if (root1.value == root2.value) {
		result = isEqual(root1, root2);
	    }
	    if (result)
		count++;
	    result = false;
	    if (!result) {
		result = hasSubTree(root1.left, root2);
	    }
	    if (result)
		count++;
	    result = false;
	    if (!result) {
		result = hasSubTree(root1.right, root2);
	    }
	    if (result)
		count++;
	    // result = false;
	}

	return result;

    }

    private static boolean isEqual(Node root1, Node root2) {

	if (root2 == null) {
	    return true;
	}
	if (root1 == null) {
	    return false;
	}

	if (root1.value != root2.value) {
	    return false;
	}

	return isEqual(root1.left, root2.left)
		&& isEqual(root1.right, root2.right);

    }

    public static void main(String[] args) {
	Node n1 = new Node(9, null, null);
	Node n2 = new Node(2, null, null);
	Node n3 = new Node(8, n1, n2);

	Node n9 = new Node(9, null, null);
	Node n10 = new Node(2, null, null);
	Node n11 = new Node(8, n9, n10);

	Node n4 = new Node(9, null, null);
	Node n5 = new Node(2, null, null);
	Node n6 = new Node(8, n4, n5);
	Node n7 = new Node(7, null, n11);
	Node n8 = new Node(8, n6, n7);

	System.out.println(hasSubTree(n8, n3));
	System.out.println(count);

    }

}
