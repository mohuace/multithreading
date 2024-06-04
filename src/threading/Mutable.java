package threading;

public class Mutable extends Immutable {
	//Because the Immutable class is not final, we can create subclass
	//Creating this variable to spoil the immutable property
	public int val;
	
	public Mutable(int value) {
		super(value);
		val = value;
	}
	
	public int getValue() {
		return val;
	}
	
	public void setValue(int newVal) {
		val = newVal;
	}
}
