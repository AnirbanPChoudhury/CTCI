package Utilities;

public class Node<T> {
    T data;
    Node<T> nextNode;

    public Node(T data) {
        this.data = data;
    }

    public Node(T data, Node<T> nextNode) {
        this.data = data;
        this.nextNode = nextNode;
    }

    public T getData() {
        return data;
    }

    public Node<T> getNextNode() {
        return this.nextNode;
    }
}
