package Utilities;

import java.util.*;

import static Helper.Helper.db;

public class Graph<T> {
    Set<GNode<T>> nodes = new HashSet<>();

    GNode<T> startNode;

    public Graph() {}

    public Graph(GNode<T> node) {
        startNode = node;
    }

    @SafeVarargs
    public final void addNodes(GNode<T>... node) {
        startNode = node[0];
        Collections.addAll(nodes, node);
    }

    public boolean dfs(GNode<T> start, GNode<T> search) {
        if (start == null) return false;

        if (start == search) return true;

        start.isVisited = true;

        for (GNode<T> n : start.adjNodes) {
            if (!n.isVisited) {
                if (dfs(n, search)) return true;
            }
        }

        return false;
    }

    public void dfsHelper(GNode<T> startNode) {
        db("StartNode: ", startNode);

        dfs(startNode);
    }

    private void dfs(GNode<T> startNode) {
        for (GNode<T> node : startNode.adjNodes) {
            if (!node.isVisited) {
                node.isVisited = true;
                db(" Node : ", node);
                db(" -> ", "");
                dfs(node);
            }
        }
    }

    public void topologicalSort() {

        LinkedList<GNode<T>> stk = new LinkedList<>();

        for (GNode<T> node : nodes) {
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
}
