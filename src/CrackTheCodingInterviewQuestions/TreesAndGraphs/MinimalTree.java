package CrackTheCodingInterviewQuestions.TreesAndGraphs;

import Utilities.BinaryTreePrinter;
import Utilities.TNode;

import java.util.Arrays;
import java.util.List;

import static Helper.Helper.db;

public class MinimalTree {

    public static TNode<Integer> makeTree(List<Integer> list) {
        if(list.isEmpty()) return null;

        int mid = list.size() / 2;

        TNode<Integer> root = new TNode<>(list.get(mid));
        root.left = makeTree(list.subList(0, mid));
        root.right = makeTree(list.subList(mid + 1, list.size()));

        return root;
    }

    public static int calculateHeight(TNode<Integer> root) {
        if(root == null) return 0;

        return 1 + Math.max(calculateHeight(root.left), calculateHeight(root.right));
    }

    public static void main(String[] args) {
        List<Integer> l = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8,9,10,11,12,13,14);

        db("\nList Size: ", l.size());
        TNode<Integer> r = makeTree(l);

        db("\nTree: ", r.data);
        db("\nHeight: ", calculateHeight(r));
        db("\n", "");

        BinaryTreePrinter<Integer> btp = new BinaryTreePrinter<>();

        btp.printTree(r);
    }
}
