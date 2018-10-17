package Thread;

public class DieLock extends Thread {
	private Boolean flag;
	public DieLock(Boolean flag) {
		// TODO Auto-generated constructor stub
		this.flag = flag;
	}
	
//	@Override
//	public void run() {
//		if(flag){
//			synchronized(MyLock.loc1){
//				System.out.println("if 1");
//			}
//			synchronized(MyLock.loc2){
//				System.out.println("if 2");
//			}
//		}else{
//			synchronized(MyLock.loc2){
//				System.out.println("else 2");
//			}
//			synchronized(MyLock.loc1){
//				System.out.println("else 1");
//			}
//		}
//		
//	}
//	
	public void run() {
		if(flag){
			synchronized(MyLock.loc1){
				System.out.println("if 1");
					synchronized(MyLock.loc2){
						System.out.println("if 2");
				}
			
			}
		}else{	
			synchronized(MyLock.loc2){
				System.out.println("else 2");
				synchronized(MyLock.loc1){
					System.out.println("else 1");
					}
	
				}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DieLock dl1 = new DieLock(true);
		DieLock dl2 = new DieLock(false);
		dl1.start();
		dl2.start();
	}

}



//定义一个锁对象类，包含两把锁
class MyLock{
	public static final Object loc1  = new Object(); 
	public static final Object loc2  = new Object(); 
}