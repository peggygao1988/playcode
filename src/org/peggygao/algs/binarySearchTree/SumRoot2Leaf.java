package org.peggygao.algs.binarySearchTree;

public class SumRoot2Leaf {

    static class Node {
	int val;
	Node left;
	Node right;

	public Node(int val, Node left, Node right) {
	    super();
	    this.val = val;
	    this.left = left;
	    this.right = right;
	}

    }

    private static int sum = 0;

    public static int sumNumbers(Node root) {

	if (root == null) {
	    return 0;
	}

	dfs(root, 0);
	return sum;

    }

    private static void dfs(Node root, int curr) {

	curr = curr * 10 + root.val;

	if (root.left == null && root.right == null) {
	    sum += curr;
	}

	if (root.left != null) {
	    dfs(root.left, curr);
	}

	if (root.right != null) {
	    dfs(root.right, curr);
	}
    }

    public static void main(String[] args) {
	Node n1 = new Node(1, null, null);
	Node n2 = new Node(0, n1, null);
	System.out.println(sumNumbers(n2));

    }

}
