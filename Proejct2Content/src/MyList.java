public interface MyList{
    // Interface methods are public abstract by default, but stating that explicitly is good practice.

    //insert 'item' at 'index'. Must rearrange pointers.
    public abstract boolean insert(int index, Object item);
    
    //insert 'item' at the end of the list.
    public abstract boolean append(Object item);
    
    //clear the entire list.
    public abstract void clear();
    
    // return true if list is empty or false otherwise.
    public abstract boolean isEmpty();
    
    // return the size of the list, else -1.
    public abstract int size();
    
    // replaces the element at 'index' with 'item'.
    public abstract boolean replace(int index, Object item);

    // removes the element at 'index'.
    public abstract boolean remove(int index);

    // return the element at 'index', but don't remove the item.
    public abstract Object get(int index);
}