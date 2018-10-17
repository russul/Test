package ProduceCus;

public class ProducerConsumer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Basket s = new Basket();
		Producer p = new Producer(s);
		Consumer c = new Consumer(s);
		new Thread(p).start();
		new Thread(c).start();

      }

}

class Manto{
	int id;
	Manto(int id){
		this.id = id;
	}
	
	
}

class Basket{
	Manto m[] = new Manto[6]; 
	
	int index = 0;
	
	

	public synchronized void push(Manto a){
		while(index == m.length){
			try {
				this.wait();
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
	
    	this.notify();
		m[index] = a;
		index ++;
		

	
	}
	
    public synchronized Manto pop() throws InterruptedException{
    	while(index==0){
			try {
				this.wait();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
    	
    	this.notify();
    	index--;
		return m[index];
		
	}
}

class Producer implements Runnable{
	
	Basket b = new Basket();
	
	//
	
	public Producer(Basket b) {
		super();
		this.b  = b;
	
	}

	public void run() {
		for(int i = 0;i<20;i++){
			Manto aa = new Manto(i);
			b.push(aa);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			System.out.println("生产了：" + aa.id);
			}
		
	}
	
}

class Consumer implements Runnable{
	
	Basket b = new Basket();
	public Consumer(Basket b) {
		super();
		this.b  = b;
	
	}

	
	public void run() {
		for(int i = 0;i<20;i++){
			
			try {
				b.pop();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				System.out.println("消费了: " + b.pop().id);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		
	}
}