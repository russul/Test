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
				m.play("������");       //��ס��play()��������run����û�����������Ǵﲻ��Ч��
				}else{
					m.play("�Ұ׻�");
				}
			
			
		}
		
	}
}
