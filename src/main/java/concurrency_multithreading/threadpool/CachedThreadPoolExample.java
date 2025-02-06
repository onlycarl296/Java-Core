package concurrency_multithreading.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPoolExample {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 1; i <= 10; i++) {
            Runnable worker = new WorkerThread("" + i);
            executor.execute(worker);
            Thread.sleep(400);
        }

        /*
         * Trong chương trình trên, tôi đã tạo ra ThreadPool sử dụng phương thức newCachedThreadPool()
         * vì vậy kích thước của ThreadPool là gần như không giới hạn (Integer.MAX_VALUE),
         * nên nó sẽ bắt đầu thực thi chương trình trên với 1 task và các task khác sẽ ở không phải đợi.
         * Nếu có Thread rãnh thì nó sẽ nhận task và thực thi. Nếu không có Thread rãnh thì nó sẽ tạo một Thread mới và thực thi.
         */
        executor.shutdown();

        // Wait until all threads are finish
        while (!executor.isTerminated()) {
            // Running ...
        }

        System.out.println("Finished all threads");
    }
}
