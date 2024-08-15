import Utilities.*;

public class Main {
    public static void main(String[] args) throws java.lang.Exception {
        Graph<Integer> g = new Graph<>();
        GNode<Integer> start = new GNode<>(21);
        GNode<Integer> n1 = new GNode<>(43);
        GNode<Integer> n2 = new GNode<>(51);
        GNode<Integer> n3 = new GNode<>(5084);
        GNode<Integer> n4 = new GNode<>(83);
        start.addAdjNodes(n1, n2);
        n2.addAdjNodes(n3, n4);
        n4.addAdjNodes(n3);

        g.addNodes(start, n1, n2, n3, n4);
        g.dfsRouteHelper(start, n4);
        //bt.traverseInorder(root);
    }
}