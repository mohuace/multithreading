package threading.prod_cons;

public class Consumer extends Thread {

    MessageModel msg;

    Consumer(MessageModel msg) {
        this.msg = msg;
    }

    @Override
    public void run() {

        //Two scenarios:
        //1. Thread goes to producer, aquires lock and then producer will finish execution and send a notify (which is wasted but its fine)
        //Then consumer thread goes inside CS, because the msg is not null, the consumer can directly consume the msg without waiting for it
        //2. Thread goes to consumer first and aquire lock...in this case, since msg will be null, it will do a wait where consumer will release the lock
        //and wait for producer to send a notify...and once the producer finishes execution and sends a notify, the consumer will again aquire the lock
        //and perform the consumption.

        synchronized (msg) {

            //If the message is not produced yet
            if (msg.getMessage() == null) {
                //THis means consumer needs to wait for the msg to be produced
                //Lets say we have not synchronized and consumer reaches here
                //and producer finishes execution and sends a notify...now since consumer
                //has not yet run msg.wait(), when it goes there, it will wait forever
                //because the notify of producer was missed...
                try {
                    //It will release the lock on the current thread and therefore the producer can
                    //aquire the lock
                    //Once producer sends a notify, it will release and consumer will reaquire the lock.
                    msg.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            //Once producer sends a notify, consumer will start doing work

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("The consumed message is " + msg.getMessage());

        }

    }


}
