package threading;

public class ReadThread extends Thread {
	public void run() {
		
		int lastValue = Main.counter;
		
		//Checking if value getting changed or not.
		//If we don't use counter as volatile, the latest value of the counter won't be fetched
		//from the main memory and hence this Got changed message will only be printed once and
		//even though there is a change in the counter value, it won't reflect. 
		
		while(true) {
			if(lastValue != Main.counter) {
				System.out.println("Got changed to: "+Main.counter);
				lastValue = Main.counter;
			}
		}
	}
}
