package org.peggygao.algs.number;

public class NumberOf1From1ToN {

    private static int highestNumber(int number) {
	int highest = 0;

	while (number != 0) {
	    highest = number % 10;
	    number = number / 10;
	}

	return highest;
    }

    private static int length(int number) {
	int count = 0;

	while (number != 0) {
	    number /= 10;
	    count++;
	}
	return count;
    }

    private static int lowerNumber(int number) {
	int highest = highestNumber(number);
	int length = length(number);

	return number % (highest * length);
    }

    private static int numberOf1(int number) {

	if (number <= 0) {
	    return 0;
	}

	int length = length(number);
	int first = highestNumber(number);

	if (length == 1 && first == 0) {

	    return 0;
	}
	if (length == 1 && first == 1) {
	    return 1;
	}

	int fisrtNumber = 0;
	if (first > 1) {
	    fisrtNumber = (int) Math.pow(10, length - 1);
	} else if (first == 1) {
	    fisrtNumber = lowerNumber(number) + 1;
	}

	int otherNumber = (int) (first * (length - 1) * Math
		.pow(10, length - 2));

	int numberRecursive = numberOf1(lowerNumber(number));

	return fisrtNumber + otherNumber + numberRecursive;

    }

    private static int count1(int n) {

	int count = 0;
	int factor = 1;

	while (n / factor != 0) {
	    int lower = n - (n / factor) * factor;
	    int current = (n / factor) % 10;
	    int higher = n / (factor * 10);

	    switch (current) {
	    case 0:
		count += higher * factor;
		break;
	    case 1:
		count += higher * factor + lower + 1;
		break;
	    default:
		count += (higher + 1) * factor;
		break;
	    }

	    factor *= 10;
	}

	return count;

    }

    public static void main(String[] args) {
	System.out.println(count1(99));

    }

}
