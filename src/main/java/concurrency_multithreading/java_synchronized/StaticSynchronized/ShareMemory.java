package concurrency_multithreading.java_synchronized.StaticSynchronized;

public class ShareMemory {
    public static synchronized void printData(String threadName) {
        for (int i = 1; i <= 1000; i++) {
            System.out.println(threadName + ": " + i);
        }
    }
}

/*
Phạm vi khóa:
Synchronized method: khóa toàn bộ phương thức của một instance của object (this).
Synchronized block: khóa một phần của code trong một phương thức.
Synchronized static method: khóa toàn bộ phương thức của một lớp (class).

Synchronized block giảm phạm vi khóa, cãi thiện performance (các luồng khác không phải chờ nếu truy cập vào các tài nguyên khác).
 */