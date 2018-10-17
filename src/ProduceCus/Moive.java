package ProduceCus;
/*
 * 电影为一份公共的资源
 * 
 */
public class Moive {
	private String pic;
	//信号灯
	//flag-->T,生产者生产，消费者等待；生产完后，通知消费
	//flag-->F,消费者消费，生产者等待；消费完后，通知生产
	//等待：wait();-->释放锁，sleep（）；--> 不释放锁
	//通知：notify（）；
	private boolean flag = true;
	
	public synchronized void play(String pic){
		//生产者等待
		if(!flag){
			try {
				this.wait();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		//开始生产
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//生产完成
		this.pic = pic;
		System.out.println("produce:" + pic);
		//通知消费
		this.notify();
		//生成者停下
		this.flag = false;
		
	}
	public synchronized void watch(){
		//消费者 等待
			if(flag){
					try {
						this.wait();
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
				}
				//开始消费
			try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
		    System.out.println("cus:" + pic);
		    //消费完成通知生产
		    this.notify();
		    //消费者停下
		    this.flag = true;
	}
}
