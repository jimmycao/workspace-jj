package cn.ggs.abase.thread;

public class Bank22RunnableSyncObject implements Runnable {
	private Bank22SyncObject bank;
	private int from;
	private double maxSum;
	private final int DELAY = 10;
	
	public Bank22RunnableSyncObject(Bank22SyncObject bank, int from, double maxSum) {
		this.bank = bank;
		this.from = from;
		this.maxSum = maxSum;
	}

	public void run() {
		while (true)
			try {
				{
					int to = (int) (this.bank.size() * Math.random());
					double sum = this.maxSum * Math.random();
					this.bank.transfer(from, to, sum);
					Thread.sleep((long) (this.DELAY * Math.random()));
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}

	public static void main(String[] args) {
		int n_account = 10;
		double init = 1000;
		Bank22SyncObject bank = new Bank22SyncObject(n_account, init);
		for (int i = 0; i < n_account; i++) {
			Bank22RunnableSyncObject r = new Bank22RunnableSyncObject(bank, i, init);
			Thread t = new Thread(r);
			t.start();
		}
	}
}
