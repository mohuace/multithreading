package threading;

public class DeadlockThread1 extends Thread {
	
	private final Object obj1;
	private final Object obj2;
	
	public DeadlockThread1(Object obj1, Object obj2) {
		this.obj1 = obj1;
		this.obj2 = obj2;
	}
	
	
	public void run() {
		synchronized(obj1) {
			
			//Need to add a small sleep because sometimes
			//thread 1 will acquire obj1, release it and then aquire obj2 and release it.
			//then thread2 will aquire obj2 and release it and then aquire obj1 and release it.
			//this will not create deadlock
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("Thread 1 has access to the resource obj1 and currently running it");
			
			
			synchronized(obj2) {
				System.out.println("Thread 1 has access to the resource obj2 and is currently running it");
			}
		}
	}
	

}
