package ProduceConsumer_ex;

public class Demo {

	public static void main(String[] args) {
		Student s  = new Student();
		SetStudent ss1 = new SetStudent(s,true);
		SetStudent ss2 = new SetStudent(s,false);
		GetStudent gs = new GetStudent(s);
		Thread p1 = new Thread(ss1,"生产者1");
		Thread p2 = new Thread(ss2,"生产者2");
		Thread c1 = new Thread(gs,"消费者1");
		Thread c2 = new Thread(gs,"消费者2");
		Thread c3 = new Thread(gs,"消费者3");
		p1.start();
		p2.start();
		c1.start();
		c2.start();
		c3.start();
	}

}
