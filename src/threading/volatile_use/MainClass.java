package threading.volatile_use;

public class MainClass {

    public static volatile int counter = 0;

    public static void main(String[] args) {
        Thread t1 = new ReadThread();
        Thread t2 = new WriteThread();

        t1.start();
        t2.start();

    }
}
