package concurrency_multithreading.practice;

public class p3Semaphore {
    private int ticket;
    private int curentTicket;

    public p3Semaphore(int ticket) {
        this.ticket = ticket;
        this.curentTicket = ticket;
    }

    public synchronized void acquire() throws InterruptedException {
        while(curentTicket==0){
            wait();
        }
        curentTicket--;
        notifyAll();
    }

    public synchronized void release() throws InterruptedException {
        while(curentTicket==ticket){
            wait();
        }
        curentTicket++;
        notifyAll();
    }

    public synchronized int availablePermits() {
        return curentTicket;
    }

}
