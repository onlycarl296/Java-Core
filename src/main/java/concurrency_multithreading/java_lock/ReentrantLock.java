package concurrency_multithreading.java_lock;

public class ReentrantLock {
    boolean isLocked = false;
    Thread  lockedBy = null;
    int     lockedCount = 0;

    public synchronized void lock()
            throws InterruptedException{
        Thread callingThread = Thread.currentThread();
        while(isLocked && lockedBy != callingThread){
            wait();
        }
        isLocked = true;
        lockedCount++;
        lockedBy = callingThread;
    }


    public synchronized void unlock(){
        if(Thread.currentThread() == this.lockedBy){
            lockedCount--;

            if(lockedCount == 0){
                isLocked = false;
                notify();
            }
        }
    }

    /*
    vòng lặp while (khóa xoay) giờ sẽ xem xét rằng thread nào đã khóa instance của Lock.
    Nếu khóa đã được mở (isLocked = false) hoặc thread gọi đến chính là thread đã khóa instance của Lock,
    vòng lặp while sẽ không được chạy, và thread gọi đến lock() sẽ được phép thoát khỏi hàm này.

    Thêm nữa, chúng ta cần đếm số lần mà lock bị khóa bởi cùng một thread.
    Nếu không thì chỉ một lời gọi duy nhất đến unlock() sẽ mở khóa lock, kể cả khi lock đã được khóa rất nhiều lần.
    Chúng ta không muốn lock được mở khóa cho đến khi thread thực hiện khóa đã gọi đủ số hàm unlock() tương ứng với số hàm lock().

    Class Lock giờ đã trở thành reentrance.
     */
}
