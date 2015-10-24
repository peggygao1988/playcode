package org.peggygao.algs.stackApplication;

import org.peggygao.algs.collections.Stack;

public class EvaluatePostFix {
    private static String[] operators = { "+", "-", "*", "/" };

    public static double evaluate(String post) {
	double result = 0;

	Stack<Double> stack = new Stack<Double>();

	String[] sequence = post.split(" ");

	for (int i = 0; i < sequence.length; i++) {
	    String s = sequence[i];
	    if (!isOprator(s)) {
		stack.push(Double.valueOf(s));
	    } else {
		double opd = stack.pop();
		switch (s) {

		case "+":

		    stack.push(stack.pop() + opd);
		    break;
		case "-":
		    stack.push(stack.pop() - opd);
		    break;
		case "*":
		    stack.push(stack.pop() * opd);
		    break;
		case "/":
		    stack.push(stack.pop() / opd);
		    break;

		}

	    }

	}
	result = stack.pop();
	return result;
    }

    private static boolean isOprator(String s) {

	for (String a : operators) {
	    if (s.equals(a)) {
		return true;
	    }
	}
	return false;
    }

    public static void main(String[] args) {
	String post = "6 5 2 3 + 8 * + 3 + *";
	System.out.println(evaluate(post));
    }
}
