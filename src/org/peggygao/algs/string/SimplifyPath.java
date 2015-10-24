package org.peggygao.algs.string;

import java.util.Stack;

public class SimplifyPath {

    public static String simplifyPath(String path) {

	if (path == null || path.length() == 0) {
	    return "/";
	}

	String[] paths = path.split("/");
	Stack<String> stack = new Stack<String>();

	for (String s : paths) {
	    if(s.equals("")){
	    }
	    else if (s.equals("..")) {

		if (!stack.isEmpty()) {
		    stack.pop();
		}

	    } else if (s.equals(".")) {

	    } else {
		stack.push(s);
	    }
	}

	if (stack.isEmpty()) {
	    return "/";
	}
	StringBuffer sb = new StringBuffer();
	for (String s : stack) {
	    if (s.equals("")) {
		continue;
	    }
	    sb.append("/");
	    sb.append(s);
	}

	return sb.toString();

    }

    public static void main(String[] args) {

	System.out.println(simplifyPath("/.hidden"));
    }

}
