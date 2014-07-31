package cn.ggs.abase.thread;

public class BankWithSync {
	private double[] accounts;
	
	public BankWithSync(int n, double init) {
		this.accounts = new double[n];
		for (int i = 0; i < n; i++) {
			this.accounts[i] = init;
		}
	}
	
	public synchronized void transfer(int from, int to, double sum) throws InterruptedException {
		if (accounts[from] < sum) 
			wait();
		System.out.println(Thread.currentThread());
		accounts[from] -= sum;
		accounts[to] += sum;
		System.out.println("total = " + getTotal());
		notifyAll();
	}
	
	public synchronized double getTotal() {
		double total = 0;
		for (double a : accounts)
			total += a;
		return total;
	}

	public int size() {
		return this.accounts.length;
	}
}