package threading.synchronization;

public class PracCount {
    private int val = 5;

    public synchronized void increment() throws InterruptedException {
        int tmp = val;

        Thread.sleep(500);

        val = tmp + 1;
    }

    public int getCount() {
        return val;
    }
}
