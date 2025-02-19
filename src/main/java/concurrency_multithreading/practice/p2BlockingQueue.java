package concurrency_multithreading.practice;

import java.util.LinkedList;

public class p2BlockingQueue<T> {
    private final LinkedList<T> blockingQueue = new LinkedList<T>();

    public synchronized void put(T value) throws InterruptedException {
        int capable = 10;
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
        blockingQueue.removeFirst();
        notifyAll();
    }

    public synchronized int size(){
        return blockingQueue.size();
    }

    public synchronized T getValue(){
        if(blockingQueue.isEmpty()) return null;
        return blockingQueue.getFirst();
    }
}
