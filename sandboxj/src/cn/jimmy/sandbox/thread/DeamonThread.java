package cn.jimmy.sandbox.thread;

public class DeamonThread implements Runnable {
	private int ticketNum = 100;
	
	public void run(){
		while(true){
			if(ticketNum > 0)
				System.out.println(Thread.currentThread().getId()+", left tickets:" + (--ticketNum));
			else break;
		}
	}
	
	public static void main(String[] args) {
		DeamonThread dt = new DeamonThread();

	}

}
