import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SudokuChecker {

    public static void main(String[] args) throws IOException {
	BufferedReader in = new BufferedReader(new FileReader("A-large.in"));

	PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
		"A-large.out")));

	int T = Integer.parseInt(in.readLine());

	for (int i = 0; i < T; i++) {

	    boolean result = true;

	    int N = Integer.parseInt(in.readLine());

	    boolean[] marked = new boolean[N * N + 1];

	    int[][] matrix = new int[N * N][N * N];

	    for (int j = 0; j < N * N + 1; j++) {
		marked[j] = false;
	    }

	    for (int j = 0; j < N * N; j++) {
		String[] line = in.readLine().split(" ");
		for (int k = 0; k < N * N; k++) {
		    matrix[j][k] = Integer.parseInt(line[k]);
		}
	    }

	    for (int j = 0; result == true && j < N * N; j++) {
		for (int k = 0; k < N * N + 1; k++) {
		    marked[k] = false;
		}

		for (int w = 0; result == true && w < N * N; w++) {
		    int n = matrix[j][w];
		    if (n < 1 || n > N * N) {
			result = false;
			break;
		    }
		    marked[n] = true;
		}

		for (int u = 1; result == true && u < N * N + 1; u++) {

		    if (marked[u] == false) {
			result = false;
			break;
		    }
		}

	    }

	    for (int j = 0; result == true && j < N * N; j++) {
		for (int k = 0; k < N * N + 1; k++) {
		    marked[k] = false;
		}

		for (int w = 0; result == true && w < N * N; w++) {
		    int n = matrix[w][j];
		    if (n < 1 || n > N * N) {
			result = false;
			break;
		    }
		    marked[n] = true;
		}

		for (int u = 1; result == true && u < N * N + 1; u++) {

		    if (marked[u] == false) {
			result = false;
			break;
		    }
		}

	    }

	    for (int j = 0; result == true && j < N; j++) {
		for (int k = 0; result == true && k < N; k++) {

		    for (int w = 0; w < N * N + 1; w++) {
			marked[w] = false;
		    }

		    for (int w = 0; result == true && w < N; w++) {
			for (int v = 0; result == true && v < N; v++) {

			    int n = matrix[j * 3 + w][k * 3 + v];
			    if (n < 1 || n > N * N) {
				result = false;
				break;
			    }
			}
		    }

		}
	    }

	    out.println(String.format("Case #%d: %s", i + 1,
		    result == true ? "Yes" : "No"));
	}

	out.close();

    }

}
