package threading;

public class Practice1 extends Thread {
	
	private PracticeCount pracObj;
	
	public Practice1(PracticeCount pracObj) {
		this.pracObj = pracObj;
	}
	
	public void run() {		
		pracObj.increment();
	}

}
