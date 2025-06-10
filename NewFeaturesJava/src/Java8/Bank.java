package Java8;
interface IBank{
	void withdraw();
	void deposit();
	
	default void loan() {
		System.out.println("Hello this method is not necessary to impleent");
	}
	
	
}
//Now in java 1.8 it is not necessary to implement default methods
//However you can override them whoever wants to use them
class hdfc implements IBank{

	@Override
	public void withdraw() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deposit() {
		// TODO Auto-generated method stub
		
	}
	
}

class axis implements IBank{

	@Override
	public void withdraw() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deposit() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void loan() {
		// TODO Auto-generated method stub
		IBank.super.loan();
	}
	
}
public class Bank {

}
