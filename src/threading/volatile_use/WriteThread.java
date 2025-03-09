package threading.volatile_use;

public class WriteThread extends Thread {
    @Override
    public void run() {
        while(true) {
            System.out.println("Incrementing counter to "+MainClass.counter++);

            try {
                Thread.sleep(600);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
