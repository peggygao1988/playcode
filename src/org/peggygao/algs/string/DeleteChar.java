package org.peggygao.algs.string;

public class DeleteChar {

    private static void deleteChar(char[] s1, char[] s2) {

	int[] hash = new int[256];
	for (char c : s2) {
	    hash[c] = 1;
	}

	int readIndex = 0;
	int writeIndex = 0;

	while (readIndex < s1.length) {

	    if (hash[s1[readIndex]] == 0) {
		s1[writeIndex++] = s1[readIndex];
	    }

	    readIndex++;

	}

	while (writeIndex < readIndex) {
	    s1[writeIndex++] = ' ';
	}

    }

    private static void print(char[] s) {
	for (char c : s) {
	    System.out.print(c);
	}

	System.out.println();
    }

    public static void main(String[] args) {
	char[] s1 = "They are students.".toCharArray();
	char[] s2 = "aeiou".toCharArray();
	deleteChar(s1, s2);
	print(s1);

    }

}
