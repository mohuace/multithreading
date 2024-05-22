package threading;

public class ReadThread extends Thread {
	public void run() {
		
		int lastValue = Main.counter;
		
		//Checking if value getting changed or not
		
		while(true) {
			if(lastValue != Main.counter) {
				System.out.println("Got changed to: "+Main.counter);
				lastValue = Main.counter;
			}
		}
	}
}
