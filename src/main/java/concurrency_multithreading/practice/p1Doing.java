package concurrency_multithreading.practice;

public class p1Doing {
    int var ;

    public p1Doing(int var) {
        this.var = var;
    }

    public synchronized void setVar(int inc){
        this.var= inc;
    }

    public synchronized int getVar(){
        return this.var;
    }

    public synchronized void incrementVar(){
        this.var+= 1;
    }
}
