package Thread;

public class Test implements Runnable {
	T t = new T();
	public static void main(String[] args) {
		
		Test test = new Test();
		Thread t1 = new Thread(test);
		Thread t2 = new Thread(test);
		t1.setName("t1");
		t2.setName("t2");
		t1.start();
		t2.start();
	}

	@Override
	public void run() {
		
	
		t.add();
	}

}
class T {
	private static int number = 0;
	public  void add(){
		synchronized(this){
		number ++;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+" " + "is" +" " + number +" " + "Thread");
	}
	}

}