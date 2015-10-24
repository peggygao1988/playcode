package org.peggygao.algs.exercise;

public class YoungMatrix
{

	public static boolean search(int[][] array, int key)
	{

		int row = array.length;
		int col = array[0].length;

		int i = row - 1;
		int j = 0;
		while (i >= 0 && j < col)
		{

			if (array[i][j] < key)
			{
				j++;
			}
			else if (array[i][j] > key)
			{
				i--;
			}
			else
			{
				System.out.println("find at : " + i + " " + j);
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args)
	{
		int[][] array = { { 1, 2, 4, 8 }, { 3, 3, 7, 12 }, { 4, 5, 9, 14 }, { 7, 8, 11, 17 } };
		System.out.println(search(array, 17));
	}

}
