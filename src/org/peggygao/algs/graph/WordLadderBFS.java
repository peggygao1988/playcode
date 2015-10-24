package org.peggygao.algs.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class WordLadderBFS {

    private HashSet<String> dict = new HashSet<String>();

    public WordLadderBFS() {
	String[] words = { "ted", "tex", "red", "tax", "tad", "den", "rex",
		"pee" };
	for (String w : words) {
	    dict.add(w);
	}

	// dict.add("a");
	// dict.add("c");
	// dict.add("dot");
	// dict.add("lot");
	// dict.add("log");
    }

    public ArrayList<ArrayList<String>> findLadders(String start, String end,
	    HashSet<String> dict) {

	int minLength = Integer.MAX_VALUE;
	Queue<String> actions = new LinkedList<String>();
	ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
	HashSet<String> visited = new HashSet<String>();
	HashMap<String, String> back = new HashMap<String, String>();

	actions.add(start);
	visited.add(start);
	while (!actions.isEmpty()) {

	    String word = actions.poll();
	    for (String v : transform(word)) {

		if (v.equals(end)) {

		    ArrayList<String> trans = new ArrayList<String>();
		    trans.add(v);

		    while (word != null) {
			trans.add(0, word);
			word = back.get(word);

		    }

		    if (trans.size() < minLength) {
			list.clear();
			list.add(trans);
			minLength = trans.size();
		    } else if (trans.size() == minLength) {
			list.add(trans);
		    }

		} else {

		    if (dict.contains(v)) {
			if (!visited.contains(v)) {
			    visited.add(v);
			    actions.add(v);
			    back.put(v, word);
			}
		    }

		}
	    }

	}

	return list;

    }

    private ArrayList<String> transform(String word) {

	ArrayList<String> trans = new ArrayList<String>();
	for (int i = 0; i < word.length(); i++) {
	    char[] ch = word.toCharArray();
	    for (char c = 'a'; c <= 'z'; c++) {
		if (c != word.charAt(i)) {
		    ch[i] = c;
		    String s = new String(ch);
		    trans.add(s);
		}
	    }
	}

	return trans;
    }

    public static void main(String[] args) {
	WordLadderBFS wl = new WordLadderBFS();
	ArrayList<ArrayList<String>> result = wl.findLadders("red", "tax",
		wl.dict);

	for (ArrayList<String> list : result) {
	    for (String s : list) {
		System.out.print(s + " \t");
	    }

	    System.out.println();
	}

    }

}
