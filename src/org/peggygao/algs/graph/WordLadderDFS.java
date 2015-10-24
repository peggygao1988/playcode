package org.peggygao.algs.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class WordLadderDFS {

    private int minLength = Integer.MAX_VALUE;

    private ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();

    private HashMap<String, Boolean> visited = new HashMap<String, Boolean>();
    private HashSet<String> dict = new HashSet<String>();

    public WordLadderDFS() {
	String[] words = { "ted", "tex", "red", "tax", "tad", "den", "rex",
		"pee" };
	for (String w : words) {
	    dict.add(w);
	}
    }

    public ArrayList<ArrayList<String>> findLadders(String start, String end,
	    HashSet<String> dict) {
	// Start typing your Java solution below
	// DO NOT write main() function

	visited.put(start, true);
//	ArrayList<String> candidates = transform(start, dict);

	ArrayList<String> ladder = new ArrayList<String>();
	ladder.add(start);

	dfs(start, end, ladder, dict, 1);

	return list;
    }

    private ArrayList<String> transform(String word, HashSet<String> dict) {

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

    private void dfs(String word, String end, ArrayList<String> ladder,
	    HashSet<String> dict, int length) {

	if (length > minLength) {
	    return;
	}
	ArrayList<String> candidates = transform(word, dict);

	for (String w : candidates) {
	    if (w.equals(end)) {
		ladder.add(end);
		if (ladder.size() < minLength) {
		    list.clear();
		    list.add(new ArrayList<String>(ladder));
		    minLength = ladder.size();
		} else if (ladder.size() == minLength) {
		    list.add(new ArrayList<String>(ladder));
		}
		ladder.remove(w);
		return;

	    }
	    if (!dict.contains(w)) {
		continue;
	    }
	    if (!visited.containsKey(w)) {
		ladder.add(w);
		visited.put(w, true);
		dfs(w, end, ladder, dict, ladder.size());
		ladder.remove(w);
		visited.remove(w);
	    }

	}

    }

    public static void main(String[] args) {

	WordLadderDFS wl = new WordLadderDFS();
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
