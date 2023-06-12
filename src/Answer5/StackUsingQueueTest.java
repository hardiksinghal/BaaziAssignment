package Answer5;

public class StackUsingQueueTest {

    public static void main(String[] args){
        StackUsingQueue stackUsingQueue = new StackUsingQueue();
        stackUsingQueue.push("Hardik");
        stackUsingQueue.push("is");
        stackUsingQueue.push("name");
        stackUsingQueue.push("My");
        System.out.println("Top element is: "+ stackUsingQueue.top());
        System.out.println(stackUsingQueue.pop());
        System.out.println(stackUsingQueue.pop());
        System.out.println(stackUsingQueue.pop());
        System.out.println(stackUsingQueue.pop());
    }

}
