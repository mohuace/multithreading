package threading;

public class Thread3 extends Thread {
	
	private int threadId;
	
	public Thread3(int id) {
		//System.out.println("Thread "+id+" created");
		threadId = id;
	}
	
	public void run() {
		System.out.println("Thread "+threadId+ " Running");
	}
}
