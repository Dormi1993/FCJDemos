package com.fcj.thread;

/**
 * Created by dormi on 2017/2/8.
 */
public class TestThread4 {
    public static void main(String[] args){

        Runner4 r = new Runner4();
        Thread t1 = new Thread(r);
        t1.start();

        for (int i = 0; i < 100000; i++){
            if (i % 10000 == 0 & i > 0){
                System.out.println("in main thread i = " + i);
            }
        }
        System.out.println("Thread main is over.");
        r.shutdown();


    }
    protected void ss(){

    }
}

class gg {
    static void hh(){

    }
}

class Runner4 extends gg implements Runnable{

    private boolean flag = true;
    int i = 0;
    @Override
    public void run() {
        while (flag){
            System.out.println(" " + i++);
        }
    }

    public void shutdown(){
        flag = false;
        TestThread4 testThread4 = new TestThread4();
        testThread4.ss();

        gg.hh();



    }


}




