package concurrency_multithreading.java_synchronized.StaticSynchronized;

public class WorkingThread extends Thread {
    private String mThreadName;

    public WorkingThread(String threadName) {
        this.mThreadName = threadName;
    }

    @Override
    public void run() {
        ShareMemory.printData(mThreadName);
    }
}
