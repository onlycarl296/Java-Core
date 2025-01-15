package java_synchronized.SynchronizedMethods;

public class ShareMemoryTest {

    public static void main(String[] args) {

        ShareMemory sm = new ShareMemory();
        WorkingThread thread1 = new WorkingThread(sm, "Thread1");
        WorkingThread thread2 = new WorkingThread(sm, "Thread2");
        WorkingThread thread3 = new WorkingThread(sm, "Thread3");

        thread1.start();
        thread2.start();
        thread3.start();
    }

}
/*
 - Khi start thì 3 luồng đều chạy song song tuy nhiên khi chạy khi chạy đến ShareMemory(có sử dụng synchronized method)
 thì trong 3 thread thì thread nào đang nắm giữ được monitor thì mới có thể gọi phương thức còn các thread còn lại thì chạy nốt
 phần không đồng bộ hoặc đợi đến khi thread kia ra khỏi monitor
 */