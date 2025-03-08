package threading.synchronization;

public class MainThread {
    public static void main(String[] args) {


        Counter counter = new Counter();

        for(int i = 0 ;  i < 10 ; i++) {
            ThreadSync thread = new ThreadSync(counter);
            thread.start();
        }


    }
}
