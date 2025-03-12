package concurrency_multithreading.java_lock;

public class BaseReentrant {

    BasicLock basicLock = new BasicLock();
    public void outer1() throws InterruptedException {
        basicLock.lock();
        inner1();
        basicLock.unlock();
    }

    public void inner1() throws InterruptedException {
        basicLock.lock();
        System.out.println("It is not locked by basicLock");
        basicLock.unlock();
    }

    // Nếu đối với lock bình thường thì khi khóa lại thì hàm đó không thể gọi đến
    // được bởi hàm trong cùng 1 luồng

    ReentrantLock lock = new ReentrantLock();

    public void outer() throws InterruptedException {
        lock.lock();
        inner();
        lock.unlock();
    }

    public void inner() throws InterruptedException {
        lock.lock();
        System.out.println("It is not locked by ReentrantLock");
        lock.unlock();
    }
    // Nếu đối với ReentrantLock thì cung cấp tính đồng bộ cho các hàm truy cập tài nguyên chung
    // ReentrantLock không giới hạn số lần truy cập tài nguyên của một thread.
    // Khi một thread truy cập lần đầu vào tài nguyên, nó được gán một biến đếm giá trị 1.
    // Trước khi giải phóng tài nguyên, nó có thể tái truy cập, và mỗi lần như thế thì biến đếm tăng lên 1.
    // Với mỗi yêu cầu unlock, biến đếm sẽ giảm một, và khi biến đếm bằng 0 thì tài nguyên được giải phóng.


    /*
     Trong Java có các loại reentrant lock sau :
     - synchronized
     - Các lock kế thừa từ class ReentrantLock.java.
     Trong quá trình làm việc của mình thì chỉ có một Lock không Reentrant đó là StampedLock
     */

}
