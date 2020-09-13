package com.producerconsumer.example;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Queue<Integer> dataSource = new LinkedList<>();

        Runnable producer = () -> {
            Integer value = new Random().nextInt(100);
            dataSource.add(value);
            System.out.println("Value produced : " + value);
        };

        Runnable consumer = () -> {
            Integer value1 = dataSource.poll();
            System.out.println("Value consumed : " + value1);
        };

        Thread producerThread = new Thread(producer, "producer1");
        producerThread.start();
        producerThread.join();

        Thread consumerThread = new Thread(consumer, "consumer1");
        consumerThread.start();
        consumerThread.join();
    }
}
