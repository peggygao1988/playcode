package org.peggygao.algs.number;

public class Power {

    private static double power(double base, int exponent) {

	if (equal(base, 0.0) && exponent < 0) {
	    return 0.0;
	}

	int absExp = exponent;
	if (exponent < 0) {
	    absExp = -exponent;
	}

	double result = 0.0;
	result = powerWithUnsignedExp(base, absExp);

	if (exponent < 0) {
	    result = 1.0 / result;
	}

	return result;

    }

    private static double powerWithUnsignedExp(double base, int exp) {

	if (exp == 1) {
	    return base;
	}
	if (exp == 0) {
	    return 1.0;
	}

	double result = powerWithUnsignedExp(base, exp >> 1);
	result *= result;
	if ((exp & 1) == 1) {
	    result *= base;
	}

	return result;

    }

    private static boolean equal(double num1, double num2) {
	if (num1 - num2 < 0.00000001 && num2 - num1 < 0.00000001) {
	    return true;
	}
	return false;
    }

    public static void main(String[] args) {

    }

}
