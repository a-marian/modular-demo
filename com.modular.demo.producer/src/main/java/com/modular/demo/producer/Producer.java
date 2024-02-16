package com.modular.demo.producer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Producer {

    private ArrayBlockingQueue<Integer> arrayBlockingQueue;

    public Producer(ArrayBlockingQueue<Integer> arrayBlockingQueue){
        this.arrayBlockingQueue = arrayBlockingQueue;

        Runnable producer = () -> {
            int a = 0;
            while(true){
                try{
                    arrayBlockingQueue.put(++a);
                    System.out.println("Added: "+ a);
                    TimeUnit.MILLISECONDS.sleep(1000);
                } catch(InterruptedException ex){
                    ex.printStackTrace();
                }
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(producer);
        executorService.shutdown();
    }

}
