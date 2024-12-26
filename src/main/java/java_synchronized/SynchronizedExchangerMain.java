package java_synchronized;

public class SynchronizedExchangerMain {
    public static void main(String[] args) {
        SynchronizedExchanger exchanger = new SynchronizedExchanger();


        Thread thread1 = new Thread(() -> {
            synchronized (exchanger) { // Đồng bộ hóa trên đối tượng exchanger
                for (int i = 0; i < 100; i++) {
//                    exchanger.setObj("" + i);
                    exchanger.object= i;

//                    System.out.println(" " + exchanger.getObj() + "A");
                    System.out.println(" " + exchanger.object + "A");
                }
            }
        });

        Thread thread2 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
//                        synchronized (exchanger) {
                            for (int i = 0; i < 100; i++) {
//                                exchanger.setObj("" + i);
                                exchanger.object= i;

//                                System.out.println(" " + exchanger.getObj() + "B");
                                System.out.println(" " + exchanger.object + "b");

                            }
                        }
//                    }
                }
        );

        thread1.start();
        thread2.start();
    }
    /*
    Khối synchronized: Khi bạn có khối mã synchronized, chỉ có một thread tại một thời điểm được phép vào khối đó nếu nó đang sử dụng cùng một đối tượng làm khóa.
    Trong trường hợp của bạn, thread1 sử dụng synchronized (exchanger), nên nó sẽ chiếm khóa của exchanger.

   Thread không synchronized: Khi bạn comment bỏ khối synchronized trong thread2, nó không còn bị ràng buộc bởi khóa của exchanger nữa.
   Do đó, cả hai thread có thể chạy song song mà không ghi đè lên nhau. Kết quả là, thread1 và thread2 có thể in ra giá trị đồng thời, và bạn sẽ thấy kết quả không được đồng bộ.
     */
}
