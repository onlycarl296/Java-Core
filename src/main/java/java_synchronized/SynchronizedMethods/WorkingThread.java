package java_synchronized.SynchronizedMethods;

public class WorkingThread extends Thread {
    private ShareMemory mShareMemory;
    private String mThreadName;

    public WorkingThread(ShareMemory sm, String threadName) {
        this.mShareMemory = sm;
        this.mThreadName = threadName;
    }

    @Override
    public void run() {
        for (int i=0; i<=1000;i++){
            System.out.println(i);
        }
        mShareMemory.printData(mThreadName);
    }
}
