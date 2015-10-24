package org.peggygao.algs.multithread;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class ProduceConsume {

    public static class BoundedHashSet<T> {
	private final Set<T> set;
	private final Semaphore sem;

	public BoundedHashSet(int bound) {
	    this.set = Collections.synchronizedSet(new HashSet<T>());
	    this.sem = new Semaphore(bound);
	}

	public boolean add(T o) throws InterruptedException {

	    sem.acquire();
	    boolean wasAdded = false;
	    try {
		wasAdded = set.add(o);
		return wasAdded;
	    } finally {
		if (!wasAdded) {
		    sem.release();
		}
	    }
	}

	public boolean remove(T o) {
	    boolean wasRemoved = set.remove(o);
	    if (wasRemoved) {
		sem.release();
	    }

	    return wasRemoved;
	}

    }

    public static class Produce extends Thread {

	private int index = 0;
	private final Semaphore semEmpty;
	private final Semaphore semFull;

	public Produce(Semaphore semEmpty, Semaphore semFull) {
	    this.semEmpty = semEmpty;
	    this.semFull = semFull;
	}

	@Override
	public void run() {
	    while (index < 10) {
		try {

		    semEmpty.release();
		    index++;
		    semFull.acquire();
		    System.out.println("produce : " + index + " "
			    + semFull.toString() + " " + semEmpty.toString());
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
	    }
	}
    }

    public static class Consume extends Thread {
	private int index = 10;
	private final Semaphore semEmpty;
	private final Semaphore semFull;

	public Consume(Semaphore semEmpty, Semaphore semFull) {
	    this.semEmpty = semEmpty;
	    this.semFull = semFull;
	}

	@Override
	public void run() {
	    while (index > 0) {
		try {
		    semFull.release();
		    index--;
		    semEmpty.acquire();
		    System.out.println("consume : " + index + " "
			    + semFull.toString() + " " + semEmpty.toString());
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
	    }
	}
    }

    public static void main(String[] args) {
	Semaphore semEmpty = new Semaphore(10);
	Semaphore semFull = new Semaphore(0);
	ExecutorService exec = Executors.newCachedThreadPool();

	exec.execute(new Produce(semEmpty, semFull));
	exec.execute(new Consume(semEmpty, semFull));

    }

}
