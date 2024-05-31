package threading;

public class Consumer extends Thread {
	private MessageBean message;
	
	public Consumer(MessageBean message) {
		this.message = message;
	}
	
	public void run() {
		synchronized(message) {
			//We need synchronized because lets say message.getM() is null,
			//but before executing wait(), the producer sets the message to a
			//particular value and sends the notify signal. This will make the notify
			//wasted and then the consumer thread will again run from where it was left
			//of and execute wait, it won't receive any new notify and hence will 
			//keep waiting forever. Therefore, we need synchronization.
			//We are updating the message object in Producer and accessing it in Consumer. If there
			//is no synchronization, we won't have control over the order of execution.
			if(message.getM() == null) {
				
				try {
					//This will release lock and wait for notify
					message.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					System.out.println(e);
				}
				
				System.out.println("Received message: "+message.getM());
			}
			
			//put print here?
			System.out.println("Message already produced:"+message.getM());
		}
	}
}
