package CollectionFramework;

import java.util.*;
import java.util.Map.Entry;

public class HashMapDemo {
	public static void main(String[] args) {
//		How to iterate through elements of HashMap?
//		Method 1
		System.out.println("Using Method 1");
		HashMap<Integer,String> Student=new HashMap<>();
		Student.put(1, "Den");
		Student.put(2, "Swan");
		Student.put(3, "Dinesh");
		Student.put(4, "Kohli");
		Student.put(5, "Raina");
		Student.put(6, "Dhoni");
		for(Integer key:Student.keySet()) {
			System.out.println(key+" : "+Student.get(key));	
		}
		
//		Method 2
		System.out.println("Using Method 2");
		for( Entry<Integer, String> key:Student.entrySet()) {
			System.out.println(key);
		}
		
//		How to get Set view of Keys from Java Hashtable?
		HashMap<Integer,String> days=new HashMap<>();
		days.put(1, "Monday");
		days.put(2, "Tuesday");
		days.put(3, "Wednesday");
		days.put(4, "Thurday");
		days.put(5, "Friday");
		days.put(6, "Saturday");
		System.out.println(days.get(1));
		days.put(1, "Sunday");
		System.out.println(days);
		


		
		
		
		

	}

}
