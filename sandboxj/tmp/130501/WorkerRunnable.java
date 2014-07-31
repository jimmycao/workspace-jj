package cn.ggs.abase.thread.book;

public class WorkerRunnable implements Runnable {
	private final long MAX;
	
	public WorkerRunnable (long max) {
		this.MAX = max;
	}
	
	public void run() {
		long total = 0;
		for (int i = 0; i < this.MAX; i++) {
			total += i;
		}
		System.out.println(Thread.currentThread() + " ::: " + total);
	}
}
