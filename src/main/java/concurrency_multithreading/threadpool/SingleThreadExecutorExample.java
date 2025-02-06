package concurrency_multithreading.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutorExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        for (int i = 1; i <= 10; i++) {
            Runnable worker = new WorkerThread("" + i);
            executor.execute(worker);
        }

        /*
         Trong chương trình trên, tôi đã tạo ra ThreadPool sử dụng phương thức newSingleThreadExecutor() vì vậy kích thước của ThreadPool là 1,
         nên nó sẽ bắt đầu thực thi chương trình trên với 1 task và các task khác sẽ ở trạng thái đợi (waiting),
         ngay khi một task hoàn thành, một task khác từ hàng đợi sẽ được chọn và thực thi.
         */
        executor.shutdown();

        // Wait until all threads are finish
        while (!executor.isTerminated()) {
            // Running ...
        }

        System.out.println("Finished all threads");
    }
}
