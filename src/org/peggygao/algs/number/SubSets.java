package org.peggygao.algs.number;

import java.util.ArrayList;
import java.util.Arrays;

public class SubSets {

    public static ArrayList<ArrayList<Integer>> subsets(int[] S) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        if(S.length == 0 ){
            result.add(new ArrayList<Integer>());
            return result;
        }
        Arrays.sort(S);
        boolean[] marked = new boolean[S.length];
        for(int i  = 0 ; i <=S.length ; i++){
            dfs(result,S,marked,i,0,0);
        }
        
        return result;
                    
    }
    
    
    private static void dfs( ArrayList<ArrayList<Integer>> result,int[] S,boolean[] marked, int n,int m,int current){
        
        if(m==n){
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int i = 0 ; i < marked.length; i++){
                if(marked[i] == true){
                    list.add(S[i]);
                }
            }
            
            result.add(list);
            return;
        }
        
        if(current >= marked.length){
            return;
        }
        
        
        marked[current] = true;
        dfs(result,S,marked,n,m+1,current+1);
        marked[current] = false;    
        dfs(result,S,marked,n,m,current+1);
        
        
        
    }
    public static void main(String[] args) {

	 ArrayList<ArrayList<Integer>> result = subsets(new int[]{4,1,0});
	 for(ArrayList<Integer> list : result){
	     for(int i : list){
		 System.out.print(i);
	     }
	     
	     System.out.println();
	 }
	 
    }

}
