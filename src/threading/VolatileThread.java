package threading;

public class VolatileThread extends Thread {
	
	private Volatile volatileObj;
	
	public VolatileThread(Volatile volatileObj) {
		this.volatileObj = volatileObj;
	}
	
	public void run() {
		System.out.println("Running");
		
		while(volatileObj.running) {
			//System.out.println("Thread is running");
		}
		
		System.out.println("Stopping");
	}
}
