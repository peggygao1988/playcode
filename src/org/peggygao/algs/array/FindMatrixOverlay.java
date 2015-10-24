package org.peggygao.algs.array;

import java.util.Stack;

public class FindMatrixOverlay {

    private static int findOverlay(int[] a) {

	int max = 0;

	Stack<Integer> stack = new Stack<Integer>();
	int i = 0;
	while (i < a.length) {

	    if (stack.isEmpty() || a[stack.peek()] <= a[i]) {
		stack.push(i++);
	    } else {

		int start = stack.pop();
		max = Math
			.max(max,
				a[start]
					* (stack.isEmpty() ? i : i
						- stack.peek() - 1));

	    }
	}

	while (!stack.isEmpty()) {
	    int start = stack.pop();
	    max = Math.max(max,
		    a[start] * (stack.isEmpty() ? i : i - stack.peek() - 1));
	}

	return max;

    }

    public static void main(String[] args) {
	int[] a = { 1, 2, 3, 5, 4, 2 };
	System.out.println(findOverlay(a));
    }

}
