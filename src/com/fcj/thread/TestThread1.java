package com.fcj.thread;

/**
 * Created by Administrator on 2017/2/8 0008.
 */
public class TestThread1 {
    public static void main(String args[]){
        Runner1 r = new Runner1();

//        r.run();这个是方法调用，不是多线程

//        Thread t = new Thread(r);
//        t.start();

        Runner2 r2 = new Runner2();
        //因为Runner2本身就是一个Thread，不用new一个Thread了
        r2.start();

        for (int i = 0; i < 100; i++){
            System.out.println("Main Thread:----" + i);
        }
    }
}

class Runner1 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++){
            System.out.println("Runner1: " + i);
        }
    }
}

class Runner2 extends Thread{
    public void run() {
        for (int i = 0; i < 100; i++){
            System.out.println("Runner2: " + i);
        }
    }
}
