package Answer4;

import java.util.UUID;

public class Producer implements Runnable{

    private final DataQueue dataQueue;
    private boolean isRunning = true;

    public Producer(DataQueue dataQueue) {
        this.dataQueue = dataQueue;
    }

    public void stop(){
        isRunning = false;
    }

    @Override
    public void run() {
        while (isRunning) {
            Message message = generateMessage();
            dataQueue.pushMessage(message);
            System.out.println(message);
        }
    }

    private Message generateMessage() {
        return new Message(UUID.randomUUID().toString(), "Message by thread: " + Thread.currentThread().getName());
    }
}
