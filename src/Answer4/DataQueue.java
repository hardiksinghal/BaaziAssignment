package Answer4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class DataQueue {

    private final Queue<Message> messageQueue;
    private final Integer maxSize;
    private final ReentrantLock lock = new ReentrantLock();
    Condition fullCondition = lock.newCondition();
    Condition emptyCondition = lock.newCondition();

    public DataQueue(Integer maxSize) {
        this.messageQueue = new LinkedList<>();
        this.maxSize = maxSize;
    }

    private boolean isFull(){
        return messageQueue.size() >= maxSize;
    }

    public void pushMessage(Message message){
        try {
            lock.lock();
            while (isFull()) {
                fullCondition.await();
            }
            messageQueue.add(message);
            emptyCondition.signalAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public Message pollMessage(){
        try {
            lock.lock();
            while (messageQueue.isEmpty()) {
                emptyCondition.await();
            }
            Message m = messageQueue.poll();
            fullCondition.signalAll();
            return m;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }



}
