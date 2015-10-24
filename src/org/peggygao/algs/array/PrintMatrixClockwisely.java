package org.peggygao.algs.array;

public class PrintMatrixClockwisely {

    private static void printMatrix(int[][] matrix) {

	int row = matrix.length;
	int column = matrix[0].length;

	int start = 0;
	while (row > start * 2 && column > start * 2) {
	    printCircle(matrix, start, row, column);
	    start++;
	}
    }

    private static void printCircle(int[][] matrix, int start, int row,
	    int column) {

	int endX = column - 1 - start;
	int endY = row - 1 - start;

	for (int i = start; i <= endX; i++) {
	    print(matrix[start][i]);
	}
	for (int i = start + 1; i <= endY; i++) {
	    print(matrix[i][endX]);
	}
	for (int i = endX - 1; i >= start && start < endY; i--) {
	    print(matrix[endY][i]);
	}

	for (int i = endY - 1; i >= start + 1 && start < endX; i--) {
	    print(matrix[i][start]);
	}

    }

    private static void print(int number) {
	System.out.print(number + "\t");
    }

    public static void main(String[] args) {
	int[][] m = { { 1 } };
	printMatrix(m);

    }

}
