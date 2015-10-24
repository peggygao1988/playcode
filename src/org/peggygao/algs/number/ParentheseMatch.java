package org.peggygao.algs.number;

public class ParentheseMatch {

    private static void match(char[] str, int length, int index, int count) {
	if (index == length) {
	    if (count == 0) {
		System.out.println("yes");
	    } else {
		System.out.println("no");
	    }

	    return;
	}

	if (str[index] == '(') {
	    count++;
	} else if (str[index] == ')') {
	    count--;

	    if (count < 0) {
		System.out.println("no");
		return;
	    }
	}

	match(str, length, index + 1, count);

    }

    public static void main(String[] args) {
	char[] str = "()".toCharArray();
	match(str, str.length, 0, 0);

    }

}
