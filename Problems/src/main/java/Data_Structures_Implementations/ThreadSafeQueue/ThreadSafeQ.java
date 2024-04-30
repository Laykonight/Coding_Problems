package Data_Structures_Implementations.ThreadSafeQueue;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeQ<T> {
    private Queue<T> Q;
    private Lock enqueueLock;
    private Lock dequeueLock;

    public ThreadSafeQ(){
        this.Q = new PriorityQueue<>();
        this.enqueueLock = new ReentrantLock();
        this.dequeueLock = new ReentrantLock();
    }

    public void enqueue(T element){
        enqueueLock.lock();
        Q.add(element);
        enqueueLock.unlock();
    }
    public T dequeue(){
        dequeueLock.lock();
        T temp = Q.remove();
        dequeueLock.unlock();
        return temp;
    }
}
