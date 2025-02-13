package concurrency_multithreading.practice;

//Write a Java program to create and start multiple threads that increment a shared counter variable concurrently.

public class p1Main {
    public static void main(String[] args) {
        p1Doing doing = new p1Doing(0);

        Thread thread1 = new Thread(() -> {
//            synchronized (doing) {
                for (int i = 0; i <= 900; i++) {
                    doing.incrementVar(); // vì hàm incrementVar() dã được đánh dấu là vào router rồi nên ko cần khối syn
                    System.out.println(Thread.currentThread().getName()+" "+ doing.getVar());
                }
//            }
        });

        Thread thread2 = new Thread(() -> {
//            synchronized (doing) {
                for (int i = 0; i <= 900; i++) {
                    doing.incrementVar();
                    System.out.println(Thread.currentThread().getName()+" "+ doing.getVar());
                }
//            }
        });

        thread1.start();
        thread2.start();

//        try {
//            thread1.join(); // Chờ cho Thread 1 kết thúc
//            System.out.println("Thread 1 đã hoàn thành.");
//            thread2.join(); // Chờ cho Thread 2 kết thúc
//            System.out.println("Thread 2 đã hoàn thành.");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("Kết thúc chương trình: "+ doing.getVar());
    }
}
