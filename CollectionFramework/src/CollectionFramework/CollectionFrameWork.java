package CollectionFramework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class CompareStringLength implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		return o2.length()-o1.length();
	}
	
	
}

class Student{
	String name;
	int id;
	Student(String name,int id){
		this.name=name;
		this.id=id;
	}
}


public class CollectionFrameWork {
	
	static void print(List<Student> enapsulateList) {
		System.out.println("How to print a collection Using Encapsulation ? ");
		for(Student s:enapsulateList) {
			System.out.println(s.id+" : "+s.name);
		}
	}
	
	public static void main(String[] args) {
		// 1 How to convert an array into a collection? 
		//Mthd-1(Using Array as List)
		//In this only we can set elements no adding no removing allowed
		List<Integer> list1=Arrays.asList(1,2,3,4,5);
		System.out.println(list1);
		//Method 2
		int [] arr= {1,2,3,4,5};
		Arrays.asList(arr);
		
		//Method 3
		//In this we cannot set anythig it will throw exception
		List<Integer> list2=List.of(1,2,3);
		
//		How to compare elements in a collection? 
		//Method 1 Using Comparator
		
		List<String> StrList=Arrays.asList("John","Henry","Kevin","Ron");
		StrList.sort(new CompareStringLength());
		System.out.println(StrList);
		
		//Method 2 Using Lambda Expression
		List<String> StrList2=Arrays.asList("Dev","Daksh","Shubam","Om");
		StrList2.sort((o1,o2)->o2.length()-o1.length());//Descending
		System.out.println(StrList2);
		
//		How to convert a collection into an array? 

		List<String> days=new ArrayList<String>();
		days.add("Monday");
		days.add("Tuesday");
		days.add("Wednesday");
		days.add("Friday");
		String[] ArrOfDays=days.toArray(new String[0]);	
		for(String s:ArrOfDays) {
			System.out.println(s);
		}
		
		
//		How to print a collection? 
//		Method-1
//		Using Main Method 
		List<Student> StudentList=new ArrayList<Student>();
		StudentList.add(new Student("Harshit",1));
		StudentList.add(new Student("Asharam",2));
		StudentList.add(new Student("NathuRam",3));
		StudentList.add(new Student("Gandhi",4));
		StudentList.add(new Student("Hitler",5));
		for(Student s:StudentList) {
			System.out.println(s.id+" : "+s.name);
		}
		
//		Method-2
//		Using ENcapsulation
		List<Student> EnapsulateList=new ArrayList<>();
		EnapsulateList.add(new Student("Latika", 1));
		EnapsulateList.add(new Student("Anushka", 2));
		EnapsulateList.add(new Student("Lali", 3));
		EnapsulateList.add(new Student("Lala", 4));
		EnapsulateList.add(new Student("Deepika", 5));
		print(EnapsulateList);
		
//		How to remove a specific element from a collection? 
		ArrayList<String> RemoveList=new ArrayList<String>();
		RemoveList.add("John");
		RemoveList.add("Ron");
		RemoveList.add("Don");
		RemoveList.add("Sun");
		RemoveList.remove("John"); 
		System.out.println(RemoveList);
		
//		How to reverse a collection?
		
		ArrayList<Integer> reversedList=new ArrayList<>();
		reversedList.add(1);
		reversedList.add(2);
		reversedList.add(3);
		reversedList.add(4);
		reversedList.add(5);
		System.out.println(reversedList.reversed());
		
//		How to get the size of a collection? 
		
		List<Integer> list4=new ArrayList<Integer>(5);
		list4.add(1);
		list4.add(2);
		list4.add(3);
		list4.add(4);
		list4.add(5);
		list4.add(6);
		System.out.println(list4.size());
		
		
		
		
		
		
		
		
		
		
		
		 
	}

}
