package Utilities;

public class TNode<T> {
    public T data;

    int height;

    public TNode<T> left;
    public TNode<T> right;

    boolean isVisited = false;

    public TNode() {
        height = 0;
    }

    public TNode(T data) {
        this.data = data;
        height = 0;
    }

    public TNode(T data, TNode<T> left, TNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.height = Math.abs(left.height - right.height);
    }

    public String toString() {
        return data.toString();
    }
}
