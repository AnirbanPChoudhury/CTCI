package CrackTheCodingInterviewQuestions.TreesAndGraphs;

import Utilities.GNode;
import Utilities.Graph;

import static Helper.Helper.db;

public class RouteBetweenTwoNodes {
    public static void main(String[] args) {
        Graph<Integer> g = new Graph<>();
        GNode<Integer> n1 = new GNode<>(1);
        GNode<Integer> n2 = new GNode<>(2);
        GNode<Integer> n3 = new GNode<>(3);
        GNode<Integer> n4 = new GNode<>(4);
        GNode<Integer> n5 = new GNode<>(5);
        GNode<Integer> n6 = new GNode<>(6);

        n1.addAdjNodes(n2);
        n2.addAdjNodes(n3);
        n3.addAdjNodes(n4);
        n4.addAdjNodes(n5);

        g.addNodes(n1, n2, n3, n4, n5, n6);
        //g.dfs(n1, n6);
        db("\nPath Exists: ", g.dfsRouteHelper(n1, n5));
    }
}
