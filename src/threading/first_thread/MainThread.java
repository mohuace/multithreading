package threading.first_thread;

public class MainThread {
    public static void main(String[] args) {
        final Thread1 thread1 = new Thread1();
        thread1.start();

        final Runnable runnable = new Thread2();
        Thread thread2 = new Thread(runnable);

        thread2.start();
    }
}
