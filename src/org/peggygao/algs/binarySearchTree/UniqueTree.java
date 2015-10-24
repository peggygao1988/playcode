package org.peggygao.algs.binarySearchTree;

import java.util.ArrayList;

public class UniqueTree {

    public static class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
	    val = x;
	    left = null;
	    right = null;
	}

    }

    private static ArrayList<TreeNode> generateTrees(int n) {

	return build(1, n);
    }

    private static ArrayList<TreeNode> build(int start, int end) {

	ArrayList<TreeNode> list = new ArrayList<TreeNode>();
	if (start > end) {
	    list.add(null);
	    return list;
	}

	for (int i = start; i <= end; i++) {
	    for (TreeNode left : build(start, i - 1)) {
		for (TreeNode right : build(i + 1, end)) {
		    TreeNode root = new TreeNode(i);
		    root.left = left;
		    root.right = right;
		    list.add(root);
		}
	    }
	}

	return list;

    }

    public static void main(String[] args) {

    }

}
