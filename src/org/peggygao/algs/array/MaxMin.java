package org.peggygao.algs.array;

/**
 * find max and min in an array with minimun compare
 * 
 * @author peggygao
 * 
 */
public class MaxMin {

    private static class Result {
	int max;
	int min;

	public Result(int max, int min) {
	    super();
	    this.max = max;
	    this.min = min;
	}

	public Result() {
	}

    }

    private static Result search(int[] a, int start, int end) {

	if (end - start <= 1) {
	    Result result = new Result();

	    result.max = a[start] > a[end] ? a[start] : a[end];
	    result.min = a[start] < a[end] ? a[start] : a[end];

	    return result;
	}

	int mid = start + (end - start) / 2;

	Result leftResult = search(a, start, mid);
	Result rightResult = search(a, mid + 1, end);

	Result finalResult = new Result();
	finalResult.max = leftResult.max > rightResult.max ? leftResult.max
		: rightResult.max;
	finalResult.min = leftResult.min < rightResult.min ? leftResult.min
		: rightResult.min;

	return finalResult;

    }

    public static void main(String[] args) {

	int[] a = new int[] { 5, 6, 8, 3, 7, 9 };
	Result result = search(a, 0, a.length - 1);
	System.out.println(result.max + "  " + result.min);
    }

}
