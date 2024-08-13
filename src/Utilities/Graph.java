package Utilities;

import java.util.*;

import static Helper.Helper.db;

public class Graph<T> {
    Set<GNode<T>> nodes = new HashSet<>();

    GNode<T> startNode;

    @SafeVarargs
    public final void addNodes(GNode<T>... node) {
        Collections.addAll(nodes, node);
    }

    public boolean dfs(GNode<T> start, GNode<T> search) {
        if(start == null) return false;

        if(start == search) return true;

        start.isVisited = true;

        for (GNode<T> n: start.adjNodes) {
            if(!n.isVisited) {
                if(dfs(n, search)) return true;
            }
        }

        return false;
    }

    public void dfsHelper(GNode<T> startNode) {
        db("StartNode: ", startNode);

        dfs(startNode);
    }

    private void dfs(GNode<T> startNode) {
        for(GNode<T> node: startNode.adjNodes) {
            if(!node.isVisited){
                node.isVisited = true;
                db(" Node : ", node);
                db(" -> ", "");
                dfs(node);
            }
        }
    }
}
