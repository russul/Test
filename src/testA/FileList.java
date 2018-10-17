package testA;
import java.io.*;


public class FileList {
	public static void main(String args[]){
		File f = new File("e:/a");
		System.out.println(f.getName());
		tree(f,1);
	}
	
	public static void tree(File f,int level){
		String preString = "";
		for(int i=0;i<level;i++){
			preString += "    " ;
		}
		
		File[] childs = f.listFiles();//еп╤овсд©б╪
		for(int i = 0; i<childs.length;i++){
		System.out.println(preString + childs[i].getName());
		if(childs[i].isDirectory()){
			tree(childs[i],level+1);
		}
	}
	}
}
