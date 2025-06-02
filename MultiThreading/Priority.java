package MultiThreading;

public class Priority extends Thread {
	@Override
	public void run() {
		for(int i=0;i<5;i++) {
			System.out.println("The Thread"+Thread.currentThread().getName());
			System.out.println("The Id:-" + Thread.currentThread().getId());
			System.out.println("The Thread priority:-"+Thread.currentThread().getPriority());
		}
	}
	
	public static void main(String[] args) {
//		How to set the priority of a thread?
		Priority thread1=new Priority();
		Priority thread2=new Priority();
		Priority thread3=new Priority();
		thread1.setPriority(MAX_PRIORITY);	
		thread2.setPriority(MIN_PRIORITY);	
		thread3.setPriority(NORM_PRIORITY);	
		thread1.start();
		thread2.start();
		thread3.start();
		
		}

}
