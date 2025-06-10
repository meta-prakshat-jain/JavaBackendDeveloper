package Java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo {
	public static void main(String[] args) {
		Predicate<Integer> predicate=(num)->num==2020;
		System.out.println(predicate.test(2020));
		System.out.println(predicate.test(2021));
		
		Predicate<String> string=(str)->str.length()>5;
		System.out.println(string.test("Hello Wolrd!"));
		System.out.println(string.test("Word"));
		
		List<Integer> arrList=new ArrayList<>();
		arrList.add(10);
		arrList.add(5);
		arrList.add(90);
		arrList.add(36);
		arrList.add(52);
		arrList.add(55);
		
		Predicate<Integer> p=num->num>10;
		
		for(Integer number:arrList) {
			if(p.test(number)) {
				System.out.println(number);
			}
		}
		
		
	}

}
