package threading;

public class Main {
	
	//If this isn't volatile, the read thread does not take latest value from main memory
	//It will take value from cache
	public static volatile int counter = 0;
	
	public static void main(String[] args) {
		//System.out.println("Hello world");
		
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
//		Counter counter = new Counter();
//		
//		for(int i = 1 ; i <= 100 ; i++) {
//			
//			Thread thread = new ThreadSync(counter);
//			thread.start();
//		}
		
		
		//Volatile Demo - 1
//		Volatile volObj = new Volatile();
//		Thread volThread = new VolatileThread(volObj);
//		volThread.start();
//		
//		//Waiting for the thread to start because stopping signal sent is getting printed first
//		try {
//			Thread.sleep(1000);
//		} catch(Exception e) {
//			System.out.println(e);
//		}
//		
//		volObj.running = false;
//		System.out.println("Stopping signal sent");
		
		
		//Volatile Demo - 2
//		new ReadThread().start();
//		new WriteThread().start();
		
		
		//Synchronization Demo - 2
//		while(true) {
//			PracticeCount countObj = new PracticeCount();
//			Thread t1 = new Practice1(countObj);
//			Thread t2 = new Practice2(countObj);
//			
//			t1.start();
//			t2.start();
//			
//			try {
//	            t1.join(); // Wait for t1 to finish
//	            t2.join(); // Wait for t2 to finish
//	        } catch (InterruptedException e) {
//	            e.printStackTrace();
//	        }
//			
//			System.out.println(countObj.getVal());
//		}
		
	}
}
