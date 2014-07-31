package cn.ggs.abase.thread;

public class Bank22SyncObject {
	private double[] accounts;
	private Object obj = new Object(); 
	
	public Bank22SyncObject(int n, double init) {
		this.accounts = new double[n];
		for (int i = 0; i < n; i++) 
			this.accounts[i] = init;
	}
	
	public void transfer(int from, int to, double sum) throws InterruptedException {
		synchronized(obj) {
//			while (accounts[from] < sum) {  //must remove such synchronization
//				wait();
//			}
			
			System.out.println(Thread.currentThread());
			accounts[from] -= sum;
			accounts[to] += sum;
			System.out.println("total = " + getTotal());
			
//			notifyAll();
		} 
	}
	
	public double getTotal() {
		synchronized(obj) {
			double total = 0;
			for (double a : accounts) {
				total += a;
			}
			return total;
		}
	}
	
	public int size() {
		return this.accounts.length;
	}

}
