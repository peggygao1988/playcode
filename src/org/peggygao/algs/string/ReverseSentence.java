package org.peggygao.algs.string;

public class ReverseSentence {

    private static void reverse(char[] string, int start, int end) {

	while (start < end) {

	    char temp = string[start];
	    string[start] = string[end];
	    string[end] = temp;
	    start++;
	    end--;
	}

    }

    private static void reverseSentence(char[] string) {
	if (string == null || string.length == 0) {
	    return;
	}

	reverse(string, 0, string.length - 1);

	int start = 0;
	int end = 0;
	for (int i = 0; i < string.length; i++) {
	    if (string[i] == ' ') {

		end = i - 1;
		reverse(string, start, end);
		start = i + 1;
	    } else if (i == string.length - 1) {
		end = i;
		reverse(string, start, end);
		start = i + 1;
	    }
	}

	System.out.println(string);
    }

    private static void leftRotate(char[] string, int k) {

	if (string == null || string.length == 0 || k < 0) {
	    return;
	}
	k = k % string.length;

	reverse(string, 0, k - 1);
	reverse(string, k, string.length - 1);
	reverse(string, 0, string.length - 1);

	System.out.println(string);
    }

    public static void main(String[] args) {
	// reverseSentence("student".toCharArray());

	leftRotate("abcdefg".toCharArray(), 9);
    }

}
