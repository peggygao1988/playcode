package org.peggygao.algs.binarySearchTree;

import java.util.ArrayList;
import java.util.Stack;

import org.peggygao.algs.search.BST.Node;

public class FindPath {

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

    private static void findPath(Node root, int sum, int currernt,
	    Stack<Integer> stack) {

	if (root == null) {
	    return;
	}

	stack.push(root.value);
	currernt += root.value;

	if (isLeaf(root) && currernt == sum) {
	    printPath(stack);
	}

	findPath(root.left, sum, currernt, stack);
	findPath(root.right, sum, currernt, stack);

	stack.pop();
	currernt -= root.value;

    }

    private static void printPath(Stack<Integer> stack) {

	for (Integer i : stack) {
	    System.out.print(i + "\t");
	}
	System.out.println();

    }

    private static boolean isLeaf(Node node) {
	return node.left == null && node.right == null;
    }

    private static ArrayList<ArrayList<Integer>> pathSum(Node root, int sum) {

	ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

	findSum(root, list, new ArrayList<Integer>(), sum, 0);
	return list;
    }

    private static void findSum(Node root, ArrayList<ArrayList<Integer>> list,
	    ArrayList<Integer> l, int sum, int current) {

	if (root == null) {
	    return;
	}

	current += root.value;
	l.add(root.value);
	if (current == sum && root.left == null && root.right == null) {

	    ArrayList<Integer> result = new ArrayList<Integer>(l);
	    list.add(result);
	}

	findSum(root.left, list, l, sum, current);
	findSum(root.right, list, l, sum, current);

	l.remove(l.size() - 1);
    }

    public static void main(String[] args) {
	Node n1 = new Node(4, null, null);
	Node n2 = new Node(7, null, null);
	Node n3 = new Node(5, n1, n2);

	Node n4 = new Node(12, null, null);
	Node n5 = new Node(10, n3, n4);

	findPath(n5, 19, 0, new Stack<Integer>());

    }

}
