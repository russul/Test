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

	/*�����̷߳���ͬһ����Դ����Ϊstatic ���ε���Դֻ��һ�ݣ�û������ʱ�����ִ������������󣬲����ϵ�����ƣ�
	   1.ͬ����������
	   2.ͬ����
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
			System.out.println(Thread.currentThread().getName() +"-->" + "��������" + Jvm.getInstance1(time));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}  
}

class Jvm {
	private static Jvm instance = null;
	//����һ����̬����
	/*private Jvm(){
		
		
	}*/
	//˽�л�������
	public static synchronized Jvm getInstance(long time) throws InterruptedException{
		if(instance == null){
			Thread.sleep(time);//ģ�ⴴ��������ʱ,�Ŵ���󣬿��ܳ���������ͬ�Ķ���
		    instance = new Jvm();
		}
		return instance;
	}
	//����һ������ľ�̬�������ʾ�̬���������û�ж��󣬴�������
	
	public static Jvm getInstance1(long time) throws InterruptedException{
		if(null == instance){//����Ѿ�����������ֱ�ӷ��ض����Դ����Ч��
		synchronized(Jvm.class){
			//Ч�ʵͣ�Դ���κν��̶�Ҫ�ȴ��������Ѿ���������
		if(instance == null){  // ȷ����ȫ
			Thread.sleep(time);//ģ�ⴴ��������ʱ,�Ŵ���󣬿��ܳ���������ͬ�Ķ���
		    instance = new Jvm();
		  }
		 }
		
		}
		return instance;
	
 }
	//����һ������ľ�̬�������ʾ�̬���������û�ж��󣬴�������
	
}