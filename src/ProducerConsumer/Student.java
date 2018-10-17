package ProducerConsumer;
/*
 * 资源类，资源为学生
 * 
 * 
 */
public class Student {
	private String name;
	private int age;
	//定义一个标志变量，表示当前是非有资源存在，true:有；false:没有
	public boolean flag = false; 
	//因为定义了name和age均是私有类型，所以一定要提供public方法，以供外部类对数据进行操作
	public String getName(){
		return name;
	}

	public int getAge(){
		return age;
	}
	public void setName(String name){
		this.name = name;
		
		
	}
	public void setAge(int age){
		
		this.age = age;
		
	}
}
