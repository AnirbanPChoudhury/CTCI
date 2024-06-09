package Utilities;

import java.util.LinkedList;
import java.util.Queue;

import static Helper.Helper.db;

public class BinaryTree<T> {
    TNode<T> root;

    public BinaryTree() {
        root = new TNode<>();
    }

    public void addNode(TNode<T> itr, TNode<T> node) {
        if (itr.left == null) {
            itr.left = node;
            return;
        }

        Queue<TNode<T>> q = new LinkedList<>();
        q.add(itr);

        while(!q.isEmpty()) {
            TNode<T> n = q.remove();

            if(n.left == null) {
                n.left = node;
                break;
            } else q.add(n.left);

            if(n.right == null) {
                n.right = node;
                break;
            } else q.add(n.right);
        }
    }

    public void traverseInorder(TNode<T> root) {
        if (root == null) return;

        traverseInorder(root.left);
        db(" -> ", root.data);
        traverseInorder(root.left);
    }
}
