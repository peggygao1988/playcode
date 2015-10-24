package org.peggygao.algs.number;

public class FindNumberAppearOnce {

    private static int findFirst1Bit(int n) {

	int index = 0;
	int key = 1;
	while (index < 32) {

	    if ((n & key) != 0) {
		return index;
	    }
	    index++;
	    key = key << 1;
	}

	return index;

    }

    private static boolean isBit1(int num, int k) {
	num = num >> k;
	return (num & 1) == 1;
    }

    
    private static void find(int[] a){
	if(a==null ||a.length ==0){
	    return;
	}
	
	int resultExclusiveOr = 0;
	for(int i = 0 ; i< a.length; i++){
	    resultExclusiveOr ^=a[i];
	}
	
	
	int indexBit = findFirst1Bit(resultExclusiveOr);
	System.out.println(indexBit);
	int num1 = 0;
	int num2 = 0;
	
	for(int i = 0 ;i<a.length ; i++){
	    int n = a[i];
	    
	    if(isBit1(n, indexBit)){
		num1 ^= n;
	    }else{
		num2 ^= n;
	    }
	}
	
	System.out.printf("%d  %d", num1,num2);
    }
    public static void main(String[] args) {
	find(new int[]{2,4});

    }

}
