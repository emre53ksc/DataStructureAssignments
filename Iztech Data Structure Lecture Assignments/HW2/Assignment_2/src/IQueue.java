public interface IQueue<T> {

    public void enqueue(T newEntry);
    public T dequeue();
    public boolean isEmpty();
    public T getFront();
    public void clear();
}
