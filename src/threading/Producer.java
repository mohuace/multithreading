package threading;

public class Producer extends Thread {
	
	private MessageBean message;
	
	public Producer(MessageBean message) {
		this.message = message;
	}
	
	public void run() {
		//Produce something -- in this case just sleep - in the meanwhile
		//consumer can run and wait for the notification
		//If we put this sleep inside synchronized block, the producer will aquire this lock while its sleeping
		//and only release the lock after setting message and sending notification (which is useless because message.wait() on
		//will not have been called yet). This means when consumer aquires lock next, this will make if statement false and the 
		//print statement outside will be executed that the message has already been produced. 
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		synchronized(message) {
			
			message.setM("Produced something");
			
			message.notify();
			
		}
	}
}
