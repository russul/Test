package io;
import java.io.*;

public class TestFileinputStream {
	public static void main(String args[]){
		int b = 0;
		FileInputStream in = null ;
		try{
			in = new FileInputStream("e:/���/java/workspace/Test/src/io/TestFileinputStream.java");
		} catch(FileNotFoundException e){
			
			System.out.println("δ�ҵ��ļ�");
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
			System.out.println("һ����ӡ��" + num + "�ֽ�");
		} catch(IOException e1){
			System.out.println("�ļ���ȡ����");
			System.exit(-1);
		}
	}

}
