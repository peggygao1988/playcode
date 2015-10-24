package org.peggygao.algs.array;

public class ReorderStar {

    private static int reourderStar(char[] string) {

	if (string == null || string.length == 0) {
	    return 0;
	}
	int count = 0;
	int i = string.length - 1;
	int k = i;

	while (i >= 0) {

	    if (string[i] != '*') {
		swap(string, i--, k--);
	    } else {

		i--;
		count++;
	    }
	}

	return count;
    }

    private static void swap(char[] string, int i, int j) {

	char temp = string[i];
	string[i] = string[j];
	string[j] = temp;
    }

    public static void main(String[] args) {
	char[] string = "*ab**sg*afg*f".toCharArray();

	System.out.println(reourderStar(string));
	for (char c : string) {
	    System.out.print(c);
	}
    }
}
