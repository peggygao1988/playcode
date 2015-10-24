package org.peggygao.algs.array;

/**
 * rotate matrix clockwise 90-degree
 * 
 * @author peggygao
 * 
 */

public class MatrixRotate {

    private static void rotate(int[][] matrix) {

	int N = matrix.length;
	for (int layer = 0; layer * 2 < N; layer++) {

	    for (int i = layer; i < N - 1 - layer; i++) {

		int temp = matrix[layer][i];
		matrix[layer][i] = matrix[N - 1 - i][layer];
		matrix[N - 1 - i][layer] = matrix[N - 1 - layer][N - 1 - i];
		matrix[N - 1 - layer][N - 1 - i] = matrix[i][N - 1 - layer];
		matrix[i][N - 1 - layer] = temp;

	    }

	}

    }

    private static void print(int[][] matrix) {
	int N = matrix.length;

	for (int i = 0; i < N; i++) {

	    for (int j = 0; j < N; j++) {
		System.out.print(matrix[i][j] + " ");
	    }
	    System.out.println();
	}
    }

    public static void main(String[] args) {

	int[][] m = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
		{ 13, 14, 15, 16 } };

	print(m);
	rotate(m);
	print(m);
    }

}
