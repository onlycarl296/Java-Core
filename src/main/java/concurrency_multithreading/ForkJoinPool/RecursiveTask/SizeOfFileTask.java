package concurrency_multithreading.ForkJoinPool.RecursiveTask;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.RecursiveTask;

public class SizeOfFileTask extends RecursiveTask<Long> {
//Tạo lớp tính tổng kích thước của một folder kế thừa từ abstract class RecursiveTask<T>.
// Nó yêu cầu bạn phải override lại phương thức compute().
// Phương thức này tương tự như run() của class Thread hay call() của interface Callable, khi Thread start() nó sẽ gọi phương thức này để xử lý.
    private static final long serialVersionUID = -196522408291343951L;

    private final File file;

    public SizeOfFileTask(final String fileName) {
        this(new File(fileName));
    }

    public SizeOfFileTask(final File file) {
        this.file = Objects.requireNonNull(file);
    }

    @Override
    protected Long compute() {
        // System.out.printf("Computing size of: %s \n", file);

        if (file.isFile()) {
            return file.length();
        }

        final List<SizeOfFileTask> tasks = new ArrayList<>();
        final File[] children = file.listFiles();
        if (children != null) {
            for (final File child : children) {
                final SizeOfFileTask task = new SizeOfFileTask(child);
                task.fork();
                tasks.add(task);
            }
        }

        long size = 0;
        for (final SizeOfFileTask task : tasks) {
            size += task.join();
        }

        return size;
    }
}
