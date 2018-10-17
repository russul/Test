package Thread;

import java.util.Date;

public class TestThreadControlDemo {
	public static void main(String[] args){
		TestThread_3 my = new TestThread_3();
//		Thread t1 = new Thread(my,"first");
//		Thread t2 = new Thread(my,"second");
//		t1.start();
//		public final void join()
//                throws InterruptedException
//			Waits for this thread to die.
//				An invocation of this method behaves in exactly the same way as the invocation
//
//				join(0)
		//线程加入
//		try {
//			t1.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		

//		t2.start();
		
		
//		public final void setDaemon(boolean on)守护线程
//		Marks this thread as either a daemon thread or a user thread. 
//		The Java Virtual Machine exits when the only threads running are all daemon threads.
//		当线程全是守护线程时，jvm将自动退出
//		This method must be invoked before the thread is started.
		
//		Thread t2 = new Thread(my,"关羽");
//		Thread t3 = new Thread(my,"张飞");
//		t2.setDaemon(true);
//		t3.setDaemon(true);
//		t2.start();
//		t3.start();
//		Thread.currentThread().setName("刘备");
//		for(int i= 0;i <5;i++){
//			System.out.println(Thread.currentThread().getName() + ":" + i);
//		}
		
		Thread t1 = new Thread(my,"first");	
		t1.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		t1.stop();
//		t1.interrupt();
		my.shutdown();
	}
}


class TestThread_3 implements Runnable{
	private boolean flag = true;
	@Override
	public void run() {
		// TODO Auto-generated method stub
	 if(flag){
		
			System.out.println("线程启动时间" + ":" + new Date());
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("线程结束时间" + ":" + new Date());
	 }	
		
	}
	
	public void shutdown(){
		flag = false;
	}

//	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//		for(int i = 0;i < 100;i++){
//			
////			public static native void sleep(long millis) throws InterruptedException;
////			try {
////				Thread.sleep(100);
////			} catch (InterruptedException e) {
////				// TODO Auto-generated catch block
////				e.printStackTrace();
////			}
//			System.out.println(Thread.currentThread().getName() + ":" + i);
////			线程礼让
////			public static void yield()
////			A hint to the scheduler that the current thread is willing to yield its current use of a processor.
////			The scheduler is free to ignore this hint.
////			让出CPU执行权，暂停自己的执行
////			不能保证各执行一次
////			Thread.yield();
//		}
//	
//	}
	
	
}