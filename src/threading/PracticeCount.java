package threading;

public class PracticeCount {
	private int val = 5;
	
	public synchronized void increment() {
		
		int tmp = val;
		
		//Thread 1 and Thread 2 won't read 5 at the same time because tmp = val is an atomic operation. But,
		//what will happen here is if the method isn't synchronized, then t1 will read 5 and then go sleep.
		//then t2 will read 5 again and go to sleep. Then t1 will update val = 6, but t2 will do the same as well because it
		//already read tmp = 5 so it will make val = 6 as well. This is an issue, hence we need to make increment() synchronized.
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		val = tmp + 1;
	}
	
	public int getVal() {
		return val;
	}
	
}
