package SocketProgramming;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class MultiThreadClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Socket sock=new Socket("127.0.0.1",9999);
		
		InputStream in=sock.getInputStream();
		OutputStream out=sock.getOutputStream();
		
		
		
	}

}
