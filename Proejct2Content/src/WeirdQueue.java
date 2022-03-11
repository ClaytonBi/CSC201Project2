public class WeirdQueue {
    private MyStack s1;
    private MyStack s2;
    //in this class, s1 could be regarded as a stack that stores the queue data in a reverse order,
    //everytime we enqueue, we temporarily move the data from s1 to s2, put the new item into s2, and
    //push the data back to s1 for storing

    //no-arg constructor
    public WeirdQueue(){
        s1 = new MyStack();
        s2 = new MyStack();
    }

    /**
     * Worst case running time: O(n)
     * Error conditions: Queue overflow (trying to enqueue a full queue will only happen if we run out of CPU memory)
     * @param item
     */
    public void enqueue(Object item){
        //move all elements from s1 to s2
        while (!s1.isEmpty()){
            s2.push(s1.pop());
        }
        //put new item into s2
        s1.push(item);
        //push everything back to s1
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
    }

    /**
     * Worst case running time: O(1)
     * Error condition: when s1 is empty (when the queue is not storing any elements), trying to dequeue from an empty
     * queue is a queue underflow, so send error message
     * @return returns null when queue underflow, returns the top of s1 if the queue is not empty (s1 is not empty)
     */
    public Object dequeue(){
        if (s1.isEmpty()){
            System.out.println("Error: queue is empty - queue underflow");
            return null;
        }
        else{
            return s1.pop();
        }
    }


}
