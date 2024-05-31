package threading;

public class InterruptThread extends Thread {
	
	public void ownBlockingMethod() throws InterruptedException {
		//
		while(!Thread.interrupted()) {
			//Doing some work
			System.out.println("Doing some work");
		}
		
		//Thread has been interrupted
		throw new InterruptedException();
		
	}
	
	public void run() {
		//Put a wait for 15 seconds...sleep throws interrupted exception so we
		//wait for some amount of time and handle the exception in the catch block
		//when it is interrupted.
		
		try {
			//Sleep is the built in blocking call that throws interrupted exception
			//Thread.sleep(15000);
			
			//Created own blocking call that will throw an interrupted exception when interrupted
			ownBlockingMethod();
			
		} catch (InterruptedException e) {
			System.out.println("Thread has been interrupted");
			return;
		}
		
		//This won't be printed
		System.out.println("Making sure code isn't reaching here");
	}
}
