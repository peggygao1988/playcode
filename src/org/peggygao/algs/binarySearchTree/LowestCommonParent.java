package org.peggygao.algs.binarySearchTree;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LowestCommonParent {

    private static class BST {
	int value;
	BST left;
	BST right;

	public BST(int value, BST left, BST right) {
	    super();
	    this.value = value;
	    this.left = left;
	    this.right = right;
	}

    }

    private static class Node1 {
	char value;
	Node1 left;
	Node1 right;
	Node1 parent;

	public Node1(char value, Node1 left, Node1 right, Node1 parent) {
	    super();
	    this.value = value;
	    this.left = left;
	    this.right = right;
	    this.parent = parent;
	}

    }

    private static class Node2 {

	char value;
	List<Node2> children;

	public Node2(char value, List<Node2> children) {
	    this.value = value;
	    this.children = children;
	}
    }

    private static boolean findInSubTree(Node2 root, Node2 n) {

	if (root == n)
	    return true;

	if (root.children != null) {
	    for (Node2 s : root.children) {
		boolean found = findInSubTree(s, n);
		if (found) {
		    return true;
		}
	    }

	}

	return false;

    }

    private static Node2 lca(Node2 root, Node2 n1, Node2 n2) {

	if (root == null || n1 == null || n2 == null) {
	    return null;
	}

	boolean rootFound = findInSubTree(root, n1) && findInSubTree(root, n2);
	if (!rootFound) {
	    return null;
	}

	boolean childFound = false;
	boolean childFound1 = false;
	boolean childFound2 = false;
	for (Node2 child : root.children) {

	    childFound1 = findInSubTree(child, n1);
	    childFound2 = findInSubTree(child, n2);
	    if (childFound1 && childFound2) {
		childFound = true;
		break;
	    }

	}

	if (childFound == false) {
	    return root;
	} else if (root.children != null) {
	    for (Node2 child : root.children) {

		Node2 result = lca(child, n1, n2);
		if (result != null)
		    return result;
	    }
	}

	return null;

    }

    private static int getListLength(Node1 n) {

	int count = 0;
	while (n != null) {
	    count++;
	    n = n.parent;
	}

	return count;
    }

    private static Node1 lca(Node1 root, Node1 n1, Node1 n2) {

	if (root == null || n1 == null || n2 == null) {
	    return null;
	}

	int length1 = getListLength(n1);
	int length2 = getListLength(n2);

	int dif = length1 - length2;
	Node1 longNode = n1;
	Node1 shortNode = n2;
	if (dif < 0) {
	    longNode = n2;
	    shortNode = n1;
	    dif = 0 - dif;
	}

	for (int i = 0; i < dif; i++) {
	    longNode = longNode.parent;
	}

	while (longNode != shortNode) {
	    longNode = longNode.parent;
	    shortNode = shortNode.parent;
	}
	return longNode;

    }

    private static BST lca(BST root, BST n1, BST n2) {

	if (root == null || n1 == null || n2 == null) {
	    return null;
	}

	if (root.value > n1.value && root.value > n2.value) {
	    return lca(root.left, n1, n2);
	} else if (root.value < n1.value && root.value < n2.value) {
	    return lca(root.right, n1, n2);
	} else {
	    return root;
	}

    }

    private static boolean getPath(Node1 root, Node1 n, List<Node1> path) {

	if (root == n) {
	    return true;
	}

	path.add(root);

	boolean result = false;
	if (root.left != null)
	    result = getPath(root.left, n, path);
	if (result) {
	    return true;
	}

	if (root.right != null)
	    result = getPath(root.right, n, path);
	if (result) {
	    return true;
	}

	path.remove(root);
	return false;

    }

    private static Node1 getLastCommonParent(List<Node1> path1,
	    List<Node1> path2) {
	Node1 common = null;

	for (int i = 0; i < path1.size() && i < path2.size(); i++) {
	    if (path1.get(i) == path2.get(i)) {
		common = path1.get(i);
	    }
	}
	return common;
    }

    private static Node1 lcaa(Node1 root, Node1 n1, Node1 n2) {

	List<Node1> path1 = new LinkedList<Node1>();
	List<Node1> path2 = new LinkedList<Node1>();

	getPath(root, n1, path1);
	getPath(root, n2, path2);

	Node1 common = getLastCommonParent(path1, path2);

	return common;
    }

    public static void main(String[] args) {

	// BST n1 = new BST(1, null, null);
	// BST n3 = new BST(3, null, null);
	// BST n2 = new BST(2, n1, n3);
	//
	// BST n5 = new BST(5, null, null);
	// BST n6 = new BST(6, n5, null);
	//
	// BST n4 = new BST(4, n2, n6);
	//
	// System.out.println(lca(n4, n1, n4).value);
	// Node1 a = new Node1('a', null, null, null);
	// Node1 b = new Node1('b', null, null, a);
	// Node1 c = new Node1('c', null, null, a);
	//
	// Node1 d = new Node1('d', null, null, b);
	// Node1 e = new Node1('e', null, null, b);
	//
	// Node1 f = new Node1('f', null, null, d);
	// Node1 g = new Node1('g', null, null, d);
	//
	// Node1 h = new Node1('h', null, null, e);
	// Node1 i = new Node1('i', null, null, e);
	// Node1 j = new Node1('j', null, null, e);
	//
	// System.out.println(lca(a, f, c).value);

	// Node2 f = new Node2('f', null);
	// Node2 g = new Node2('g', null);
	// Node2 d = new Node2('d', Arrays.asList(f, g));
	//
	// Node2 h = new Node2('h', null);
	// Node2 i = new Node2('i', null);
	// Node2 j = new Node2('j', null);
	// Node2 e = new Node2('e', Arrays.asList(h, i, j));
	//
	// Node2 b = new Node2('b', Arrays.asList(d, e));
	// Node2 c = new Node2('c', null);
	//
	// Node2 a = new Node2('a', Arrays.asList(b, c));
	//
	// System.out.println(lca(b, f, e).value);

	Node1 f = new Node1('f', null, null, null);
	Node1 g = new Node1('g', null, null, null);

	Node1 d = new Node1('d', f, g, null);

	Node1 h = new Node1('h', null, null, null);
	Node1 i = new Node1('i', null, null, null);
	// Node1 j = new Node1('j', null, null, e);
	Node1 e = new Node1('e', h, i, null);

	Node1 b = new Node1('b', d, e, null);

	Node1 c = new Node1('c', null, null, null);

	Node1 a = new Node1('a', b, c, null);
	System.out.println(lcaa(a, f, c).value);
    }
}
