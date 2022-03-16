public class DLinkedList implements MyList{
    private class Node{
        Object item;
        Node prev;
        Node next;

        private Node(Object item){
            this.item = item;
        }
    }

    private Node head;
    private Node tail;
    private int length;

    /**
     * Default constructor
     */
    public DLinkedList(){
        head = null;
        tail = null;
        length = 0;
    }

    /**
     * function: insert 'item' at 'index'
     * error: if the list is empty (while index is not 0), or the index is out of bound (too big or too small for the list) - index < 0 or index > length, the program will show error
     * worst case running time: O(n)
     * @param index
     * @param item
     * @return boolean value: true when insert successfully, false when fail to insert
     */
    public boolean insert(int index, Object item){
        Node newNode = new Node(item);
        //Case 1: list is empty
        if (head == null){
            //Case 1-1: index == 0
            if (index == 0){
                append(item);
                return true;
            }
            //Case 1-2: index != 0
            else{
                System.out.println("Error: the list is empty, can't insert element");
                return false;
            }
        }
        //Case 2: index out of bound
        else if (index < 0 || index > length){
            System.out.println("Error: index out of bound, can't insert element");
            return false;
        }
        //Case 3: insert as head
        else if (index == 0){
            head.prev = newNode;
            newNode.next = head;
            newNode.prev = null;
            head = newNode;
            length++;
            return true;
        }
        //Case 4: insert as tail
        else if (index == length){
            tail.next = newNode;
            newNode.next = null;
            newNode.prev = tail;
            tail = newNode;
            length++;
            return true;
        }
        //Case 5: 0 < index <= length - 1
        else{
            Node curr = head;
            for (int i = 0; i < index - 1; ++i){
                curr = curr.next;
            }
            newNode.next = curr.next;
            newNode.prev = curr;
            curr.next.prev = newNode;
            curr.next = newNode;
            length++;
            return true;
        }
    }

    /**
     * function: this method inserts 'item' at the end of the list.
     * error: there is no error condition for appending any item at the end of the list
     * worst case running time: O(1)
     * @param item
     * @return boolean value: true when successfully append, false when fail
     */
    public boolean append(Object item){
        Node newNode = new Node(item);
        //if head==null, it means the list is empty. So let both head and tail point to newNode
        if (head == null){
            head = newNode;
            tail = newNode;
            head.prev = null;
            tail.next = null;
        }
        else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            tail.next = null;
        }
        length++;
        return true;
    }

    /**
     * function: clear the list
     * error: no error condition
     * worst case running time: O(1)
     */
    public void clear(){
        head = null;
        tail = null;
        length = 0;
    }

    /**
     * function: check if the list is empty
     * error: no error condition
     * worst case running rime: O(1)
     * @return boolean value: true when the list is empty and false when it's not
     */
    // return true if list is empty or false otherwise.
    public boolean isEmpty(){
        if (head == null){
            return true;
        }
        else{
            return false;
        }
    }

    // return the size of the list, else -1.

    /**
     * return the size of the list
     * worst case running time: O(1)
     * @return integer value: size of the list
     */
    public int size(){
        if (head == null){//if the list is empty, return -1
            return -1;
        }
        else{
            return length;
        }
    }

    // replaces the element at 'index' with 'item'.

    /**
     * function: replace the element at the specific index with item.
     * error: if the list is empty, or the index is out of bound (too big or too small for the list) - index < 0 or index > length - 1, the program will show error
     * worst case running time: O(n)
     * @param index
     * @param item
     * @return boolean value: true when replace successfully, false when fail to replace
     */
    public boolean replace(int index, Object item){
        Node newNode = new Node(item);
        //Case 1: list is empty
        if (head == null){
            System.out.println("Error: the list is empty, can't replace element");
            return false;
        }
        //Case 2: index out of bound
        else if (index < 0 || index > length - 1){
            System.out.println("Error: index out of bound, can't replace element");
            return false;
        }
        //Case 3: replace head
        else if (index == 0){
            //Case 3-1: list size == 1
            if (length == 1){
                head = newNode;
                tail = newNode;
                head.prev = null;
                tail.next = null;
                return true;
            }
            //Case 3-2: list size > 1
            else{
                newNode.next = head.next;
                newNode.prev = null;
                head.next.prev = newNode;
                head = newNode;
                return true;
            }
        }
        //Case 4: replace tail
        else if (index == length - 1){
            newNode.next = null;
            newNode.prev = tail.prev;
            tail.prev.next = newNode;
            tail = newNode;
            return true;
        }
        //Case 5: 0 < index < length - 1
        else{
            Node curr = head;
            for (int i = 0; i < index; ++i){
                curr = curr.next;
            }
            newNode.next = curr.next;
            newNode.prev = curr.prev;
            curr.prev.next = newNode;
            curr.next.prev = newNode;
            return true;
        }
    }

    /**
     * function: removes 'item' at the specific index.
     * error: if the list is empty, or the index is out of bound (too big or too small for the list) - index < 0 or index > length - 1, the program will show error
     * worst case running time: O(n)
     * @param index
     * @return boolean value: true if remove successfully, false if fail to remove
     */
    public boolean remove(int index){
        //Case 1: list is empty
        if (head == null){
            System.out.println("Error: the list is empty, can't remove element");
            return false;
        }
        //Case 2: index out of bound
        else if (index < 0 || index > length - 1){
            System.out.println("Error: index out of bound, can't remove element");
            return false;
        }
        //Case 3: remove head
        else if (index == 0){
            //Case 3-1: list size == 1
            if (length == 1){
                head = null;
                tail = null;
                length--;
                return true;
            }
            //Case 3-2: list size > 1
            else{
                head = head.next;
                head.prev = null;
                length--;
                return true;
            }
        }
        //Case 4: remove tail
        else if (index == length - 1){
            tail = tail.prev;
            tail.next = null;
            length--;
            return true;
        }
        //Case 5: 0 < index < length - 1
        else{
            Node curr = head;
            for (int i = 0; i < index; ++i){
                curr = curr.next;
            }
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;
            length--;
            return true;
        }
    }

    /**
     * function: return the element at 'index', without removing the item.
     * error: if the list is empty, or the index is out of bound (too big or too small for the list) - index < 0 or index > length - 1, the program will show error
     * worst case running time: O(n)
     * @param index
     * @return the Object item contained in the node of 'index'
     */
    public Object get(int index){
        //Case 1: list is empty
        if (head == null){
            System.out.println("Error: the list is empty, can't get element");
            return null;
        }
        //Case 2: index out of bound
        else if (index < 0 || index > length - 1){
            System.out.println("Error: index out of bound, can't get element");
            return null;
        }
        //Case 3: 0 <= index <= length - 1
        else{
            Node curr = head;
            for (int i = 0; i < index; ++i){
                curr = curr.next;
            }
            return curr.item;
        }
    }
}
