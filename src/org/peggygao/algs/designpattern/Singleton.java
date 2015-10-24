package org.peggygao.algs.designpattern;

public class Singleton {

   private static Singleton instance;
   private Singleton(){
       
   }
   
   public static Singleton getInstance(){
       if(instance == null){
	   synchronized (Singleton.class) {
	       if(instance == null){
		   instance = new Singleton();
	       }
	}
       }
       return instance;
   }
    
    
    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }

}
