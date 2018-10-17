package ProducerConsumer;
/*
 * 设置资源类（生产者）
 * 它是一个线程类
 * 
 * 
 */
public class SetStudent implements  Runnable {
	
	//涉及多个类共享一个资源，学生资源，可以通过外部定义通过构造方法传入
	private Student s;
	
	public int i = 0;
	public SetStudent(Student s) {
		
		this.s = s;
	}


	public void run() {
		while(true){
			synchronized(s){ //我们巧妙的将Student对象当做锁，省的再去单独定义
				
				if(s.flag){  //如果有资源，生产者就等待
					try {
						s.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				//如果没有，就进行生产
				if(i%2==0){
					s.setName("Tom");
					s.setAge(3);	
				}else{
					s.setName("Jerry");
					s.setAge(5);	
				}
				i++;
//				
					
				//生产结束后，改变标志位
				s.flag = true;
				//通知消费者进行消费
				s.notify();
				}
			}
			
	}
}