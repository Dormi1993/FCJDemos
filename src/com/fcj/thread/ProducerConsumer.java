package com.fcj.thread;

/**
 * Created by dormi on 2017/2/11.
 */
public class ProducerConsumer {
    public static void main(String[] args){
        SyncStack ss = new SyncStack();
        Producer p = new Producer(ss);
        Consumer c = new Consumer(ss);

        new Thread(p).start();
        new Thread(p).start();
        new Thread(p).start();
        new Thread(c).start();


    }
}

class WoTou{
    int id;
    WoTou(int id){
        this.id = id;
    }
    public String toString(){
        return "WoTo: " + id;
    }
}

class SyncStack{
    int index = 0;
    WoTou[] arrWT = new WoTou[6];

    public synchronized void push(WoTou wt){
        while (index == arrWT.length){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notifyAll();
        arrWT[index] = wt;
        index++;
    }

    public synchronized WoTou pop(){
        while (index == 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notifyAll();
        index--;
        return arrWT[index];
    }

}

class Producer implements Runnable{

    SyncStack ss = null;

    Producer(SyncStack ss){
        this.ss = ss;
    }

    @Override
    public void run() {

        for (int i = 0; i < 20; i++){
            WoTou wt = new WoTou(i);
            ss.push(wt);
            System.out.println("生产了：" + wt.id);
            try {
                Thread.sleep((int) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable{

    SyncStack ss = null;

    Consumer(SyncStack ss){
        this.ss = ss;
    }

    @Override
    public void run() {

        for (int i = 0; i < 60; i++){
            WoTou wt = ss.pop();
            System.out.println("消费了：" + wt);
            try {
                Thread.sleep((int) (Math.random() * 200));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

//当生产者快的时候，很快就满了，所以push方法wait住了，
// 接着消费者慢慢消化，消化完之后pop方法中没有notify的话，不会唤醒push方法
//反之亦然

//notifyall是唤醒它本身之外的线程

//还有一个潜在性的问题是，不能用if来判断匡是否满了或者为空，因为如果是if，
// 当index满了，但突然有一个打断，那么程序还能继续往下执行下去。如果是while则会返回继续判断是否满了。

//如果有三个生产者，一个消费者，那么消费者for循环里面需要是<60