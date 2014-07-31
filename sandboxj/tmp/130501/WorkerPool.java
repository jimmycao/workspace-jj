package cn.ggs.abase.thread.book;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class WorkerPool {
	private static final int NTHREADS = 10;
	public static void main(String[] args) {
		long MAX = 100;
		ExecutorService executor = Executors.newFixedThreadPool(NTHREADS);
		for (int i = 0; i < 500; i++) {
			WorkerRunnable worker = new WorkerRunnable(MAX+i);
			executor.execute(worker);
		}
		
		executor.shutdown();
		while(!executor.isTerminated()) {
			System.out.println("not finished yet!");
		}
		
		System.out.println("all finished!");
			
	}

}
