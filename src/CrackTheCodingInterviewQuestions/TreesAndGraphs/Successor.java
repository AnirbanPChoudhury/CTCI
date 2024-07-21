package CrackTheCodingInterviewQuestions.TreesAndGraphs;

import Utilities.BinarySearchTrees;
import Utilities.BinaryTreePrinter;
import Utilities.TNode;

import static Helper.Helper.db;

public class Successor<T> {

    public T successor(TNode<T> root) {
        return inOrderSuccessor(root.right);
    }
    private T inOrderSuccessor(TNode<T> node) {
        if(node.left == null) return node.data;
        return inOrderSuccessor(node.left);
    }

    public static void main(String[] args) {
        TNode<Integer> root = new TNode<>(7);
        BinarySearchTrees bst = new BinarySearchTrees(root);
        bst.addNode(new TNode<>(9));
        bst.addNode(new TNode<>(10));
        bst.addNode(new TNode<>(6));
        bst.addNode(new TNode<>(5));
        bst.addNode(new TNode<>(7));

        BinaryTreePrinter<Integer> btp = new BinaryTreePrinter<>();

        btp.printTree(root);

        db("InOrder Successor of root -> ", new Successor().successor(root));
    }
}
