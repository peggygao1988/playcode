package org.peggygao.algs.array;

/**
 * 把s数组中的顺序变成t数字，s数组每个元素只能跟0交换
 * @author peggygao
 *
 */
public class SwapZero {

    private static void process(int[] s, int[] t) {

	int n = s.length;
	int[] p2 = new int[n];

	for (int i = 0; i < n; i++) {
	    p2[t[i]] = i;
	}

	int index = -1;
	for (int i = 0; i < s.length; i++) {
	    if (s[i] == 0) {
		index = i;
		break;
	    }
	}
	while (true) {
	    int i = 0;
	    while (i < n) {
		if (s[i] == 0) {
		    i++;
		} else {
		    int k = s[i];
		    int p = p2[k];
		    if (p == i) {
			i++;
		    } else {

			swap(s, index, p);
			index = p;
			swap(s, index, i);
			index = i;
			i = 0;
		    }
		}

	    }

	    if (i == n) {
		break;
	    }

	}

	for (int i : s) {
	    System.out.print(i + "\t");
	}
	System.out.println();

    }

    private static void swap(int[] p1, int i, int j) {

	int temp = p1[i];
	p1[i] = p1[j];
	p1[j] = temp;
    }

    public static void main(String[] args) {
	int[] s = { 0, 1, 2 };

	int[] t = { 0, 2, 1 };
	process(s, t);
    }

}
