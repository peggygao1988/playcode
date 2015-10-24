package org.peggygao.algs.array;

public class FindIn2DMatrix {

    private static boolean find(int[][] matrix, int key) {

	if (matrix == null) {
	    return false;
	}
	int row = matrix.length;
	int col = matrix[0].length;
	int i = 0;
	int j = col - 1;

	while (i < row && j >= 0) {

	    if (matrix[i][j] == key) {
		return true;
	    } else if (matrix[i][j] > key) {
		j = j - 1;
	    } else {
		i = i + 1;
	    }
	}

	return false;

    }

    public static void main(String[] args) {
	int[][] matrix = { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 },
		{ 6, 8, 11, 15 } };
	System.out.println(find(matrix, 5));
    }

}
