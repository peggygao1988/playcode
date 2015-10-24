import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Sorting {

    public static void main(String[] args) throws Exception {

	BufferedReader in = new BufferedReader(new FileReader("C-large.in"));

	PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
		"C-large.out")));

	int N = Integer.valueOf(in.readLine());

	for (int i = 0; i < N; i++) {

	    int length = Integer.valueOf(in.readLine());

	    int[] array = new int[length];
	    String line = in.readLine();
	    String[] l = line.split(" ");
	    for (int j = 0; j < l.length; j++) {
		array[j] = Integer.valueOf(l[j]);
	    }

	    int evenN = 0;
	    int oddN = 0;
	    for (int a : array) {
		if ((a & 1) == 0) {
		    evenN++;
		} else {
		    oddN++;
		}
	    }

	    int[] AI = new int[oddN];
	    int[] BI = new int[evenN];

	    int v = 0;
	    int w = 0;
	    for (int u = 0; u < array.length; u++) {
		if ((array[u] & 1) == 0) {
		    BI[w++] = u;
		} else {
		    AI[v++] = u;
		}
	    }

	    for (int q = oddN; q > 0; q--) {

		for (int p = 0; p < q - 1; p++) {
		    int index1 = AI[p];
		    int index2 = AI[p + 1];

		    if (array[index1] > array[index2]) {
			int temp = array[index1];
			array[index1] = array[index2];
			array[index2] = temp;
		    }
		}

	    }

	    for (int q = evenN; q > 0; q--) {
		for (int p = 0; p < q - 1; p++) {
		    int index1 = BI[p];
		    int index2 = BI[p + 1];

		    if (array[index1] < array[index2]) {
			int temp = array[index1];
			array[index1] = array[index2];
			array[index2] = temp;
		    }
		}
	    }

	    out.print("Case #" + (i + 1) + ":");
	    for (int x = 0; x < array.length; x++) {
		out.print(" " + array[x]);
	    }
	    out.println();

	}

	out.close();
    }
}
