package org.peggygao.algs.array;

public class LongestIncreasingNumber {

    private static int lin(char[] string) {

	int maxLength = 0;
	int start = 0;
	int end = 0;
	int maxNumber = 0;
	while (start < string.length) {

	    if (!isNumber(string[start])) {
		start++;
	    } else {
		end = start + 1;

		while (end < string.length && isNumber(string[end])
			&& string[end] > string[end - 1]) {
		    end++;
		}

		if (end - start > maxLength) {
		    maxLength = end - start;
		    maxNumber = charToNumber(string, start, end);
		}

		start = end;
	    }

	}

	return maxNumber;
    }

    private static int lin2(char[] string) {

	int maxNumber = 0;
	boolean flag = false;
	int length = 0;
	int maxLength = 0;
	for (int i = 0; i < string.length; i++) {

	    if (isNumber(string[i])) {
		if (!flag) {
		    flag = true;
		    length++;
		} else if (string[i] > string[i - 1]) {
		    length++;
		}
	    } else if (flag) {
		flag = false;
		if (maxLength < length) {
		    maxLength = length;
		    maxNumber = charToNumber(string, i - length, i);
		}

		length = 0;
	    }
	}

	return maxNumber;
    }

    private static int charToNumber(char[] string, int start, int end) {
	int result = 0;
	for (int i = start; i < end; i++) {
	    result = result * 10 + string[i] - '0';
	}

	return result;
    }

    private static boolean isNumber(char c) {
	if (c >= '0' && c <= '9') {
	    return true;
	}

	return false;
    }

    public static void main(String[] args) {
	char[] string = "ads3sl456789DF3456987654321ld3456789AA".toCharArray();
	System.out.println(lin2(string));

    }

}
