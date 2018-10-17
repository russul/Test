package ProduceCus;

public class App {
	
	
	public static void main(String[] args) { 
		Moive m = new Moive();
		Player p = new Player(m);
		Watcher w = new Watcher(m);
		new Thread(p).start();
		new Thread(w).start();
		}

}
