import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class ReadPhoneNumber {

    public static void main(String[] args) throws Exception {

	String[] n = { "zero", "one", "two", "three", "four", "five", "six",
		"seven", "eight", "nine" };
	String[] mul = { "double", "triple", "quadruple", "quintuple",
		"sextuple", "septuple", "octuple", "nonuple", "decuple" };
	BufferedReader in = new BufferedReader(new FileReader("A-large.in"));

	PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
		"A-large.out")));

	int T = Integer.valueOf(in.readLine());
	// System.out.println(T);
	for (int i = 0; i < T; i++) {
	    String line = in.readLine();
	    String num = line.split(" ")[0];
	    String format = line.split(" ")[1];

	    // System.out.println(num);
	    // System.out.println(format);
	    out.print("Case #" + (i + 1) + ":");

	    int[] sep;

	    int ss = 0;
	    for (int k = 0; k < format.length(); k++) {
		if (format.charAt(k) == '-') {
		    ss++;
		}
	    }
	    sep = new int[ss + 1];
	    for (int k = 0; k <= ss; k++) {
		sep[k] = Integer.valueOf(format.split("-")[k]);
	    }

	    int j = 0;
	    int w = 0;
	    for (int t = 0; t <= ss; t++) {

		int pre = num.charAt(j) - '0';
		j++;
		int count = 1;
		int curr = -1;
		w += sep[t];
		// if (t - 1 >= 0) {
		// w += sep[t - 1];
		// }
		for (; j < w; j++) {
		    curr = num.charAt(j) - '0';
		    if (curr != pre) {
			if (count == 0 || count == 1) {
			    out.print(" " + n[pre]);
			} else if (count <= 10) {
			    out.print(" " + mul[count - 2] + " " + n[pre]);
			} else {
			    for (int l = 0; l < count; l++) {
				out.print(" " + n[pre]);
			    }
			}

			pre = curr;
			count = 1;
		    } else {
			count++;
		    }
		}

		if (count == 0 || count == 1) {
		    out.print(" " + n[pre]);
		} else if (count <= 10) {
		    out.print(" " + mul[count - 2] + " " + n[pre]);
		} else {
		    for (int l = 0; l < count; l++) {
			out.print(" " + n[pre]);
		    }
		}

	    }
	    out.println();
	}

	out.close();
    }
}
