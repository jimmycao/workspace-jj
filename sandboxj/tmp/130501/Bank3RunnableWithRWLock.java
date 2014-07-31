package cn.ggs.abase.thread.book;


public class Bank3RunnableWithRWLock implements Runnable {
	private Bank3WithRWLock bank;
	private int from;
	private double maxSum;
	private final int DELAY = 10;
	
	public Bank3RunnableWithRWLock(Bank3WithRWLock bank, int from, double maxSum) {
		this.bank = bank;
		this.from = from;
		this.maxSum = maxSum;
	}
	
	public void run() {
		while (true) {
			int to = (int)(this.bank.size() * Math.random());
			double sum = this.maxSum * Math.random();
			try {
				this.bank.transfer(from, to, sum);
				Thread.sleep((long)(this.DELAY * Math.random()));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	
	public static void main(String[] args) {
		int n_account = 10;
		double init = 1000;
		Bank3WithRWLock bank = new Bank3WithRWLock(n_account, init);
		for (int i= 0; i < n_account; i++) {
			Bank3RunnableWithRWLock r = new Bank3RunnableWithRWLock(bank, i, init);
			Thread t = new Thread(r);
			t.start();
		}
	}
}