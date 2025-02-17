package concurrency_multithreading.practice;

import java.util.LinkedList;

public class p2BlockingQueue<T> {
    private final int capable =10 ;
    private final LinkedList<T> blockingQueue = new LinkedList<T>();

    public synchronized void put(T value) throws InterruptedException {
        while (blockingQueue.size() == capable){
            System.out.println("Queue is full");
            wait();
        }
        blockingQueue.addFirst(value);
        notify();
    }

    public synchronized void take() throws InterruptedException {
        while (blockingQueue.isEmpty()){
            System.out.println("Queue is empty");
            wait();
        }
        notify();
        blockingQueue.removeFirst();
    }

    public synchronized int size(){
        return blockingQueue.size();
    }
}
