package threading.volatile_use;

public class ReadThread extends Thread{
    @Override
    public void run() {

        int lastValue = MainClass.counter;

        while(true) {
            if(lastValue != MainClass.counter) {
                System.out.println("Counter got changed to "+MainClass.counter);
                lastValue = MainClass.counter;
            }
        }
    }
}
