package threading.synchronization;

import threading.PracticeCount;

public class Thread1 extends Thread {

    private PracCount pracObj;

    public Thread1(PracCount pracObj) {
        this.pracObj = pracObj;
    }

    public void run() {
        try {
            pracObj.increment();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //System.out.println(pracObj.getCount());
    }
}
