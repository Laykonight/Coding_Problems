package Concurrency.ProducerConsumer;

/*
You have a known number of producer threads and one consumer thread.
    • Once all the producers are done, the consumer should start.
    • Once the consumer is done, the producers should start.
    • Polling will cause an issue.
    • You may use any synchronization tools (mutexes, semaphores, condition variables).

Implement the following functions:
    void producer();
    void consumer();
*/
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class n_Producer_1_Consumer {
     private final int numOfProducts;
    private Lock lock;
    private Semaphore sem;

    public n_Producer_1_Consumer(int numOfProducts) {
        this.numOfProducts = numOfProducts;
        this.lock = new ReentrantLock();
        this.sem = new Semaphore(numOfProducts);
    }

    public void producer() throws InterruptedException {
        lock.lock();
        sem.acquire();
        // producing code
        lock.unlock();
    }

    public void consumer(){
        lock.lock();
        if (sem.availablePermits() == 0){
            // consuming code

            for (int i = 0; i < numOfProducts; ++i){
                sem.release();
            }
        }
        lock.unlock();
    }
}
