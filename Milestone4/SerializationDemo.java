package Milestone4;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import Milestone4.Student;

public class SerializationDemo {
	public static void main(String[] args) {
		try {
//			create object of student
			Student student=new Student("Ankit Kumar Tiwari","ankit@gmail.com",23,"Jodhpur");
			FileOutputStream fos =new FileOutputStream("student.txt");
			
			ObjectOutput oos=new ObjectOutputStream(fos);

			
			//How to serialize
			oos.writeObject(student);
			oos.close();
			fos.close();
			System.out.println("Object stated is transfered to file object");
			
		}catch(IOException exception) {
			exception.printStackTrace();
			
		}
		

	}

}
