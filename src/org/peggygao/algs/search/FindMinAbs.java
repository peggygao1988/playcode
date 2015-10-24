package org.peggygao.algs.search;

import java.util.Arrays;

import org.peggygao.algs.utils.StdRandom;

public class FindMinAbs
{

	private static int findMinAbs(int[] a)
	{
		int length = a.length;
		if (a[length - 1] <= 0)
		{
			return Math.abs(a[length - 1]);
		}
		if (a[0] >= 0)
		{
			return a[0];
		}
		int low = 0;
		int high = a.length - 1;

		while (low <= high)
		{
			int middle = (low + high) / 2;
			if (a[middle] == 0)
			{
				return 0;
			}

			else if (a[middle] > 0)
			{

				if (a[middle - 1] <= 0)
				{
					return Math.min(-1 * a[middle - 1], a[middle]);
				}
				else
				{
					high = middle - 1;
				}
			}
			else if (a[middle] < 0)
			{
				if (a[middle + 1] >= 0)
				{
					return Math.min(-1 * a[middle], a[middle + 1]);
				}
				else
				{
					low = middle + 1;
				}
			}

		}

		return -1;

	}

	public static void main(String[] args)
	{

		int[] a = new int[100];
		for (int i = 0; i < 100; i++)
		{
			a[i] = StdRandom.uniform(-1000, 0);
		}

		Arrays.sort(a);
		for (int k : a)
		{
			System.out.printf("%d ", k);
		}
		System.out.println();
		System.out.println(findMinAbs(a));
	}
}
