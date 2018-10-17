package io;
import java.io.*;

public class TestFileinputStream {
	public static void main(String args[]){
		int b = 0;
		FileInputStream in = null ;
		try{
			in = new FileInputStream("e:/编程/java/workspace/Test/src/io/TestFileinputStream.java");
		} catch(FileNotFoundException e){
			
			System.out.println("未找到文件");
			System.exit(-1);
		}
		
		try{
			long num = 0;
			while((b = in.read())!= -1){
				System.out.print((char) b);
				num ++;
			}
			in.close();
			System.out.println();
			System.out.println("一共打印了" + num + "字节");
		} catch(IOException e1){
			System.out.println("文件读取错误");
			System.exit(-1);
		}
	}

}
