package threading.race_condition_2;

public class Thread1 implements Runnable {
    private int id;
    Thread1(Integer id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Thread "+id +" is running");
    }
}
