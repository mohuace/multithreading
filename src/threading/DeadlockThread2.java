package threading;

public class DeadlockThread2 extends Thread {
	
	private final Object obj1;
	private final Object obj2;
	
	public DeadlockThread2(Object obj1, Object obj2) {
		this.obj1 = obj1;
		this.obj2 = obj2;
	}
	
	
	public void run() {
		synchronized(obj2) {
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("Thread 2 has access to the resource obj2 and currently running it");
			
			
			synchronized(obj1) {
				System.out.println("Thread 2 has access to the resource obj1 and is currently running it");
			}
		}
	}

}
