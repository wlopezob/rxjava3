package com.callback;

import com.callback.callback.CallBack;

public class Main {

    public static void main(String[] args) throws InterruptedException {
	      System.out.println("Main Thread is running");
        Runnable r = new Runnable() {
            @Override
            public void run() {
                new Main().runningAsyn(new CallBack() {
                    @Override
                    public void call() {
                        System.out.println("Callback called");
                    }
                });
            }
        };
        Thread t = new Thread(r);
        t.run();

        Thread.sleep(2000);
        System.out.println("Main Thread completed");
    }

    public void runningAsyn(CallBack callBack){
        System.out.println("I am running in separate thread");
        sleep(1000);
        callBack.call();
    }

    private void sleep(int duration){
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
