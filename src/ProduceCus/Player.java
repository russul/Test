package ProduceCus;

public class Player implements Runnable {
	
	private Moive m ;

	
	
	public Player(Moive m) {
		super();
		this.m = m;
	}
	public void run() {
		
		for(int i = 0; i<20; i++){
			if(i%2==0){
				m.play("左青龙");       //锁住了play()方法，但run（）没有锁定，还是达不到效果
				}else{
					m.play("右白虎");
				}
			
			
		}
		
	}
}
