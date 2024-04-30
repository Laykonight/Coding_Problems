package Data_Structures_Implementations.ThreadSafeFixSizeQueue;

import java.util.PriorityQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
Implement a ThreadSafeFixedSizeQueue class

Keep in mind the following constraints:

• Fixed Size Queue
• The stored element type is generic
• Thread Safe
• A producer and consumer can enqueue/dequeue at the same time
*/

public class FSQ<E> {
    private PriorityQueue<E> Q;
    int size;
    private final Semaphore sem;
    private final Lock lock1;
    private final Lock lock2;

    public FSQ(int size){
        this.Q = new PriorityQueue<>();
        this.size = size;
        this.sem = new Semaphore(size);
        this.lock1 = new ReentrantLock();
        this.lock2 = new ReentrantLock();
    }

    public void enqueue(E element) throws InterruptedException {
        lock1.lock();
        sem.acquire();
        Q.add(element);
        lock1.unlock();
    }

    public E dequeue(){
        if (size == sem.availablePermits()){
            throw new RuntimeException("dequeue from empty queue");
        }

        lock2.lock();
        sem.release();
        E element = Q.remove();
        lock2.unlock();
        return element;
    }
}
