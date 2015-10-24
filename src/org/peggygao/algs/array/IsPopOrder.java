package org.peggygao.algs.array;

import java.util.Stack;

public class IsPopOrder {

    private static boolean isPopOrder(int[] push, int[] pop) {

	Stack<Integer> stack = new Stack<Integer>();

	int i = 0;
	int j = 0;

	while (i <= push.length && j < pop.length) {

	    if (stack.isEmpty() || stack.peek() != pop[j]) {
		if (i == push.length) {
		    break;
		}
		stack.push(push[i++]);

	    } else if (stack.peek() == pop[j]) {

		stack.pop();
		j++;
	    }

	}

	if (i == push.length && j == pop.length) {
	    return true;
	}

	return false;

    }

    public static void main(String[] args) {
	int[] push = { 1, 2, 3, 4, 5 };
	int[] pop = { 4, 5, 3, 2, 1 };
	System.out.println(isPopOrder(push, pop));
    }

}
