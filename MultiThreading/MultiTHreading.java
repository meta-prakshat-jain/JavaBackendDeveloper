package MultiThreading;

public class MultiTHreading extends Thread {
	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println(Thread.currentThread().getName());
		}
	}
	public static void main(String[] args) throws InterruptedException {
//		How to check a thread is alive or not? 
		MultiTHreading thread=new MultiTHreading();
		System.out.println("before start() method calling:-"+thread.isAlive());
		thread.start();
		System.out.println("Just After Start start() method calling:-"+thread.isAlive());
		for(int i=0;i<10;i++) {
			System.out.println(Thread.currentThread().getName());
			
		}
		System.out.println("THe end of main() "+thread.isAlive());
		
//		How to check a thread has stop or not?
//		How to get the name of a running thread? 
		MultiTHreading thread2=new MultiTHreading();
		System.out.println(thread2.currentThread().getName()+" : "+thread2.currentThread().getState());
		thread2.start();
		thread2.join();
		thread.join();
		System.out.println(thread2.currentThread().getName()+" : "+thread2.currentThread().getState());
		System.out.println(thread.currentThread().getName()+" : "+thread.currentThread().getState());
		
		
	}

}
