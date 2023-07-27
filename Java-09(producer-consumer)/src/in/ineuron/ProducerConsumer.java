package in.ineuron;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {
    private static final int MAX_CAPACITY = 5;
    private static final int NUM_ITEMS = 10;

    private static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {
        // Create producer and consumer threads
        Thread producerThread = new Thread(new Producer());
        Thread consumerThread = new Thread(new Consumer());

        // Start the threads
        producerThread.start();
        consumerThread.start();
    }

    static class Producer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < NUM_ITEMS; i++) {
                synchronized (queue) {
                    // Wait if the queue is full
                    while (queue.size() == MAX_CAPACITY) {
                        try {
                            System.out.println("Producer is waiting. Queue is full.");
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    // Generate a random number and add it to the queue
                    int number = (int) (Math.random() * 100);
                    queue.add(number);
                    System.out.println("Producer produced: " + number);

                    // Notify the consumer that an item is added to the queue
                    queue.notifyAll();
                }
            }
        }
    }

    static class Consumer implements Runnable {
        @Override
        public void run() {
            int sum = 0;
            for (int i = 0; i < NUM_ITEMS; i++) {
                synchronized (queue) {
                    // Wait if the queue is empty
                    while (queue.isEmpty()) {
                        try {
                            System.out.println("Consumer is waiting. Queue is empty.");
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    // Remove the number from the queue and calculate the sum
                    int number = queue.poll();
                    sum += number;
                    System.out.println("Consumer consumed: " + number);

                    // Notify the producer that an item is consumed from the queue
                    queue.notifyAll();
                }
            }

            System.out.println("Sum of consumed numbers: " + sum);
        }
    }
}
