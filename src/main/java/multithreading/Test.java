package multithreading;

public class Test implements Runnable{
    private int count ;

    public Test(int count){
        this.count = count;
    }
    @Override
    public void run() {
        synchronized (this){
            for(int i=0;i<=3;i++){
                count++;
                System.out.println(count);
            }
        }
    }

    public static void main(String[] args) {
        Test test = new Test(1);
        Thread t1 = new Thread(test);
        Thread t2 = new Thread(test);
        t1.start();
        System.out.println(t1.getName());
        t2.start();
    }
}
