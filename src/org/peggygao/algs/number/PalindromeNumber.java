package org.peggygao.algs.number;

public class PalindromeNumber {

    public static boolean isPalindrome(int x) {
	// Start typing your Java solution below
	// DO NOT write main() function
	if (x < 0) {
	    return false;
	}

	long factory = 10;
	int count = 1;
	while (x / factory > 0) {
	    factory *= 10;
	    count++;
	}

	if (factory == 10) {
	    return true;
	}

	factory /= 10;
	for (int i = 1; i * 2 <= count; i++) {

	    int high = (int) (x / factory);
	    int low = x % 10;
	    if (high != low) {
		return false;
	    }

	    x -= high * factory;
	    x /= 10;
	    factory /= 100;
	}

	return true;
    }

    public static void main(String[] args) {
	System.out.println(isPalindrome(1000000001));
	System.out.println("AvFE,d.R".toLowerCase());
    }

}
