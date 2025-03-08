package threading;

public class ThreadSync extends Thread {
	
	private Counter counter;
	
	public ThreadSync(Counter counter) {
		this.counter = counter;
	}
	
	
	public synchronized void run() {
		
		//Running inside while loop to make the issue visible.
		//Basically each thread is running indefinitely and updating the same counter object
		//So the issue can occur that one thread increments, other increments as well at the 
		//same time and some third thread printing the get count at the same time. 
		//So we won't get 0 (which is desired value).
		
		while(true) {
			
			counter.increment();
//			
//			//Using synchronized keyword on the methods seems to be working fine.
//			//However, problem arises when we use thread.sleep.
//			//What I think will happen is thread 1 acquires the lock, releases it and then goes to sleep
//			//in the meanwhile other thread comes in and increments the counter then again goes to sleep
//			//this will happen for 100 threads and somewhere in between a thread will wake up and do
//			//decrement and then get the count which will definitely not be 0.
			try {
				Thread.sleep(1000);
			} catch(Exception e) {
				System.out.println(e);
			}

			//Even if do a synchronized on increment and decrement, that will make increment and decrement
			//as atomic. However, this particular block entirely is not atomic, so when one thread goes to sleep
			//other thread can come and update which will give strange results
			//counter.increment(), counter.decrement(), counter.getCount(), these 3 are individually atomic but
			//not atomic together as a whole.

			counter.decrement();

			System.out.println(counter.getCount());
			
			//This will create critical section based on counter object
			//If we use "this" object, it will create CS based on Thread objects -- as good as non synchronized
			//That will again cause random results because new CS will be created for each thread
			//and then all of them will update the count randomly because there would be separate
			//rooms for each thread
			//ASK - Do we still need synchronized methods in Counter class?
			//I dont think so because we have made the entire operation of increment, decrement and print as atomic,
			//so it doesnt matter whether individual methods are kept as atomic (synchronized) or not
//			synchronized(counter) {
//				counter.increment();
//				try {
//					Thread.sleep(1000);
//				} catch(Exception e) {
//					System.out.println(e);
//				}
//
//				counter.decrement();
//
//				System.out.println(counter.getCount());
//			}
		}
	}
	
	
}
