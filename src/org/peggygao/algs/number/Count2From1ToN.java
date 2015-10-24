package org.peggygao.algs.number;

public class Count2From1ToN {

    private static int count2(int num) {

	int count = 0;
	int factory = 1;

	while (num / factory > 0) {

	    int lower = num - (num / factory) * factory;
	    int current = (num / factory) % 10;
	    int high = num / (factory * 10);

	    switch (current) {

	    case 0:
	    case 1:
		count += high * factory;
		break;
	    case 2:
		count += high * factory + lower + 1;
		break;
	    default:
		count += (high + 1) * factory;
		break;
	    }

	    factory *= 10;

	}

	return count;
    }

    public static void main(String[] args) {

	System.out.println(count2(122));
    }

}
