package org.peggygao.algs.array;

/**
 * reverse a stack using recursion
 */
import java.util.Stack;

public class ReverseStack {

    private static void reverse(Stack<Integer> s) {
	if (!s.isEmpty()) {
	    Integer o = s.pop();
	    reverse(s);
	    addToButtom(s, o);
	}

    }

    private static void addToButtom(Stack<Integer> s, Integer o) {

	if (s.isEmpty()) {
	    s.push(o);
	    return;
	}

	Integer top = s.pop();
	addToButtom(s, o);
	s.push(top);

    }

    public static void main(String[] args) {
	Stack<Integer> s = new Stack<Integer>();
	s.push(5);
	s.push(4);
	s.push(3);
	s.push(2);
	s.push(1);

	reverse(s);

	while (!s.isEmpty()) {
	    System.out.println(s.pop());
	}

    }

}
