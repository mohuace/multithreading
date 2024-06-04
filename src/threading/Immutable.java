package threading;


//I am trying to make this class immutable but not keeping the class final
public class Immutable {
	//Field is private final because we want immutable objects
	private final int value;
	
	public Immutable(int val) {
		value = val;
	}
	
	
	public int getValue() {
		return value;
	}
	
	
	
	
}
