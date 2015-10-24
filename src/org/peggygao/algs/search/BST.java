package org.peggygao.algs.search;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import org.peggygao.algs.collections.Queue;

public class BST<Key extends Comparable<Key>, Value> {

    public Node root;

    public class Node {
	public Key key;
	public Value value;
	public Node left, right;
	public int N;

	public Node(Key key, Value value, int N) {
	    this.key = key;
	    this.value = value;
	    this.N = N;
	}

    }

    private int size() {
	return size(root);
    }

    private int size(Node root) {
	if (root == null) {
	    return 0;
	}
	return root.N;
    }

    public Value get(Key key) {
	return get(root, key);
    }

    private Value get(Node root, Key key) {
	if (root == null) {
	    return null;
	}
	int com = key.compareTo(root.key);
	if (com < 0) {
	    return get(root.left, key);
	} else if (com > 0) {
	    return get(root.right, key);
	} else {
	    return root.value;
	}
    }

    public Value getNotRe(Key key) {
	Node t = root;
	while (t != null) {
	    int cmp = key.compareTo(t.key);
	    if (cmp < 0)
		t = t.left;
	    else if (cmp > 0)
		t = t.right;
	    else {
		return t.value;
	    }
	}
	return null;

    }

    public void put(Key key, Value value) {
	root = put(root, key, value);

    }

    private Node put(Node root, Key key, Value value) {
	if (root == null) {
	    return new Node(key, value, 1);
	}
	int cmp = key.compareTo(root.key);
	if (cmp < 0) {
	    root.left = put(root.left, key, value);
	} else if (cmp > 0) {
	    root.right = put(root.right, key, value);
	} else {
	    root.value = value;
	}
	root.N = size(root.left) + size(root.right) + 1;
	return root;
    }

    public void putNotRe(Key key, Value value) {
	if (root == null) {
	    root = new Node(key, value, 1);
	}
	Node x = root;
	Node parent = null;
	int cmp = 0;
	while (x != null) {
	    cmp = key.compareTo(x.key);
	    if (cmp > 0) {
		parent = x;
		x = x.right;
	    } else if (cmp < 0) {
		parent = x;
		x = x.left;
	    } else {
		x.value = value;
		return;
	    }
	}
	if (cmp > 0) {
	    parent.right = new Node(key, value, 1);
	} else if (cmp < 0) {
	    parent.left = new Node(key, value, 1);
	}

    }

    public Key min() {
	return min(root).key;
    }

    private Node min(Node root) {
	if (root.left == null) {
	    return root;
	} else {
	    return min(root.left);
	}
    }

    public Node minNotRe(Node root) {
	Node t = root;
	while (t.left != null)
	    t = t.left;
	return t;
    }

    public Key select(int k) {
	return select(root, k).key;
    }

    private Node select(Node root, int k) {
	if (root == null)
	    return null;

	int t = size(root.left);
	if (t > k) {
	    return select(root.left, k);
	} else if (t < k) {
	    return select(root.right, k - t - 1);
	} else {
	    return root;
	}
    }

    public Node selectNotRe(Node root, int k) {
	Node x = root;
	while (x != null) {
	    int t = size(x.left);
	    if (t > k) {
		x = x.left;
	    } else if (t < k) {
		x = x.right;
		k = k - t - 1;
	    } else {
		return x;
	    }
	}
	return null;

    }

    public int rank(Key key) {
	return rank(root, key);
    }

    private int rank(Node root, Key key) {

	if (root == null)
	    return 0;
	int cmp = key.compareTo(root.key);
	if (cmp < 0) {
	    return rank(root.left, key);
	} else if (cmp > 0) {
	    return rank(root.right, key) + size(root.left) + 1;
	} else {
	    return size(root.left);
	}
    }

    public void deleteMin() {
	root = deleteMin(root);
    }

    private Node deleteMin(Node root) {
	if (root.left == null) {
	    return root.right;
	}
	root.left = deleteMin(root.left);
	root.N = size(root.left) + size(root.right) + 1;
	return root;
    }

    public void delete(Key key) {
	delete(root, key);
    }

    private Node delete(Node root, Key key) {
	if (root == null) {
	    return null;
	}

	int cmp = key.compareTo(root.key);
	if (cmp < 0) {
	    return delete(root.left, key);
	} else if (cmp > 0) {
	    return delete(root.right, key);

	} else {

	    Node t = root;
	    root = min(t.right);
	    root.left = t.left;
	    root.right = deleteMin(t.right);
	}

	root.N = root.left.N + root.right.N + 1;
	return root;
    }

    public void print() {
	print(root);
    }

    public void print(Node root) {
	if (root == null)
	    return;
	print(root.left);
	System.out.print(root.key + ": " + root.value + "  ");
	print(root.right);
    }

    public int height(Node root) {
	if (root == null)
	    return -1;
	return Math.max(height(root.left), height(root.right)) + 1;
    }

    public int count(Node root) {
	if (root == null) {
	    return 0;
	}
	return 1 + count(root.left) + count(root.right);
    }

    public void printLevel(Node root) {
	Queue<Node> queue = new Queue<Node>();
	queue.enqueue(root);
	while (!queue.isEmpty()) {
	    Node t = queue.dequeue();
	    if (t.left != null) {
		queue.enqueue(t.left);
	    }
	    if (t.right != null) {
		queue.enqueue(t.right);
	    }
	    System.out.print(t.key + ":" + t.value + "  ");
	}
    }

    public static void main(String[] args) {
	BST<Character, Integer> tree = new BST<Character, Integer>();
	char[] input = "binarysearchtree".toCharArray();
	for (int i = 0; i < input.length; i++) {
	    tree.put(input[i], i);
	}
	tree.printLevel(tree.root);

	System.out.println();
	// tree.printLevel(tree.root);
	// System.out.println(tree.height(tree.root));
	// System.out.println(tree.get('h'));
	// System.out.println(tree.getNotRe('h'));
	// System.out.println(tree.min());
	// System.out.println(tree.minNotRe(tree.root).key);
	// System.out.println(tree.select(6));
	// System.out.println(tree.selectNotRe(tree.root, 6).key);
	// System.out.println(tree.count(tree.root));

	// HashMap<Object, Object> map = new HashMap<Object, Object>(1);
	// map.put(1, 1);
	// map.put(null, 2);
	// map.put(3, null);
	// map.put(111, 111);
	//
	// Set<Entry<Object, Object>> entries = map.entrySet();
	// for (Entry<Object, Object> entry : entries)
	// {
	// System.out.println(entry.getKey() + "  :  " + entry.getValue());
	// }
    }
}
