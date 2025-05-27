package Milestone3;

import java.awt.print.Printable;






//Making a class Generic
class Pair<K,V>{
	private K key;
	private V value;
	
	Pair(K key,V value){
		this.key=key;
		this.value=value;
	}
	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}
	
	
}


//Making an interface generic
interface Container<T>{
	void add(T item);
	T get();
	
}

class StringContainer<T> implements Container<T>{
	
	private T item;

	@Override
	public void add(T item) {
		// TODO Auto-generated method stub
		this.item=item;
		
	}

	@Override
	public T get() {
		// TODO Auto-generated method stub
		return item;
	}
		
}
//	Bounded Type Parameter
	
class Box<T extends Number>{
	
	private T value;
	
	public T getValue() {
		return value;	
	}
	//Generic Constructor
	
	public Box(T value) {
		this.value=value;
	}
	
	
	public void setValue(T value) {
		this.value=value;
	}
}

interface printable{
	
	void print();
}

class MyNumber extends Number implements printable{
	
	private final int value;
	
	MyNumber(int value){
		this.value=value;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int intValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long longValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float floatValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double doubleValue() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}

class NewBox<T extends Number & printable>{
	private T item;
	
	public NewBox(T item) {
		this.item=item;
	}
	
	public void display() {
		 item.print();
	}
	
	public T getItem() {
		return item;
	}
}




public class Generics {
	

	//Geniric Method
	public static <T>void printArray(T[] inputArray){
		for(T element:inputArray) {
			System.out.println(element);
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Pair<Integer,String> pair=new Pair<>(1,"John");
		System.out.println(pair.getKey());
		System.out.println(pair.getValue());
		Integer[] inputArray= {1,2,3,4,5};
		String[] inputArray2= {"Hello","World","Sonu"};
		Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
		Character[] charArr= {'H','E','L','L','O'};
		printArray(inputArray2);
		printArray(inputArray);
		printArray(doubleArray);
		printArray(charArr);
		
//		Box<Integer> Box=new Box<>();
//		Box.setValue(4);
//		Box<Double> box2=new Box<>();
//		box2.setValue(2.1);
		
		
		MyNumber myNumber =new MyNumber(22);
		NewBox<MyNumber> box=new NewBox<>(myNumber);
		
	}

}
