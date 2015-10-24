package org.peggygao.algs.number;

public class DecimalToBinary {

    private static String toBinary(String n) {

	int intPart = Integer.parseInt(n.substring(0, n.indexOf(".")));
	double decPart = Double.parseDouble(n.substring(n.indexOf("."),
		n.length()));

	String intString = "";

	while (intPart > 0) {
	    int r = intPart % 2;
	    intString = r + intString;
	    intPart /= 2;
	}

	StringBuffer sb = new StringBuffer();
	while (decPart > 0) {
	    if (sb.length() > 32) {
		return "ERROR";
	    }

	    decPart *= 2;
	    if (decPart >= 1) {
		sb.append(1);
		decPart -= 1;
	    } else {
		sb.append(0);
	    }

	}

	return intString + "." + sb.toString();

    }

    public static void main(String[] args) {
	System.out.println(toBinary("3.75"));

    }

}
