package concurrency_multithreading.threadpool.jakob;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPool {

    private BlockingQueue taskQueue = null;
    private List<PoolThreadRunnable> runnables = new ArrayList<>();
    private boolean isStopped = false ;

    public ThreadPool(int noOfThreads, int MaxNoOfTasks){
        taskQueue = new ArrayBlockingQueue(MaxNoOfTasks);

        for(int i=0;i< noOfThreads;i++){
            PoolThreadRunnable poolThreadRunnable = new PoolThreadRunnable(taskQueue);

            runnables.add(poolThreadRunnable);
        }

        for(PoolThreadRunnable runnable: runnables){
            new Thread(runnable).start();
        }
    }
    /*
    Khai báo
        - Tạo ra 1 task queue có giơi hạn là 10
        - Khởi chạy 3 thread trong thread pool với tham số của cả 3 thread là task queue và thêm cả 3 thread vào list thread
        - Cho cả 3 thread chạy
     */

    public synchronized void execute(Runnable task){
        if (this.isStopped)throw
                new IllegalStateException("ThreadPool is stopped");
        this.taskQueue.offer(task);
    }
    /*
    - Khi sử dụng hàm này thì các task sẽ được nạp vào trong taskQueue
    - Và sau khi hàm này chạy xong thì 1  trong 3 thread đang ở trên nếu có thread nào đang ko xử lý gì thì sẽ nhận được task
    - Và mỗi task lại là 1 runnable -> thứ tự chạy là 1 trong 3 thread trong pool sẽ chạy thread của task
     */

    public synchronized void stop(){
        this.isStopped = true ;
        for (PoolThreadRunnable runnable : runnables){
            runnable.doStop();
        }
    }

    public synchronized void waitUntilAllTasksFinished() {
        while(this.taskQueue.size() > 0) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
