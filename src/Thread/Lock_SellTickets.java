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
							
							System.out.println(Thread.currentThread().getName() + "���ڳ��۵�" + tickets-- + "��Ʊ");
						}
			}finally{ //����catch��try��䣬��ֹ�����ͷŶ���ɵ���������
			lock.unlock();}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Lock_SellTickets lst = new Lock_SellTickets();
		Thread t1 = new Thread(lst,"����1");
		Thread t2 = new Thread(lst,"����2");
		Thread t3 = new Thread(lst,"����3");
		t1.start();
		t2.start();
		t3.start();
		
	}

}
