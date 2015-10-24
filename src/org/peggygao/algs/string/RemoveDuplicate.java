package org.peggygao.algs.string;

public class RemoveDuplicate {

    private static void remove(char[] string) {

	boolean[] hash = new boolean[256];

	int wi = 0;
	int ri = 0;

	// for (char c : string) {
	// hash[c]++;
	// }
	while (ri < string.length) {

	    if (hash[string[ri]] == true) {
		ri++;
	    } else {
		hash[string[ri]] = true;
		string[wi++] = string[ri++];

	    }
	}
	while (wi < ri) {
	    string[wi++] = '\0';
	}

    }

    public static void main(String[] args) {

	char[] c = "google".toCharArray();
	remove(c);
	System.out.println(c);

    }

}
