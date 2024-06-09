import Utilities.BinaryTree;
import Utilities.BinaryTreePrinter;
import Utilities.TNode;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws java.lang.Exception {
        BinaryTree<Integer> bt = new BinaryTree<>();
        TNode<Integer> root = new TNode<>(20);

        bt.addNode(root, new TNode<>(12));
        bt.addNode(root, new TNode<>(11));
        bt.addNode(root, new TNode<>(1));
        bt.addNode(root, new TNode<>(234));
        bt.addNode(root, new TNode<>(874));
//        bt.addNode(root, new TNode<>(98));
//        bt.addNode(root, new TNode<>(3982));

        BinaryTreePrinter<Integer> btp = new BinaryTreePrinter<>();
        btp.printTree(root);
        //bt.traverseInorder(root);
    }
}