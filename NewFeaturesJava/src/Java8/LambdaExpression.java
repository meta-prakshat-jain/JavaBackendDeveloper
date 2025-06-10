package Java8;
@FunctionalInterface
interface Car{
	void model();
}

//Lambda expression are effectively just methods
//lambda expressions can take parameters just like methods.

@FunctionalInterface
interface Add{
	void add(int a,int b);
	
	default void m1() {
		
	}
	
	static void m2() {
		
	}
	
//	void addNew();// Shows error
}

public class LambdaExpression {
	public static void main(String[] args) {
		Car car=()->{
			System.out.println("The model of the car is mustang");
		};
		car.model();
		
		Add add=(a,b)->{
			System.out.println(a+b) ;
		};
		add.add(13, 14);
		
		Add add2=(a,b)->System.out.println(a+b);
		add2.add(3, 23);
		
	}

}
