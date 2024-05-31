package Utilities;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static Helper.Helper.db;

public class Graph<T> {
    Set<GNode<T>> nodes = new HashSet<>();

    GNode<T> startNode;

    @SafeVarargs
    public final void addNodes(GNode<T>... node) {
        Collections.addAll(nodes, node);
    }

    public boolean dfs(GNode<T> start, GNode<T> search) {
        boolean ret = false;
        boolean b = false;
        for (GNode<T> n : start.adjNodes) {
            n.isVisited = true;
            db("\nNode: ", n.data);
            db("\nVisited: ", n.isVisited);
            if (search.isVisited) {
                db("\n n = ", n.data);
                db("\n search = ", search.data);
                ret = true;
                return ret;
            }
            else {
                b = ret ^ dfs(n, search);
            }
        }

        return ret ^ b;
    }
}
