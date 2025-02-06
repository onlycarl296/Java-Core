package concurrency_multithreading.java_synchronized.Wait_Notify_Notifyall;

public class Customer {
    private int balance = 1000;

    public Customer() {
        System.out.println("Tài khoản của bạn là " + balance);
    }

    public synchronized void withdraw(int amount) {
        System.out.println("Đang thực hiện giao dịch rút tiền " + amount + "...");
        while (balance < amount) {
            System.out.println("Không đủ tiền rút!!!");
            try {
                wait(); // Chờ nạp tiền
            } catch (InterruptedException ie) {
                System.out.println(ie.toString());
            }
        }
        balance -= amount;
        System.out.println("Rút tiền thành công. Tài khoản của bạn hiện tại là " + balance);
    }

    public synchronized void deposit(int amount) {
        System.out.println("Đang thực hiện giao dịch nạp tiền " + amount + "...");
        balance += amount;
        System.out.println("Nạp tiền thành công. Tài khoản của bạn hiện tại là " + balance);
        notify(); // Thông báo đã nạp tiền
    }

}
/*
 - wait(): Phương thức này sẽ làm cho luồng đang sở hữu monitor của đối tượng b (hay luồng đang khóa đối tượng b
            và nắm giữ đối tượng này) tạm thời ngưng hoạt động và trả monitor của b cho luồng khác.
            Sau khi trả monitor luồng 1 sẽ về trạng thái đợi (nằm ở vùng wait set. Trạng thái này java định nghĩa là Thread.State.WAITING).
 - notify() và notifyall(): Sau khi luồng 2 nắm giữ monitor của b và xử lý xong những gì luồng 1 cần,
            thì luồng 2 sẽ gọi phươg thức notify() hoặc notifyall() trên đối tượng b để đánh thức các luồng đang chờ monitor của b và
            ngay sau đó luồng 2 sẽ trả lại monitor của b.
 - Điểm khác nhau giữa notify() và notifyall() là: notify() sẽ gửi thông điệp đánh thức cho 1 luồng ngẫu nhiên trong các luồng đang chờ,
            còn notifyall() sẽ gửi cho tất cả các luồng đang chờ b. Tuy nhiên, thông điệp gửi bởi notify() như đã nói,
            nó sẽ đánh thức 1 luồng bất kỳ chứ không chắc chắn là luồng 1 nên Oracle khuyến cáo nên dùng notifyall().
 */