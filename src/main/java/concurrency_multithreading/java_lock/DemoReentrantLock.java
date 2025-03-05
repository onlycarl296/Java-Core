package concurrency_multithreading.java_lock;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;


public class DemoReentrantLock {
    private static final Integer MAX_T =2;

    public void demo() {
        ReentrantLock rel = new ReentrantLock();
        ExecutorService pool = Executors.newFixedThreadPool(MAX_T);
        Runnable w1 = new Worker(rel, "Job1");
        Runnable w2 = new Worker(rel, "Job2");
        Runnable w3 = new Worker(rel, "Job3");
        Runnable w4 = new Worker(rel, "Job4");
        pool.execute(w1);
        pool.execute(w2);
        pool.execute(w3);
        pool.execute(w4);
        pool.shutdown();
    }

    public static String getCurrentTime() {
        Date d = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
        return ft.format(d);
    }

    public static void main(String[] args) {
        new DemoReentrantLock().demo();
    }

    class Worker implements Runnable
    {
        String name;
        ReentrantLock re;

        public Worker(ReentrantLock rl, String n)
        {
            re = rl;
            name = n;
        }
        public void run()
        {
            boolean done = false;
            while (!done)
            {
                //Getting Outer Lock
                boolean ans = re.tryLock();

                // Returns True if lock is free
                if(ans)
                {
                    try
                    {
                        System.out.println(getCurrentTime() + ": task name - "+ name
                                + " outer lock acquired at "
                                + " Doing outer work");
                        Thread.sleep(1500);

                        // Getting Inner Lock
                        re.lock();
                        try
                        {
                            System.out.println(getCurrentTime() + ": task name - "+ name
                                    + " inner lock acquired at "
                                    + " Doing inner work");
                            System.out.println("Lock Hold Count - "+ re.getHoldCount());
                            Thread.sleep(1500);
                        }
                        catch(InterruptedException e)
                        {
                            e.printStackTrace();
                        }
                        finally
                        {
                            //Inner lock release
                            System.out.println(getCurrentTime() +  ": task name - " + name +
                                    " releasing inner lock");
                            re.unlock();
                        }
                        System.out.println("Lock Hold Count - " + re.getHoldCount());
                        System.out.println(getCurrentTime() + ": task name - " + name + " work done");

                        done = true;
                    }
                    catch(InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                    finally
                    {
                        //Outer lock release
                        System.out.println(getCurrentTime()+ ": task name - " + name +
                                " releasing outer lock");

                        re.unlock();
                        System.out.println(getCurrentTime() + ": Lock Hold Count - " +
                                re.getHoldCount());
                    }
                }
                else
                {
                    System.out.println(getCurrentTime() + ": task name - " + name +
                            " waiting for lock");
                    try
                    {
                        Thread.sleep(1000);
                    }
                    catch(InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
