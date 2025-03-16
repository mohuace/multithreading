package threading.prod_cons;

public class Producer extends Thread {

    MessageModel msg;

    Producer(MessageModel msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        //I want in multithreading, it should come to producer first
        //for that on consumer side we will keep a wait
        //When producer is producing, we dont want consumer to consume, so needs to be inside CS
        synchronized (msg) {


            //Mocking some producer work
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            msg.setMessage("The producer has produced");
            //Once producer has produced, it is ready to release lock but before that it can send a notify
            //Saying that the producer has finished work....There should be some thread waiting for this notification
            //That would be on the consumer side
            msg.notify();

        }
    }
}
