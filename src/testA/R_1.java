package testA;

import java.util.*;
public class R_1 {   
		static int X = 9;
		static int Y = 6;//定义X，Y，Z为该网络的三维坐标的最大值，X 和Y构成一个分区，Z表示分区的数目；
		static int Z = 4;                                         //主类
	public static void main(String[] args){                  //主方法，程序执行入口
		
		
		     
		int z = 0;     //变量z为路由节点的z轴坐标，因为网络的分块都是对称的，这里把它定为0.表示源节点的路由选在第一分区；
		double[][] averageHopsEWr = new double[X*Y][X*Y*Z]; //定义二维数组用来装每个路由节点到每一个目的节点的平均跳数（距离）；
		Point[] Wr = new Point[X*Y];                        //路由节点数组，用来装要测试的所用路由节点对象；
		Point[] destination = new Point[X*Y*Z];             //目的节点数组，用来装要测试的所有目的节点对象；
		
		for(int i=0;i<X;i++){                                //初始化路由节点数组
			for(int j=0;j<Y;j++){
				Wr[Y*i+j] = new Point(i,j,z,X,Y,Z);
				
			}
		}
		
		
		for(int k=0;k<Z;k++){                               //初始化目的节点数组
			for(int i=0;i<X;i++){
				for(int j=0;j<Y;j++){
					destination[X*Y*k+Y*i+j] = new Point(i,j,k,X,Y,Z);
				}
			}
		}
		
		
		for(int j=0;j<Wr.length;j++){                                 //调用getdistance()方法，将经过每一个路由节点到达任意一个目的节点的距离算出来，放在二维数组里；
			for(int i=0;i<destination.length;i++){
				averageHopsEWr[j][i] = Wr[j].getDistance(destination[i]); //二维数组里的每一行都代表一个路由节点到任意一个目的节点的距离；
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
		double[] hop = new double[Wr.length];                  //将经过同一个路由节点到达任意一个目的节点的距离加起来，得到经过这个路由节点总的距离，然后再得到平均距离；
		for(int i=0;i<Wr.length;i++){
			for(int j=0;j<averageHopsEWr[i].length;j++){
				sum[i] = sum[i]+averageHopsEWr[i][j];
				hop[i]= sum[i]/averageHopsEWr[i].length;
			}
		}
		
		
		
		for(int i=0;i<Wr.length;i++){                   //输出每一个路由节点要通信的总跳数和平均跳数
			System.out.println("路由节点设在" + "(" + Wr[i].x + "," + Wr[i].y + "," + Wr[i].z + ")" + "点，到各点的总跳数" + "  " + sum[i]+"                 " + "到各点的平均跳数" + "     " + hop[i]);
		}
		
		
		double[] hopResult ;
		hopResult = bubbleOrder(hop);  //调用冒泡排序方法，求出最短跳数以及它的位置
		
		int[] location = new int[hopResult.length-1];
		
		for(int i=1;i<hopResult.length;i++){
			 location[i-1] = (int)hopResult[i];
		}
		
		
		for(int i=0;i<location.length;i++){
			
			
			System.out.println("最优化的路由节点位置"+" "+ "(" + Wr[location[i]].x + "," + Wr[location[i]].y + "," + Wr[location[i]].z + ")"+"    "+"最优化的平均跳数"+" "+hopResult[0]);
		}
		
		Router();
		
		
	}
		
	
	
	public static void Router(){
			Scanner s = new Scanner(System.in);
			
			Point test = new Point(0,0,0,X,Y,Z);
			Point test1 = new Point(0,0,0,X,Y,Z);
			Point ssrouse = new Point(0,0,0,X,Y,Z);
			Point ddest = new Point(0,0,0,X,Y,Z);
		
				
	
		
			System.out.println("请输入您选择的源节点的X，Y，Z坐标");
			ssrouse.x = s.nextInt();
			ssrouse.y = s.nextInt();
			ssrouse.z = s.nextInt();
			if(ssrouse.x > X ||ssrouse.y > Y || ssrouse.z > Z){
				System.out.println("您输入的节点不在本网络中，请重新输入源节点的X，Y，Z坐标");
				ssrouse.x = s.nextInt();
			    ssrouse.y = s.nextInt();
			    ssrouse.z = s.nextInt();
			}
			System.out.println("请输入您选择的目的节点的X，Y，Z坐标");
			ddest.x = s.nextInt();
			ddest.y = s.nextInt();
			ddest.z = s.nextInt();
			if(ddest.x > X || ddest.y > Y || ddest.z > Z){
				System.out.println("您输入的节点不在本网络中，请重新输入目的节点的X，Y，Z坐标");
				ddest.x = s.nextInt();
			    ddest.y = s.nextInt();
			    ddest.z = s.nextInt();
			}
			
			System.out.println("请输入您选择的WR1位置的X，Y坐标");
			test.x = s.nextInt();
		    test.y = s.nextInt();
		    test.z = ssrouse.z;
			if(test.x > X || test.y > Y || test.z > Z){
				System.out.println("您输入的节点不在本网络中，请重新输入WR1节点的X，Y坐标");
				test.x = s.nextInt();
			    test.y = s.nextInt();
			    test.z = ssrouse.z;
			}
			System.out.println("请输入您选择的WR2位置的X，Y坐标");
			test1.x = s.nextInt();
		    test1.y = s.nextInt();
		    test1.z = ddest.z;
			if(test.x > X || test.y > Y || test.z > Z){
				System.out.println("您输入的节点不在本网络中，请重新输入WR1节点的X，Y坐标");
				test1.x = s.nextInt();
			    test1.y = s.nextInt();
			    test1.z = ddest.z;
			}
			System.out.println("您选择的源节点位置是" + "(" + ssrouse.x + "," +ssrouse.y + "," + ssrouse.z + ")");
			System.out.println("您选择的目的节点位置是" + "(" + ddest.x + "," +ddest.y + "," + ddest.z + ")");
			System.out.println("您选择的WR1节点位置是" + "(" + test.x + "," +test.y + "," + test.z + ")");
			System.out.println("您选择的WR2节点位置是" + "(" + test1.x + "," +test1.y + "," + test1.z + ")");
			
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
			System.out.println("一共经历" + ccount +"跳");
			//System.out.println(a.x +" " +a.y +" "+a.z);
	}
		
	
	
	
	
	public static double[] bubbleOrder(double[] a){                  //冒泡排序方法
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
		
		for(int i=0,j=0;i<b.length;i++){            //为了记录最小值的位置
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







class Point {                         //定义一个点类；里面有用来表示坐标的x,y,z，还有表示三维坐标的最大值
	int x,y,z;
	int x_max,y_max,z_max;
	
	Point(int x,int y,int z,int a,int b,int c){            //Point 类的构造方法
		this.x = x;
		this.y = y;
		this.z = z;
		x_max = a;
		y_max = b;
		z_max = c;
	} 
	
	public  Point[] sourse(){                             //类中有sourse()方法，用来初始化源节点的坐标，返回一个Point数组来模拟源节点位置
		
		
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
	
	
	public double getDistance(Point d){                         //类中还有一个方法getdistance()方法，用来表示到一个分区的源节点通过一个发送端路由节点到达一个目的节点的平均距离
		int x,y;
		double hop;
		int sum = 0;
		int[] hops = new int[this.sourse().length];
		Point wr2= new Point(this.x,this.y,d.z,this.x_max,this.y_max,this.z_max);//定义并初始化接收端路由节点
		
		
		Point[] ss= this.sourse(); //调用源节点初始化方法，构造源节点数组ss
		
	
		for(int k=0;k<ss.length;k++){                      // 距离的计算
			
			
			if(ss[k].z == d.z){                              //如果源节点和目的节点在同一个分区中，采用有线通信方式，不通过路由节点
				 hops[k] = (max(ss[k].x,d.x)- min(ss[k].x,d.x))+(max(ss[k].y,d.y)- min(ss[k].y,d.y));
			}
			else{                              //否则要用路由节点，下面是距离计算公式
				x = (max(ss[k].x,this.x)- min(ss[k].x,this.x))+(max(ss[k].y,this.y)- min(ss[k].y,this.y));
				y = (max(wr2.x,d.x)- min(wr2.x,d.x))+(max(wr2.y,d.y)- min(wr2.y,d.y));
			        hops[k] = x+y+1;
			}
			
			
			sum = sum+hops[k];                //经过该路由节点到达目的节点的总距离（跳数）
		
		
		}
		
		hop = (double)sum/(double)this.sourse().length;       //经过该路由节点到达目的节点的平均距离（跳数）
		return hop;                                              //平均跳数作为方法返回值
		
		
		
		
	}
	
	

	
	
	int max(int a,int b){ return a>b?a:b;}                     //比较大小的两个方法，在计算距离的时候会用到
	int min(int a,int b){ return a<b?a:b;}
}