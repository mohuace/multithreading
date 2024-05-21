package threading;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello world");
		
		//Using extend thread method to create thread
		//ASK - Why final?
//		final Thread thread1 = new Thread1();
//		thread1.start();
//		
//		//Using runnable interface to create threads
//		final Runnable runnable = new Thread2();
//		Thread thread2 = new Thread(runnable);
//		thread2.start();
//		
//		
//		//Showing threads not running in the same order they were created.
//		for(int i = 1 ; i<=10 ; i++) {
//			final Thread thread3 = new Thread3(i);
//			thread3.start();
//		}
		
		
		//Synchronization Demo - Why is it required?
		//We will keep the counter object same and generate multiple threads
		//We will have our threads perform increment and decrement.
		//Putting the Counter counter = new Counter() line inside the for loop will not cause
		//any issues because every thread will have its own separate counter object and it will repeatedly
		//increment and decrement that object itself.
		Counter counter = new Counter();
		
		for(int i = 1 ; i <= 100 ; i++) {
			
			Thread thread = new ThreadSync(counter);
			thread.start();
		}
		
		
	}
}
