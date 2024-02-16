package com.modular.demo.consumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Consumers {

    ArrayBlockingQueue<Integer> arrayBlockingQueue;

    public Consumers(ArrayBlockingQueue<Integer> arrayBlockingQueue){
        this.arrayBlockingQueue = arrayBlockingQueue;

        Runnable consumer = () -> {
            while(true) {
                try{
                    TimeUnit.MILLISECONDS.sleep(5000);
                    Integer poll;
                    poll = arrayBlockingQueue.take();
                    System.out.println("Polled: "+ poll);
                    TimeUnit.MILLISECONDS.sleep(20);
                } catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(consumer);
        executorService.shutdown();
    }

}
