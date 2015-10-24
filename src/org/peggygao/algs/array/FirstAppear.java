package org.peggygao.algs.array;

/**
 * find the char first appear once
 * 
 * @author peggygao
 * 
 */
public class FirstAppear {

    private static void firstAppear(char[] string) {

	int[] map = new int[256];

	for (int i = 0; i < string.length; i++) {
	    char c = string[i];
	    map[c]++;
	}

	for (int i = 0; i < string.length; i++) {
	    if (map[string[i]] == 1) {
		System.out.println(string[i]);
		break;
	    }
	}

    }

    public static void main(String[] args) {
	firstAppear("acdsgew".toCharArray());

    }

}
