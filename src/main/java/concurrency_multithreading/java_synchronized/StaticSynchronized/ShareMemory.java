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
Synchronized block:  khóa một phần của code trong một phương thức. (this)
Synchronized static method: khóa toàn bộ phương thức của một lớp (class).

Nguyên tắc: chỉ 1 thread được vào vùng synchronized trên this/class
VD:  synchronized void execute() và synchronized void stop() hoặc
   public void execute(Runnable task){
    synchronized (this) {
        ...
    }
}

public void stop(){
    synchronized (this) {
        ...
    }
}

Không thể có chuyện:
A đang ở giữa execute()
B nhảy vào chạy stop() giữa chừng
Chỉ có 2 kịch bản có thể xảy ra
- Thread A vào execute() trước, B gọi stop() sau
- Thread B vào stop() trước, A gọi execute() sau

Synchronized block giảm phạm vi khóa, cãi thiện performance (các luồng khác không phải chờ nếu truy cập vào các tài nguyên khác).
 */