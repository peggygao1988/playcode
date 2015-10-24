package org.peggygao.algs.binarySearchTree;

public class ArrayTreeHeight {

    private static int maxHeight(int[] tree) {

	if (tree == null || tree.length == 0) {
	    return -1;
	}

	int maxHeight = -1;
	int[] height = new int[tree.length];

	for (int i = 0; i < height.length; i++) {
	    height[i] = -1;
	}

	for (int i = 0; i < height.length; i++) {
	    height[i] = findHeight(i, tree, height);
	    if (maxHeight < height[i]) {
		maxHeight = height[i];
	    }
	}

	return maxHeight;
    }

    private static int findHeight(int index, int[] tree, int[] height) {

	if (height[index] != -1) {
	    return height[index];
	} else if (tree[index] == -1) {
	    return 0;
	} else {
	    return findHeight(tree[index], tree, height) + 1;
	}
    }

    public static void main(String[] args) {
	int[] tree = { 3, 3, 3, -1, 2 };

	System.out.println(maxHeight(tree));
    }

}
