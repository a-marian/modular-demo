package com.modular.demo.client;

import com.modular.demo.consumer.Consumers;
import com.modular.demo.producer.Producer;

import java.util.concurrent.ArrayBlockingQueue;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<>(5);
        Producer producer = new Producer(arrayBlockingQueue);
        Consumers consumers = new Consumers(arrayBlockingQueue);
    }
}