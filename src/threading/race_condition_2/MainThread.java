package threading.race_condition_2;

public class MainThread {
    public static void main(String[] args) {



        for(int i = 0 ; i < 10 ; i++) {
            final Runnable runnable = new Thread1(i);
            Thread thread = new Thread(runnable);
            thread.start();
        }
    }
}
