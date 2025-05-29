package SocketProgramming;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
class QuoteService2{
	Map<String, String> productInfo=new HashMap<>();
	public QuoteService2() {
		productInfo.put("Almonds", "100");
		productInfo.put("Cashew", "200");
	}
	
	public String getQuote(String product) {
		return productInfo.get(product);		
	}
	
}

class ServiceThread extends Thread{
	Socket sock;
	QuoteService2 quoteService=new QuoteService2();
	
	public ServiceThread(Socket sock) {
		this.sock=sock;
	}
	
	public void run() {
		try {

			InputStream in=sock.getInputStream();
			OutputStream output=sock.getOutputStream();
			System.out.println("waiting for product information from the clinet");
			byte request[]=new byte[100];
			in.read(request);
			String product =new String(request).trim();
			
			System.out.println("Received product name. "+product);
			String price=quoteService.getQuote(product);
			
			if(price==null) {
				price="Invalid product"; 
			}
			
			output.write(price.getBytes());
			
			System.out.println("Response Sent");
			
			sock.close(); 
			
		}catch(Exception e) {
			
			
		}
		
		
	}
}

public class MultiThreadServer {
	public static void main(String[] args) throws IOException {

		ServerSocket serSocket=new ServerSocket(9999);
		System.out.println("Started listing to 9999");
		
		while(true) {
			System.out.println("Waiting for client..");
			Socket sock=serSocket.accept();//Waits for client to connect
			// create a new thread to service client.
			
			System.out.println("Starting a thread which will service the client... ");
			new ServiceThread(sock).start();
		}
			
			
		}



}
