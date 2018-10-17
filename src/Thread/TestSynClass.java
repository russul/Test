package Thread;

public class TestSynClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	JvmThread jvm1 = new JvmThread(100);
	JvmThread jvm2 = new JvmThread(500);
	jvm1.start();
	jvm2.start();

	/*俩个线程访问同一分资源，因为static 修饰的资源只有一份，没有锁定时，出现创建了两个对象，不符合单例设计，
	   1.同步方法即可
	   2.同步块
	 * 
	 */
	}

}

class JvmThread extends Thread{
	private long time ;
	JvmThread(long time){
		this.time = time;
	}
	public void run(){
		try {
			System.out.println(Thread.currentThread().getName() +"-->" + "创建对象：" + Jvm.getInstance1(time));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}  
}

class Jvm {
	private static Jvm instance = null;
	//声明一个静态变量
	/*private Jvm(){
		
		
	}*/
	//私有化构造器
	public static synchronized Jvm getInstance(long time) throws InterruptedException{
		if(instance == null){
			Thread.sleep(time);//模拟创建对象延时,放大错误，可能出现两个不同的对象
		    instance = new Jvm();
		}
		return instance;
	}
	//创建一个对外的静态方法访问静态变量，如果没有对象，创建对象；
	
	public static Jvm getInstance1(long time) throws InterruptedException{
		if(null == instance){//如果已经创建对象则直接返回对象，以此提高效率
		synchronized(Jvm.class){
			//效率低，源于任何进程都要等待，无论已经创建对象
		if(instance == null){  // 确保安全
			Thread.sleep(time);//模拟创建对象延时,放大错误，可能出现两个不同的对象
		    instance = new Jvm();
		  }
		 }
		
		}
		return instance;
	
 }
	//创建一个对外的静态方法访问静态变量，如果没有对象，创建对象；
	
}