package threading;

public class WriteThread extends Thread {
	public void run() {
		while(true) {
			Main.counter++;
			
			try {
				Thread.sleep(600);
			} catch (Exception e) {
				System.out.println(e);
			}
			
			System.out.println("Incremented the value to "+Main.counter);
		}
	}
}
