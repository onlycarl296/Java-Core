package concurrency_multithreading.ForkJoinPool;

public class Note {
/*
    ForkJoinPool tương tự như Java ExecutorService (ThreadPool) nhưng với một sự khác biệt. ForkJoinPool phân chia các tác vụ cho
    các luồng thực thi trong Thread Pool. Framework Fork/ Join sử dụng thuật toán work-stealing. Các luồng sẽ thực thi
    công việc của mình trên một bộ xử lý riêng biệt (thread/ processor), khi làm hết việc của mình, nó lấy bớt (steal)
    các tác vụ từ các luồng khác đang bận rộn.

    - Trong thực tế, bước đầu tiên framework Fork/ Join thực hiện là chia nhỏ task (fork/ split),
        đệ quy chia nhỏ nhiệm vụ thành các nhiệm vụ phụ nhỏ hơn cho đến khi chúng đơn giản đủ để được thực hiện xử lý không đồng bộ.
    - Sau đó, phần gộp kết quả (join) bắt đầu, trong đó các kết quả của tất cả các nhiệm vụ phụ được đệ quy
        một cách đệ quy vào một kết quả, hoặc trong trường hợp một nhiệm vụ trả về void, chương trình chỉ cần đợi cho đến khi mỗi nhiệm vụ phụ được thực hiện.


    Các ForkJoinPool là một Thread Pool đặc biệt được thiết kế để làm việc tốt với chia tách công việc fork/ join.
        ForkJoinPool nằm trong gói java.util.concurrent, vì vậy tên lớp đầy đủ là java.util.concurrent.ForkJoinPool. Một số lớp tiêu biểu của Fork/ Join Framework:

ForkJoinTask<V>: một abstract class định nghĩa task sẽ được thực thi trong một ForkJoinPool.
ForkJoinPool: là một thread pool quản lý việc thực thi các ForkJoinTasks.
RecursiveAction: là một lớp con của ForkJoinTask, nó thực thi tác vụ mà không trả lại bất kỳ kết quả nào (action).
RecursiveTask<V>: là một lớp con của ForkJoinTask, nó thực thi tác vụ mà có trả lại kết quả (task).
 */
}
