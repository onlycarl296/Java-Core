package java_synchronized;

public class SynchronizedExchangerMain {
    public static void main(String[] args) {
        SynchronizedExchanger exchanger = new SynchronizedExchanger();


        Thread thread1 = new Thread(() -> {
            synchronized (exchanger) { // Đồng bộ hóa trên đối tượng exchanger
                for (int i = 0; i < 100; i++) {
                    exchanger.setObj("" + i);
                    System.out.println(" " + exchanger.getObj() + "A");
                }
            }
        });

        Thread thread2 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
//                        synchronized (exchanger) {
                            for (int i = 0; i < 100; i++) {
                                exchanger.setObj("" + i);
                                System.out.println(" " + exchanger.getObj() + "B");
                            }
                        }
//                    }
                }
        );

        thread1.start();
        thread2.start();
    }
}
