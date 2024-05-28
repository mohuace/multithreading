package threading;

public class Practice2 extends Thread {
	
	
	private PracticeCount pracObj;
	
	public Practice2(PracticeCount pracObj) {
		this.pracObj = pracObj;
	}
	
	public void run() {

		pracObj.increment();
	}
}
