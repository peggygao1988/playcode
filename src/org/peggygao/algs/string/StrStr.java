package org.peggygao.algs.string;

public class StrStr {

    private static int strstr(char[] string, char[] query) {

	if (string == null || query == null || string.length == 0
		|| query.length == 0) {
	    return -1;
	}

	int start = -1;

	for (int i = 0; i < string.length; i++) {

	    if (string[i] != query[0]) {
		continue;
	    } else {

		int j = i + 1;
		int k = 1;
		while (k < query.length && j < string.length
			&& string[j] == query[k]) {
		    k++;
		    j++;
		}

		if (k == query.length && j < string.length) {
		    start = i;
		    break;
		}

	    }

	}

	return start;
    }

    private static int str(char[] str, char[] sub) {

	int j = 0;

	for (int i = 0; i < str.length; i++) {
	    if (str[i] == sub[j]) {
		j++;
		if (j == sub.length) {
		    return i + 1 - sub.length;

		}

	    } else {
		j = 0;
	    }
	}

	return -1;
    }

    public static void main(String[] args) {

	char[] string = "fghjadsdrehashgfas".toCharArray();
	char[] query = "ads".toCharArray();
	System.out.println(str(string, query));
    }

}
