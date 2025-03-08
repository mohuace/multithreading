package threading.synchronization;

public class ThreadSync extends Thread {

    private Counter counter;

    ThreadSync(Counter counter) {
        this.counter = counter;
    }

    public void run() {

        //synchronized (counter) {

            //while (true) {

                counter.increment();

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                counter.decrement();

                System.out.println("THe count is " + counter.getCount() + "and the thread is "+getName());

            //}

        //}

    }
}
