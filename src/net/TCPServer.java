package net;
import java.net.*;
import java.io.*;

public class TCPServer {
	public static void main(String[] args) throws Exception{
		ServerSocket ss = new ServerSocket(6666);
		while(true){                                      //֧�ֶ��client����
			Socket s = ss.accept();
			DataInputStream dis = new DataInputStream(s.getInputStream());
			System.out.println(dis.readUTF());
			
			dis.close();
			s.close();
	}
		}
}
