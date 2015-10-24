package org.peggygao.algs.exercise;

public class Fibonaci
{

	public static int F(int n)
	{
		int[] a = { 0, 1 };
		int flag = 0;
		if (n == 0)
			return a[0];
		if (n == 1)
			return a[1];

		for (int i = 2; i <= n; i++, flag++)
		{
			a[flag % 2] = a[0] + a[1];
		}
		return a[(flag - 1) % 2];
	}

	public static void main(String[] args)
	{
		for (int i = 0; i < 10; i++)
		{
			System.out.print(F(i));
			System.out.print("  ");

		}
	}
}
