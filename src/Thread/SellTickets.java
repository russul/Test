package Thread;

public class SellTickets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		A a = new A();
//		A b = new A();
//		Thread t1 = new Thread(a,"����1");
//		Thread t2 = new Thread(a,"����2");
//		Thread t3 = new Thread(a,"����3");
//		//����t1t4�����߳���������A���ʵ����������ģ�����������Ψһ�ģ�����ס
//		Thread t4 = new Thread(b,"����4");
//		t1.start();
////		t2.start();
////		t3.start();
//		t4.start();
		
//		ͨ���̳еķ�ʽ�������̻߳ᷢ�֣�ͬ����������ʧЧ�ˣ�����Ϊͬ��������this������������b1,b2����Ψһ
//		����취��ʹ��ͬ������飬ͨ������static�ؼ��ֶ���һ��Ψһ�������������Դ
//		����Ƽ���ʵ�ֽӿ�Runnable�������߳�
		B b1 = new B();
		B b2 = new B();
		b1.setName("����1");
		b2.setName("����2");

		b1.start();
		b2.start();
	}

}


class A implements Runnable{

	private int tickets = 100;
	private Object o = new Object();  //������
	private int x = 0;
	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//		while(true){   //ģ���ӰԺһֱ��Ʊ����
//			synchronized(o) {
//				if(tickets>0){
//					try {
//						Thread.sleep(100);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					
//					System.out.println(Thread.currentThread().getName() + "���ڳ��۵�" + tickets-- + "��Ʊ");
//				}
//		}
//	  }
//	}
	
//	public void run() {
//	// TODO Auto-generated method stub
//		while(true){   //ģ���ӰԺһֱ��Ʊ����
//			if(x%2==0){
//				synchronized(o) {  //�������л����������Ϊͬ������������ͬ��������������һ����ֻ�н�������ĳ�this���ſ�����������
//				if(tickets>0){
//					try {
//						Thread.sleep(100);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					
//					System.out.println(Thread.currentThread().getName() + "���ڳ��۵�" + tickets-- + "��Ʊ");
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
//				System.out.println(Thread.currentThread().getName() + "���ڳ��۵�" + tickets-- + "��Ʊ");
//			}
//	}

	
	public void run() {
	// TODO Auto-generated method stub
		while(true){   //ģ���ӰԺһֱ��Ʊ����
			if(x%2==0){
				synchronized(this) {  //�������л����������Ϊͬ������������ͬ��������������һ����ֻ�н�������ĳ�this���ſ����������У����Կ�����ͨͬ������������this����
				if(tickets>0){
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					System.out.println(Thread.currentThread().getName() + "���ڳ��۵�" + tickets-- + "��Ʊ");
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
				
				System.out.println(Thread.currentThread().getName() + "���ڳ��۵�" + tickets-- + "��Ʊ");
			}
	}
}


//�̳з�ʽ�����߳�
class B extends Thread{
	private  static int tickets = 100;
	//����һ���������������Դ
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
//			System.out.println(Thread.currentThread().getName() + "���ڳ��۵�" + tickets-- + "��Ʊ");
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
				
				System.out.println(Thread.currentThread().getName() + "���ڳ��۵�" + tickets-- + "��Ʊ");
			}
		}
	}
 }
}