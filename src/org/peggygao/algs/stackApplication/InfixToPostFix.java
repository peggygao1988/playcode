package org.peggygao.algs.stackApplication;

import org.peggygao.algs.collections.Stack;

public class InfixToPostFix {

    private static char[] operators = { '+', '-', '*', '/', '(', ')' };

    public static String infixToPostFix(String infix) {
	StringBuffer post = new StringBuffer();
	Stack<Character> stack = new Stack<Character>();

	char c;
	for (int i = 0; i < infix.length(); i++) {
	    c = infix.charAt(i);
	    if (!isOprator(c)) {
		post.append(c);
	    } else if (c == ')') {
		for (char a = stack.pop(); a != '('; a = stack.pop()) {
		    post.append(a);
		}
	    } else {
		if (stack.isEmpty()) {
		    stack.push(c);
		} else {
		    char previous = stack.peek();
		    if (previous == '(') {
			stack.push(c);
		    } else if (priority(previous) < priority(c)) {
			stack.push(c);
		    } else {
			while (!stack.isEmpty()
				&& (stack.peek() != '(' && priority(stack
					.peek()) >= priority(c))) {
			    post.append(stack.pop());
			}
			stack.push(c);
		    }
		}

	    }
	}

	while (!stack.isEmpty()) {
	    post.append(stack.pop());
	}

	return post.toString();

    }

    public static String convert(char[] infix) {

	StringBuffer sb = new StringBuffer();
	Stack<Character> stack = new Stack<Character>();
	int i = 0;
	while (i < infix.length) {
	    char c = infix[i];
	    if (!isOprator(c)) {
		sb.append(c);
		i++;
	    } else if (c == ')') {
		char top = stack.pop();
		if (top != '(') {
		    sb.append(top);
		} else {
		    i++;
		}
	    } else if (c == '(') {
		stack.push(c);
		i++;
	    } else {
		if (stack.isEmpty() || priority(c) > priority(stack.peek())) {
		    stack.push(c);
		    i++;
		} else if (stack.peek() == '(') {
		    stack.push(c);
		    i++;
		} else {
		    char top = stack.pop();
		    sb.append(top);
		}
	    }
	}

	while (!stack.isEmpty()) {
	    sb.append(stack.pop());
	}

	return sb.toString();

    }

    private static boolean isOprator(char c) {

	for (char a : operators) {
	    if (c == a) {
		return true;
	    }
	}
	return false;
    }

    private static int priority(char c) {
	int p = -1;

	switch (c) {
	case '-':
	case '+':
	    p = 1;
	    break;

	case '/':
	case '*':
	    p = 2;
	    break;
	case '(':
	    p = 3;
	    break;
	default:
	    p = 0;
	    break;
	}

	return p;
    }

    public static void main(String[] args) {
	String infix = "a+b*c+(d*e+f)*g";
	System.out.println(infixToPostFix(infix));
	System.out.println("=================");
	System.out.println(convert(infix.toCharArray()));
    }
}
