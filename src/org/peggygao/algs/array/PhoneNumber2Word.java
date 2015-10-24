package org.peggygao.algs.array;

import java.util.ArrayList;

/**
 * map numbers to word
 * 
 * @author peggygao
 * 
 */
public class PhoneNumber2Word {

    static char[][] c = { {}, {}, { 'a', 'b', 'c' }, { 'd', 'e', 'f' },
	    { 'g', 'h', 'i' }, { 'j', 'k', 'l' }, { 'm', 'n', 'o' },
	    { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' } };

    static char[][] dic = { {}, {}, { 'a', 'b', 'c' }, { 'd', 'e', 'f' },
	    { 'g', 'h', 'i' }, { 'j', 'k', 'l' }, { 'm', 'n', 'o' },
	    { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' } };

    private static void map(int[] number, int index, int[] state) {

	if (index == number.length) {
	    for (int i = 0; i < number.length; i++) {
		System.out.print(c[number[i]][state[i]]);
	    }
	    System.out.println();
	    return;
	}

	for (int i = 0; i < c[number[index]].length; i++) {
	    state[index] = i;
	    map(number, index + 1, state);
	}

    }

    private static char[] result;

    public static void convert(int[] numbers, int index) {

	if (index == numbers.length) {
	    for (char a : result) {
		System.out.print(a);
	    }
	    System.out.println();
	    return;
	}

	int n = numbers[index];
	for (int i = 0; i < c[n].length; i++) {
	    result[index] = c[n][i];
	    convert(numbers, index + 1);
	}

    }

    public static ArrayList<String> letterCombinations(String digits) {

	ArrayList<String> list = new ArrayList<String>();
	StringBuffer sb = new StringBuffer();
	dfs(digits, 0, sb, list);

	return list;

    }

    private static void dfs(String digits, int index, StringBuffer sb,
	    ArrayList<String> list) {

	if (index == digits.length()) {
	    list.add(sb.toString());
	    return;
	}

	int n = Integer.valueOf(digits.charAt(index)) - '0';
	for (int i = 0; i < dic[n].length; i++) {
	    sb.append(dic[n][i]);
	    dfs(digits, index + 1, sb, list);
	    sb.deleteCharAt(index);
	}

    }

    public static void main(String[] args) {
	// int[] number = { 4, 2 };
	// int[] state = new int[number.length];
	// result = new char[number.length];
	// map(number, 0, state);
	// convert(number, 0);

	ArrayList<String> result = letterCombinations("2");
	for (String s : result) {
	    System.out.println(s);
	}

    }

}
