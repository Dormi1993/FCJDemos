package com.fcj.thread;

/**
 * Created by Administrator on 2017/2/8 0008.
 */
public class TestJoin {
    public static void main(String[] args){
        MyThread2 t1 = new MyThread2("t1abc");
        t1.start();
        try {
            t1.join();//t1线程执行完之后再执行main线程，相当于方法调用了
        } catch (InterruptedException e) {

        }
        for (int i = 1; i <= 5; i++){
            System.out.println("I am main thread");
        }

    }
}

class MyThread2 extends Thread{
    MyThread2(String s){
        super(s);
    }
    public void run(){
        for (int i = 1;i <= 5; i++){
            System.out.println(" I am " + getName());
            try {
                sleep(1000);
            } catch (InterruptedException e){
                return;
            }
        }
    }
}
