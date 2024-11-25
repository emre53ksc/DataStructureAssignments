public class QueueClass<T> implements IQueue<T> {

    private static final int MAX_CAPACITY = 1000;
    private static final int DEFAULT_CAPACITY = 50;

    private T[] queue;
    private int frontIndex;
    private int backIndex;
    private int size;
    private boolean initialized = false;

    

    public QueueClass(){
        this(DEFAULT_CAPACITY);
    }

    public QueueClass(int initialCapacity){
        @SuppressWarnings("unchecked")
        T[] temp = (T[])new Object[initialCapacity + 1];
        queue = temp;
        frontIndex = 0;
        backIndex = initialCapacity;
        size = 0;
        initialized = true;
    }

    @Override
    public void clear() {
        checkInitialized();
        while(!isEmpty()){
            dequeue();
        }
    }

    @Override
    public T dequeue() {
        checkInitialized();
        
        if(!isEmpty()){
            T front = getFront();
            queue[frontIndex] = null;
            frontIndex = (frontIndex + 1) % queue.length;
            size--;
        return front;
        }
        return null;
    }

    @Override
    public void enqueue(T newEntry){
        checkInitialized();
        ensureCapacity();

        backIndex = (backIndex + 1) % queue.length;
        queue[backIndex] = newEntry;
        size++;
    }

    @Override
    public T getFront() {
        checkInitialized();
        T front = null;
		
		if (!isEmpty()) 
			front = queue[frontIndex];
		
		return front;
    }

    @Override
    public boolean isEmpty() {
        checkInitialized();
        return frontIndex == ((backIndex + 1) % queue.length);
    }

    public void checkInitialized(){
        if(!initialized){
            throw new SecurityException("not initialized");
        }
    }

    public int size() {
       checkInitialized();
       return size;
    }

    public void checkCapacity(int newSize){
        if(newSize >= MAX_CAPACITY){
            throw new SecurityException("reached max capacity");
        }
    }


    
    @SuppressWarnings("unchecked")
    public void ensureCapacity(){
        if(frontIndex == (backIndex + 2) % queue.length){
            int newSize = queue.length * 2;
            checkCapacity(newSize);
            
            T[] oldqueue = queue;
            int oldsize = queue.length;

            T[] queue = (T[])new Object[newSize];

            for(int i = 0; i < oldsize - 1; i++){
                queue[i] = oldqueue[(frontIndex + i) % oldsize];
            }

            frontIndex = 0;
            backIndex = oldsize - 2;
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
    
    public void displayItems() {
        for (int i = 0; i < size; i++) {
            if (queue[i]!= null) {
                System.out.println(queue[i].toString());
            }
        }
    }


}




