package cn.ggs.abase.thread;

public class BankRunnableWithSync implements Runnable {
	private BankWithSync bank;
	private int from;
	private double maxSum;
	private final int DEALY = 10;
	
	public BankRunnableWithSync(BankWithSync bank, int from, double maxSum) {
		this.bank = bank;
		this.from =  from;
		this.maxSum = maxSum;
	}	

	public void run() {
		while (true) { 
			int to = (int) (this.bank.size() * Math.random());
			double sum = this.maxSum * Math.random();
			try {
				this.bank.transfer(from, to, sum);
				Thread.sleep((int) (this.DEALY * Math.random()));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		int n_account = 10;
		double init = 1000;
		BankWithSync bank = new BankWithSync(n_account, init);
		for (int i = 0; i < n_account; i++) {
			BankRunnableWithSync r = new BankRunnableWithSync(bank, i, init);
			Thread t = new Thread(r);
			t.start();
		}
	}
}