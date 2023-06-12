package Answer4;

public class Consumer implements Runnable{

    private final DataQueue dataQueue;
    private boolean isRunning = true;

    public Consumer(DataQueue dataQueue) {
        this.dataQueue = dataQueue;
    }

    public void stop(){
        isRunning = false;
    }

    @Override
    public void run() {
        while (isRunning) {
            Message message = this.dataQueue.pollMessage();
            System.out.println("Message Consumed by " + Thread.currentThread().getName() + ": " + message.toString());
        }
    }
}
