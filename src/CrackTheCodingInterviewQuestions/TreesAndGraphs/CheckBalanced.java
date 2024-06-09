package CrackTheCodingInterviewQuestions.TreesAndGraphs;

import Utilities.TNode;

public class CheckBalanced {

    public static int height(TNode<Integer> root) {
        if(root == null) return 0;

        return 1 + Math.max(height(root.left), height(root.right));
    }

    public static void main(String[] args) {

    }
}
