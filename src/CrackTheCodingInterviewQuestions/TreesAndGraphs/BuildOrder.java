package CrackTheCodingInterviewQuestions.TreesAndGraphs;

import Utilities.GNode;
import Utilities.Graph;

public class BuildOrder<T> {
    public static void main(String[] args) {
        GNode<String> a = new GNode<>("a");
        GNode<String> b = new GNode<>("b");
        GNode<String> c = new GNode<>("c");
        GNode<String> d = new GNode<>("d");
        GNode<String> e = new GNode<>("e");
        GNode<String> f = new GNode<>("f");

        Graph<String> g = new Graph<>();
        g.addNodes(a, b, c, d, e, f);

        a.addAdjNodes(d);
        f.addAdjNodes(b);
        b.addAdjNodes(d);
        f.addAdjNodes(a);
        d.addAdjNodes(c);

        //g.topologicalSort();

        g.dfsTraverse();
    }
}
