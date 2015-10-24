package org.peggygao.algs.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class ThreeSum {

    public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {

	HashSet<String> set = new HashSet<String>();
	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	Arrays.sort(num);
	for (int i = 0; i < num.length; i++) {

	    int sum = 0 - num[i];

	    int j = i + 1;
	    int k = num.length - 1;

	    while (j < k) {
		if (num[j] + num[k] == sum) {
		    String key = String.valueOf(num[i])
			    + String.valueOf(num[j]) + String.valueOf(num[k]);
		    if (!set.contains(key)) {
			set.add(key);
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(num[i]);
			list.add(num[j]);
			list.add(num[k]);
			result.add(list);
		    }

		    j++;
		} else if (num[j] + num[k] < sum) {
		    j++;
		} else {
		    k--;
		}

	    }

	}

	return result;

    }

    public static int threeSumClosest(int[] num, int target) {

	if (num.length < 3) {
	    return Integer.MAX_VALUE;
	}
	Arrays.sort(num);
	int result = num[0] + num[1] + num[2];
	for (int i = 0; i < num.length - 2; i++) {

	    int j = i + 1;
	    int k = num.length - 1;

	    while (j < k) {
		int sum = num[i] + num[j] + num[k];

		if (Math.abs(sum - target) < Math.abs(result - target)) {
		    result = sum;
		}
		if (sum == target) {
		    return target;
		} else if (sum > target) {
		    k--;
		} else {
		    j++;
		}
	    }
	}

	return result;
    }

    public static void main(String[] args) {

	// int[] a = { -1, 0, 1, 2, -1, -4 };
	//
	// ArrayList<ArrayList<Integer>> result = threeSum(a);
	// for (ArrayList<Integer> l : result) {
	// for (int i : l) {
	// System.out.print(i + " ");
	// }
	// System.out.println();
	// }

	int[] a = { -3, -2, -5, 3, -4 };
	System.out.println(threeSumClosest(a, -1));
    }

}
