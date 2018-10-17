package ProduceCus;

public  class Watcher implements Runnable {
	private Moive m ;

	public Watcher(Moive m) {
		super();
		this.m = m;
	}
	
	public void run() {
		
		for(int i = 0; i<20; i++){
		m.watch();
		
		}
	}
	
}
