package io;
import java.io.*;

public class TestTransform {
	public static void main(String[] args){
		InputStreamReader fd = new InputStreamReader(System.in);//µ»¥˝º¸≈Ã ‰»Î
		BufferedReader f = new BufferedReader(fd);
		String s = null ;
		try{
			s = f.readLine();
			while(s!=null){
				if(s.equalsIgnoreCase("exit")) break;
				System.out.println(s.toUpperCase());
				s = f.readLine();
			}
			f.close();
			}
			catch(IOException e){
				e.printStackTrace();
			
		}
	}
}
