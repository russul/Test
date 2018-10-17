package Thread;
/*
 * @kevin
 * 2018-5-10
 * 继承Thread类实现多线程
 * 
 * 
 */
public class TestThread_1Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestThread_1 t1 = new TestThread_1();
		TestThread_1 t2 = new TestThread_1();
		t1.start();
		t2.start();
		for(int i = 0;i < 50;i++)
		System.out.println("这是第"+ i +"个" + ' ' + Thread.currentThread().getName());
		
	}

}



class TestThread_1 extends Thread{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0;i < 100;i++){
			System.out.println(getName() + ":" + i);
		}
	}
}

	