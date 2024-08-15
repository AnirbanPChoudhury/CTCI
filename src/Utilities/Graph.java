package Utilities;

import java.util.*;

import static Helper.Helper.db;

public class Graph<T> {
    Set<GNode<T>> nodes = new HashSet<>();

    GNode<T> startNode;

    public Graph() {
    }

    public Graph(GNode<T> node) {
        startNode = node;
    }

    @SafeVarargs
    public final void addNodes(GNode<T>... node) {
        startNode = node[0];
        Collections.addAll(nodes, node);
    }

    public boolean dfsRouteHelper(GNode<T> start, GNode<T> search) {
        if (start == null) return false;

        if (start == search) return true;

        start.isVisited = true;

        for (GNode<T> n : start.adjNodes) {
            if (!n.isVisited) {
                if (dfsRouteHelper(n, search)) return true;
            }
        }

        return false;
    }

    public void topologicalSort() {

        LinkedList<GNode<T>> stk = new LinkedList<>();

        db("Set of Nodes: ", nodes);
        db("\nStart Node: ", startNode);
        for (GNode<T> node : nodes) {
            db("\nNodes: ", node.data);
            db("\nIsVisited: ", node.isVisited);

            if (!node.isVisited)
                topologicalSortHelper(node, stk);
        }

        db("Final Topological Order: ", "");
        stk.traverseList();
    }

    private void topologicalSortHelper(GNode<T> node, LinkedList<GNode<T>> stk) {
        node.isVisited = true;

        for (GNode<T> adjNode : node.adjNodes) {
            if (!adjNode.isVisited)
                topologicalSortHelper(adjNode, stk);
        }

        stk.traverseList();

        stk.insertAtBeginning(node);
    }

    public void dfsTraverse() {

        LinkedList<GNode<T>> traversalList = new LinkedList<>();

        for (GNode<T> node : nodes) {
            if (!node.isVisited)
                dfsHelper(node, traversalList);
        }

        db("\nDFS Traversal List: ", "");
        traversalList.traverseList();
    }

    private void dfsHelper(GNode<T> node, LinkedList<GNode<T>> list) {
        node.isVisited = true;

        db("Node: ", node.data);

        //Pre Order DFS
        list.insertAtEnd(node);

        for (GNode<T> adjNode : node.adjNodes) {
            if (!adjNode.isVisited) {
                dfsHelper(adjNode, list);
            }
        }

        //Post Order DFS
        //list.insertAtBeginning(node);
    }
}
