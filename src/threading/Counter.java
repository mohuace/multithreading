package threading;

public class Counter {
	private int count;
	
	//Keeping the methods synchronized means no two threads will enter any of the
	//methods at the same time
	
	public synchronized void increment() {
		count++;
	}
	
	public synchronized void decrement() {
		count--;
	}
	
	public synchronized int getCount() {
		return count;
	}
}
