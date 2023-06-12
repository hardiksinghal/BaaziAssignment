package Answer5;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

    /**
     * Implemented Stack using 2 Queues.
     * Making the push operation Costly
     */
    private Queue<String> q1 = new LinkedList<>();
    private Queue<String> q2 = new LinkedList<>();

    public void push(String message){
        q2.add(message);
        while (! q1.isEmpty()){
            q2.add(q1.poll());
        }
        Queue<String> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public String pop(){
        return q1.poll();
    }

    public String top(){
        return q1.peek();
    }
}