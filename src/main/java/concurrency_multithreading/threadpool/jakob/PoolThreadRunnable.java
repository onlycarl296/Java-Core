package concurrency_multithreading.threadpool.jakob;

import java.util.concurrent.BlockingQueue;

public class PoolThreadRunnable implements Runnable{

    private Thread thread = null;
    private BlockingQueue tasQueue =null;
    private boolean isStopped = false ;

    public PoolThreadRunnable(BlockingQueue queue){
        tasQueue = queue ;
    }

    @Override
    public void run() {
        this.thread = Thread.currentThread();
        while (!isStopped()){
            try {
                Runnable runnable =(Runnable) tasQueue.take();
                runnable.run();
            }catch (Exception e){
                //log or otherwise report exception
                //but keep pool alive
            }
        }
    }

    public  synchronized  void doStop(){
        isStopped = true;
        //break pool thread out of dequeue() call
        this.thread.interrupt();
    }

    public synchronized boolean isStopped(){
        return isStopped;
    }
}
