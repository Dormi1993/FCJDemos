package com.fcj.thread;

import java.util.Date;

/**
 * Created by Administrator on 2017/2/8 0008.
 */
public class TestInterrupt {
    public static void main(String[] args){

        MyThread thread = new MyThread();
        thread.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {

        }
        thread.interrupt();
//            thread.stop();一般很少用stop，因为太粗暴了，影响会很大
    }
}

class MyThread extends Thread{
    public void run(){
        while (true){
            System.out.println("===" + new Date() + "===");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
