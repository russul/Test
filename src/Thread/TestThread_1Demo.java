package Thread;
/*
 * @kevin
 * 2018-5-10
 * �̳�Thread��ʵ�ֶ��߳�
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
		System.out.println("���ǵ�"+ i +"��" + ' ' + Thread.currentThread().getName());
		
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

	