package threading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

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
		Counter counter = new Counter();

		for(int i = 1 ; i <= 100 ; i++) {

			Thread thread = new ThreadSync(counter);
			thread.start();
		}
		
		
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
		
		
		//Join thread demo
//		Thread t1 = new JoinThread();
//		t1.start();
//		
//		//Main thread will wait for t1 to finish executing (exit run method) and then the rest of the code
//		//will be executed.
//		try {
//			t1.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		System.out.println("Exiting main thread");
		
		
		//Producer Consumer Demo
//		MessageBean message = new MessageBean();
//		Producer thread1 = new Producer(message);
//		Consumer thread2 = new Consumer(message);
		
		//thread1.start();
//		
//		//If we add a long wait after thread1.start, what this will do is producer will wait for 2 seconds,
//		//then main thread will wait another 5 seconds in the meanwhile producer will wake up and produce message
//		//and then send notify. This notify signal goes waste because there is no thread waiting for the notification.
//		//Thread 2 which is the consumer will be called, then it will aquire the lock on the object and then
//		//because the message is already produced, the print statement outside will be printed.
//		
//		
//		//Normal behaviour that we want is producer wait for 2 seconds, in the meanwhile consumer will aquire the lock and
//		//call wait, this will release the lock and then the producer will produce message and send notify which will release lock,
//		//this will wake up consumer which will again aquire the lock and then print the message that the message
//		//has been produced.
		
		
		//This code ensures that if producer is running first entirely, then it will produce the message and 
		//consumer can directly print that message. However, if producer is going to sleep and then consumer 
		//is aquiring lock before message has been produced, then it will wait for the producer to produce the
		//message and then consume the data. So it works always.
//		
////		try {
////			Thread.sleep(5000);
////		} catch (InterruptedException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
//		
		//thread2.start();
		
		
		//Interrupts - Demo 1
//		Thread interruptThread = new InterruptThread();
//		interruptThread.start();
//		
//		//Make sure that the thread starts and then we interrupt it
//		
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		interruptThread.interrupt();
		
		//Interrupts - Demo 2
		//I want to check what if we send interrupt to a thread and there is no throw new InterruptedException called
//		Thread intThread = new InterruptDemo();
//		intThread.start();
//		
//		//Waiting for thread to start
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		intThread.interrupt();
		
		
		//Understanding the importance of having Immutable classes as final
//		Immutable immutable = new Immutable(5);
//		Mutable mutable = new Mutable(6);
//		
//		System.out.println(immutable.getValue());
//		
//		
//		//The mutable object's reference is copied to the immutable object
//		//so whatever updates we do on the mutable object will be reflected on the "immutable" object too.
//		//Hence we need immutable class to be final.
//		immutable = (Immutable) mutable;
//		
//		
//		mutable.setValue(25);
//		
//		System.out.println(immutable.getValue());
		
		
		//Understanding Immutable class but mutable object references
//		ImmClass immObj1 = new ImmClass(5);
//		ImmClass immObj2 = new ImmClass(6);
//		
//		immObj2 = immObj1;
//		
//		//Because the reference of the immObj1 object is copied to immObj2, output will be 5
//		System.out.println(immObj2.getValue());
//		
//		//We can keep the objects final as well.
//		final ImmClass im1 = new ImmClass(5);
//		final ImmClass im2 = new ImmClass(6);
//		
//		//Throws error because we can't change.
//		//im2 = im1;
//		
//		//Should print 6
//		System.out.println(im2.getValue());
		
		
		//Example of Immutable Class
//		List<String> carIngredients = new ArrayList<String>();
//		
//		carIngredients.add("tyre");
//		carIngredients.add("wipers");
//		
//		final Product prod = new Product("Car", 123, carIngredients);
//		
//		carIngredients.add("windows");
//		
//		//This will return tyre and wipers when immutable class
//		//or tyre wipers and windows when mutable
//		System.out.println(prod.getIngredients());
//		
//		//Need to make sure the method also does not return the reference
//		List<String> carss = prod.getIngredients();
//		
//		try {
//			carss.add("Dummyyy");
//		} catch(UnsupportedOperationException e) {
//			System.out.println(e);
//		}
//		
//		
//		System.out.println(prod.getIngredients());
		
		//Atomic Variables - AtomicInteger and AtomicReference
		final AtomicInteger atomicInt = new AtomicInteger(0);
		//This happens atomically - non divisible
		atomicInt.incrementAndGet();
		System.out.println("Value is: "+atomicInt);
		
		atomicInt.addAndGet(10);
		System.out.println("Value is: "+atomicInt);
		
		final AtomicReference<String> atomicString = new AtomicReference<String>("boss");
		boolean changed = atomicString.compareAndSet("boss", "BOSS");
		
		System.out.println("Changed: "+changed+" ,value is: "+atomicString);
		
		
		
		
		
		//Deadlocks
		//When two threads are waiting for each other to release a lock,
		//it causes deadlock
		
//		Object obj1 = new Object();
//		Object obj2 = new Object();
//		
//		final Thread thread1 = new DeadlockThread1(obj1, obj2);
//		final Thread thread2 = new DeadlockThread2(obj1, obj2);
//		
//		thread1.start();
//		thread2.start();
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
