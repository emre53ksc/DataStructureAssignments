import java.util.Arrays;

public class ListClass<T> implements ListInterface<T> {

    private T[] list;
    private int numberOfEntries;
    private boolean initialized = false;
    @SuppressWarnings("unused")
    private static final int MAX_CAPACITY = 1000;
    private static final int DEFAULT_CAPACITY = 25;


    public ListClass(){
        this(DEFAULT_CAPACITY);
    }

    public ListClass(int initialCapacity){
        if(initialCapacity < DEFAULT_CAPACITY){
            initialCapacity = DEFAULT_CAPACITY;
        } else {
            checkCapacity(initialCapacity);
        }

        @SuppressWarnings("unchecked")
        T[] tempList = (T[])new Object[initialCapacity + 1];
        list = tempList;
        numberOfEntries = 0;
        initialized = true;
    }

    public void checkInitialized(){
        if(!initialized){
            throw new SecurityException("not initialized");
        }
    }

    @Override
    public void add(T newEntry) {
        add(numberOfEntries + 1, newEntry);  
    }

    @Override
    public void add(int newPosition, T newEntry) {
        checkInitialized();
        if((newPosition >= 1) && (newPosition <= numberOfEntries + 1)){
            if(newPosition <= numberOfEntries){
                makeRoom(newPosition);
            }
            list[newPosition] = newEntry;
            numberOfEntries++;
            ensureCapacity();
        }
        else{
            throw new  IndexOutOfBoundsException("Given position of add's new entry is out of bounds.");
        }
    }

    private void makeRoom(int newPosition) {
        assert (newPosition >= 1) && (newPosition <= numberOfEntries + 1);
        int newIndex = newPosition;
        int lastIndex = numberOfEntries;

        for(int index = lastIndex; index >= newIndex; index--){
            list[index + 1] = list[index];
        }
    }

    @Override
    public void clear() {
        while(!isEmpty()){
            remove(numberOfEntries);
        }
        
    }

    @Override
    public boolean contains(T anEntry) {
        checkInitialized();
        boolean found = false;
        int index = 1;
        while(!found && (index <= numberOfEntries)){
            if(anEntry.equals(list[index])){
                found = true;
            }
            index++;
        }
        
        return false;
    }

    @Override
    public void display() {
        checkInitialized();
        for(int i = 1; i <= numberOfEntries; i++){
            System.out.println(list[i]);
        }
    }

    @Override
    public T getEntry(int givenPosition) {
        checkInitialized();
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)){
            assert !isEmpty();
            return list[givenPosition];
        }
        else
        throw new IndexOutOfBoundsException("Illegal position given to getEntry operation.");
    }

    @Override
    public int getLength() {
        return numberOfEntries;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    @Override
    public T remove(int givenPosition) {
        checkInitialized();
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            // Move the assert statement to the beginning of the method
            assert !isEmpty() : "List should not be empty";
    
            T result = list[givenPosition];
    
            if (givenPosition < numberOfEntries) {
                removeGap(givenPosition);
            }
            numberOfEntries--;
            return result; // Return the removed element
        } else {
            throw new IndexOutOfBoundsException("Illegal position given to remove operation.");
        }
    }


    private void removeGap(int givenPosition) {
        assert (givenPosition >= 1) && (givenPosition < numberOfEntries);
        int removedIndex = givenPosition;
        int lastIndex = numberOfEntries;
        for(int index = removedIndex + 1; index < lastIndex; index++){
            list[index] = list[index + 1];
        }
    }

    @Override
    public T replace(int givenPosition, T newEntry) {
        checkInitialized();
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)){
            
            assert !isEmpty();
            T originalEntry = list[givenPosition];
            list[givenPosition] = newEntry;
            return originalEntry;
        } else {
            throw new SecurityException("...");
        }
    }

    @Override
    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] result = (T[])new Object[numberOfEntries];
        for(int i = 0; i < numberOfEntries; i++){
            result[i] = list[i + 1];
        }
        return result;
    }

    private void checkCapacity(int initialCapacity) {
        if(initialCapacity > MAX_CAPACITY){
            throw new IllegalStateException("Attempt to create a list " + "whose capacity exceeds " + "allowed maximum of " + MAX_CAPACITY);
        }
    }

    private void ensureCapacity(){
        int capacity = list.length - 1;
        if(numberOfEntries >= capacity){
            int newCapacity = 2 * capacity;
            checkCapacity(newCapacity);
            list = Arrays.copyOf(list, newCapacity + 1);
        }
    }

    public void remove(T anEntry) {
        checkInitialized();
        int index = 1;
        while(index <= numberOfEntries){
            if(anEntry.equals(list[index])){
                remove(index);
                return;
            }
            index++;
        }
    }
}
