package threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExample {

    public static final int NUM_OF_THREAD = 2;
    public static final int INITIAL_DELAY = 1; // second
    public static final int DELAY = 3; // second

    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(NUM_OF_THREAD);

        for (int i = 1; i <= 5; i++) {
            Runnable worker = new WorkerThread("" + i);
            executor.scheduleWithFixedDelay(worker, INITIAL_DELAY, DELAY, TimeUnit.SECONDS);
        }

        // waits for termination for 10 seconds only
        executor.awaitTermination(10, TimeUnit.SECONDS);

        /*
         * Trong chương trình trên, tôi đã tạo ra ThreadPool có kích thước cố định là 2.
         * Sau đó, tôi đã tạo 5 task (công việc) vào ThreadPool, vì kích thước ThreadPool là 2,
         * nên nó sẽ bắt đầu thực thi chương trình trên vói 5 task và các task khác sẽ ở trạng thái đợi (waiting),
         * ngay khi một task hoàn thành, một task khác từ hàng đợi sẽ được chọn và thực thi.
         */
        executor.shutdown();

        // Wait until all threads are finish
        while (!executor.isTerminated()) {
            // Running ...
        }

        System.out.println("Finished all threads");
    }
}
