package org.peggygao.algs.binarySearchTree;

public class ConstructTreeFromPreIn {

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

    private static Node construct(int[] pre, int[] in, int preStart,
	    int preEnd, int inStart, int inEnd) {

	if (preStart == preEnd && inEnd == inStart) {
	    return new Node(pre[preStart], null, null);
	}

	int root = pre[preStart];
	int rootIndex = -1;
	for (int i = inStart; i <= inEnd; i++) {
	    if (in[i] == root) {
		rootIndex = i;
		break;
	    }
	}

	Node newRoot = new Node(root, null, null);

	int leftLength = 0;
	int rightLength = 0;

	if (rootIndex > inStart) {
	    leftLength = rootIndex - inStart;
	    newRoot.left = construct(pre, in, preStart + 1, preStart
		    + leftLength, inStart, rootIndex - 1);
	}

	if (rootIndex < inEnd) {

	    rightLength = inEnd - rootIndex;
	    newRoot.right = construct(pre, in, preStart + leftLength + 1,
		    preStart + leftLength + rightLength, rootIndex + 1, inEnd);

	}

	return newRoot;
    }

    private static void inPrint(Node root) {
	if (root == null) {
	    return;
	}
	inPrint(root.left);
	System.out.print(root.value + "\t");
	inPrint(root.right);
    }

    public static void main(String[] args) {

	int[] pre = { 1 };
	int[] in = { 1 };
	Node root = construct(pre, in, 0, pre.length - 1, 0, in.length - 1);
	inPrint(root);

    }
}
