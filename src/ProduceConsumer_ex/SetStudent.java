package ProduceConsumer_ex;
/*
 * ������Դ�ࣨ�����ߣ�
 * ����һ���߳���
 * 
 * 
 */
public class SetStudent implements  Runnable {
	
	//�漰����๲��һ����Դ��ѧ����Դ������ͨ���ⲿ����ͨ�����췽������
	private Student s;
	
	private boolean b;
	public SetStudent(Student s,boolean b) {
		
		this.s = s;
		this.b = b;
	}


	public void run() {
		while(true){
			synchronized(s){ //��������Ľ�Student����������ʡ����ȥ��������
				
				if(s.flag){  //�������Դ�������߾͵ȴ�
					try {
						s.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				//���û�У��ͽ�������
				if(b){
					s.setName("Tom");
					s.setAge(3);
					s.setinfo(Thread.currentThread().getName());
				}else {
					s.setName("Jerry");
					s.setAge(5);
					s.setinfo(Thread.currentThread().getName());
				}
						
				
					
				
				
//				
					
				//���������󣬸ı��־λ
				s.flag = true;
				//֪ͨ�����߽�������
				s.notify();
				}
			}
			
	}
}