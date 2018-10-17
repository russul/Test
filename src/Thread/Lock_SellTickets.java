package Thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Lock_SellTickets implements Runnable {

	private int tickets = 100;
	private Lock lock = new ReentrantLock();
	
    
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try{
			lock.lock();
			if(tickets>0){
							
							try {
								Thread.sleep(300);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							System.out.println(Thread.currentThread().getName() + "正在出售第" + tickets-- + "张票");
						}
			}finally{ //不带catch的try语句，防止锁不释放而造成的死锁问题
			lock.unlock();}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Lock_SellTickets lst = new Lock_SellTickets();
		Thread t1 = new Thread(lst,"窗口1");
		Thread t2 = new Thread(lst,"窗口2");
		Thread t3 = new Thread(lst,"窗口3");
		t1.start();
		t2.start();
		t3.start();
		
	}

}
