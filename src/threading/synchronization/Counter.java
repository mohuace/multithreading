package threading.synchronization;

public class Counter {

    private int count = 0;

    public void increment() {
        count = count + 1;
    }

    public void decrement() {
        count = count - 1;
    }

    public int getCount() {
        return count;
    }
}
