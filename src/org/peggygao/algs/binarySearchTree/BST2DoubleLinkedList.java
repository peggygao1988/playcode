package org.peggygao.algs.binarySearchTree;

import org.peggygao.algs.search.BST;
import org.peggygao.algs.search.BST.Node;

public class BST2DoubleLinkedList {

    public static Node convert(Node currentNode, Node lastNode) {

	if (currentNode.left != null) {
	    lastNode = convert(currentNode.left, lastNode);
	}

	currentNode.left = lastNode;
	if (lastNode != null) {
	    lastNode.right = currentNode;
	}

	lastNode = currentNode;

	if (currentNode.right != null) {
	    lastNode = convert(currentNode.right, lastNode);
	}
	return lastNode;
    }

    public static Node convert2(Node current, boolean asRight) {
	if (current == null) {
	    return null;
	}

	Node leftLast = null;
	if (current.left != null) {
	    leftLast = convert2(current.left, false);
	}

	Node rightLast = null;
	if (current.right != null) {
	    rightLast = convert2(current.right, true);
	}

	if (leftLast != null) {
	    leftLast.right = current;
	    current.left = leftLast;
	}
	if (rightLast != null) {
	    rightLast.left = current;
	    current.right = rightLast;
	}

	Node temp = current;
	if (!asRight) {

	    while (temp.right != null) {
		temp = temp.right;
	    }
	} else {
	    while (temp.left != null) {
		temp = temp.left;
	    }
	}

	return temp;
    }

    public static void main(String[] args) {
	BST<Integer, Integer> tree = new BST<Integer, Integer>();

	tree.put(10, 10);
	tree.put(6, 6);
	tree.put(14, 14);
	tree.put(4, 4);
	tree.put(8, 8);

	tree.put(12, 12);
	tree.put(16, 16);
	tree.printLevel(tree.root);

	System.out.println();
	// Node result = convert(tree.root, null);
	Node result = convert2(tree.root, true);
	for (Node x = result; x != null; x = x.right) {
	    System.out.println(x.key);
	}
    }
}
