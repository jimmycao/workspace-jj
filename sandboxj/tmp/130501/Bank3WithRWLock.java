package cn.ggs.abase.thread.book;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Bank3WithRWLock {
	private double[] accounts;
	private ReadWriteLock rwLock;
	private Lock readLock;
	private Lock writeLock;
	private Condition con;
	
	public Bank3WithRWLock(int n, double init) {
		this.accounts = new double[n];
		for (int i = 0; i < n; i++) {
			this.accounts[i] = init;
		}
		this.rwLock =  new ReentrantReadWriteLock();
		this.readLock = this.rwLock.readLock();
		this.writeLock = this.rwLock.writeLock();
		this.con =  this.writeLock.newCondition();
	}
	
	public void transfer(int from, int to, double sum) throws InterruptedException {
		this.writeLock.lock();
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
			this.writeLock.unlock();
		}
	}
	
	public double getTotal() {
		this.readLock.lock();
		try {
			double total = 0;
			for (double a : accounts) {
				total += a;
			}
			return total;
		} finally {
			this.readLock.unlock();
		}
	}
	
	public int size() {
		return this.accounts.length;
	}
}
