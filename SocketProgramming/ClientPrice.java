package SocketProgramming;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientPrice {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("Waiting for the server to accept");
		Socket sock=new Socket("127.0.0.1",9999);
		System.out.println("Connected to the server");
		
		Scanner sc=new Scanner(System.in);
		
		String product =sc.nextLine();
		
		InputStream in=sock.getInputStream();
		OutputStream out=sock.getOutputStream();
		
		out.write(product.getBytes());
		
		byte[] response =new byte[100];
		in.read(response);
;
		
		String strResponse=new String(response).trim();
		
		System.out.println("Obtainde response is - "+strResponse);
		
		sock.close();
		
	}

}
