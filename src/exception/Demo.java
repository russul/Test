package exception;

import exception.MyException;
public class Demo {
	public static void main(String[] args) {
		Integer integer = new Integer(1);
		try {
			System.out.println(create(integer));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
	
	public static int create(Integer i) throws Exception{
//		if(i instanceof Integer){
//			throw new MyException("整数异常");
//		}
		if (i==0) {
			throw new MyException("不能为0");
		}
		return i;
	}
}



