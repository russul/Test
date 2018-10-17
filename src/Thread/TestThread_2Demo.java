package Thread;
/*
 * @kevin
 * 2018 -5-10
 * 实现Runnable接口实现多线程
 * 
 * 
 */
public class TestThread_2Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestThread_2 t = new TestThread_2();
		Thread t1 = new Thread(t);
		Thread t2 = new Thread(t);
		
//		public final void setPriority(int newPriority)
		t1.setPriority(10);
		t2.setPriority(1);
		t1.start();
		t2.start();
	}

}


class TestThread_2 implements Runnable{

	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//		for(int i = 0;i < 100;i++){
//			System.out.println(i);
//		}
//	}
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0;i < 100;i++){
			System.out.println(Thread.currentThread().getName() + ":" + i);
		}
	}
	
}