package concurrency_multithreading.java_synchronized.SynchronizedMethods;

public class ShareMemory {
    private int count = 0;

    public synchronized void printData(String threadName) {
        for (int i = 1; i <= 5; i++) {
            System.out.println(threadName + ": " + i);
        }
    }
    public synchronized void increment() {

        count++;

    }

    public synchronized int getCount() {

        return count;

    }
}

/*
 - Từ khóa synchronized trong khai báo method, từ khóa này sẽ ngăn các luồng gọi đồng thời.
 - Về cơ chế ngăn, phương thức này sẽ được cấp duy nhất 1 “java monitor” cho phương thức này ,
  chỉ có luồng nào đang nắm giữ monitor mới có quyền gọi phương thức này.
 */