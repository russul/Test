package io;
import java.io.*;

public class TestFileOutputStream {
	public static void main(String arga[]){
		FileInputStream in = null ;
		FileOutputStream out = null ;
		int b = 0;
		try{
			in = new FileInputStream("e:/编程/java/workspace/Test/src/testA/testString.java");
			out = new FileOutputStream("e:/编程/java/workspace/Test/src/container/testStringCopy.java");
			while((b = in.read())!= -1){
				out.write(b);
			}
			in.close();
			out.close();
		} catch(FileNotFoundException e){
			System.out.println("未找到指定文件");
			System.exit(-1);
		} catch(IOException e1){
			System.out.println("文件复制错误");
			System.exit(-1);
		}
		System.out.println("文件已复制");
	}
}
