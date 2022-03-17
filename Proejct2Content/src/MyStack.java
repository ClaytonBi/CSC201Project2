public class MyStack {
    private DLinkedList myList;

    //constructor
    public MyStack(){
        myList = new DLinkedList();
    }

    //returns true if stack has no elements
    public boolean isEmpty(){
        return myList.isEmpty();
    }

    //returns -1 if stack has no elements, otherwise return the current size of the stack
    public int size(){
        return myList.size();
    }

    //place given value on top of stack
    public void push(Object item){
        myList.insert(0,item);
    }

    //print error message （DLinkedList will do this） and return null if the stack(LinkedList) is empty, otherwise remove the head from the array and
    //return the removed item
    public Object pop(){
        Object target = myList.get(0);
        if (target == null){
            return null;
        }
        else{
            myList.remove(0);
            return target;
        }
    }

    //return top value from stack without removing it
    public Object peek(){
        return myList.get(0);
    }


}
