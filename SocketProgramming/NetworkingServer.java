package SocketProgramming;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class NetworkingServer {
	public static void main(String[] args) throws IOException { 
		//Request for the server port
		ServerSocket serSocket=new ServerSocket(9999);
		System.out.println("Waiting for Client..");
		//Once you created the socket you need to wait for the clients
		//Accept Method waits for the client
		//Once the client is arrived it creates a seprate socket
		//With the help of this socket we will start interacting with the client
		Socket sock=serSocket.accept();
		System.out.println("Client Connected.. ");
		
		
		//What ever you read from the input stream is what is sent by the client
		InputStream in=sock.getInputStream();
		
		//What ever is written to the output stream is what is sent to the client
		OutputStream out=sock.getOutputStream();
		
		byte buffer[]=new byte[1024];
		in.read(buffer);
		
		System.out.println("Recieved from client-"+new String(buffer).trim());
		
		out.write("Hello from Server...".getBytes());
		
		sock.close();
		serSocket.close();
		
		
	}

}
