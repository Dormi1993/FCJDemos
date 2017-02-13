package com.fcj.thread;

/**
 * Created by dormi on 2017/2/10.
 */
public class TT implements Runnable{
    int b = 100;

    public synchronized void m1() throws Exception {
        b = 1000;
        Thread.sleep(5000);
        System.out.println("b = " + b);
    }

    public void m2(){
        System.out.println(b);
    }
    public synchronized void m3() throws Exception {
        Thread.sleep(3000);
        b = 2000;
//        System.out.println("m3'b = " + b);//有没有这句，线程执行顺序不一样

    }

    @Override
    public void run() {
        try {
            m1();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        TT tt = new TT();
        Thread t = new Thread(tt);
        t.start();

//        Thread.sleep(1000);
//        tt.m2();

//        Thread.sleep(100);

        //下面这俩是同一线程？
        tt.m3();
        System.out.println(tt.b);

    }
}
