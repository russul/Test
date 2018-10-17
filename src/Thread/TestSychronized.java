package Thread;

public class TestSychronized implements Runnable {
	int a = 100;
	
	public static void main(String[] args) {
		TestSychronized mm = new TestSychronized();
		Thread m = new Thread(mm);
		m.start();
		//mm.m1();
		mm.m2();

	}

	@Override
	public void run() {
		synchronized(this){
			//System.out.println("xianchengqi");
			m1();
		}
	}
	public synchronized void m1(){
	
		a = 1000;
		System.out.println(a);
		
	}
	public synchronized void m2(){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		a = 2000;
		System.out.println("a = "+ a);
	}
}
