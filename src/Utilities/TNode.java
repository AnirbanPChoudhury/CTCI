package Utilities;

public class TNode<T> {
    public T data;

    public TNode<T> left;
    public TNode<T> right;

    public TNode() {}

    public TNode(T data) {
        this.data = data;
    }

    public TNode(T data, TNode<T> left, TNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
