package org.peggygao.algs.string;

public class CountSubString {

    private static int countSubString(char[] string, char[] query) {
	int count = 0;

	int start = 0;

	while (start < string.length) {

	    if (string[start] != query[0]) {
		start++;
	    } else {

		int i = start + 1;
		int j = 1;

		while (j < query.length && string[i] == query[j]) {
		    ++i;
		    ++j;
		}

		if (j == query.length) {
		    count++;
		}

		start++;

	    }

	}

	return count;

    }

    private static int countSubStr(char[] str, char[] sub) {

	if (str == null || str.length == 0 || sub == null || sub.length == 0) {
	    return 0;
	}

	int count = 0;
	int i = 0;
	int j = 0;
	while (i < str.length) {
	    if (j < sub.length && str[i] == sub[j]) {
		j++;

		if (j == sub.length) {
		    count++;
		    j = 0;
		}
	    } else {
		j = 0;
	    }

	    i++;
	}
	return count;
    }

    public static void main(String[] args) {
	char[] string = "asbsbsbsdqrwsbdr".toCharArray();
	char[] query = "sb".toCharArray();
	System.out.println(countSubStr(string, query));

    }

}
