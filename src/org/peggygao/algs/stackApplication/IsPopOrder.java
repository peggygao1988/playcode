package org.peggygao.algs.stackApplication;

import java.util.Stack;

public class IsPopOrder {

    private static boolean isPopOrder(int[] push, int[] pop) {

	Stack<Integer> stack = new Stack<Integer>();
	if (push != null && pop != null) {

	    int pushIndex = 0;
	    int popIndex = 0;
	    int length = push.length;
	    while (popIndex < length) {
		while (stack.isEmpty() || stack.peek() != pop[popIndex]) {

		    if (pushIndex == length) {
			break;
		    }
		    stack.push(push[pushIndex++]);
		}
		if (!stack.isEmpty() && stack.peek() == pop[popIndex]) {
		    stack.pop();
		    popIndex++;
		}

		if (popIndex == length) {
		    break;
		}

		if (pushIndex == length && stack.peek() != pop[popIndex]) {
		    return false;
		}

	    }
	}

	return true;

    }

    public static void main(String[] args) {
	int[] push = { 1 };
	int[] pop = { 4};
	System.out.println(isPopOrder(push, pop));

    }

}
