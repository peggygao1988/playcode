package org.peggygao.algs.binarySearchTree;

import java.util.Stack;

import org.peggygao.algs.search.BST;
import org.peggygao.algs.search.BST.Node;

public class FindPathSum {

    public static void findPath(Node root, int sum, int currentSum,
	    Stack<Integer> stack) {

	if (root == null) {
	    return;
	}
	currentSum = currentSum + (Integer) root.key;
	stack.push((Integer) root.key);

	if (currentSum == sum && isLeaf(root)) {
	    printPath(stack);

	}

	if (root.left != null)
	    findPath(root.left, sum, currentSum, stack);
	if (root.right != null)
	    findPath(root.right, sum, currentSum, stack);

	currentSum -= (Integer) root.key;
	stack.pop();

    }

    private static boolean isLeaf(Node node) {
	return node.left == null && node.right == null;
    }

    private static void printPath(Stack<Integer> stack) {
	for (int s : stack) {
	    System.out.print(s + "\t");
	}
	System.out.println();
    }

    public static void main(String[] args) {
	BST<Integer, Integer> tree = new BST<Integer, Integer>();

	tree.put(10, 10);
	tree.put(5, 5);
	tree.put(12, 12);
	tree.put(4, 4);

	tree.put(7, 7);
	tree.printLevel(tree.root);

	System.out.println();

	findPath(tree.root, 22, 0, new Stack<Integer>());
    }

}
