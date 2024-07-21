package CrackTheCodingInterviewQuestions.TreesAndGraphs;

import Utilities.BinarySearchTrees;
import Utilities.BinaryTreePrinter;
import Utilities.TNode;

import static Helper.Helper.db;

public class ValidateBST<T extends Comparable<T>>{
    public boolean validate(TNode<T> root, T min, T max) {
        if(root == null) return true;

        if((min != null && root.data.compareTo(min) <= 0) || (max != null && root.data.compareTo(max) > 0))
            return false;

        return validate(root.left, min, root.data) && validate(root.right, root.data, max);
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

        db("Is BST? -> ", new ValidateBST().validate(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }
}
