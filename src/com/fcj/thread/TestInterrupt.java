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
//            thread.stop();一般很少用stop，因为太粗暴了，影响会很大
        thread.interrupt();//其实interrupt也比较粗暴，虽然比stop好一些
        //好的方法是看TestThread4
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
