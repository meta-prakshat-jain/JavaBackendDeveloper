package Java8;

import java.util.function.Function;

public class FunctionsDemo {
	public static void main(String[] args) {
		//<T,R>t=type of input
		//R = Type of Output
		Function<Integer, Integer> function1=(num)->num;
		Function<Integer, Boolean> function2=(num)->num>10;
		
		System.out.println(function1.apply(2021));
		System.out.println(function2.apply(2021));
		System.out.println(function2.apply(1));
		
		//Find Length of String
		Function<String,Integer> length=(str)->str.length();
		System.out.println(length.apply("Hello World"));
		System.out.println(length.apply("Javaexpress"));
		
		//Remove Spaces
		Function<String,String> remove=(str)->str.replace(" ","");
		System.out.println(remove.apply("H e l l o W o r l d !"));
		System.out.println(remove.apply("A B C D E X Y Z !"));

	}

}
