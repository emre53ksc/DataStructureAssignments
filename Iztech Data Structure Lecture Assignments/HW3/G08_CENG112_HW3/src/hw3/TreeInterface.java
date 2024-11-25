package hw3;

public interface TreeInterface<T extends Comparable<T>> {
    void add(T data);
    boolean containsNode(T data);
    void traverseInOrder(Node<T> node);
    Node<T> getRoot();
}
