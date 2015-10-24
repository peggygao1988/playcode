package org.peggygao.algs.string;

public class RepalceBlank {

    private static void replace(char[] s, int length) {

	if (s == null || length <= 0) {
	    return;
	}

	int originalLength = 0;
	int count = 0;
	for (int i = 0; s[i] != '\0'; i++) {
	    if (s[i] == ' ') {
		count++;
	    }
	    originalLength++;
	}

	if (count == 0) {
	    return;
	}
	int p1 = originalLength;
	int p2 = p1 + count * 2;

	if (p2 > length - 1) {
	    return;
	}
	while (p1 >= 0) {
	    if (s[p1] != ' ') {
		s[p2--] = s[p1];

	    } else {
		s[p2--] = '0';
		s[p2--] = '2';
		s[p2--] = '%';

	    }
	    p1--;
	}

    }

    public static void main(String[] args) {

	char[] a = { ' ', ' ', 'w', 'a', 'r', 'e', ' ', 'h', 'a', 'p', 'p',
		'y', '.', '\0', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' };

	for (int i = 0; i < a.length; i++) {
	    System.out.print(a[i]);
	}
	System.out.println();
	replace(a, a.length);
	for (int i = 0; i < a.length; i++) {
	    System.out.print(a[i]);
	}
    }
}
