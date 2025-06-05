package RMI;
import java.rmi.Remote; 
import java.rmi.RemoteException;  

import java.rmi.registry.Registry; 
import java.rmi.registry.LocateRegistry; 
import java.rmi.RemoteException; 
import java.rmi.server.UnicastRemoteObject; 

// Creating Remote interface for our application 
public interface Hello extends Remote {  
   void printMsg() throws RemoteException;  
} 

//Implementing the remote interface 
class ImplExample implements Hello {  

// Implementing the interface method 
public void printMsg() {  
   System.out.println("This is an example RMI program");  
}  
} 

class Server extends ImplExample { 
   public Server() {} 
   public static void main(String args[]) { 
      try { 
         // Instantiating the implementation class 
         ImplExample obj = new ImplExample(); 
    
         // Exporting the object of implementation class  
         // (here we are exporting the remote object to the stub) 
         Hello stub = (Hello) UnicastRemoteObject.exportObject(obj, 0);  
         
         // Binding the remote object (stub) in the registry 
         Registry registry = LocateRegistry.getRegistry(); 
         
         registry.bind("Hello", stub);  
         System.err.println("Server ready"); 
      } catch (Exception e) { 
         System.err.println("Server exception: " + e.toString()); 
         e.printStackTrace(); 
      } 
   } 
} 