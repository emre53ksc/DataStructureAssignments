public interface IStack <T> {
    public T pop();
    public void push(T newEntry);
    public T peek();
    public boolean isEmpty();
    public void clear();
}

