package Thread;

public class SellTickets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		A a = new A();
//		A b = new A();
//		Thread t1 = new Thread(a,"窗口1");
//		Thread t2 = new Thread(a,"窗口2");
//		Thread t3 = new Thread(a,"窗口3");
//		//由于t1t4两个线程是有两个A类的实例对象产生的，所以锁不是唯一的，锁不住
//		Thread t4 = new Thread(b,"窗口4");
//		t1.start();
////		t2.start();
////		t3.start();
//		t4.start();
		
//		通过继承的方式启动多线程会发现，同步方法的锁失效了，是因为同步方法的this锁对象有两个b1,b2，非唯一
//		解决办法：使用同步代码块，通过定义static关键字定义一个唯一共享的锁对象资源
//		因此推荐用实现接口Runnable来启动线程
		B b1 = new B();
		B b2 = new B();
		b1.setName("窗口1");
		b2.setName("窗口2");

		b1.start();
		b2.start();
	}

}


class A implements Runnable{

	private int tickets = 100;
	private Object o = new Object();  //锁对象
	private int x = 0;
	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//		while(true){   //模拟电影院一直有票出售
//			synchronized(o) {
//				if(tickets>0){
//					try {
//						Thread.sleep(100);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					
//					System.out.println(Thread.currentThread().getName() + "正在出售第" + tickets-- + "张票");
//				}
//		}
//	  }
//	}
	
//	public void run() {
//	// TODO Auto-generated method stub
//		while(true){   //模拟电影院一直有票出售
//			if(x%2==0){
//				synchronized(o) {  //这样运行会出现问题因为同步代码块的锁和同步方法的锁不是一个，只有将锁对象改成this，才可以正常运行
//				if(tickets>0){
//					try {
//						Thread.sleep(100);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					
//					System.out.println(Thread.currentThread().getName() + "正在出售第" + tickets-- + "张票");
//					x++;
//				}
//			}
//		}else{
//		  selltickets();
//		  x++;
//		 }
//	  }
//}
//	private synchronized void selltickets(){
//		
//			if(tickets>0){
//				try {
//					Thread.sleep(100);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				
//				System.out.println(Thread.currentThread().getName() + "正在出售第" + tickets-- + "张票");
//			}
//	}

	
	public void run() {
	// TODO Auto-generated method stub
		while(true){   //模拟电影院一直有票出售
			if(x%2==0){
				synchronized(this) {  //这样运行会出现问题因为同步代码块的锁和同步方法的锁不是一个，只有将锁对象改成this，才可以正常运行，可以看出普通同步方法的锁是this对象
				if(tickets>0){
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					System.out.println(Thread.currentThread().getName() + "正在出售第" + tickets-- + "张票");
					x++;
				}
			}
		}else{
		  selltickets();
		  x++;
		 }
	  }
}
	private synchronized void selltickets(){
		
			if(tickets>0){
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println(Thread.currentThread().getName() + "正在出售第" + tickets-- + "张票");
			}
	}
}


//继承方式启动线程
class B extends Thread{
	private  static int tickets = 100;
	//定义一个共享的锁对象资源
	private static Object obj = new Object();
	
	
	
	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//		while(true){
//			selltickets();
//		}
//	}
//
//
//
//
//	private synchronized void selltickets(){
//		
//		if(tickets>0){
//			try {
//				Thread.sleep(300);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//			System.out.println(Thread.currentThread().getName() + "正在出售第" + tickets-- + "张票");
//		}
//}

	
	public void run() {
	// TODO Auto-generated method stub
	while(true){
		synchronized(obj){
			if(tickets>0){
				
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println(Thread.currentThread().getName() + "正在出售第" + tickets-- + "张票");
			}
		}
	}
 }
}