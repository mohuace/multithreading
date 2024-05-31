package threading;

public class InterruptDemo extends Thread {
	
	
	//When there is an interrupt sent, if we haven't handled it anywhere, the thread won't stop running
	//and run normally. But we need to handle it
	public void test() throws InterruptedException {
		System.out.println("This is a test method which will run forever till it is interrupted");
		
		while(!Thread.currentThread().isInterrupted()) {
			//doing nothing here
		}
		
		throw new InterruptedException();
	}
	
	
	public void run() {
		//calling a method
		
		try {
			test();
		} catch (InterruptedException e) {
			System.out.println("Thread Interrupted");
		}
		
		System.out.println("Doing some work");
	}
}
