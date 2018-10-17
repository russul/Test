package ProducerConsumer;
/*
 * 
 * 
 * 
 * 
 * 
 */
public class GetStudent implements Runnable {

	private Student s;
	
	
	public GetStudent(Student s) {
		this.s = s;
	}


	@Override
	public void run() {
		while(true){
			synchronized(s){    //我们巧妙的将Student对象当做锁，省的再去单独定义
			
				if(!s.flag){ //如果没有资源，消费者就等待
					try {
						s.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			//如果有资源就进行消费
			System.out.println(s.getName() + "---" + s.getAge());
			//消费结束后，更改标志位
			s.flag = false;
			//通知生产者生产
			s.notify();        //唤醒必须在最后一步，无论生产还是消费
			}	
			}
		
		
	}

}

/*
 * 分析一个过程
 * 1 假如消费者先抢到CPU执行权
 * 2 默认的flag为假，说明此时没有资源，消费者就等待，立即释放锁，这时候，生产者就会抢到执行权
 * 3 没有资源，生产者就会进行生产，生产结束后，将flag改为真，接着notify()
 * 4 注意notify()唤醒的是监视器（锁对象）的线程中的某一个，也是需要各线程去抢夺CPU执行权的
 *    就有两种情况：1 生产者继续抢到，由于flag是真，只能继续等，这时消费者拿到执行权，进行消费
 *             2 消费者抢到，flag是真，进行消费操作
 * 两种情况都是消费者执行，这就是Java的等待唤醒机制
 * 
 * 
 * 
 */