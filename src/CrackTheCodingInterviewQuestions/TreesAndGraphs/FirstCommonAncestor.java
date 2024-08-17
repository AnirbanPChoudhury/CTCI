package CrackTheCodingInterviewQuestions.TreesAndGraphs;

import Utilities.BinaryTree;
import Utilities.BinaryTreePrinter;
import Utilities.TNode;

import static Helper.Helper.db;

public class FirstCommonAncestor {

    private static TNode<Integer> findLCA(TNode<Integer> itr, TNode<Integer> node1, TNode<Integer> node2) {
        if(itr == null || itr == node1 || itr == node2) {
            db("Node found", "");
            return itr;
        }

        TNode<Integer> node1inLST = findLCA(itr.left, node1, node2);
        TNode<Integer> node2inRST = findLCA(itr.right, node1, node2);

        if(node1inLST != null && node2inRST != null) {
            db("\nCommon Ancestor: ", itr);
            return itr;
        }

        return (node1inLST != null ? node1inLST : node2inRST);
    }

    public static void main(String[] args) {
        BinaryTree<Integer> bt = new BinaryTree<>();
        TNode<Integer> root = new TNode<>(20);

        bt.addNode(root, new TNode<>(12));
        TNode<Integer> node1 = new TNode<>(11);
        bt.addNode(root, node1);
        TNode<Integer> node2 = new TNode<>(1);
        bt.addNode(root, node2);
        bt.addNode(root, new TNode<>(234));
        bt.addNode(root, new TNode<>(874));
        bt.addNode(root, new TNode<>(98));
        bt.addNode(root, new TNode<>(3982));

        BinaryTreePrinter<Integer> btp = new BinaryTreePrinter<>();
        btp.printTree(root);

        TNode<Integer> lca = findLCA(root, node1, node2);
        db("\nLCA : ", lca);
    }
}
