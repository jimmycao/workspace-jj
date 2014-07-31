package cn.ggs.abase.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankWithLock {
	private double[] accounts;
	private Lock bankLock;
	private Condition con;
	
	public BankWithLock(int n, double init) {
		this.accounts = new double[n];
		for (int i = 0; i < n; i++) {
			this.accounts[i] = init;
		}
		this.bankLock = new ReentrantLock();
		this.con = this.bankLock.newCondition();
	}
	
	public void transfer(int from, int to, double sum) throws InterruptedException {
		this.bankLock.lock();
		try {
			if (accounts[from] < sum) { 
				this.con.await();
			}
			
			System.out.println(Thread.currentThread());
			accounts[from] -= sum;
			accounts[to] += sum;
			System.out.println("total = " + getTotal());
			
			this.con.signalAll();
		} finally {
			this.bankLock.unlock();
		}
	}
	
	public double getTotal() {
		this.bankLock.lock();
		try {
			double total = 0;
			for (double a : accounts) {
				total += a;
			}
			return total;
		} finally {
			this.bankLock.unlock();
		}
	}
	
	public int size() {
		return this.accounts.length;
	}
}
