package org.peggygao.algs.exercise;

import org.peggygao.algs.collections.Stack;

public class Parentheses {

    public static void main(String[] args) {
	String input = "[(])";

	Stack<Character> stack = new Stack<Character>();

	for (int i = 0; i < input.length(); i++) {
	    char ch = input.charAt(i);
	    if (ch == ')') {
		char top = stack.pop();
		if (top != '(') {
		    System.out.println("false");
		    return;
		}
	    } else if (ch == ']') {
		char top = stack.pop();
		if (top != '[') {
		    System.out.println("false");
		    return;
		}
	    } else if (ch == '}') {
		char top = stack.pop();
		if (top != '{') {
		    System.out.println("false");
		    return;
		}
	    } else {
		stack.push(ch);
	    }

	}

	System.out.println("true");

    }

}
