package ProduceCus;
/*
 * ��ӰΪһ�ݹ�������Դ
 * 
 */
public class Moive {
	private String pic;
	//�źŵ�
	//flag-->T,�����������������ߵȴ����������֪ͨ����
	//flag-->F,���������ѣ������ߵȴ����������֪ͨ����
	//�ȴ���wait();-->�ͷ�����sleep������--> ���ͷ���
	//֪ͨ��notify������
	private boolean flag = true;
	
	public synchronized void play(String pic){
		//�����ߵȴ�
		if(!flag){
			try {
				this.wait();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		//��ʼ����
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//�������
		this.pic = pic;
		System.out.println("produce:" + pic);
		//֪ͨ����
		this.notify();
		//������ͣ��
		this.flag = false;
		
	}
	public synchronized void watch(){
		//������ �ȴ�
			if(flag){
					try {
						this.wait();
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
				}
				//��ʼ����
			try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
		    System.out.println("cus:" + pic);
		    //�������֪ͨ����
		    this.notify();
		    //������ͣ��
		    this.flag = true;
	}
}
