package org.peggygao.algs.array;

/**
 * find subsquare with four borders are filled with black pixels
 * 
 * @author peggygao
 * 
 */
public class FindSubSquare {

    private static boolean isSquare(int[][] matrix, int row, int col, int size) {

	for (int i = 0; i < size; i++) {
	    if (matrix[row][col + i] == 1)
		return false;

	    if (matrix[row + size - 1][col + i] == 1)
		return false;

	    if (matrix[row + i][col] == 1)
		return false;
	    if (matrix[row + i][col + size - 1] == 1)
		return false;
	}

	return true;
    }

    private static int findMaxSubSquare(int[][] matrix) {

	int max = 0;
	int col = 0;
	int N = matrix.length;
	while (N - col > max) {

	    for (int row = 0; row < N; row++) {

		int size = N - Math.max(col, row);

		while (size > max) {
		    if (isSquare(matrix, row, col, size)) {
			max = size;
			break;
		    }

		    size--;
		}
	    }
	    col++;

	}

	return max;
    }

    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }

}
