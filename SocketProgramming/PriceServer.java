package SocketProgramming;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

class QuoteService{
	Map<String, String> productInfo=new HashMap<>();
	public QuoteService() {
		productInfo.put("Almonds", "100");
		productInfo.put("Cashew", "200");
	}
	
	public String getQuote(String product) {
		return productInfo.get(product);		
	}
	
}
public class PriceServer {
	public static void main(String[] args) throws IOException {
		
		QuoteService quoteService=new QuoteService();
		ServerSocket serSocket=new ServerSocket(9999);
		System.out.println("Started listing to 9999");
		
		while(true) {
			System.out.println("Waiting for client..");
			Socket sock=serSocket.accept();//Waits for client to connect
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
		}

		
	
	}

}
