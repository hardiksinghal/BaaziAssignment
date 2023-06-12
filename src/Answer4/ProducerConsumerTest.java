package Answer4;

public class ProducerConsumerTest {

    public static void main(String[] args) throws InterruptedException {
        DataQueue dataQueue = new DataQueue(20);
        Producer producer1 = new Producer(dataQueue);
        Producer producer2 = new Producer(dataQueue);
        Consumer consumer1 = new Consumer(dataQueue);
        Consumer consumer2 = new Consumer(dataQueue);

        Thread t1 = new Thread(producer1);
        Thread t2 = new Thread(producer2);
        Thread t3 = new Thread(consumer1);
        Thread t4 = new Thread(consumer2);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        Thread.sleep(5000);
        t1.stop();
        t2.stop();
        t3.stop();
        t4.stop();
    }

}
