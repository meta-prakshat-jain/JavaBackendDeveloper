package Milestone4;

public class Student implements java.io.Serializable  {
	private String name;
	private String email;
	private int age;
	private String address;
	
	public Student(String name,String email,int age ,String address){
		this.name=name;
		this.email=email;
		this.age=age;
		this.address=address;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public int getAge() {
		return age;
	}
	public String getaddress() {
		return address;
	}
	public Student(){
		
	}
	
	public void displayName() {
		System.out.println("Hi my name is "+name);
	}

}
