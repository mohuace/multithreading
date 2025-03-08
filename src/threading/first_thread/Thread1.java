package threading.first_thread;

public class Thread1 extends Thread {
    public void run() {
        System.out.println("This is the thread called "+getName() + " created by extending Thread class");
    }
}
