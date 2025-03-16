package threading.prod_cons;

public class MainThread {
    public static void main(String[] args) {
        MessageModel msg = new MessageModel();
        Producer producer = new Producer(msg);
        Consumer consumer = new Consumer(msg);

        producer.start();
        consumer.start();
    }
}
