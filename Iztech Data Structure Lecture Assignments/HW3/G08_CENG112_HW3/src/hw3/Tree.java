package hw3;

public class Tree<T extends Comparable<T>> implements TreeInterface<T> {
    private Node<T> root;

    public Tree() {
        this.root = null;
    }

    public void add(T data) {
        root = addRecursive(root, data);
    }

    private Node<T> addRecursive(Node<T> current, T data) {
        if (current == null) {
            return new Node<>(data);
        }

        if (data.compareTo(current.getData()) < 0) {
            current.setLeft(addRecursive(current.getLeft(), data));
        } else if (data.compareTo(current.getData()) > 0) {
            current.setRight(addRecursive(current.getRight(), data));
        }

        return current;
    }

    public boolean containsNode(T data) {
        return containsNodeRecursive(root, data);
    }

    private boolean containsNodeRecursive(Node<T> current, T data) {
        if (current == null) {
            return false;
        }

        if (data.equals(current.getData())) {
            return true;
        }

        if (data.compareTo(current.getData()) < 0) {
            return containsNodeRecursive(current.getLeft(), data);
        } else {
            return containsNodeRecursive(current.getRight(), data);
        }
    }

    public void traverseInOrder(Node<T> node) {
        if (node != null) {
            traverseInOrder(node.getLeft());
            System.out.println(node.getData().toString());
            traverseInOrder(node.getRight());
        }
    }

    public Node<T> getRoot() {
        return root;
    }
}
