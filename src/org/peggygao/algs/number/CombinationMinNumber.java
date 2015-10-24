package org.peggygao.algs.number;

import java.util.Arrays;
import java.util.Comparator;

public class CombinationMinNumber {
    
    
    private static class CComparator implements Comparator<String>{

	@Override
	public int compare(String c1, String c2) {
	    String com1 = c1+c2;
	    String com2 = c2+c1;
	    return com1.compareTo(com2);
	 
	}
	
    }
    
    
    private static void printMin(int[] numbers){
	String[] strings = new String[numbers.length];
	
	for(int i = 0 ; i< numbers.length;i++){
	    strings[i] = Integer.toString(numbers[i]);
	}
	
	Arrays.sort(strings, new CComparator());
	
	for(int i = 0 ; i< strings.length;i++){
	    System.out.print(strings[i]);
	}
	System.out.println();
    }

    public static void main(String[] args) {
	printMin(new int[]{345,678,174});

    }

}
