package CrackTheCodingInterviewQuestions.TreesAndGraphs;

import Utilities.BinaryTreePrinter;
import Utilities.LinkedList;
import Utilities.TNode;

import java.util.*;

import static CrackTheCodingInterviewQuestions.TreesAndGraphs.MinimalTree.makeTree;
import static Helper.Helper.db;

class NodeAndLevel<T> {
    TNode<T> node;
    int level;

    public NodeAndLevel(TNode<T> node, int level) {
        this.node = node;
        this.level = level;
    }

    public String toString() {
        return "Node: " + node.data + ", Level: " + level;
    }
}

public class ListOfDepths {

    public static List<List<TNode<Integer>>> createList(TNode<Integer> root) {
        List<List<TNode<Integer>>> list = new ArrayList<>();

        Queue<TNode<Integer>> q = new java.util.LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int level = q.size();
            List<TNode<Integer>> l = new ArrayList<>();

            for(int i = 0; i < level; ++i) {
                TNode<Integer> node = q.remove();
                l.add(node);
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            list.add(l);
        }
        return list;
    }

    public static void main(String[] args) {
        List<Integer> l = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14);

        db("\nList Size: ", l.size());
        db("\n", "");
        TNode<Integer> r = makeTree(l);

        BinaryTreePrinter<Integer> btp = new BinaryTreePrinter<>();
        btp.printTree(r);

        List<List<TNode<Integer>>> lists = createList(r);
        db("\nTraversal: ", lists);

    }
}
