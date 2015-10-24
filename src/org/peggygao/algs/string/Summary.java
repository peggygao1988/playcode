package org.peggygao.algs.string;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class Summary {

    private static HashMap<String, Integer> map = new HashMap<String, Integer>();

    private static boolean isAllExist() {

	boolean result = true;
	Set<Entry<String, Integer>> entries = map.entrySet();

	for (Entry<String, Integer> entry : entries) {

	    if (entry.getValue() == 0) {
		result = false;
		break;
	    }
	}

	return result;
    }

    private static String summary(String[] description, String[] keywords) {

	for (String s : keywords) {
	    map.put(s, 0);

	}

	String summary = "";

	int start = 0;
	int end = 0;
	int sumStart = 0;
	int sumEnd = 0;
	int sumLen = description.length;
	while (true) {

	    while (!isAllExist() && end < description.length) {
		if (map.containsKey(description[end])) {
		    map.put(description[end], map.get(description[end]) + 1);
		}
		end++;
	    }

	    while (isAllExist()) {
		while (!map.containsKey(description[start])) {
		    start++;
		}

		if (end - start < sumLen) {
		    sumStart = start;
		    sumEnd = end - 1;
		    sumLen = end - start;

		}

		map.put(description[start], map.get(description[start]) - 1);
		start++;

	    }

	    if (end >= description.length) {
		break;
	    }
	}

	for (int i = sumStart; i <= sumEnd; i++) {
	    summary += description[i];
	}
	return summary;
    }

    public static void main(String[] args) {
	String[] description = "a c c c c g b e d t f f f f b".split(" ");
	String[] keywords = { "f", "b" };
	System.out.println(summary(description, keywords));

    }

}
