public class StackClass<T> implements IStack<T> {
    
    private static final int MAX_CAPACİTY = 1000;
    private static final int DEFAULT_CAPACİTY = 25;
    
    private T[] Stack;
    private int topIndex;
    private boolean initialized = false;


    public StackClass(){
        this(DEFAULT_CAPACİTY);
    }

    public StackClass(int capacity){
        if(checkCapacity(capacity)){
            @SuppressWarnings("unchecked")
            T[] temp = (T[])new Object[capacity];
            Stack = temp;
            topIndex = -1;
            initialized = true;
        }
    }

    public boolean checkCapacity(int capacity){
        if(capacity > 0 && capacity <= MAX_CAPACİTY){
            return true;
        }
        System.out.println("illegal attempt");
        return false;
    }

    public void checkInitialized(){
        if(!initialized){
            throw new SecurityException("not initialized");
        }
    }
    
    public void resizeCapacity(){
        if(Stack.length - 1 == topIndex){
            @SuppressWarnings("unchecked")
            T[] temp = (T[])new Object[(topIndex - 1)*2];
            for(int i = 0; i < topIndex - 1; i++){
                temp[i] = Stack[i]; 
            }
            Stack = temp;
        }
    }

    @Override
    public void clear() {
        checkInitialized();
        while(!isEmpty()){
            pop();
        }        
    }

    @Override
    public boolean isEmpty() {
        checkInitialized();
        return topIndex == -1;
    }

    @Override
    public T peek() {
        checkInitialized();
        if(isEmpty()){
            return null;
        }
        return Stack[topIndex];
    }

    @Override
    public T pop() {
        checkInitialized();
        if(!isEmpty()){
        T result = Stack[topIndex];
        Stack[topIndex] = null;
        topIndex--;
        return result;
        }
        return null;
    }

    @Override
    public void push(T newEntry) {
        checkInitialized();
        resizeCapacity();
        Stack[topIndex + 1] = newEntry;
        topIndex++;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public void display() {
        checkInitialized();
        for (int i = topIndex; i >= 0; i--) {
            System.out.println(Stack[i].toString());
        }
    }
}

