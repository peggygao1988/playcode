package org.peggygao.algs.string;

/**
 * 
 * remove "b" and "ac" from a given string
 * 
 * automation
 * 
 * @author peggygao
 * 
 */
public class RemoveString {

    static enum State {
	ONE, TWO
    };

    static void removeString(char[] s) {

	State state = State.ONE;
	int j = 0;
	for (int i = 0; i < s.length; i++) {
	    if (state == State.ONE && s[i] != 'a' && s[i] != 'b') {
		s[j++] = s[i];
	    }

	    if (state == State.TWO && s[i] != 'c') {
		s[j++] = 'a';
		if (s[i] != 'a' && s[i] != 'b') {
		    s[j++] = s[i];

		}
	    }

	    state = s[i] == 'a' ? State.TWO : State.ONE;
	}

	if (state == State.TWO) {
	    s[j++] = 'a';
	}

	s[j] = '\0';
    }

    public static void main(String[] args) {
	char[] s = "ababac".toCharArray();
	System.out.println(s);
	removeString(s);
	System.out.println(s);
    }

}
