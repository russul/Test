package Thread;

public class TestThread1 {
	public static void main(String[] args){
		Runner s = new Runner();
		//s.run();//���÷���
		//Thread t = new Thread(s);
		s.start();//�����߳�
		for(int i=0;i<100;i++){
			System.out.println("thread__"+" "+i);
			
		}
		
	}
}

//class Runner implements Runnable {
class Runner extends Thread{
	public void run(){
		for(int i =0 ; i< 100; i++){
			System.out.println("count__"+"  "+i);
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
