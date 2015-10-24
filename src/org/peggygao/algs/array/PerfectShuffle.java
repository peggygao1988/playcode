package org.peggygao.algs.array;

public class PerfectShuffle {

    private static void shuffle(int[] a) {

	for (int i = 0; i < a.length; i++) {
	    int j = (int) (Math.random() * (a.length - i) + i);
	    int temp = a[i];
	    a[i] = a[j];
	    a[j] = temp;
	}

    }

    private static int[] pickMRandomly(int[] original,int m){
	
	int[] subset = new int[m];
	int[] array = original.clone();
	for(int j = 0 ;j < m ; j++){
	    int index = (int) (Math.random()*(array.length-j)+j);
	    subset[j] = array[index];
	    array[index] = array[j];
	}
	
	return subset;
    }
    public static void main(String[] args) {

	int[] a = { 1, 2, 3, 4, 5 };
	shuffle(a);
	for (int i : a) {
	    System.out.print(i + "\t");
	}
	System.out.println();
	
    }

}
