package threading;

public class ImmClass {
	private final int value;
	
	public ImmClass(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
}
