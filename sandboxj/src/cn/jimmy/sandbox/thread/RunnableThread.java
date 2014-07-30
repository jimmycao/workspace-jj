package cn.jimmy.sandbox.thread;

public class RunnableThread implements Runnable {

	private int ticketNum = 100;
	
	public void run() {
		while(true){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(ticketNum > 0)
				System.out.println(Thread.currentThread().getName()+",left tickets:" + (--ticketNum));
			else break;
		}		
	}

	public static void main(String[] args) {
		RunnableThread t = new RunnableThread();
		new Thread(t).start();
		new Thread(t).start();
		new Thread(t).start();
		new Thread(t).start();
		System.out.println("Main is over, but all thread will go on...");
	}
}
