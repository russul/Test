package testA;

import java.util.*;
public class R_1 {   
		static int X = 9;
		static int Y = 6;//����X��Y��ZΪ���������ά��������ֵ��X ��Y����һ��������Z��ʾ��������Ŀ��
		static int Z = 4;                                         //����
	public static void main(String[] args){                  //������������ִ�����
		
		
		     
		int z = 0;     //����zΪ·�ɽڵ��z�����꣬��Ϊ����ķֿ鶼�ǶԳƵģ����������Ϊ0.��ʾԴ�ڵ��·��ѡ�ڵ�һ������
		double[][] averageHopsEWr = new double[X*Y][X*Y*Z]; //�����ά��������װÿ��·�ɽڵ㵽ÿһ��Ŀ�Ľڵ��ƽ�����������룩��
		Point[] Wr = new Point[X*Y];                        //·�ɽڵ����飬����װҪ���Ե�����·�ɽڵ����
		Point[] destination = new Point[X*Y*Z];             //Ŀ�Ľڵ����飬����װҪ���Ե�����Ŀ�Ľڵ����
		
		for(int i=0;i<X;i++){                                //��ʼ��·�ɽڵ�����
			for(int j=0;j<Y;j++){
				Wr[Y*i+j] = new Point(i,j,z,X,Y,Z);
				
			}
		}
		
		
		for(int k=0;k<Z;k++){                               //��ʼ��Ŀ�Ľڵ�����
			for(int i=0;i<X;i++){
				for(int j=0;j<Y;j++){
					destination[X*Y*k+Y*i+j] = new Point(i,j,k,X,Y,Z);
				}
			}
		}
		
		
		for(int j=0;j<Wr.length;j++){                                 //����getdistance()������������ÿһ��·�ɽڵ㵽������һ��Ŀ�Ľڵ�ľ�������������ڶ�ά�����
			for(int i=0;i<destination.length;i++){
				averageHopsEWr[j][i] = Wr[j].getDistance(destination[i]); //��ά�������ÿһ�ж�����һ��·�ɽڵ㵽����һ��Ŀ�Ľڵ�ľ��룻
			}
		}
		
		/*int count=0;
		
		for(int i=0;i<averageHopsEWr.length;i++){
			for(int j=0;j<averageHopsEWr[i].length;j++){
				
				System.out.print(averageHopsEWr[i][j]+" ");
				count++;
				if(count%averageHopsEWr[i].length==0){
					System.out.println();
				}
			}
           }*/
		double[] sum = new double[Wr.length];
		double[] hop = new double[Wr.length];                  //������ͬһ��·�ɽڵ㵽������һ��Ŀ�Ľڵ�ľ�����������õ��������·�ɽڵ��ܵľ��룬Ȼ���ٵõ�ƽ�����룻
		for(int i=0;i<Wr.length;i++){
			for(int j=0;j<averageHopsEWr[i].length;j++){
				sum[i] = sum[i]+averageHopsEWr[i][j];
				hop[i]= sum[i]/averageHopsEWr[i].length;
			}
		}
		
		
		
		for(int i=0;i<Wr.length;i++){                   //���ÿһ��·�ɽڵ�Ҫͨ�ŵ���������ƽ������
			System.out.println("·�ɽڵ�����" + "(" + Wr[i].x + "," + Wr[i].y + "," + Wr[i].z + ")" + "�㣬�������������" + "  " + sum[i]+"                 " + "�������ƽ������" + "     " + hop[i]);
		}
		
		
		double[] hopResult ;
		hopResult = bubbleOrder(hop);  //����ð�����򷽷��������������Լ�����λ��
		
		int[] location = new int[hopResult.length-1];
		
		for(int i=1;i<hopResult.length;i++){
			 location[i-1] = (int)hopResult[i];
		}
		
		
		for(int i=0;i<location.length;i++){
			
			
			System.out.println("���Ż���·�ɽڵ�λ��"+" "+ "(" + Wr[location[i]].x + "," + Wr[location[i]].y + "," + Wr[location[i]].z + ")"+"    "+"���Ż���ƽ������"+" "+hopResult[0]);
		}
		
		Router();
		
		
	}
		
	
	
	public static void Router(){
			Scanner s = new Scanner(System.in);
			
			Point test = new Point(0,0,0,X,Y,Z);
			Point test1 = new Point(0,0,0,X,Y,Z);
			Point ssrouse = new Point(0,0,0,X,Y,Z);
			Point ddest = new Point(0,0,0,X,Y,Z);
		
				
	
		
			System.out.println("��������ѡ���Դ�ڵ��X��Y��Z����");
			ssrouse.x = s.nextInt();
			ssrouse.y = s.nextInt();
			ssrouse.z = s.nextInt();
			if(ssrouse.x > X ||ssrouse.y > Y || ssrouse.z > Z){
				System.out.println("������Ľڵ㲻�ڱ������У�����������Դ�ڵ��X��Y��Z����");
				ssrouse.x = s.nextInt();
			    ssrouse.y = s.nextInt();
			    ssrouse.z = s.nextInt();
			}
			System.out.println("��������ѡ���Ŀ�Ľڵ��X��Y��Z����");
			ddest.x = s.nextInt();
			ddest.y = s.nextInt();
			ddest.z = s.nextInt();
			if(ddest.x > X || ddest.y > Y || ddest.z > Z){
				System.out.println("������Ľڵ㲻�ڱ������У�����������Ŀ�Ľڵ��X��Y��Z����");
				ddest.x = s.nextInt();
			    ddest.y = s.nextInt();
			    ddest.z = s.nextInt();
			}
			
			System.out.println("��������ѡ���WR1λ�õ�X��Y����");
			test.x = s.nextInt();
		    test.y = s.nextInt();
		    test.z = ssrouse.z;
			if(test.x > X || test.y > Y || test.z > Z){
				System.out.println("������Ľڵ㲻�ڱ������У�����������WR1�ڵ��X��Y����");
				test.x = s.nextInt();
			    test.y = s.nextInt();
			    test.z = ssrouse.z;
			}
			System.out.println("��������ѡ���WR2λ�õ�X��Y����");
			test1.x = s.nextInt();
		    test1.y = s.nextInt();
		    test1.z = ddest.z;
			if(test.x > X || test.y > Y || test.z > Z){
				System.out.println("������Ľڵ㲻�ڱ������У�����������WR1�ڵ��X��Y����");
				test1.x = s.nextInt();
			    test1.y = s.nextInt();
			    test1.z = ddest.z;
			}
			System.out.println("��ѡ���Դ�ڵ�λ����" + "(" + ssrouse.x + "," +ssrouse.y + "," + ssrouse.z + ")");
			System.out.println("��ѡ���Ŀ�Ľڵ�λ����" + "(" + ddest.x + "," +ddest.y + "," + ddest.z + ")");
			System.out.println("��ѡ���WR1�ڵ�λ����" + "(" + test.x + "," +test.y + "," + test.z + ")");
			System.out.println("��ѡ���WR2�ڵ�λ����" + "(" + test1.x + "," +test1.y + "," + test1.z + ")");
			
			int ccount = 0;
			Point a = ssrouse;
			if(ssrouse.z != ddest.z){
				ddest = test;
				ssrouse = test1;
			}
			
			int I = (ssrouse.x - ddest.x);
			int J = (ssrouse.y - ddest.y);
			int K = (ddest.y - ssrouse.y);
			
			if(ssrouse.x > ddest.x){
				
				for(int i =0; i<I;i++){
					
					System.out.print("(" + (a.x = ssrouse.x -1) +"," + a.y  +"," +a.z  +")" + "--->");
					ccount ++;
					}
				if(ssrouse.y > ddest.y){
					for(int j =0; j<J;j++){
							
							System.out.print("(" + a.x +"," + (a.y = ssrouse.y-1) +"," +a.z +")" +"--->");
							ccount ++;
					}
				}else{
					for(int k =0; k<K;k++){
						System.out.print("(" + a.x +"," + (a.y = ssrouse.y+1) +"," +a.z +")" + "--->");
						ccount ++;
					}
				}
			
		}else{
			
				for(int i =0; i<(-I);i++){
					System.out.print("(" + (a.x = ssrouse.x +1) +"," + a.y +"," +a.z +")" + "--->");
					ccount ++;
					}
				if(ddest.y > ssrouse.y){
						for(int j =0; j<K;j++){
							System.out.print("(" + a.x +"," + (a.y = ssrouse.y+1) +"," +a.z +")" + "--->");
							ccount ++;
					}
				}else{
					for(int k =0; k<J;k++){
						System.out.print("(" + a.x +"," + (a.y = ssrouse.y-1) +"," +a.z +")" + "--->");
						ccount ++;
					}
				}
			
		}
			
			/*if(ssrouse.z == ddest.z){
					int I = (ssrouse.x - ddest.x);
					int J = (ssrouse.y - ddest.y);
					int K = (ddest.y - ssrouse.y);
				if(ssrouse.x > ddest.x){
					
					for(int i =0; i<I;i++){
						
						System.out.print("(" + (a.x = ssrouse.x -1) +"," + a.y  +"," +a.z  +")" + "--->");
						ccount ++;
						}
					if(ssrouse.y > ddest.y){
						for(int j =0; j<J;j++){
								
								System.out.print("(" + a.x +"," + (a.y = ssrouse.y-1) +"," +a.z +")" +"--->");
								ccount ++;
						}
					}else{
						for(int k =0; k<K;k++){
							System.out.print("(" + a.x +"," + (a.y = ssrouse.y+1) +"," +a.z +")" + "--->");
							ccount ++;
						}
					}
				
			}else{
				
					for(int i =0; i<(-I);i++){
						System.out.print("(" + (a.x = ssrouse.x +1) +"," + a.y +"," +a.z +")" + "--->");
						ccount ++;
						}
					if(ddest.y > ssrouse.y){
							for(int j =0; j<K;j++){
								System.out.print("(" + a.x +"," + (a.y = ssrouse.y+1) +"," +a.z +")" + "--->");
								ccount ++;
						}
					}else{
						for(int k =0; k<J;k++){
							System.out.print("(" + a.x +"," + (a.y = ssrouse.y-1) +"," +a.z +")" + "--->");
							ccount ++;
						}
					}
				
			}
		}else{
				int O = ssrouse.x - test.x;
				int P = ssrouse.y - test.y;
			if(ssrouse.x > test.x){
				
				for(int i =0; i<O;i++){
					System.out.print("(" + (a.x = ssrouse.x -1) +"," + a.y +"," +a.z +")" + "--->");
					ccount ++;
					}
				if(ssrouse.y > test.y){
						for(int j =0; j<P;j++){
							System.out.print("(" + (a.x ) +"," + (a.y= ssrouse.y-1) +"," +a.z +")" + "--->");
							ccount ++;
					}
				}else{
					for(int k =0; k<(-P);k++){
						System.out.print("(" + (a.x ) +"," + (a.y = ssrouse.y+1) +"," +a.z +")" + "--->");
						ccount ++;
					}
				}
			
		}else{
			
				for(int i =0; i<(-O);i++){
					System.out.print("(" + (a.x = ssrouse.x +1) +"," + a.y +"," +a.z +")" + "--->");
					ccount ++;
					}
				if(test.y > ssrouse.y){
						for(int j =0; j<(-P);j++){
							System.out.print("(" + (a.x ) +"," + (a.y = ssrouse.y+1) +"," +a.z +")" + "--->");
							ccount ++;
					}
				}else{
					for(int k =0; k<P;k++){
						System.out.print("(" + (a.x ) +"," + (a.y = ssrouse.y-1) +"," +a.z +")" + "--->");
						ccount ++;
					}
				}
			}
				System.out.print("(" + (test1.x ) +"," + (test1.y) +"," +test1.z +")" + "--->");
				ccount ++;
				a = test1;
				int M = test1.x - ddest.x;
				int N = test1.y - ddest.y;
				if(test1.x > ddest.x){
					for(int i =0; i<M;i++){
						System.out.print("(" + (a.x = test1.x -1) +"," + a.y +"," +a.z +")" + "--->");
						ccount ++;
						}
					if(test1.y > ddest.y){
							for(int j =0; j<N;j++){
								System.out.print("(" + (a.x ) +"," + (a.y = test1.y-1) +"," +a.z +")" + "--->");
								ccount ++;
						}
					}else{
						for(int k =0; k<(-N);k++){
							System.out.print("(" + (a.x ) +"," + (a.y=test1.y+1) +"," +a.z +")" + "--->");
							ccount ++;
						}
					}
				
		    }else{
		    	for(int i =0; i<(-M);i++){
					System.out.print("(" + (a.x = test1.x +1) +"," + a.y +"," +a.z +")" + "--->");
					ccount ++;
					}
				if(test1.y > ddest.y){
						for(int j =0; j<N;j++){
							System.out.print("(" + (a.x ) +"," + (a.y = test1.y-1) +"," +a.z +")" + "--->");
							ccount ++;
					}
				}else{
					for(int k =0; k<(-N);k++){
						System.out.print("(" + (a.x ) +"," + (a.y=test1.y+1) +"," +a.z +")" + "--->");
						ccount ++;
					}
				}
			
		    }
		
	  }*/
			System.out.println();
			System.out.println("һ������" + ccount +"��");
			//System.out.println(a.x +" " +a.y +" "+a.z);
	}
		
	
	
	
	
	public static double[] bubbleOrder(double[] a){                  //ð�����򷽷�
		double temp;
		
		
		double[] b = new double[a.length];
		
		System.arraycopy(a,0,b,0,a.length);
		for(int i=a.length-1;i>=1;i--){
			for(int j=0;j<i-1;j++){
				if(a[j]>a[j+1]){
					temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
		
		int count = 0;
		for(int i=0;i<b.length;i++){          
			if(b[i] == a[0]){
				count++;
			}
		
		}
		
	
		
		double[] l = new double[count];
		double[] c = new double[count+1];
		
		for(int i=0,j=0;i<b.length;i++){            //Ϊ�˼�¼��Сֵ��λ��
			if(b[i] == a[0]){
				l[j] = i;
				
				j++;
			}
		
		}
		
		
		c[0] = a[0];
		for(int i=1;i<c.length;i++){
			c[i] = l[i-1];
		}
		
		return c;
	}
}







class Point {                         //����һ�����ࣻ������������ʾ�����x,y,z�����б�ʾ��ά��������ֵ
	int x,y,z;
	int x_max,y_max,z_max;
	
	Point(int x,int y,int z,int a,int b,int c){            //Point ��Ĺ��췽��
		this.x = x;
		this.y = y;
		this.z = z;
		x_max = a;
		y_max = b;
		z_max = c;
	} 
	
	public  Point[] sourse(){                             //������sourse()������������ʼ��Դ�ڵ�����꣬����һ��Point������ģ��Դ�ڵ�λ��
		
		
		Point[] s=new Point[this.x_max*this.y_max];	
		
		
		
	 
		for(int i=0;i<x_max;i++){
			for(int j=0;j<y_max;j++){
				int t = this.y_max*i+j;
				if(t<s.length){
					s[t]= new Point(i,j,this.z,this.x_max,this.y_max,this.z_max);
				
				}
			
			}
			
		}
		return s;
	}
	
	
	public double getDistance(Point d){                         //���л���һ������getdistance()������������ʾ��һ��������Դ�ڵ�ͨ��һ�����Ͷ�·�ɽڵ㵽��һ��Ŀ�Ľڵ��ƽ������
		int x,y;
		double hop;
		int sum = 0;
		int[] hops = new int[this.sourse().length];
		Point wr2= new Point(this.x,this.y,d.z,this.x_max,this.y_max,this.z_max);//���岢��ʼ�����ն�·�ɽڵ�
		
		
		Point[] ss= this.sourse(); //����Դ�ڵ��ʼ������������Դ�ڵ�����ss
		
	
		for(int k=0;k<ss.length;k++){                      // ����ļ���
			
			
			if(ss[k].z == d.z){                              //���Դ�ڵ��Ŀ�Ľڵ���ͬһ�������У���������ͨ�ŷ�ʽ����ͨ��·�ɽڵ�
				 hops[k] = (max(ss[k].x,d.x)- min(ss[k].x,d.x))+(max(ss[k].y,d.y)- min(ss[k].y,d.y));
			}
			else{                              //����Ҫ��·�ɽڵ㣬�����Ǿ�����㹫ʽ
				x = (max(ss[k].x,this.x)- min(ss[k].x,this.x))+(max(ss[k].y,this.y)- min(ss[k].y,this.y));
				y = (max(wr2.x,d.x)- min(wr2.x,d.x))+(max(wr2.y,d.y)- min(wr2.y,d.y));
			        hops[k] = x+y+1;
			}
			
			
			sum = sum+hops[k];                //������·�ɽڵ㵽��Ŀ�Ľڵ���ܾ��루������
		
		
		}
		
		hop = (double)sum/(double)this.sourse().length;       //������·�ɽڵ㵽��Ŀ�Ľڵ��ƽ�����루������
		return hop;                                              //ƽ��������Ϊ��������ֵ
		
		
		
		
	}
	
	

	
	
	int max(int a,int b){ return a>b?a:b;}                     //�Ƚϴ�С�������������ڼ�������ʱ����õ�
	int min(int a,int b){ return a<b?a:b;}
}