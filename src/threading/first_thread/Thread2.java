package threading.first_thread;

public class Thread2 implements Runnable{
    @Override
    public void run() {
        System.out.println("This is the thread called "+Thread.currentThread().getName() + " created by implementing runnable");
    }
}
