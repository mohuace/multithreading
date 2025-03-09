package threading.synchronization;

public class MainThread {
    public static void main(String[] args) throws InterruptedException {


//        Counter counter = new Counter();
//
//        for(int i = 0 ;  i < 10 ; i++) {
//            ThreadSync thread = new ThreadSync(counter);
//            thread.start();
//        }




        //while(true) {
            PracCount pracCount = new PracCount();
            Thread thread1 = new Thread1(pracCount);
            Thread thread2 = new Thread1(pracCount);
            thread1.start();
            thread2.start();

            thread1.join();
            thread2.join();

            //If not put join, the main thread wont wait for the threads to finish before printing

            System.out.println(pracCount.getCount());
        //}



    }
}
