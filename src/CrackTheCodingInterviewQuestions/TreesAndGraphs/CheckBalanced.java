package CrackTheCodingInterviewQuestions.TreesAndGraphs;

import Utilities.BinaryTree;
import Utilities.BinaryTreePrinter;
import Utilities.TNode;

import static Helper.Helper.db;

public class CheckBalanced {

    public static int height(TNode<Integer> root) {
        if(root == null) return 0;

        return 1 + Math.max(height(root.left), height(root.right));
    }

    public boolean checkBalanced(TNode<Integer> root) {

        if(root == null) return true;

        int lst = height(root.left);
        int rst = height(root.right);

        if(Math.abs(lst - rst) > 1) return false;
        return checkBalanced(root.left) && checkBalanced(root.right);
    }

    private int checkHeight(TNode<Integer> node) {
        if(node == null) return 0;

        int lst = checkHeight(node.left);
        if(lst == -1) return -1;

        int rst = checkHeight(node.right);
        if(rst == -1) return -1;

        if(Math.abs(lst - rst) > 1) return -1;

        return Math.max(lst, rst) + 1;
    }

    public static void main(String[] args) {
        BinaryTree<Integer> bt = new BinaryTree<>();
        TNode<Integer> root = new TNode<>(20);

        bt.addNode(root, new TNode<>(12));
        bt.addNode(root, new TNode<>(11));
        bt.addNode(root, new TNode<>(1));
        bt.addNode(root, new TNode<>(234));
        bt.addNode(root, new TNode<>(874));
        bt.addNode(root, new TNode<>(98));
        bt.addNode(root, new TNode<>(3982));

        BinaryTreePrinter<Integer> btp = new BinaryTreePrinter<>();
        btp.printTree(root);
        db("\nHeight: ", height(root));
        db("\nBF: ", height(root.left) - height(root.right));
    }
}
