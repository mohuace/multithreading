package threading;

public class Volatile {
	
	//If we don't keep this volatile, java will not stop the VolatileThread even when stopping
	//signal is sent. This is because it keeps a local cache in the memory and hence latest
	//value of running variable is not updated and hence the thread doesn't stop running
	//even when the value of the variable is changed. keeping the variable volatile
	//ensures that the latest value is fetched from the main memory which doesn't cause
	//any problems.
	public volatile boolean running = true;
	
	public void stop() {
		running = false;
	}
}
