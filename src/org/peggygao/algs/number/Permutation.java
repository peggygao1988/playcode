package org.peggygao.algs.number;

public class Permutation {

    private static void permutation(char[] string, int index) {

	if (string == null) {
	    return;
	}
	if (index == string.length) {
	    print(string);
	} else {

	    for (int i = index; i < string.length; i++) {
		swap(string, index, i);

		permutation(string, index + 1);

		swap(string, index, i);
	    }

	}

    }

    private static void swap(char[] string, int i, int j) {
	char temp = string[i];
	string[i] = string[j];
	string[j] = temp;
    }

    private static void permutation2(char[] s) {
	char[] r = new char[s.length];
	boolean[] marked = new boolean[s.length];
	per2(s, r, 0, marked);
    }

    private static void per2(char[] s, char[] r, int index, boolean[] marked) {
	if (index == r.length) {
	    print(r);
	    return;
	}

	for (int i = 0; i < s.length; i++) {
	    if (marked[i] == true) {
		continue;
	    }

	    r[index] = s[i];
	    marked[i] = true;
	    per2(s, r, index + 1, marked);
	    marked[i] = false;
	}
    }

    private static void print(char[] string) {
	for (int i = 0; i < string.length; i++) {
	    System.out.print(string[i]);
	}
	System.out.println();
    }

    public static void main(String[] args) {
	char[] string = { 'a', 'b', 'c' };
	permutation2(string);

    }

}
