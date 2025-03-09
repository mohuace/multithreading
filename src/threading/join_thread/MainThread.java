package threading.join_thread;

public class MainThread {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new JoinThread();

        t1.start();

        //It will wait for t1 to finish execution, main thread will be blocked till that time
        t1.join();

        System.out.println("Exiting main thread");
    }
}
