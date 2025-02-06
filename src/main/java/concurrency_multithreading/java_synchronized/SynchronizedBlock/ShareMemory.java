package concurrency_multithreading.java_synchronized.SynchronizedBlock;

import java.util.Random;

public class ShareMemory {
    public void printData(String threadName) {
        Random rand = new Random();
        int randomInt = rand.nextInt(10000); // Số ngẫu nhiên từ 0 đến 99
        for(int i =0 ;i<=randomInt;i++){
            System.out.println(threadName + "before syn: " + i);
        }
        synchronized (this) {
            for (int i = 1; i <= 100; i++) {
                System.out.println(threadName + ": " + i);
            }
        }
    }
}

/*
 - Với Synchronized methods thời gian chờ giữa các luồng khá lớn vì cả method sẽ được đưa vào monitor để các thread lần lượt sử dụng
 - Với Synchronized block cả 3 luông đều đồng thời sử dụng được hàn printData() cùng lúc tuy nhiên khi đến khối synchronized thì chỉ có 1 luồng được sử dụng vòng
   for bên dưới, 2 vòng for còn lại được chia làm 2 trường hợp
        + Nếu chưa chạy đến vòng for bên dưới thì sẽ tiếp tục chạy ở vòng for bên trên
        + Nếu chạy xong vòng for bên trên mà đã có 1 luồng ở trong monitor rồi thì sẽ đợi đến khi luồng đó hoàn thành thì luồng này mới được chạy vaopf monitor
 */
