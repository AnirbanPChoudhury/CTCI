package Utilities;

public class BinarySearchTrees<T extends Comparable<T>> {
    TNode<T> root;

    public BinarySearchTrees(TNode<T> root) {
        this.root = root;
    }

    private void addNode(TNode<T> r, TNode<T> node) {

        if(root == null) {
            root = node;
            return;
        }

        if(node.data.compareTo(r.data) <= 0) {
            if(r.left == null) {
                r.left = node;
            } else addNode(r.left, node);
        } else {
            if(r.right == null) {
                r.right = node;
            } else addNode(r.right, node);
        }
    }

    public void addNode(TNode<T> node) {
        addNode(root, node);
    }

    public static void main(String[] args) {
        TNode<Integer> root = new TNode<>(7);
        BinarySearchTrees bst = new BinarySearchTrees(root);
        bst.addNode(root, new TNode<>(9));
        bst.addNode(root, new TNode<>(10));
        bst.addNode(root, new TNode<>(6));
        bst.addNode(root, new TNode<>(5));
        bst.addNode(root, new TNode<>(7));

        BinaryTreePrinter<Integer> btp = new BinaryTreePrinter<>();

        btp.printTree(root);
    }
}
